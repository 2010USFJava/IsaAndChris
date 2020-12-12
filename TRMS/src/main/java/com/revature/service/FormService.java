package com.revature.service;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import com.revature.daoimpl.AttachmentDaoImpl;
import com.revature.daoimpl.FormDaoImpl;
import com.revature.users.Attachment;
import com.revature.users.Employee;
import com.revature.users.Events.EventType;
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
	
	
}
	
	











