package com.yuriy.sample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet(description = "A simple servlet", urlPatterns = { "/SimpleServletPath" },
            initParams = { @WebInitParam(name="defaultUser", value="Aleph") })
public class SimpleServletSession extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int testvar = 0;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println(testvar++);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();
		if (userName != "" && userName != null) {			
			session.setAttribute("sevedUserName", userName);
			context.setAttribute("sevedUserName", userName);
		}
		
		out.println("<p>Request parameter has user name: " + userName + "</p>");
		out.println("<p>Session parameter has user name: " + (String) session.getAttribute("sevedUserName") + "</p>");
		out.println("<p>Context parameter has user name: " + (String) context.getAttribute("sevedUserName") + "</p>");
	
		out.println("<p>Init parameter has default user name: " 
		  + (String) this.getServletConfig().getInitParameter("defaultUser") + "</p>");
	    
	}

}
