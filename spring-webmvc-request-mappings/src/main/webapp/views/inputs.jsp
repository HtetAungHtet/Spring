<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>INPUTS</title>
</head>
<body>

	<h1>User INPUTs</h1>
	
	<div>
		<c:if test="${not empty type and not empty id }">
			<h3>${type} / ${id}</h3>
		</c:if>
		
		<c:if test="${not empty date }">
			<h3>${date}</h3>
		</c:if>
	</div>
	
	<ul>
		<li>
			<c:url value="/inputs/Path type/search/100" var="pathLink"></c:url>
			<a href="${pathLink}">Path Variables</a>
		</li>
		<li>
			<c:url value="/inputs/2023-04-09" var="dateLink"></c:url>
			<a href="${dateLink}">Date Variables</a>
		</li>
		<li>
			<c:url value="/inputs/Basic" var="enumLink"></c:url>
			<a href="${enumLink}">Enum Variables</a>
		</li>
		<li>
			<c:url value="/inputs/matrix/western%20shirt;s=L" var="matrix"></c:url>
			<a href="${matrix}">Using Matrix</a>
		</li>
		<li>
			<c:url value="/inputs/request?p=Jean&w=30&l=30" var="request"></c:url>
			<a href="${request}">Request Params</a>
		</li>
	</ul>
</body>
</html>