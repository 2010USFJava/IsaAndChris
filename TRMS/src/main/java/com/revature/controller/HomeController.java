package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController {
	public static String home(HttpServletRequest req, HttpServletResponse res) {
		if (SessionController.enforceLogin(req, res)) {
			return "html/home.html";
		} else {
			return "html/index.html";
		}
	}
}
