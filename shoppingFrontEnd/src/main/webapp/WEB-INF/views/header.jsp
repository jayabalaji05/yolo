<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<head>
<title>Home Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 80%;
      margin: auto;
  }
  </style>
 </head>
 <body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="index">SuggestionCART</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="/">Home<span class="glyphicon glyphicon-home"></span> </a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">About <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Page 1-1</a></li>
          <li><a href="#">Page 1-2</a></li>
          <li><a href="#">Page 1-3</a></li>
        </ul>
      </li>
      <li><a href="#">Contact</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <c:if test="${empty SuccessMessage}">
      <li><a href="register">Signup <span class="glyphicon glyphicon-user"></span></a></li>
      <li><a href="login">Login <span class="glyphicon glyphicon-log-in"></span></a></li>
      </c:if>
      <c:if test="${not empty SuccessMessage}">
       <li><a href="#">My Cart<span class="glyphicon glyphicon-shopping-cart"></span></a></li>
       <li><a href="/">Logout<span class="glyphicon glyphicon-log-out"></span></a></li>
       </c:if>
    </ul>
  </div>
</nav>
</body>
</html>