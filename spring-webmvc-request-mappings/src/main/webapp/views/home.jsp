<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to My WebMvc</title>
</head>
<body>

	<h1>MVC request mappings</h1>
	
	<ul>
		<li>
			<c:url value="/multi" var="multi"></c:url>
			<a href="${multi}">Multi Actions</a>
		</li>
		<li>
			<c:url value="/inputs" var="inputs"></c:url>
			<a href="${inputs}">Inputs</a>
		</li>
		<li>
			<c:url value="/course" var="course"></c:url>
			<a href="${course}">Course List</a>
		</li>
	</ul>
	
</body>
</html>