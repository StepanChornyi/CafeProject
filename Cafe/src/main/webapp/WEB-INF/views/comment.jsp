<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<title>Comment</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-12">
			
			<form:form action="/cafe/${cafeId}/comments" method="POST" modelAttribute="comment">
					<div class="form-group row">
						<label class="col-2 col-form-label" for="user">User:</label>
						<div class="col-10">
							<form:input class="form-control" id="user" path="user"/>
						</div>
					</div>
					 <div class="form-group row">
						<label class="col-2 col-form-label" for="comment">Comment:</label>
						<div class="col-10">
							<form:textarea class="form-control" id="comment"
								path="comment" rows="5"></form:textarea>
						</div>
					</div>
					<div class="form-group row">
						<label class="col-2 col-form-label" for="rate">Rate:</label>
						<div class="col-10">
							<form:input class="form-control" id="rate" path="rate"/>
						</div>
					</div>
					<div class="form-group row">
						<div class="col-10 mr-left">
							<button class="btn btn-sm btn-outline-success">Save</button>
						</div>
					</div>
				</form:form>
				<table class="table table-bordered">
					<tr>
						<th class="text-center">User</th>
						<th class="text-center">Comment</th>
						<th class="text-center">Rate</th>
					</tr>
					<c:forEach var="comment" items="${comments}">
						<tr>
							<td>${comment.user}</td>
							<td>${comment.comment}</td>
							<td>${comment.rate}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<a href="/cafedesc/${cafeId}" class="btn btn-sm btn-outline-secondary">Cafe</a>
	</div>
</body>
</html>