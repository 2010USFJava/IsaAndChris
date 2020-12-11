package com.revature.service;

import java.sql.SQLException;
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

	public Form formSubmission(Form form) {
		return form;
//		Timestamp days;
//		if(form.getSubmission() > days) {
//			form.setApproved(false);
//		}else {
//		 //continue with form
//		}
	}
	
	public Form formDate(Form form) {
//		Date sub = form.getSubmission();
		Date fDate = form.getDateAndTime();
		
//		Duration dd = Duration.between(sub, fDate);
		Boolean urgent = false;
//		if()
		
		return form;
	}
	
	public Form getProjectedAmount(Form form) {
		double cost = form.getEventCost();
		double projected;
		if(form.getEventType().equals(EventType.SEMINAR)) {
			//60%
			projected = (cost * .60);
			form.setProjectedAmount(projected);
		}else if(form.getEventType().equals(EventType.UNIVERSITYCOURSE)) {
			//80%
			projected = (cost * .80);
			form.setProjectedAmount(projected);
		}else if(form.getEventType().equals(EventType.CERTIFICATIONPREPARATIONCLASS)) {
			//75%
			projected = (cost *.75);
			form.setProjectedAmount(projected);
		}else if(form.getEventType().equals(EventType.CERTIFICAITON)) {
			//100%
			projected = cost;
			form.setProjectedAmount(projected);
		}else if(form.getEventType().equals(EventType.TECHNICALTRAINING)){
			//90%
			projected = (cost * .90);
			form.setProjectedAmount(projected);
		}else if(form.getEventType().equals(EventType.OTHER)) {
			//30%
			projected = (cost * .30);
			form.setProjectedAmount(projected);
		}else {
			System.out.println("this didn't work");
		}
//		Employee e = new Employee();
//		if(form.getProjectedAmount() > e.getReimburseAmount()) {
//			//adjust to amount available?
//		}
		return form;
	}
}
	
	











