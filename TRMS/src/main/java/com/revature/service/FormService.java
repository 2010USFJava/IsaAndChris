package com.revature.service;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.databind.ObjectMapper;
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

	
	public boolean formDate(long eventId, Timestamp eventDate, Timestamp submittedOn) {
		int event = eventDate.compareTo(submittedOn);
		if(event == 0) {
			//deny request
			return false;
		}else if(event < 0) {
			//deny request
			return false;
		}else if(event > 0) {
			//continue with request
			return true;
		}
		//the value 0 if the two Timestampobjects are equal; a value less than 0 if this Timestamp object is
			//before the given argument;and a value greater than 0 if this Timestamp object is after the given argument.
		return false;
	}
	
	
	public List<Form> getEmployeeForms(HttpServletRequest req, Integer id){
		List<Form> fList = new ArrayList<Form>();
		try {
			Employee employ = (Employee) req.getSession().getAttribute("currentlogin");
			fList = fdi.getAllFormsByEmployeeId(employ.getEmployeeId());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fList;
	}
	
}
	
	











