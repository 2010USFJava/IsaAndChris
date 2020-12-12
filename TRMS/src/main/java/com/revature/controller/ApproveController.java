package com.revature.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.ApproveService;
import com.revature.users.Form;

public class ApproveController {
	static ApproveService approveService = new ApproveService();

	public static String approve(HttpServletRequest req, HttpServletResponse res) {
		if (SessionController.enforceLogin(req, res)) {
			List<Form> formList = approveService.getEventForms(req);
			req.getSession().setAttribute("formlist", formList);
			return "html/approve_deny_reimbursements.html";
		} else {
			return "html/index.html";
		}
	}
	
	public static void updateApproval(HttpServletRequest req, HttpServletResponse res) {
		try {
			System.out.println(req.getReader().lines().collect(Collectors.joining("&")));
			// Update DB
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
