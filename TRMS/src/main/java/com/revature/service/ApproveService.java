package com.revature.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.daoimpl.FormDaoImpl;
//import com.revature.daoimpl.FormDaoImpl;
import com.revature.users.Form;

public class ApproveService {

	public List<Form> getEventForms(HttpServletRequest req) {
		FormDaoImpl fdi = new FormDaoImpl();
		List<Form> formList = null;
		try {
			formList = fdi.getFormsIdByEmployeeJobCode(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return formList;
	}
	public void raiseApprovalLevel(String eventId) {
		Integer iEventId = Integer.valueOf(eventId);
		System.out.println("ApproveService.raiseApprovalLevel eventId = " + iEventId);
		FormDaoImpl fdi = new FormDaoImpl();
		try {
			fdi.raiseFormApprovalLevel(iEventId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void denyEvent(String eventId) {
		Integer iEventId = Integer.valueOf(eventId);
		System.out.println("ApproveService.deny eventId = " + iEventId);
		FormDaoImpl fdi = new FormDaoImpl();
		try {
			fdi.denyRowById(iEventId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
