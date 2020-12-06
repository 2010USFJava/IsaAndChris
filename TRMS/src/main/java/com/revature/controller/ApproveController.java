package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.service.ApproveService;

public class ApproveController {

	public static String approve(HttpServletRequest req) {
		ApproveService approveService = new ApproveService();
		if (!req.getMethod().equals("POST")) {
			return "html/home.html";
		} else {
			approveService.getEventApplications(req);
			return "html/approve_deny_reimbursements.html";
		}
	}

}
