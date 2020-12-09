package com.revature.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.users.Employee;
import com.revature.users.Form;

public class SessionController {

	public static void getUserSession(HttpServletRequest req, HttpServletResponse res)
			throws JsonProcessingException, IOException {
		System.out.println("SessionController.getUserSession session = " + req.getSession());
		System.out.println("SessionController.getUserSession session currentlogin = "
				+ req.getSession().getAttribute("currentlogin"));
		Employee employee = (Employee) req.getSession().getAttribute("currentlogin");
		System.out.println("Employee from session = " + employee);
		res.getWriter().write(new ObjectMapper().writeValueAsString(employee));
	}

	public static void getForms(HttpServletRequest req, HttpServletResponse res) {
		List<Form> formList = (ArrayList<Form>) req.getSession().getAttribute("formlist");
		System.out.println("SessionController.getForms formlist from session = " + formList);
		try {
			res.getWriter().write(new ObjectMapper().writeValueAsString(formList));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
