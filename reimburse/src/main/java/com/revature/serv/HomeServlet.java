package com.revature.serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HomeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HomeServlet.doGet");
		request.getRequestDispatcher("login.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("HomeServlet.doPost");
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		pw.write("<h3>Log out</h3>");
		pw.close();
	}

}
