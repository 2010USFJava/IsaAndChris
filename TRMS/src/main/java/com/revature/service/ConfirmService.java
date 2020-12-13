package com.revature.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.daoimpl.FormDaoImpl;
import com.revature.users.Employee;
import com.revature.users.Form;

public class ConfirmService {

	public List<Form> getEventForms(HttpServletRequest req) {
		FormDaoImpl fdi = new FormDaoImpl();
		List<Form> formList = null;
		try {
			Employee employee = (Employee) req.getSession().getAttribute("currentlogin");
			formList = fdi.getFormsIdByEmployeeJobCode(employee.getJobTitleCode());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return formList;
	}

}
