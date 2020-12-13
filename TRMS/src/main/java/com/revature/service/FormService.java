package com.revature.service;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.controller.SessionController;
import com.revature.daoimpl.AttachmentDaoImpl;
import com.revature.daoimpl.FormDaoImpl;
import com.revature.users.Attachment;
import com.revature.users.Employee;
import com.revature.users.Form;

public class FormService {
	static FormDaoImpl fdi = new FormDaoImpl();
	static AttachmentDaoImpl adi = new AttachmentDaoImpl();
	
	public void insertMultipleAttachments(Attachment a, Attachment b) {
		try {
			adi.insertMultipleAttachments(a, b);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public boolean formDate(long eventId, Timestamp duration) {
		System.out.println(duration);
		
		return false;
	}
	
	public List<Form> getEmployeeForms(HttpServletRequest req, Integer id){
		List<Form> fList = new ArrayList<Form>();
		req.getSession().setAttribute("emlist", fList);
		try {
			fList = fdi.getAllFormsByEmployeeId(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fList;
	}
	
}
	
	











