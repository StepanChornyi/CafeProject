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
<title>Cafe</title>
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
		<a href="/profile/cafe/addtable/${cafe.id}" class="btn btn-outline-danger btn-sm">Tables</a>
		<a href="/profile/cafe/${cafe.id}/orders" class="btn btn-sm btn-outline-info">Orders</a>
		<a href="/profile/addcafe/update/${cafe.id}" class="btn btn-sm btn-outline-success">Update</a>
		<br><div class="row">		
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
		
	</div>
</body>
</html>