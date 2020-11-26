package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.model.SuperVillain;
import com.revature.service.VillainService;

public class LoginController {

	static VillainService vServ = new VillainService();

	public static String login(HttpServletRequest req) {
		if (!req.getMethod().equals("POST")) {
			return "resources/html/index.html";
		}

		String name = req.getParameter("villainname");
		String superPower = req.getParameter("superpower");
		SuperVillain vill = vServ.loginGetVillain(name, superPower);
		if (vill == null) {
			return "wrongcreds.change";
		} else {
			req.getSession().setAttribute("currentvill", vill);
			return "home.change";
		}
	}
}
