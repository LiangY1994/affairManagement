package com.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import com.DAO.*;
import com.util.bean.Employee;
import com.util.bean.Message;

public class newMessage extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException{
		Employee employee = (Employee)request.getSession().getAttribute("employee");
		String employeeName = employee.getEmployeeName(); // get employee name from session
		Message message = new Message(); // create a message
		Date date = new Date();
		message.setMessageDate(date);
		message.setEmployeeName(employeeName);
		message.setMessageTitle(request.getParameter("title"));
		message.setMessageContent(request.getParameter("content"));
		MessageDAO messageDAO = MessageDAOFactory.getMessageDAOInstance();
		messageDAO.addMessage(message, employeeName);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException{
		doPost(request, response);
	}
}
