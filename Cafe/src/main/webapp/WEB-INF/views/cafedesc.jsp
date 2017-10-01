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
.one{
border:2px solid black;
}
.two{
margin:5px;

border:1px solid black;
}
div.stars {
  width: 270px;
  display: inline-block;
}
input.star { display: none; }
label.star {
  float: right;
  padding: 10px;
  font-size: 36px;
  color: #444;
  transition: all .2s;
}
input.star:checked ~ label.star:before {
  content: '\f005';
  color: #FD4;
  transition: all .25s;
}
input.star-5:checked ~ label.star:before {
  color: #FE7;
  text-shadow: 0 0 20px #952;
}
input.star-1:checked ~ label.star:before { color: #F62; }
label.star:hover { transform: rotate(-15deg) scale(1.3); }
label.star:before {
  content: '\f006';
  font-family: FontAwesome;
}
</style>
</head>
<body>
	<div class="container">
			<div class="row one">
				<div class="col-12">
					<div class="row">
						<div class="col-1 two">Photo</div>				
						<div class="col-10">
							<div class="row">
								<div class="col-12">
									<div class="row">
										<div class="col-6">${cafe.name}</div>
										<div class="col-6">${cafe.type}</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-12">
									<div class="row">
										<div class="col-6">${cafe.address}</div>
										<div class="col-6">${cafe.phone}</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-12">${cafe.open.time}-${cafe.close.time}</div>
							</div>
							<div class="row">
								<div class="col-12">${cafe.fullDescription}</div>
							</div>
						</div>
					</div>
				</div>
				
		</div>
		<div class="row">
			<div class="stars">
				  <form action="">
				    <input class="star star-5" id="star-5" value="5" type="radio" name="star"/>
				   <label class="star star-5" for="star-5"></label>
				    <input class="star star-4" id="star-4" value="4" type="radio" name="star"/>
				     <label class="star star-4" for="star-4"></label>
				    <input class="star star-3" id="star-3" value="3" type="radio" name="star"/>
				     <label class="star star-3" for="star-3"></label>
				    <input class="star star-2" id="star-2" value="2" type="radio" name="star"/>
				     <label class="star star-2" for="star-2"></label>
				    <input class="star star-1" id="star-1" value="1" type="radio" name="star"/>
				     <label class="star star-1" for="star-1"></label>
				  </form>
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
		
		<a href="/cafe/${cafe.id}/tables" class="btn btn-sm btn-outline-danger">Tables</a>
		<a href="/profile/cafe/${cafe.id}/orders" class="btn btn-sm btn-outline-info">Orders</a>
		
		<form:form action="/cafedesc/${cafe.id}" method="POST" modelAttribute="comment">
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
						<div class="col-10 mr-left">
							<button class="btn btn-sm btn-outline-success">Save</button>
							<a href="/cafedesc/${cafe.id}/cancel" class="btn btn-sm btn-outline-warning">Cancel</a>
						</div>
					</div>
				</form:form>
		
		
		<div class="row">		
			<div class="col-12">
				<table class="table table-bordered">
						<tr>
							<th>User</th>
							<th>Comment</th>
						<tr>
					<c:forEach var="comment" items="${comments}">
						<tr>
							<td>${comment.user}</td>
							<td>${comment.comment}</td>
						<tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>