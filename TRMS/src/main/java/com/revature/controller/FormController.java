package com.revature.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.revature.daoimpl.FormDaoImpl;
import com.revature.users.Events.EventType;
import com.revature.users.Events.GradeFormat;
import com.revature.users.Form;


public class FormController {
//	static VillainService vServ = new VillainService();
	static FormDaoImpl fdi = new FormDaoImpl();
	static Form form = new Form();

	public static String form(HttpServletRequest req) {
		if (!req.getMethod().equals("POST")) {
			return "FrontEndFiles/HTML/form.change";// ????????
		}

		ObjectMapper om = new ObjectMapper();
 
		
		try {
			//this serializes the the input from request
			String eventStr = om.writeValueAsString(req.getParameter("field3"));
			//this deserializes the input to make it into an enum for EventType
			EventType event = om.readValue(eventStr, EventType.class);			
			
			//this serializes the input from request
			String formatStr = om.writeValueAsString(req.getParameter("field8"));
			//this deserializes the input to make it into an enum for GradeFormat
			GradeFormat format = om.readValue(formatStr, GradeFormat.class);
			
			
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
			boolean hasApprovalEmail = Boolean.parseBoolean(req.getParameter("file-upload2"));

			if (!hasApprovalEmail) {
				hasApprovalEmail = true;
			} else {
				hasApprovalEmail = false;
			}

			Form form = new Form(0, 0, event, dateAndTime, eventLocation, eventCost, format, description, justification,
					false, false);
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

		if (req.getSession() == null) {
			return "wrongcreds.change";
		} else {
			req.getSession();
			return "home.change";
		}
	
		
	}
	


}
