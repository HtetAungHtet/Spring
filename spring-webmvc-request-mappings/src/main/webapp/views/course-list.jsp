<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Course List</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
</head>
<body>

	<div class="container pt-4">
		<h1>Course List</h1>
		
		<div class="mt-4">
			
			<div>
				<c:url value="/course/edit" var="courseEdit"></c:url>
				<a href="${courseEdit}" class="btn btn-primary mb-4">Add New Course</a>
			</div>
			
		
			<table class="table">
			
				<thead>
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Level</th>
						<th>Duration</th>
						<th>Fees</th>
					</tr>
				</thead>
				<tbody>
					
					<c:forEach var="c" items="${list}">
						<tr>
							<td>${c.id}</td>
							<td>
								<c:url value="/course/${c.id }" var="detailsUrl"></c:url>
								<a href="${detailsUrl}">${c.name}</a>
							</td>
							<td>${c.level}</td>
							<td>${c.duration}</td>
							<td>${c.fees}</td>
						</tr>
					</c:forEach>		
					
				</tbody>
			</table>
		</div>
	</div>

</body>
</html>