package com.revature.services;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;

import com.revature.daoimpl.FormDaoImpl;
import com.revature.users.Employee;
import com.revature.users.Form;

public class FormService {
	static FormDaoImpl fdi = new FormDaoImpl();

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
		Date sub = form.getSubmission();
		Date fDate = form.getDateAndTime();
		
//		Duration dd = Duration.between(sub, fDate);
		Boolean urgent = false;
		if()
		
		return form;
	}
	
	public double getProjectedAmount(Form form) {
		double cost = form.getEventCost();
		if(form.getEventType().equals("seminar")) {
			double t = Math.multiplyExact((long)cost, (long) .6);
			//60%
			return t;
			
		}else if(form.getEventType().equals("universitycourse")) {
			//80%
		}else if(form.getEventType().equals("certificationpreparationclass")) {
			//75%
		}else if(form.getEventType().equals("certificaiton")) {
			//100%
		}else if(form.getEventType().equals("technicaltraining")){
			//90%
		}else if(form.getEventType().equals("other")) {
			//30%
		}else {
			return 0;
		}
		Employee e = new Employee();
		if(form.getProjectedAmount() > e.getReimburseAmount()) {
			//adjust to amount available?
		}
		return 0;
	}
}
	
	
