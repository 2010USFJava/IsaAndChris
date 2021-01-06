package com.revature.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.service.FormService;
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

	public static String logout(HttpServletRequest req) {
		req.getSession().invalidate();
		System.out.println("SessionController.logout");
		return "html/index.html";
	}

	public static boolean enforceLogin(HttpServletRequest req, HttpServletResponse res) {
		res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		res.setHeader("Pragma", "no-cache");
		res.setDateHeader("Expires", 0);
		System.out.println("SessionController.enforceLogin - removed website caching");
		HttpSession session = req.getSession(false);
		if (session == null || session.getAttribute("currentlogin") == null) {
			System.out.println("SessionController.enforceLogin session or attribute currentlogin == null");
			return false;
		} else {
			System.out.println("SessionController.enforceLogin - login validated");
			return true;
		}
	}
	
	static FormService fServ = new FormService();

	public static void getEmployeeForms(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		List<Form> employeeForms = (ArrayList<Form>) req.getSession().getAttribute("employeeForms");
		System.out.println("SessionController.employeeforms employeeForms from session = " + employeeForms);
		try {
			res.getWriter().write(new ObjectMapper().writeValueAsString(employeeForms));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
