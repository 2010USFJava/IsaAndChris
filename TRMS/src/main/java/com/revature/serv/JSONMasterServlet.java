package com.revature.serv;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;

public class JSONMasterServlet extends HttpServlet{

		

		protected void doGet(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
			System.out.println("JSONMasterServlet doGet");
			JSONRequestHelper.process(req, res);
		}
		
		protected void doPost(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
			System.out.println("JSONMasterServlet doPost");
			JSONRequestHelper.process(req, res);
		}
		
}
