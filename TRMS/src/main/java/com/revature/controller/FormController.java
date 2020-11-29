package com.revature.controller;

import javax.servlet.http.HttpServletRequest;


public class FormController {
//	static VillainService vServ = new VillainService();
	
	public static String form(HttpServletRequest req) {
		if(!req.getMethod().equals("POST")) {
			return "FrontEndFiles/HTML/form.html";
		}
		return null;//don't need
		
//		String name = req.getParameter("villainname");
//		String superpower = req.getParameter("superpower");
//		SuperVillain vill = vServ.loginGetVillain(name, superpower);
//		if(vill==null) {
//			return "wrongcreds.change";
//		}else {
//			req.getSession().setAttribute("currentvill", vill);
//			return "home.change";
//		}
		
	}
}
