<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Log In</title>
	<link rel="stylesheet" type="text/css" href="css/main.css" />
</head>
<body>
	<img id="banner" src="images/banner.jpg" />
	<div id="banner2">Affair Management Web Site</div>
	<ul id="navi">
		<li><a href="">Log_In</a></li>
		<li><a href="newMessage.jsp">New_Message</a></li>
		<li><a href="messages">Messages</a></li>
		<li><a href="index.jsp">Home</a></li>
	</ul>
	<img src="images/partition.gif" />
	<c:choose>
			<c:when test="${empty sessionScope.employee }">
				<div id="login">
					${requestScope.error }
					<form method="post" action="logInCheck.do">
						<h2>Employee Log In</h2> <br />
						Employee Id: <input type="text" name="id" required="required" /><br />
						Password: <input type="password" name="password" required="required" /><br />
						<input type="submit" value="LogIn" />
					</form>
				</div>
			</c:when>
			<c:otherwise>
				<ul>
					<li>Employee ID: ${employee.employeeID }</li>
					<li>Employee Name: ${employee.employeeName }</li>
					<li>Is Lead: ${employee.isLead }</li>
				</ul>
				<form action="logOut.do" method="post">
					<input type="submit" value="Log_Out" />
				</form>
			</c:otherwise>
		</c:choose>
	<div id="footer">Affair Management System @Liang Yi</div>
</body>
</html>
