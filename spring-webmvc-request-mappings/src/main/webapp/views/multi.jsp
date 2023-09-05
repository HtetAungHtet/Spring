<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Multi Controllers</title>
</head>
<body>

	<h1>Multi Controllers</h1>
	
	<p>${not empty message ? message : 'default action '}</p>

	<ul>
		<li>
			<c:url value="/multi/action1" var="action1"></c:url>
			<a href="${action1 }">Action 1</a>
		</li>
		<li>
			<c:url value="/multi/action2" var="action2"></c:url>
			<a href="${action2 }">Action 2</a>
		</li>
		<li>
			<c:url value="/multi/action2?id=1" var="action2id"></c:url>
			<a href="${action2id }">Action 2 with Id</a>
		</li>
		<li>
			<c:url value="/multi/happy" var="wildcard"></c:url>
			<a href="${wildcard }">Wild Card</a>
		</li>
		<li>
			<c:url value="/multi/10" var="digit"></c:url>
			<a href="${digit}">Digit</a>
		</li>
		<li>
			<c:url value="/" var="home"></c:url>
			<a href="${home }">Back To Home</a>
		</li>
	</ul>
</body>
</html>