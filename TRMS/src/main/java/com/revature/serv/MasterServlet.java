package com.revature.serv;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MasterServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		System.out.println("inside MasterServlet doGet");
		req.getRequestDispatcher(RequestHelper.process(req)).forward(req,res);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		System.out.println("inside MasterServlet doPost");
		req.getRequestDispatcher(RequestHelper.process(req)).forward(req,res);
	}
}
