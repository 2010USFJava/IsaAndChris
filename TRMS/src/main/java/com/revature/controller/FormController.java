package com.revature.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daoimpl.FormDaoImpl;
import com.revature.users.Events.EventType;
import com.revature.users.Events.GradeFormat;
import com.revature.users.Form;


public class FormController {
//	static VillainService vServ = new VillainService();
	static FormDaoImpl fdi = new FormDaoImpl();
	
	public static String form(HttpServletRequest req) {
		if(!req.getMethod().equals("POST")) {
			return "FrontEndFiles/HTML/form.html";//????????
		}
		//chagne strings
		EventType eventType = EventType.valueOf(req.getParameter("eventType"));
		Timestamp dateAndTime = Timestamp.valueOf(req.getParameter("dateAndTime"));
		String eventLocation = req.getParameter("eventLocation");
		double eventCost = Double.parseDouble(req.getParameter("eventCost"));
		GradeFormat gradeFormat  = GradeFormat.valueOf(req.getParameter("gradeFormat"));
		String description = req.getParameter("description");
		String justification = req.getParameter("justification");
		boolean hasApprovalEmail = Boolean.parseBoolean(req.getParameter("hasApprovalEmail"));
		
		Form form = new Form(0, 0, eventType, dateAndTime, eventLocation, eventCost,
				gradeFormat, description, justification, hasApprovalEmail, false);
		try {
			long eventId = fdi.insertNewForm(form, form.getEventId());
			System.out.println("FormController form: " + form.toString());
//			if(eventId == 0) {
//				return "wrongcred.change";
//			}else {
//				req.getSession().setAttribute("currentform", eventId);
//				return "home.change";
//			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "index.html";//?????????
	}
	
	public static void getFormSession(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		Form form = (Form) req.getSession().getAttribute("currentform");
		res.getWriter().write(new ObjectMapper().writeValueAsString(form));
	}
}
