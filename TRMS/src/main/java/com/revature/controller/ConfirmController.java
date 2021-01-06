package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.service.ConfirmService;
import com.revature.users.Form;

public class ConfirmController {
	static ConfirmService confirmService = new ConfirmService();

	public static String confirm(HttpServletRequest req, HttpServletResponse res) {
		if (SessionController.enforceLogin(req, res)) {
			List<Form> formList = confirmService.getEventForms(req);
			req.getSession().setAttribute("formlist", formList);
			return "html/confirm_grade_presentation.html";
		} else {

			return "html/index.html";
		}
	}

}
