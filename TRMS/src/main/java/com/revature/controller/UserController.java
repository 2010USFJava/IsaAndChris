package com.revature.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.users.Users;

public class UserController {

	public static void getUserSession(HttpServletRequest req, HttpServletResponse res)
			throws JsonProcessingException, IOException {
		Users user = (Users) req.getSession().getAttribute("currentUser");
		res.getWriter().write(new ObjectMapper().writeValueAsString(user));
	}

}
