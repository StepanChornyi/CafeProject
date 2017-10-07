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
<title>Order</title>
</head>
<body>
	<div class="container">
	<a href="/profile/cafe/${cafeId}/addorder" class="btn btn-outline-warning btn-sm">Add Order</a>
	<a href="/profile/cafe/${cafeId}/paidorder" class="btn btn-outline-warning btn-sm">Paid Orders</a>
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
							<td>
							<c:forEach var="meal" items="${order.meals}">
							${meal}<br>
							</c:forEach>
							</td>
							<td>${order.price}</td>
							
							<td class="text-center">
							<c:if
									test="${order.status.equals(accepted)}">
									<a
								href="/profile/cafe/${cafeId}/done/${order.id}"
								class="btn btn-outline-info btn-sm">Done</a> 
								</c:if>
								<c:if
									test="${order.status.equals(done)}">
									<a
								href="/profile/cafe/${cafeId}/paid/${order.id}"
								class="btn btn-outline-success btn-sm">Paid</a> 
								</c:if>
							<!-- <a
								href="/profile/cafe/${cafeId}/delete/${order.id}"
								class="btn btn-outline-danger btn-sm">Delete</a></td> -->
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>