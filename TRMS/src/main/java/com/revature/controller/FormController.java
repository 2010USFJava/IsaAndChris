package com.revature.controller;


import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daoimpl.AttachmentDaoImpl;
import com.revature.daoimpl.FormDaoImpl;
import com.revature.service.ApproveService;
import com.revature.service.FormService;
import com.revature.users.Attachment;
import com.revature.users.Events.Approval;
import com.revature.users.Events.EventType;
import com.revature.users.Events.GradeFormat;
import com.revature.users.Events.PassingGrade;
import com.revature.users.Form;

public class FormController {
//	static VillainService vServ = new VillainService();
	static FormDaoImpl fdi = new FormDaoImpl();
	static Form form = new Form();
	static AttachmentDaoImpl adi = new AttachmentDaoImpl();
	static FormService fServ = new FormService();
	static ApproveService aServ = new ApproveService();

	public static String form(HttpServletRequest req) {
		if (!req.getMethod().equals("POST")) {
			return "html/newform.html";// ????????
		}

		
		if (req.getSession() == null) {
			return "wrongcreds.change";
		}else {
			ObjectMapper om = new ObjectMapper();
			req.getSession().getAttribute("currentuser");
		try {
			//this serializes the the input from request
			String eventStr = om.writeValueAsString(req.getParameter("field3"));
			//this deserializes the input to make it into an enum for EventType
			EventType event = om.readValue(eventStr, EventType.class);			
			
			//this serializes the input from request
			String formatStr = om.writeValueAsString(req.getParameter("field8"));
			//this deserializes the input to make it into an enum for GradeFormat
			GradeFormat format = om.readValue(formatStr, GradeFormat.class);
			
			String passGrd = om.writeValueAsString(req.getParameter("grade-pass"));
			PassingGrade grade = om.readValue(passGrd, PassingGrade.class);
			
			
			//this has value of ("2020-12-10") very good serialize
			String dateTimeStr = om.writeValueAsString(req.getParameter("field4"));
			//deserialize
			Date dateTimeDate = om.readValue(dateTimeStr, Date.class);
			//convert date java.util to timestamp java.sql
			Timestamp dateAndTime = new Timestamp(dateTimeDate.getTime());

			
			
			String eventLocation = req.getParameter("field6");
			double eventCost = Double.parseDouble(req.getParameter("field7"));
			String description = req.getParameter("field9");
			String justification = req.getParameter("field10");
			
			//BROKEN
			double projectedAmount = 0 ;//Double.parseDouble(req.getParameter("pro-amount"));
			String subTime= om.writeValueAsString(req.getParameter("timestamp"));
			Date subTime2 = om.readValue(subTime, Date.class);
			Timestamp submission = new Timestamp(subTime2.getTime());
			
			Approval appr = Approval.PENDING;
			
			//puts byte infromation into a byte[] - compatiable with bytea in postgresql
			byte[] file = om.writeValueAsBytes(req.getParameter("file-upload2"));
			
			Attachment a = new Attachment(0, "filename", file);
			long attachId = adi.insertNewAttachment(a);
			adi.getAttachmentById(attachId);
		
			Long subimssion = req.getSession().getCreationTime();
			//get projected amount
			//get passinggrade
			
			Boolean hasApprovalEmail;
			if (file != null) {
				hasApprovalEmail = true;
			} else {
				hasApprovalEmail = false;
			}

			Form form = new Form(0, 0, event, dateAndTime, eventLocation, eventCost, format, description, justification,
					hasApprovalEmail, appr, submission, 0, grade);
			double projectedAmount2 = fServ.getProjectedAmount(form);
			System.out.println(form);
			
			long eventId = fdi.insertNewForm(form, form.getEventId());
			
			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			return "html/form.html";
		}
	}
	
	public static String formGet(HttpServletRequest req, HttpServletResponse res) {
//		List<Form> formList = aServ.getEventForms();
		
		
		
		return "forms.change";
	}


}

