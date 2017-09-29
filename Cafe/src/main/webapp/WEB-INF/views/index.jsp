<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
.one{
border:2px solid black;
border-radius:8px;
border-spacing:10;
padding:4px;
margin:1px;
}
</style>
</head>
<body>
	<h2>${message}</h2>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<div class="row">
		<form:form action="/logout">
			<button>Logout</button>
		</form:form>
		<a href="/admin">Admin</a>
		<a href="/profile">Profile</a>
		</div>
		
	</sec:authorize>
	<sec:authorize access="isAnonymous()">
		<a href="/registration">Registration</a>
		<a href="/login">Login</a>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_CAFE')">
	<div class="container">		
		<div class="row">
		<form:form action="/logout">
			<button>Logout</button>
		</form:form>
		<button ><a href="/profile">Profile</a></button>
		</div>
		</div>
	</sec:authorize>	
		<div class="container">		
			<div class="row">
			<c:forEach var="cafe" items="${cafes}">
				<div class="col-3 one">
					<h3><a href="/cafedesc/${cafe.id}">${cafe.name}</a></h3>
					<h6>${cafe.address}</h6><h6>${cafe.type}</h6>
					<p>${cafe.shortDescription}</p>
				</div>
				</c:forEach>
			</div>
		</div>
	
	
</body>
</html>