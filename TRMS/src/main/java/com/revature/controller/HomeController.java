package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

public class HomeController {
	public static String home(HttpServletRequest req) {
		return "FrontEndFiles/HTML/home.html";
	}
}
