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
<title>Order</title>
</head>
<body>
	<div class="container">
	<a href="/profile/cafe/${cafeId}/addorder" class="btn btn-outline-warning btn-sm">Add Order</a>
		<div class="row">
			<div class="col-12">
				<table class="table table-bordered">
					<tr>
						<th class="text-center">Table</th>
						<th class="text-center">Status</th>
						<th class="text-center">Meals</th>
						<th class="text-center">Price</th>
						<th class="text-center">Options</th>
					</tr>
					<c:forEach var="order" items="${orders}">
						<tr>
							<td>${order.table}</td>
							<td>${order.status}</td>
							<td>${order.meals}</td>
							<td>${order.price}</td>
							
							<td class="text-center"><a
								href="/admin/table/update/${order.id}"
								class="btn btn-outline-warning btn-sm">Update</a> <a
								href="/admin/table/delete/${order.id}"
								class="btn btn-outline-danger btn-sm">Delete</a></td>
						</tr>
						
						
						
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>