package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.users.Form;
import com.revature.users.GradePresentation;

public interface FormDao {
	public List<Form> getAllForms() throws SQLException;
	public Form getFormById(long id) throws SQLException;
	public long insertNewForm(Form form, long id) throws SQLException;
	public long deleteForm(Form form, long id) throws SQLException;
	public void updateForm(long id) throws SQLException;
	public long viewForm(Form form, long id) throws SQLException;
	public boolean checkUrgency(Form form, long id) throws SQLException;
	public List<Form> getAllFormsByEmployeeId(long id) throws SQLException;
	
	public long getFormIdByEmployeeId(long id) throws SQLException;
	List<Form> getFormsIdByEmployeeJobCode(int code) throws SQLException;
	public void insertGradePresentation(int id, GradePresentation grade) throws SQLException;
	
}
