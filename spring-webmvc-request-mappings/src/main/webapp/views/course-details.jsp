<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Course Details</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

</head>
<body>

	<div class="container pt-4">
		<h1>Course Details</h1>
		
		<div class="row">
			<div class="col-6">
			
			<c:if test="${not empty result }">
				<div class="alert alert-success">
					${result.message}
				</div>
			</c:if>
			
				<c:url value="/course" var="saveUrl"></c:url>
				<form method="post" action="${saveUrl}">
					<div class="mb-4">
						<label for="id" class="mb-1">Course Id</label>
						<input id="id" name ="id" type="number" value="${course.id}" readonly="readonly" class="form-control"/>
					</div>
					<div class="mb-4">
						<label for="name" class="mb-1">Course Name</label>
						<input id="name" name ="name" type="text" value="${course.name}" readonly="readonly" class="form-control"/>
					</div>
					<div class="mb-4">
						<label for="level" class="mb-1">Course Level</label>
						<input id="level" name ="level" type="text" value="${course.level}" readonly="readonly" class="form-control"/>
					</div>
					<div class="mb-4">
						<label for="duration" class="mb-1">Course Duration</label>
						<input id="duration" name ="duration" type="number" value="${course.duration}" readonly="readonly" class="form-control"/>
					</div>
					<div class="mb-4">
						<label for="fees" class="mb-1">Course Fees</label>
						<input id="fees" name ="fees" type="number" value="${course.fees}" readonly="readonly" class="form-control"/>
					</div>
				</form>
				
			</div>
		</div>
		
	</div>
	
</body>
</html>