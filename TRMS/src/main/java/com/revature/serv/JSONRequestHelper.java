package com.revature.serv;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.controller.FormController;
import com.revature.controller.UserController;
import com.revature.services.FormService;
import com.revature.users.Form;

public class JSONRequestHelper {
	
	public static void process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		switch(req.getRequestURI()) {
			case "/TRMS/getsession.json":
				UserController.getUserSession(req, res);
				break;
			
			default:
				Form form = new Form(0, 0, null, null, "?", 0, null, "?", "?", false, false);
				res.getWriter().write(new ObjectMapper().writeValueAsString(form));
		}
	}

}
