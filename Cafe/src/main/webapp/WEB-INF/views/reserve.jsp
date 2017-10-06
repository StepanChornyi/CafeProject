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
<title>Reserve</title>
</head>
<body>
  <div class="container">
    <div class="row">
      <div class="col-12">
        <form:form action="/cafe/${cafeId}/reserve/${_table.id}" method="POST" modelAttribute="_table">
          <div class="form-group row">
            <label class="col-2 col-form-label" for="user">Name :</label>
            <div class="col-10">
              <form:input class="form-control" id="user" path="user" />
            </div>
          </div>
          <div class="form-group row">
            <label class="col-2 col-form-label" for="userPhone">Phone :</label>
            <div class="col-10">
              <form:input class="form-control" id="userPhone" path="userPhone" />
            </div>
          </div>
          <div class="form-group row">
            <div class="col-10 ml-auto">
              <button class="btn btn-sm btn-outline-success">Save</button>
              <a href="/cafe/${cafeId}/tables"
                class="btn btn-sm btn-outline-warning">Cancel</a>
            </div>
          </div>
        </form:form>
      </div>
    </div>
  </div>
</body>
</html>