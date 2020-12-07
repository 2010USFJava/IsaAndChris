package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.services.LoginService;
import com.revature.users.Employee;
import com.revature.users.User;

public class LoginController {
	static LoginService loginService = new LoginService();

	public static String login(HttpServletRequest req) {
		System.out.println("LoginController.login");
		if (!req.getMethod().equals("POST")) {
			return "html/index.html";
		}

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println("LoginController.login username = " + username + " password = " + password);
		User user = loginService.loginGetUser(username, password);
		System.out.println("LoginController.login user = " + user);
		if (user == null) {
			return "wrongcreds.change";
		} else {
			Employee employee = loginService.callGetEmployeeByUserId(user.getEmployeeId());
			System.out.println("LoginController.login employee = " + employee);
			req.getSession().setAttribute("currentlogin", employee);
			return "home.change";
		}
	}
}
