package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.service.ApproveService;

public class ApproveController {

	public static String approve(HttpServletRequest req) {

		return "html/approve_deny_reimbursements.html";
	}

}
