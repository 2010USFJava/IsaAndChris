package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.FormDao;
import com.revature.users.Form;
import com.revature.util.ConnFactory;

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
		String sql = "insert into eventform values (DEFAULT,?,?,?,?,?,?,?,?,?,?,?)";
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
//		pstmt.setString(12, 0);
	//	pstmt.setString(12, form.getPassingGrade().toString());
//		pstmt.setBoolean(10, form.isApproved());

		// pstmt.setBinaryStream(12, ); for files
//		CopyManager cm = new CopyManager();
//		try(FileOutputStream fop = new FileOutputStream(fileName)
//				OutputStreamWriter osw = new OutputStreamWriter(fop, StandardCharsets.UTF_8)){
//			cm.copyOut("copy txt to stdout with delimter as'|'", ows);
//		}
//		
		long eventId = 0;
		int affectedRows = pstmt.executeUpdate();
		if (affectedRows > 0) {
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				eventId = rs.getLong(1);
			}
		}

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
	public void updateForm(Form form, long id) throws SQLException {
		Connection conn = cf.getConnection();
		int affectedRows = 0;

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
		String sql = "select * from eventform";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		Form f = null;
		while (rs.next()) {
			f = new Form();
			f.setEventId(rs.getInt(1));
//			f.setEventType(EventType.valueOf(rs.getString(3)));
//			System.out.println(f.getEventType().toString());
			f.setEventLocation(rs.getString(5));
			formList.add(f);
		}
		return formList;
	}
}
