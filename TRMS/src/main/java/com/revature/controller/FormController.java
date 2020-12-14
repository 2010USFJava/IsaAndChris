package com.revature.controller;


import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daoimpl.AttachmentDaoImpl;
import com.revature.daoimpl.FormDaoImpl;
import com.revature.service.ApproveService;
import com.revature.service.FormService;
import com.revature.users.Attachment;
import com.revature.users.Employee;
import com.revature.users.Events.Approval;
import com.revature.users.Events.EventType;
import com.revature.users.Events.FileName;
import com.revature.users.Events.GradeFormat;
import com.revature.users.Events.PassingGrade;
import com.revature.users.Form;
import com.revature.users.GradePresentation;

public class FormController {
//	static VillainService vServ = new VillainService();
	static FormDaoImpl fdi = new FormDaoImpl();
	static Form form = new Form();
	static AttachmentDaoImpl adi = new AttachmentDaoImpl();
	static FormService fServ = new FormService();
	static ApproveService aServ = new ApproveService();

	public static String form(HttpServletRequest req, HttpServletResponse res) {
		if (!req.getMethod().equals("POST")) {
			return "html/newform.html";
		}

		Employee em = (Employee) req.getSession().getAttribute("currentlogin");
		Integer employeeId = em.getEmployeeId();

		if (employeeId == null) {
			return "wrongcreds.change";
		} else {
			ObjectMapper om = new ObjectMapper();
			try {
				// this serializes the the input from request
				String eventStr = om.writeValueAsString(req.getParameter("field3"));
				// this deserializes the input to make it into an enum for EventType
				EventType event = om.readValue(eventStr, EventType.class);

				// this has value of ("2020-12-10") very good serialize
				String dateTimeStr = om.writeValueAsString(req.getParameter("field4"));
				// deserialize
				Date dateTimeDate = om.readValue(dateTimeStr, Date.class);
				// convert date java.util to timestamp java.sql
				Timestamp dateAndTime = new Timestamp(dateTimeDate.getTime());

				String eventLocation = req.getParameter("field5");
				double eventCost = Double.parseDouble(req.getParameter("field6"));

				// this serializes the input from request
				String formatStr = om.writeValueAsString(req.getParameter("field7"));
				// this deserializes the input to make it into an enum for GradeFormat
				GradeFormat format = om.readValue(formatStr, GradeFormat.class);

				String passGrd8_1 = om.writeValueAsString(req.getParameter("field8-1"));
				String passGrd8_2 = om.writeValueAsString(req.getParameter("field8-2"));
				String passGrd8_3 = om.writeValueAsString(req.getParameter("field8-3"));
				String passGrd8_4 = om.writeValueAsString(req.getParameter("field8-4"));
				PassingGrade grade;
				if (passGrd8_1.equals("true")) {
					grade = PassingGrade.a;
				} else if (passGrd8_2.equals("true")) {
					grade = PassingGrade.b;
				} else if (passGrd8_3.equals("true")) {
					grade = PassingGrade.c;
				} else if (passGrd8_4.equals("true")) {
					grade = PassingGrade.c;
				} else {
					grade = PassingGrade.c;
				}
//			PassingGrade grade = om.readValue(passGrd, PassingGrade.class);


				String description = req.getParameter("field9");
				String justification = req.getParameter("field10");

				// BROKEN
				String pro = req.getParameter("hidden-text");
				double projectedAmount = Double.parseDouble(pro);

				// puts byte infromation into a byte[] - compatiable with bytea in postgresql
				byte[] file01 = om.writeValueAsBytes(req.getParameter("file-upload1"));
				byte[] file02 = om.writeValueAsBytes(req.getParameter("file-upload2"));

				Boolean hasApprovalEmail;
				if (file02 != null) {
					hasApprovalEmail = true;
				} else {
					hasApprovalEmail = false;
				}

				Approval approval = Approval.pending;

				Form form = new Form(0, employeeId, event, dateAndTime, eventLocation, eventCost, format, description,
						justification, hasApprovalEmail, approval, projectedAmount, grade, 2);
				System.out.println(form);

				long eventId = fdi.insertNewForm(form, employeeId);

				Attachment a1;
				Attachment a2;
				if (file02 != null) {
					hasApprovalEmail = true;

//				 a1 = new Attachment(0, FileName.EVENTRELATEDDOCUMENT, file01, false, eventId);
					a2 = new Attachment(0, FileName.approvaldocument, file02, false, employeeId);
					adi.insertNewAttachment(a2);
				} else if (file02 == null) {
					hasApprovalEmail = false;
				}

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

			return "html/home.html";
		}
	}

	public static String view(HttpServletRequest req, HttpServletResponse res) {
		Employee employ = (Employee) req.getSession().getAttribute("currentlogin");
		Integer employeeId = employ.getEmployeeId();
		Form f = new Form();
		f.setEmployeeId(employeeId);
		if (SessionController.enforceLogin(req, res)) {
			List<Form> employeeForms = fServ.getEmployeeForms(req, employeeId);
			req.getSession().setAttribute("employeeForms", employeeForms);
			return "html/form.html";
		} else {
			return "html/index.html";
		}
	}
	
	public static String update(HttpServletRequest req, HttpServletResponse res) {
		if (!req.getMethod().equals("POST")) {
			return "html/grade_presentation.html";
		}
		Employee em = (Employee) req.getSession().getAttribute("currentlogin");
		Integer employeeId = em.getEmployeeId();
		if(employeeId == null) {
			return "wrongcreds.change";
		}else {
			try {
			ObjectMapper om = new ObjectMapper();
			byte[] file01 = om.writeValueAsBytes(req.getParameter("file-upload"));
			String grade = om.writeValueAsString(req.getParameter("grade-input"));
			char g = om.readValue(grade, char.class);
			GradePresentation gp = new GradePresentation(employeeId, 7, file01, g);
			
			fdi.updateForm(employeeId);
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
			return "html/home.html";
		}
	}

	public static void getEmployeeForms(HttpServletRequest req, HttpServletResponse res)
			throws JsonProcessingException, IOException {
//		List<Form> fList = fServ.getEmployeeForms(req);
//		ObjectMapper om = new ObjectMapper();
//		res.getWriter().write(om.writeValueAsString(fList));
	}

}
