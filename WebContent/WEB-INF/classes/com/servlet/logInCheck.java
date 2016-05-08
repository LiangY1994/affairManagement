package com.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import com.DAO.*;
import com.util.bean.*;

import java.io.*;

public class logInCheck extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException{
		ServletContext servletContest = getServletContext(); // set servlet contest;
		RequestDispatcher dispatcher = null;
		String employeeID = request.getParameter("id"); // get id
		String employeePassword = request.getParameter("password"); // get password
		EmployeeDAO employeeDAO = EmployeeDAOFactory.getEmployeeDAOInstance();
		Employee employee = employeeDAO.findEmployee(Integer.parseInt(employeeID));
		if(employee == null){
			request.setAttribute("error", "This ID does not exist");
			dispatcher = servletContest.getRequestDispatcher("/login.jsp");
		}else{
			if(employeePassword.equals(employee.getEmployeePassword())){
				request.getSession().setAttribute("employee", employee);
				// get latest message
				MessageDAO messageDAO = MessageDAOFactory.getMessageDAOInstance();
				int messageID = messageDAO.findAmount();
				Message latestMessage = messageDAO.findMessage(messageID);
				request.getSession().setAttribute("latestMessage", latestMessage);
				dispatcher = servletContest.getRequestDispatcher("/index.jsp");
			}else{
				request.setAttribute("error", "Password incorrect");
				dispatcher = servletContest.getRequestDispatcher("/login.jsp");
			}
		}
		dispatcher.forward(request, response);
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException{
		doPost(request, response);
	}
}
