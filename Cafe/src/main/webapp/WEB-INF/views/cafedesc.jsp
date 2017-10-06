<%@ include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<title>CafeDesc</title>
<style>

</style>
</head>
<body>
	<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="row">
						<div class="col-6">
										<h1>${cafe.name}</h1>
										<h4>${cafe.type}<br>
										${cafe.rate}<br>
										${cafe.address}<br>
										${cafe.phone}<br>
										${cafe.open}-${cafe.close}<br></h4>
										<h5>${cafe.fullDescription}</h5>
						</div>				
						<div class="col-4 text-right">
							<img src="https://upload.wikimedia.org/wikipedia/commons/c/c2/Daisy_Cafe%2C_White_Conduit_Street%2C_Islington_-_geograph.org.uk_-_1523976.jpg" width="500px">
						</div>
					</div>
				</div>
		</div>
		<div class="row">		
			<div class="col-12">
				<table class="table table-bordered">
						<tr>
							<th>Meal title</th>
							<th>Meal cuisine</th>
							<th>Meal weight</th>
							<th>Meal price</th>
							<th>Meal description</th>
							<th>Meal ingredients</th>
						<tr>
					<c:forEach var="meal" items="${meals}">
						<tr>
							<td>${meal.title}</td>
							<td>${meal.cuisine.name}</td>
							<td>${meal.weight}</td>
							<td>${meal.price}</td>
							<td>${meal.description}</td>
							<td>
								<c:forEach var="ingredient" items="${meal.ingredients}">
									${ingredient.name} 
								</c:forEach>
							</td>
						<tr>
					</c:forEach>
				</table>
			</div>
		</div>
		
		<a href="/cafe/${cafe.id}/tables" class="btn btn-sm btn-outline-danger">Reservation</a>
		<div class="row">		
			<div class="col-5">
		<form:form action="/cafedesc/${cafe.id}/comment" method="POST" modelAttribute="comment">
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
				</div>
					</div>
				
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
		
	</div>
</body>
</html>