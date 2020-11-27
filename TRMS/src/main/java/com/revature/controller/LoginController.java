package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.service.UsersService;
import com.revature.users.Users;

public class LoginController {
	static UsersService loginService = new UsersService();

	public static String login(HttpServletRequest req) {
		if (!req.getMethod().equals("POST")) {
			return "html/index.html";
		}

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		Users user = loginService.loginGetEmployee(username, password);
		if (user == null) {
			return "wrongcreds.change";
		} else {
			req.getSession().setAttribute("currentLogin", user);
			return "home.change";
		}
	}
}
