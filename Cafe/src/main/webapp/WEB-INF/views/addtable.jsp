<%@ include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<title>Add table</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<form:form action="/profile/cafe/addtable/${cafeId}" method="POST"
					modelAttribute="addtable">
					<div class="form-group row">
						<label class="col-2 col-form-label" for="tableNumber">Table
							number :</label>
						<div class="col-10">
							<form:input class="form-control" id="tableNumber"
								path="tableNumber" />
							<form:errors path="tableNumber" style="color:red;"/>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="countOfPeople">Count
							of chairs :</label>
						<div class="col-10">
							<form:input class="form-control" id="countOfPeople"
								path="countOfPeople" />
								<form:errors path="countOfPeople" style="color:red;"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-10 ml-auto">
							<button class="btn btn-sm btn-outline-success">Save</button>
							<a href="/profile/cafe/addtable/${cafeId}/cancel"
								class="btn btn-sm btn-outline-warning">Cancel</a>
						</div>
					</div>
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<tr>
						<th class="text-center">Table number</th>
						<th class="text-center">Chairs</th>
						<th class="text-center">Is Free</th>
						<th class="text-center">Cafe</th>
						<th class="text-center">User</th>
						<th class="text-center">User phone</th>
						<th class="text-center">Options</th>
					</tr>
					<c:forEach var="table" items="${tables}">
						<tr>
							<td>${table.tableNumber}</td>
							<td>${table.countOfPeople}</td>
							<td>${table.isFree}</td>
							<td>${table.cafe}</td>
							<td>${table.user}</td>
							<td>${table.userPhone}</td>


							<td class="text-center"><a
								href="/profile/cafe/addtable/${cafeId}/update/${table.id}"
								class="btn btn-outline-warning btn-sm">Update</a> <a
								href="/profile/cafe/addtable/${cafeId}/delete/${table.id}"
								class="btn btn-outline-danger btn-sm">Delete</a> 
								<c:if
									test="${table.getIsFree().equals(true)}">
									<a href="/profile/cafe/addtable/${cafeId}/reserve/${table.id}"
										class="btn btn-outline-success btn-sm">Reserve</a>
								</c:if> <c:if test="${table.getIsFree().equals(false)}">
									<a
										href="/profile/cafe/addtable/${cafeId}/dereserve/${table.id}"
										class="btn btn-outline-danger btn-sm">Dereserve</a>
								</c:if></td>
						</tr>
					</c:forEach>
				</table>
				<a href="/profile"
					class="btn btn-outline-secondary">Profile</a>
			</div>
		</div>
	</div>
</body>
</html>