<%@page import="org.apache.jasper.tagplugins.jstl.core.When"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.sql.*"%>
<%@page import="com.util.*" %>
<%@page import="com.DAO.*"%>
<%@page import="com.util.bean.*" %>
<!DOCTYPE html>
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
	
	<div id="messageAccess">
		Title: ${messageAccess.getMessageTitle() } <br />
		Content: ${messageAccess.getMessageContent() } <br />
	</div>
	<form action="newReply" method="post">
		MessageID: <input name="messageID" value="${messageAccess.getMessageID }" />
		Reply: <input type="text" name="reply" required="required" />
		<input type="submit" value="Submit" />
	</form>
	<div id="footer">Affair Management System @Liang Yi</div>
</body>
</html>