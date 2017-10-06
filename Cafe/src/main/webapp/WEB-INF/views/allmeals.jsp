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
<title>Meal</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<tr>
						<th class="text-center">Title</th>
						<th class="text-center">Cafe</th>
						<th class="text-center">Price</th>
						<th class="text-center">Weight</th>
					</tr>
					<c:forEach var="meal" items="${meals.content}">
						<tr>
							<td>${meal.title}</td>
							<td><a href="/meal/${meal.cafe}">${meal.cafe}</a></td>
							<td>${meal.price}</td>
							<td>${meal.weight}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<div class="row">
			<div class="col-12 text-center">
				<custom:pageable page="${meals}"/>
			</div>
		</div>
	</div>
</body>
</html>