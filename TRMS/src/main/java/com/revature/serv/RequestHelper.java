package com.revature.serv;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controller.ApproveController;
import com.revature.controller.ConfirmController;
import com.revature.controller.FormController;
import com.revature.controller.HomeController;
import com.revature.controller.LoginController;

public class RequestHelper {

	public static String process(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("RequestHelper URI: " + req.getRequestURI());
		switch (req.getRequestURI()) {
		case "/TRMS/login.change":
			System.out.println("RequestHelper.process case: login.change");
			return LoginController.login(req, res);
		case "/TRMS/home.change":
			System.out.println("RequestHelper.process case: home.change");
			return HomeController.home(req);
		case "/TRMS/newform.change":
			System.out.println("RequestHelper.process case: newform.change");
			return FormController.form(req);
		case "/TRMS/approve.change":
			System.out.println("RequestHelper.process case: approve.change");
			return ApproveController.approve(req);
		case "/TRMS/confirm.change":
			System.out.println("RequestHelper.process case: confirm.change");
			return ConfirmController.confirm(req);
		default:
			System.out.println("RequestHelper.process case: default");
			return "html/unsuccessfullogin.html";
		}
	}

}
