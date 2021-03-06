<%@ include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<title>Ingredient</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<form:form action="/admin/ingredient" method="POST" modelAttribute="ingredient">
					<div class="form-group row">
						<label class="col-2 col-form-label" for="name">Name:</label>
						<div class="col-10">
							<form:input class="form-control" id="name" path="name"/>
							<form:errors path="name" style="color:red;"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-10 mr-left">
							<button class="btn btn-sm btn-outline-success">Save</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<tr>
						<th class="text-center">Name</th>
						<th class="text-center">Options</th>
					</tr>
					<c:forEach var="ingredient" items="${ingredients}">
						<tr>
							<td>${ingredient.name}</td>
							<td class="text-center">
								<a href="/admin/ingredient/update/${ingredient.id}" class="btn btn-outline-warning btn-sm">Update</a>
								<!-- <a href="/admin/ingredient/delete/${ingredient.id}" class="btn btn-outline-danger btn-sm">Delete</a> -->
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>