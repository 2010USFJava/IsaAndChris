package com.revature.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.core.util.IOUtils;

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


	public static void raiseApproval(HttpServletRequest req, HttpServletResponse res) {
		try {
			String eventId = IOUtils.toString(req.getReader());
			System.out.println("ApproveController.raiseApproval body = " + eventId);
			approveService.raiseApprovalLevel(eventId);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void deny(HttpServletRequest req, HttpServletResponse res) {
		try {
			String eventId = IOUtils.toString(req.getReader());
			System.out.println("ApproveController.deny body = " + eventId);
			approveService.denyEvent(eventId);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
