package com.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;
import com.DAO.*;
import com.util.Page;
import com.util.PageUtil;
import com.util.bean.*;

public class messageList extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException{
		RequestDispatcher requestDispatcher = null;
		ServletContext servletContext = getServletContext();
		Employee employee = (Employee)request.getSession().getAttribute("employee");
		if(employee == null){ // the user has not logged in
			request.setAttribute("error", "Please log in first");
			requestDispatcher = servletContext.getRequestDispatcher("/login.jsp");
		}else{ // if logged in
			MessageDAO messageDAO = MessageDAOFactory.getMessageDAOInstance(); 
			int sumRecord = messageDAO.findAmount(); // set attributes of Page
			int eachPage = 5;
			int currentPage = 1;
			String currentPageStr = request.getParameter("currentPage"); 
			if(currentPageStr == null || "".equals(currentPageStr))
				currentPage = 1;
			else
				currentPage = Integer.parseInt(currentPageStr);
			Page page = PageUtil.createPage(eachPage, sumRecord, currentPage); // get a page object
			servletContext.setAttribute("page", page);
			List<Message> messageList = messageDAO.findAllMessage(page);// get message list
			servletContext.setAttribute("messageList", messageList);
			requestDispatcher = servletContext.getRequestDispatcher("/messages.jsp");
		}
		requestDispatcher.forward(request, response);
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException{
		doPost(request, response);
	}
}
