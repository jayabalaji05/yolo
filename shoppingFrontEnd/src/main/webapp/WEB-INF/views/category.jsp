<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Categories</title>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
	border-color: #101010;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #101010;
	color: #E0E0E0;
	background-color: #282828;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: #282828;
	color: #E0E0E0;
	background-color: #101010;
}

.tg .tg-4eph {
	background-color: #101010;
}
</style>

</head>
<body>
<div class="container-fluid">
<div class="row">
<div class="col-sm-12">
  
    <div class="col-sm-5">
			<div class="panel panel-default" style="background-color:#484848; color:#000000">
           <div class="panel-heading" style="background-color:#101010; color:#E0E0E0">Add category</div>
    <div class="panel-body">

	<c:url var="addAction" value="/category/add"></c:url>

	<form:form action="${addAction}" commandName="category">
		<table>
			<tr>
				<td><form:label path="id">Id </form:label>
						
				<c:choose>
					<c:when test="${!empty category.id}">
						<td><form:input path="id" disabled="true" readonly="true" />
						</td>
					</c:when>

					<c:otherwise>
						<td><form:input path="id" pattern =".{3,7}" required="true" title="id should contains 3 to 7 characters" /></td>
					</c:otherwise>
				</c:choose>
			<tr>
			<form:input path="id"  hidden="true"  />
				<td><form:label path="name">
						<spring:message text="Name" />
					</form:label></td>
				<td><form:input path="name" required="true" /></td>
			</tr>
			<tr>
				<td><form:label path="description">
						<spring:message text="Description" />
					</form:label></td>
				<td><form:input path="description" required="true" /></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty category.name}">
						<input type="submit" style="background-color:#484848"
							value="<spring:message text="Edit Category"/>" />
					</c:if> <c:if test="${empty category.name}">
						<input type="submit" style="background-color:#484848" value="<spring:message text="Add Category"/>" />
					</c:if></td>
			</tr>
		</table>
	
	</form:form>
	
	</div>
	</div>
	</div>
	
	
	<div class="col-sm-7">
			<div class="panel panel-default" style="background-color:#303030;color:#E0E0E0" >
           <div class="panel-heading" style="background-color:#101010; color:#E0E0E0">Category List</div>
    <div class="panel-body">
	
	
	<c:if test="${!empty categoryList}">
		<table class="tg">
			<tr>
				<th width="80">Category ID</th>
				<th width="120">Category Name</th>
				<th width="120">Category Description</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${categoryList}" var="category">
				<tr>
					<td>${category.id}</td>
					<td>${category.name}</td>
					<td>${category.description}</td>
					<td><a href="<c:url value='category/edit/${category.id}' />">Edit</a></td>
					<td><a href="<c:url value='category/remove/${category.id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	</div>
	</div>
	</div>
	</div>
	</div></div>
</body>
</html>