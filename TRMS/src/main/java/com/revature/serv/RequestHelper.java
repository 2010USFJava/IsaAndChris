package com.revature.serv;

import javax.servlet.http.HttpServletRequest;

import com.revature.controller.FormController;

public class RequestHelper {
		
	
	public static String process(HttpServletRequest req) {
		System.out.println("RequestHelper URI: " + req.getRequestURI());
		
		switch(req.getRequestURI()) {
		case "/TRMS/form.change":
				System.out.println("RequestHelper.process case: form.change");
				return FormController.form(req);
		default:
			System.out.println("RequestHelper.process default case");
			return "html/index.html";
		}
	}
}
