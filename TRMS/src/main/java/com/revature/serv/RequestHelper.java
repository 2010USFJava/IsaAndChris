package com.revature.serv;

import javax.servlet.http.HttpServletRequest;

import com.revature.controller.HomeController;
import com.revature.controller.LoginController;

public class RequestHelper {

	public static String process(HttpServletRequest req) {
		System.out.println("RequestHelper URI: " + req.getRequestURI());
		switch (req.getRequestURI()) {
		case "/TRMS/login.change":
			System.out.println("RequestHelper.process case: login.change");
			return LoginController.login(req);
		case "/TRMS/home.change":
			System.out.println("RequestHelper.process case: home.change");
			return HomeController.home(req);
		default:
			System.out.println("RequestHelper.process case: default");
			return "html/unsuccessfullogin.html";
		}
	}

}
