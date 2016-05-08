<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>New Message</title>
	<link rel="stylesheet" type="text/css" href="css/main.css" />
</head>
<body>
	<img id="banner" src="images/banner.jpg" />
	<div id="banner2">Affair Management Web Site</div>
	<ul id="navi">
		<li><a href="login.jsp">Log_In</a></li>
		<li><a href="">New_Message</a></li>
		<li><a href="messages">Messages</a></li>
		<li><a href="index.jsp">Home</a></li>
	</ul>
	<img src="images/partition.gif" />
	<c:choose>
			<c:when test="${empty sessionScope.employee }">
				<h2>Please log in</h2>
			</c:when>
			<c:otherwise>
				<form action="submitMessage.do" method="post">
					Title: <br /> <input type="text" name='title' required="required" /> <br />
					Content:<br/> <input type="text" name='content' required="required" /> <br/>
					<input type="submit" value="Send it!" />
				</form>
			</c:otherwise>
		</c:choose>
	<div id="footer">Affair Management System @Liang Yi</div>
</body>
</html>