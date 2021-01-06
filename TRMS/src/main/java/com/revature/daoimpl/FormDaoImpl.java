package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.FormDao;
import com.revature.service.FormService;
import com.revature.users.Events.Approval;
import com.revature.users.Events.EventType;
import com.revature.users.Events.GradeFormat;
import com.revature.users.Events.PassingGrade;
import com.revature.users.Form;
import com.revature.users.GradePresentation;
import com.revature.util.ConnFactory;
import com.revature.util.LogInfo;

public class FormDaoImpl implements FormDao {

	public static ConnFactory cf = ConnFactory.getInstance();
	List<Form> formList = new ArrayList<Form>();

//	static {
//		try {
//			Class.forName("org.postgresql.Driver");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
//	}

	@Override
	public List<Form> getAllForms() throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select * from eventform";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		Form f = null;
		while (rs.next()) {
			f = new Form(/*
							 * rs.getLong(1), rs.getLong(2), EventType.valueOf(rs.getString(3)),
							 * rs.getTimestamp(4), rs.getString(5), rs.getDouble(6),
							 * GradeFormat.valueOf(rs.getString(7)), rs.getString(8), rs.getString(9),
							 * rs.getBoolean(10), rs.getBoolean(11)
							 */);
			formList.add(f);
		}
		return formList;
	}

	@Override
	public Form getFormById(long id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select * from eventform where eventId=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, id);
		ResultSet rs = pstmt.executeQuery();
		Form f = null;
		while (rs.next()) {
			f = new Form(/*
							 * rs.getLong(1), rs.getLong(2), EventType.valueOf(rs.getString(3)),
							 * rs.getTimestamp(4), rs.getString(5), rs.getDouble(6),
							 * GradeFormat.valueOf(rs.getString(7)), rs.getString(8), rs.getString(9),
							 * rs.getBoolean(10), rs.getBoolean(11)
							 */);
		}
		return f;
	}

	@Override
	public long insertNewForm(Form form, long id) throws SQLException {
		String sql = "insert into eventform values (DEFAULT,?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection conn = cf.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		pstmt.setLong(1, form.getEmployeeId());
		pstmt.setString(2, form.getEventType().toString());
		pstmt.setTimestamp(3, form.getDateAndTime());
		pstmt.setString(4, form.getEventLocation());
		pstmt.setDouble(5, form.getEventCost());
		pstmt.setString(6, form.getGradeFormat().toString());
		pstmt.setString(7, form.getDescription());
		pstmt.setString(8, form.getJustification());
		pstmt.setBoolean(9, form.isHasApprovalEmail());
		pstmt.setString(10, form.getApproval().toString());
		pstmt.setDouble(11, form.getProjectedAmount());
		pstmt.setString(12, form.getPassingGrade().toString());


		long eventId = 0;
		int affectedRows = pstmt.executeUpdate();
		if (affectedRows > 0) {
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				eventId = rs.getLong(1);
			}
		}
		LogInfo.LogIt("info", id + " has submitted a new reimbursement request id: " + eventId);
		return eventId;
	}

	@Override
	public long deleteForm(Form form, long id) throws SQLException {
		Connection conn = cf.getConnection();
		int affectedRows = 0;
		String sql = "delete from eventform where employeeId=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, id);
		affectedRows = pstmt.executeUpdate();
		return affectedRows;
	}

	@Override
	public void updateForm(long id) throws SQLException {
		Connection conn = cf.getConnection();
		int affectedRows = 0;
		LogInfo.LogIt("info", "Reimbursement request form " + id + " has been updated");
	}

	@Override
	public long viewForm(Form form, long id) throws SQLException {

		return 0;
	}

	@Override
	public long getFormIdByEmployeeId(long id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select * from eventform where employeeId=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, id);
		ResultSet rs = pstmt.executeQuery();
		long eventId = 0;
		if (rs != null) {
			while (rs.next()) {
				eventId = rs.getLong(1);
				return eventId;
			}
		}
		return 0;
	}

	@Override
	public List<Form> getFormsIdByEmployeeJobCode(int code) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select * from eventform where approvallevel = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, code);
		ResultSet rs = ps.executeQuery();
		Form f = null;
		while (rs.next()) {
			f = new Form();
			f.setEventId(rs.getInt(1));
			f.setEmployeeId(rs.getInt(2));
//			f.setEventType(EventType.valueOf(rs.getString(3)));
//			System.out.println(f.getEventType().toString());
			f.setDateAndTime(rs.getTimestamp(4));
			f.setEventLocation(rs.getString(5));
			f.setApprovalLevel(rs.getInt(14));
			formList.add(f);
		}
		return formList;
	}

	public void raiseFormApprovalLevel(Integer eventId) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select employeeid, eventcost, approvallevel from eventform where eventid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, eventId);
		ResultSet rs = ps.executeQuery();
		Integer approvalLevel = null;
		Double cost = null;
		Integer employeeId = null;
		while (rs.next()) {
			employeeId = rs.getInt(1);
			cost = rs.getDouble(2);
			approvalLevel = rs.getInt(3);
		}
		System.out.println("employeId = " + employeeId);
		System.out.println("cost = " + cost);
		System.out.println("approvalLevel = " + approvalLevel);
		boolean balanceIsHighEnough = false;
		switch (approvalLevel) {
		case 2:
		case 3:
			approvalLevel++;
			break;
		case 4:
			EmployeeDaoImpl edi = new EmployeeDaoImpl();
			balanceIsHighEnough = edi.updateEmployeeReimbursement(employeeId, cost);
			break;
		}
		if (balanceIsHighEnough) {
			approvalLevel = 5;
		} else {
			approvalLevel = 6;
		}
		String sql2 = "update eventform set approvallevel = ? where eventid = ?";
		PreparedStatement ps2 = conn.prepareStatement(sql2);
		ps2.setInt(1, approvalLevel);
		ps2.setInt(2, eventId);
		ps2.execute();
	}
	
	public void denyRowById(Integer eventId) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "update eventform set approvallevel = 6 where eventid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, eventId);
		ps.execute();
	}

	static FormService fServ = new FormService();

	@Override
	public boolean checkUrgency(Form form, long id) throws SQLException {

		String sql = "select eventId,dateAndTimeOfEvent,submittedOn from eventform where eventId=?";

		Connection conn = cf.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, form.getEventId());
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			long eventId = rs.getLong(1);
			Timestamp eventDate = rs.getTimestamp(2);
			Timestamp submittedOn = rs.getTimestamp(3);
			int days = 14;
			boolean isUrgent = fServ.formDate(eventId, eventDate, submittedOn);

		}
		return false;
	}

	@Override
	public List<Form> getAllFormsByEmployeeId(long id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select * from eventform where employeeId=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, id);
		ResultSet rs = pstmt.executeQuery();
		Form f = null;
		while (rs.next()) {
			f = new Form( rs.getLong(1), rs.getLong(2), EventType.valueOf(rs.getString(3).toLowerCase()),
						rs.getTimestamp(4), rs.getString(5), rs.getDouble(6),
						GradeFormat.valueOf(rs.getString(7).toLowerCase()), rs.getString(8), rs.getString(9),
						rs.getBoolean(10), Approval.valueOf(rs.getString(11).toLowerCase()), rs.getDouble(12), 
						PassingGrade.valueOf(rs.getString(13).toLowerCase()), rs.getInt(14));
			formList.add(f);
		}
		return formList;
	}

	
	public void insertGradePresentation(int id, GradePresentation grade) throws SQLException{
		Connection conn = cf.getConnection();

		
	}
}
