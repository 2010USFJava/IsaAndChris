package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MasterServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		System.out.println("MasterServlet.doGet");
		req.getRequestDispatcher(RequestHelper.process(req)).forward(req,resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		System.out.println("MasterServlet.doPost");
		req.getRequestDispatcher(RequestHelper.process(req)).forward(req,resp);
	}
}
