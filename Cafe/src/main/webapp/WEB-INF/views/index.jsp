<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<title>Cafe</title>
<style>
.one {
	border: 2px solid black;
	border-radius: 8px;
	border-spacing: 10;
	padding: 4px;
	margin: 1px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="row">
		<div class="col-8">
				<a href="/cafe" class="btn btn-sm btn-outline-primary">All Cafes</a>
				<a href="/maels" class="btn btn-sm btn-outline-primary">All Meals</a>
			</div>
			<div class="col-4 text-right">
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<form:form action="/logout">
						<a href="/admin" class="btn btn-sm btn-outline-primary">Admin</a>
						<button class="btn btn-primary btn-sm">Logout</button>
					</form:form>
				</sec:authorize>

				<sec:authorize access="isAnonymous()">
					<a href="/login" class="btn btn-primary btn-sm">Login</a>
					<a href="/registration" class="btn btn-secondary btn-sm">Registration</a>
				</sec:authorize>

				<sec:authorize access="hasRole('ROLE_CAFE')">
					<form:form action="/logout">
						<a href="/profile" class="btn btn-sm btn-outline-primary">Profile</a>
						<button class="btn btn-primary btn-sm">Logout</button>
					</form:form>
				</sec:authorize>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<tr>
						<th class="text-center">Name</th>
						<th class="text-center">Type</th>
						<th class="text-center">Rate</th>
					</tr>
					<c:forEach var="cafe" items="${cafes}">
						<tr>
							<td><a href="/cafedesc/${cafe.id}">${cafe.name}</a></td>
							<td>${cafe.type}</td>
							<td>${cafe.rate}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>

	</div>

</body>
</html>