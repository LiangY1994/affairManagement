package com.servlet;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.*;

import com.DAO.MessageDAO;
import com.DAO.MessageDAOFactory;
import com.util.bean.Message;

import java.util.*;

public class messageContent extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException{
		String tempID = request.getParameter("id");
		int id = Integer.parseInt(tempID);
		ServletContext servletContext = getServletContext();
		RequestDispatcher requestDispatcher = null;
		try{
			MessageDAO messageDAO = MessageDAOFactory.getMessageDAOInstance();
			Message messageAccess = messageDAO.findMessage(id);
			request.getSession().setAttribute("messageAccess", messageAccess);
			requestDispatcher = servletContext.getRequestDispatcher("/messageContent.jsp");
		}catch(Exception e){
			e.printStackTrace();
		}
		requestDispatcher.forward(request, response);
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException{
		doPost(request, response);
		}
}
