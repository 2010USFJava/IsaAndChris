package com.revature.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.users.Employee;

public class UserController {

	public static void getUserSession(HttpServletRequest req, HttpServletResponse res)
			throws JsonProcessingException, IOException {
		System.out.println("UserController.getUserSession session = " + req.getSession());
		System.out.println("UserController.getUserSession session currentlogin = "
				+ req.getSession().getAttribute("currentlogin"));
		Employee employee = (Employee) req.getSession().getAttribute("currentlogin");
		System.out.println("User from session = " + employee);
		res.getWriter().write(new ObjectMapper().writeValueAsString(employee));
	}

}
