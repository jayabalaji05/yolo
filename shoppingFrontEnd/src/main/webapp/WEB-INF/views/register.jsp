<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>register page</title>
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
      <li><a href="/">Home<span class="glyphicon glyphicon-home"></span> </a></li>
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
      <li class="active"><a href="register">Signup <span class="glyphicon glyphicon-user"></span></a></li>
      <li><a href="login">Login <span class="glyphicon glyphicon-log-in"></span></a></li>
      </c:if>
      <c:if test="${not empty SuccessMessage}">
       <li><a href="#">My Cart<span class="glyphicon glyphicon-shopping-cart"></span></a></li>
       <li><a href="/">Logout<span class="glyphicon glyphicon-log-out"></span></a></li>
       </c:if>
    </ul>
  </div>
</nav>
<form:form action="registration">
<table style="text-align:left;">
<tr>
	<td><label for="firstname">Firstname</label></td>
	<td>:</td>
	<td><input type="text" id="firstname" name="firstname" placeholder="firstname" required>
	</td>
</tr>
<tr>
	<td><label for="middlename">Middlename</label></td>
	<td>:</td>
	<td><input type="text" id="Middlename" placeholder="middlename"></td>
</tr>
<tr>
	<td><label for="lastname">Lastname</label></td>
	<td>:</td>
	<td><input type="text" id="lastname" placeholder="lastname"></td>
</tr>
<tr>
	<td><label for="phonenumber">Phone no</label></td>
	<td>:</td>
	<td><input type="number" id="phonenumber" placeholder="phonenumber" required></td>
</tr>
<tr>
	<td><label for="emailid">Emailid</label></td>
	<td>:</td>
	<td><input type="email" id="emailid"  placeholder="emailid" required></td>
</tr>
<tr>
	<td><label for="password">Password</label></td>
	<td>:</td>
	<td><input type="password" id="password" required></td>
</tr>
<tr>
	<td><label for="confirm_password">Confirm password</label></td>
	<td>:</td>
	<td><input type="password" id="confirm_password" required></td>
</tr>
<tr>
	<td><label for="address1">Address1</label></td>
	<td>:</td>
	<td><input type="text" id="address1" name=""></td>
</tr>
<tr>
	<td><label for="address2">Address2<label></td>
	<td>:</td>
	<td><input type="text" id="address2" name=""></td>
</tr>
<tr>
	<td><label for="district">District</label></td>
	<td>:</td>
	<td><select>
			<option value="chennai">Chennai</option>
			<option value="banglore">Bangalore</option>
			<option value="mumbai">Mumbai</option>
			<option value="kolkata">Kolkata</option>
			<option value="delhi">Delhi</option>
			<option value="pune">Pune</option></td>
</tr>
<tr>
	<td><label for="state">State</label></td>
	<td>:</td>
	<td><select>
			<option value="tamilnadu">Tamilnadu</option>
			<option value="karnataka">Karnataka</option>
			<option value="maharastra">Maharastra</option>
			<option value="westbengal">Westbengal</option>
			<option value="newdelhi">NewDelhi</option></td>
</tr>
<tr>
	<td><label for="pincode">Pincode</label></td>
	<td>:</td>
	<td><input type="text" id="pincode" name=""></td>
</tr>
<tr>
	<td><input type="reset" name="Reset">
	<input type="submit" value="Submit"></td>
</tr>
</table>
</form:form>
</body>
</html>