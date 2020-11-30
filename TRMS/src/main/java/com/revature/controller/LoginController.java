package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.service.UsersService;
import com.revature.users.Users;

public class LoginController {
	static UsersService usersService = new UsersService();

	public static String login(HttpServletRequest req) {
		System.out.println("LoginController.login");
		if (!req.getMethod().equals("POST")) {
			return "html/index.html";
		}

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Users user = usersService.loginGetEmployee(username, password);
		System.out.println("LoginController.login user = " + user);
		if (user == null) {
			return "wrongcreds.change";
		} else {
			req.getSession().setAttribute("currentlogin", user);
			return "home.change";
		}
	}
}
