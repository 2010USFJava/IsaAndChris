package com.revature.serv;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controller.FormController;
import com.revature.controller.HomeController;
import com.revature.controller.LoginController;

public class RequestHelper {
		
	
	public static String process(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("RequestHelper URI: " + req.getRequestURI());
		
		switch(req.getRequestURI()) {
		case "/TRMS/login.change":
				System.out.println("RequestHelper process case: login.change");
				return LoginController.login(req);
		case "/TRMS/home.change":
			System.out.println("RequestHelper process case: home.change");
				return HomeController.home(req);
		case "/TRMS/form.change":
				System.out.println("RequestHelper.process case: form.change");
				return FormController.form(req);
		case "/TRMS/dashboard.change":
				System.out.println("RequestHelper.process case: dashboard.change");
				return HomeController.home(req);
		default:
			System.out.println("RequestHelper.process default case");
			return "HTML/unsuccessfullogin.html";
		}
	}
}
