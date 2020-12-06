package com.revature.serv;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.controller.UserController;
import com.revature.users.User;

public class JSONRequestHelper {

	public static void process(HttpServletRequest req, HttpServletResponse res)
			throws IOException, JsonProcessingException {
		switch (req.getRequestURI()) {
		case "/TRMS/getsession.json":
			System.out.println("JSONRequestHelper.process req = " + req.toString());
			UserController.getUserSession(req, res);
		default:
			User user = new User(0, "?", "?");
			res.getWriter().write(new ObjectMapper().writeValueAsString(user));
		}
	}

}
