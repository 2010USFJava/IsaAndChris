package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.FormDao;
import com.revature.users.Form;
import com.revature.util.ConnFactory;

public class FormDaoImpl implements FormDao{
	
	public static ConnFactory cf = ConnFactory.getInstance();
	List<Form> formList = new ArrayList<Form>();

	@Override
	public List<Form> getAllForms() throws SQLException {
		return null;
	}

	@Override
	public Form getFormById(long id) throws SQLException {
		
		return null;
	}

	@Override
	public long insertNewForm(Form form, long id) throws SQLException {
		String eventEnum = form.getEventType().toString();
		String gradeEnum = form.getGradeFormat().toString();
		
		String sql = "insert into form values (DEFAULT,?,?,?,?,?,?,?,?,?,?)";
		Connection conn = cf.getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		pstmt.setLong(1, id);
		pstmt.setLong(2, form.getEmployeeId());
		pstmt.setString(3, eventEnum);
		pstmt.setTimestamp(4, form.getDateAndTime());
		pstmt.setString(5, form.getEventLocation());
		pstmt.setDouble(6, form.getEventCost());
		pstmt.setString(7, gradeEnum);
		pstmt.setString(8, form.getDescription());
		pstmt.setString(9, form.getJustification());
		pstmt.setBoolean(10, form.isHasApprovalEmail());
		pstmt.setBoolean(11, form.isApproved());
		
		long eventId = 0;
		int affectedRows = pstmt.executeUpdate();
		if(affectedRows > 0) {
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				eventId = rs.getLong(1);
			}
		}
		
		return eventId;
	}

	@Override
	public long deleteForm(Form form, long id) throws SQLException {
		
		return 0;
	}

	@Override
	public void updateForm(Form form, long id) throws SQLException {
		
		
	}

	@Override
	public long viewForm(Form form, long id) throws SQLException {
		
		return 0;
	}

	@Override
	public long getFormIdByEmployeeId(long id) throws SQLException {
	
		return 0;
	}

}
