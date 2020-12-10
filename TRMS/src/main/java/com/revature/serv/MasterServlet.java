package com.revature.serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daoimpl.AttachmentDaoImpl;
import com.revature.users.Attachment;

public class MasterServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		System.out.println("inside MasterServlet doGet");
		req.getRequestDispatcher(RequestHelper.process(req, res)).forward(req,res);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		System.out.println("inside MasterServlet doPost");
		req.getRequestDispatcher(RequestHelper.process(req, res)).forward(req,res);
	}
}
