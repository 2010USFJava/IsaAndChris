package com.revature.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.controller.VillainController;
import com.revature.model.SuperVillain;

public class JsonRequestHelper {
	public static void process(HttpServletRequest req, HttpServletResponse resp)
			throws JsonProcessingException, IOException {
		switch (req.getRequestURI()) {
		case "/ExampleFrontController/getsession.json":
			VillainController.getSessionVillain(req, resp);
		default:
			SuperVillain vill = new SuperVillain("?", "?", 0);
			resp.getWriter().write(new ObjectMapper().writeValueAsString(vill));
			;
		}
	}
}
