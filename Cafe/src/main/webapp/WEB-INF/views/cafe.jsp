<%@ include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="custom" uri="/WEB-INF/tags/implicit.tld"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">
<title>Cafe</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-3">
				<form:form action="/all/allcafe" method="GET"
					modelAttribute="cafeFilter">
					<span class="text-secondary">RATE</span>
					<div class="form-group row">
						<div class="col pr-1">
							<form:input path="minRate" class="form-control form-control-sm"
								placeholder="Min" />
						</div>
						<div class="col pl-1">
							<form:input path="maxRate" class="form-control form-control-sm"
								placeholder="Max" />
						</div>
					</div>
					<span class="text-secondary">TYPE</span>
					<div class="row">
						<div class="form-group col-2">
							<div>
								<label><form:checkbox path="types" value="PUB" /> Pub</label>
							</div>
						</div>
						<br>
						<div class="form-group col-2">
							<div>
								<label><form:checkbox path="types" value="SUSHY" />
									Sushy</label>
							</div>
						</div>
						<br>
						<div class="form-group col-2">
							<div>
								<label><form:checkbox path="types" value="BAR" /> Bar</label>
							</div>
						</div>
						<br>
						<div class="form-group col-2">
							<div>
								<label><form:checkbox path="types" value="CAFE" /> Cafe</label>
							</div>
						</div>
						<br>
						<div class="form-group col-2">
							<div>
								<label><form:checkbox path="types" value="RESTAURANT" />
									Restaurant</label>
							</div>
						</div>
					</div>
					<div class="form-group">
						<form:input path="search" class="form-control form-control-sm"
							placeholder="Search" />
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-success">Search</button>
					</div>
					<div class="row">
					<div class="col-6">
						<button class="dropdown-toggle btn btn-outline-info btn-sm"
							type="button" data-toggle="dropdown">Sort</button>
						<div class="dropdown-menu">
							<custom:sort innerHtml="Name asc" paramValue="name" />
							<custom:sort innerHtml="Name desc" paramValue="name,desc" />
							<custom:sort innerHtml="Type asc" paramValue="type" />
							<custom:sort innerHtml="Type desc" paramValue="type,desc" />
						</div>
					</div>
					<div class="col-2 ">
						<custom:size posibleSizes="1,2,5,10" size="${cafes.size}" />
					</div>
				</div>
				</form:form>
			</div>
			<div class="col-8">
				<table class="table table-bordered">
					<tr>
						<th class="text-center">Name</th>
						<th class="text-center">Address</th>
						<th class="text-center">Short description</th>
						<th class="text-center">Type</th>
					</tr>
					<c:forEach var="cafe" items="${cafes.content}">
						<tr>
							<td><a href="/cafedesc/${cafe.id}">${cafe.name}</a></td>
							<td>${cafe.address}</td>
							<td>${cafe.shortDescription}</td>
							<td>${cafe.type}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
			<div class="row">
			<div class="col-12 text-center">
				<custom:pageable page="${cafes}" />
			</div>
		</div>
		</div>
		
</body>
</html>