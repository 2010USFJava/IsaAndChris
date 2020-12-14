package com.revature.serv;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.controller.ApproveController;
import com.revature.controller.ConfirmController;
import com.revature.controller.FormController;
import com.revature.controller.HomeController;
import com.revature.controller.LoginController;
import com.revature.controller.SessionController;

public class RequestHelper {

	public static String process(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("RequestHelper URI: " + req.getRequestURI());
		switch (req.getRequestURI()) {
		case "/TRMS/login.change":
			System.out.println("RequestHelper.process case: login.change");
			return LoginController.login(req, res);
		case "/TRMS/home.change":
			System.out.println("RequestHelper.process case: home.change");
			return HomeController.home(req, res);
		case "/TRMS/newform.change":
			System.out.println("RequestHelper.process case: newform.change");
			return FormController.form(req, res);
		case "/TRMS/approve.change":
			System.out.println("RequestHelper.process case: approve.change");
			return ApproveController.approve(req, res);
		case "/TRMS/raiseapprovallevel.change":
			System.out.println("RequestHelper.process case: eventapproval.change");
			ApproveController.raiseApproval(req, res);
			return "html/approve_deny_reimbursements.html";
		case "/TRMS/denyevent.change":
			ApproveController.deny(req, res);
			return "html/approve_deny_reimbursements.html";
		case "/TRMS/confirm.change":
			System.out.println("RequestHelper.process case: confirm.change");
			return ConfirmController.confirm(req, res);
		case "/TRMS/logout.change":
			System.out.println("RequestHelper.process case: logout.change");
			return SessionController.logout(req);
		default:
			System.out.println("RequestHelper.process case: default");
			return "html/unsuccessfullogin.html";
		}
	}

}
