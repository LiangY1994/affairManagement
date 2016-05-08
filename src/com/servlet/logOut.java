package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class logOut extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws IOException, ServletException{
		HttpSession session = request.getSession();
		session.removeAttribute("employee");
		session.invalidate();
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException{
		doPost(request, response);
	}
}
