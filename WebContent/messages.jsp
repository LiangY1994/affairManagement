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
	<title>Messages</title>
	<link rel="stylesheet" type="text/css" href="css/main.css" />
</head>
<body>
	<img id="banner" src="images/banner.jpg" />
	<div id="banner2">Affair Management Web Site</div>
	<div class="blank"></div>
	<ul id="navi">
		<li><a href="login.jsp">Log_In</a></li>
		<li><a href="newMessage.jsp">New_Message</a></li>
		<li><a href="">Messages</a></li>
		<li><a href="index.jsp">Home</a></li>
	</ul>
	<img src="images/partition.gif" />
	<div id="message">
		<div id="messages">
			<c:forEach items="${messageList }" var="message">
				<h2>Title: <a href="messageContent?id=${message.getMessageID() }"> ${message.getMessageTitle() }</a> </h2>
				<h3>
					Publisher: ${message.getEmployeeName() };
					Publish Time: ${message.getMessageDate() }
				</h3>
				<br />
			</c:forEach>
		</div>
		<div id="pageNavi">
			<c:choose>
				<c:when test="${page.hasPreviousPage }">
					<a href="messages?currentPage=1">First Page</a>
					<a href="messages?currentPage=${page.currentPage-1 }">Previous Page</a>
				</c:when>
				<c:otherwise>
					<a href="messages?currentPage=1">First Page</a>
				</c:otherwise>
			</c:choose>
			<c:choose>
				<c:when test="${page.hasNextPage }">
					<a href="messages?currentPage=${page.currentPage+1 }">Next Page</a>
					<a href="messages?currentPage=${page.numPage }">Last Page</a>
				</c:when>
			</c:choose>
			<br />
			<center>We are at Page N.${page.currentPage }; In total we have ${page.numPage } pages</center>
		</div>
	</div>
	<div id="footer">Affair Management System @Liang Yi</div>
</body>
</html>