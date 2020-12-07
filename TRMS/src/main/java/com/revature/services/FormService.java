package com.revature.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.daoimpl.FormDaoImpl;
import com.revature.users.Form;

public class FormService {
	static FormDaoImpl fdi = new FormDaoImpl();

	public static void getFormSession(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
//		ObjectMapper om = new ObjectMapper();
//		om.writeValueAsString(res.get)
		
		
		
		
		
		
		
		
//		Form form = (Form) req.getSession().getAttribute("currentuser");
//		res.getWriter().write(new ObjectMapper().writeValueAsString(form));
		
//		PrintWriter printOut = res.getWriter();
//		res.setContentType("TRMS/json");
//		res.setCharacterEncoding("UTF-8");
	//	printOut.print(b);
//		printOut.flush();
		//response headers must be set before the response is committed
		
		
		//should of had a session with your login
	}
}
	
	
