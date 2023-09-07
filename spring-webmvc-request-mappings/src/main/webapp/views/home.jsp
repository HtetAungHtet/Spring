<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to My WebMvc</title>
</head>
<body>

	<div class="container">
		<div class="row mb-4">
			<h2>MVC request mappings</h2>
		</div>

		<div>
			<ul>
			<li>
				<c:url value="/multi" var="multi"></c:url>
				<a href="${multi}"><h4>Multi Actions</h4></a>
			</li>
			<li>
				<c:url value="/inputs" var="inputs"></c:url>
				<a href="${inputs}"><h4>Path Variables</h4></a>
			</li>
			<li>
				<c:url value="/course" var="course"></c:url>
				<a href="${course}"><h4>Return Type Demo</h4></a>
				
			</li>
		</ul>
		
		</div>
	</div>
	
</body>
</html>