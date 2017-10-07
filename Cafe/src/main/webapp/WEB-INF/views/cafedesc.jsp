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
  href="//netdna.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
<link rel="stylesheet"
  href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
  integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
  crossorigin="anonymous">
<title>CAFE DESCRIPTION</title>
<style>
</style>
</head>
<body>
  <div class="container main">
    <div class="row">

      <div class="col text-center">
        <div class="row">
          <div class="col pt-3">
            <span class="text-secondary">D E S C R I P T I O N</span>
            <p>${cafe.fullDescription}</p>
          </div>
        </div>

        <table class="table table-bordered table-hover text-center">
          <tr class="table-danger">
            <th class="text-center">NAME</th>
            <th class="text-center">LOCATION</th>
            <th class="text-center">NUMBER</th>
          </tr>
          <tr>
            <td>${cafe.name}</td>
            <td>${cafe.address}</td>
            <td>${cafe.phone}</td>
          </tr>
        </table>

        <div class="progress" style="width: 540px;">
          <div class="progress-bar progress-bar-success" role="progressbar"
            style="width: ${cafe.rate*10}%" aria-valuenow="${cafe.rate}"
            aria-valuemin="0" aria-valuemax="10">${cafe.rate}</div>
        </div>
        <table class="table table-bordered table-hover text-center">
          <tr class="table-danger">
            <th class="text-center">TYPE</th>
            <th class="text-center">OPEN TIME</th>
            <th class="text-center">CLOSE TIME</th>
          </tr>
          <tr>
            <td>${cafe.type}</td>
            <td>${cafe.open}</td>
            <td>${cafe.close}</td>
          </tr>
        </table>
      </div>
      <div class="col-6">
        <img
          src="https://upload.wikimedia.org/wikipedia/commons/c/c2/Daisy_Cafe%2C_White_Conduit_Street%2C_Islington_-_geograph.org.uk_-_1523976.jpg"
          width="500px" class="img-fluid">
      </div>
    </div>
    <sec:authorize access="hasRole('ROLE_CAFE')">
      <c:if test="${isOwnCafe}">
        <div class="col text-right">
          <a href="/cafe/${cafe.id}/update"
            class="btn btn-info btn-block mt-3">U P D A T E</a>
        </div>
      </c:if>
    </sec:authorize>

  </div>
  <div class="container">

    <div class="row">
      <div class="col-12 text-center">
        <table class="table table-bordered table-hover text-center">
          <tr class="table-danger text-center">
            <th>TITLE</th>
            <th>CUISINE</th>
            <th>WEIGHT</th>
            <th>PRICE</th>
            <th>DESCRIPTION</th>
            <th>INGREDIENTS</th>
          <tr>
            <c:forEach var="meal" items="${meals}">
              <tr class="table-primary">
                <td>${meal.title}</td>
                <td>${meal.cuisine.name}</td>
                <td>${meal.weight}</td>
                <td>${meal.price}</td>
                <td>${meal.description}</td>
                <td><c:forEach var="ingredient" items="${meal.ingredients}">
                  ${ingredient.name} 
                </c:forEach></td>
              <tr>
            </c:forEach>
        </table>
      </div>
    </div>
    
    <a href="/cafe/${cafe.id}/tables"
      class="btn btn-danger btn-block mt-3">RESERVATION OF TABLE!</a>
    <div class="row">
      <div class="col-5">
        <form:form action="/cafedesc/${cafe.id}/comment" method="POST"
          modelAttribute="comment">
          <div class="form-group row">
            <label class="col-2 col-form-label" for="user">User:</label>
            <div class="col-10">
              <form:input class="form-control" id="user" path="user" />
              <form:errors path="user" style="color:red;"/>
            </div>
          </div>
          <div class="form-group row">
            <label class="col-2 col-form-label" for="comment">Comment:</label>
            <div class="col-10">
              <form:textarea class="form-control" id="comment" path="comment"
                rows="5"></form:textarea>
                <form:errors path="comment" style="color:red;"/>
            </div>
          </div>
          <div class="form-group row">
            <label class="col-2 col-form-label" for="rate">Rate:</label>
            <div class="col-10">
              <form:input class="form-control" id="rate" path="rate" />
              <form:errors path="rate" style="color:red;"/>
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

    <table class="table table-bordered table-hover text-center">
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