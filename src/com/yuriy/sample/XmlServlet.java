package com.yuriy.sample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class XmlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public XmlServlet(){
		super();
		System.out.println("Servlet XmlServlet is created.");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("XML servlet called");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		out.println("User name (GET method): " + userName);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("XML servlet called");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		String fullName = request.getParameter("fullName");
		out.println("<p>User name (POST method): " + userName + "</p><p>" +
		            "Full name (POST method): " + fullName + "</p>");
		
		String prof = request.getParameter("prof");
		out.println("<p>You are a " + prof + "</p>");
		
		//String location = request.getParameter("location");
		String[] location = request.getParameterValues("location");
		out.println("<p>You are at " + location.length + " places:</p>");
		for (int i = 0; i < location.length; i++) {
			out.println("<p>    " + location[i] + "</p>");
		}
	}

}
