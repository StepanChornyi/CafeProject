<%@ include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<title>Profile</title>
</head>
<body>
	<div class="container">
		<h2>Profile</h2>
		<a href="/profile/addcafe" class="btn btn-outline-success">Add cafe</a> 
		<a href="/profile/meal" class="btn btn-outline-success">Meals</a>
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<tr>
						<th class="text-center">Name</th>
						<th class="text-center">Type</th>
						<th class="text-center">Phone</th>
					</tr>
					<c:forEach var="cafe" items="${cafes}">
						<tr >
							<td><a href="profile/cafe/${cafe.id}">${cafe.name}</a></td>
							<td>${cafe.type}</td>
							<td>${cafe.phone}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>	
</body>
</html>