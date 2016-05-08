<%@page import="org.apache.jasper.tagplugins.jstl.core.When"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.sql.*"%>
<%@page import="com.util.*" %>
<%@page import="com.DAO.*"%>
<%@page import="com.util.bean.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Affair Management</title>
	<link rel="stylesheet" type="text/css" href="css/main.css" />
</head>
<body>
	<img id="banner" src="images/banner.jpg" />
	<div id="banner2">Affair Management Web Site</div>
	<div class="blank"></div>
	<ul id="navi">
		<li><a href="login.jsp">Log_In</a></li>
		<li><a href="newMessage.jsp">New_Message</a></li>
		<li><a href="messages">Messages</a></li>
		<li><a href="">Home</a></li>
	</ul>
	<img src="images/partition.gif" />
	<div id="employee">
		<c:choose>
			<c:when test="${empty sessionScope.employee }">
				<h2>Please log in</h2>
			</c:when>
			<c:otherwise>
				<h2>Employee Information</h2>
				<ul>
					<li>Employee ID: ${employee.employeeID }</li>
					<li>Employee Name: ${employee.employeeName }</li>
					<li>Is Lead: ${employee.isLead }</li>
				</ul>
			</c:otherwise>
		</c:choose>
	</div>
	<div id="message">
		<c:choose>
			<c:when test="${empty sessionScope.employee }">
				<h2>Please log in</h2>
			</c:when>
			<c:otherwise>
				<h2>Latest Message</h2>
				<h3>
					Publisher: ${latestMessage.getEmployeeName() }
				</h3>
				<h3>
					Publish Time: ${latestMessage.getMessageDate() }
				</h3>
				<h3>
					Content: ${latestMessage.getMessageContent() }
				</h3>
			</c:otherwise>
		</c:choose>
	</div>
	<div id="footer">Affair Management System @Liang Yi</div>
</body>
</html>