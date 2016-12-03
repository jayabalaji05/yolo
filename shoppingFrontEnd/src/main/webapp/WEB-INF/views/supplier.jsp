<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Suppliers</title>
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
           <div class="panel-heading" style="background-color:#101010; color:#E0E0E0">Add supplier</div>
    <div class="panel-body">

	<c:url var="addAction" value="/supplier/add"></c:url>

	<form:form action="${addAction}" commandName="supplier">
		<table>
			<tr>
				<td><form:label path="id">Id </form:label>
						
				<c:choose>
					<c:when test="${!empty supplier.id}">
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
				<td colspan="2"><c:if test="${!empty supplier.name}">
						<input type="submit" style="background-color:#484848"
							value="<spring:message text="Edit supplier"/>" />
					</c:if> <c:if test="${empty supplier.name}">
						<input type="submit" style="background-color:#484848" value="<spring:message text="Add supplier"/>" />
					</c:if></td>
			</tr>
		</table>
	
	</form:form>
	
	</div>
	</div>
	</div>
	
	
	<div class="col-sm-7">
			<div class="panel panel-default" style="background-color:#303030;color:#E0E0E0" >
           <div class="panel-heading" style="background-color:#101010; color:#E0E0E0">supplier List</div>
    <div class="panel-body">
	
	
	<c:if test="${!empty supplierList}">
		<table class="tg">
			<tr>
				<th width="80">supplier ID</th>
				<th width="120">supplier Name</th>
				<th width="120">supplier Description</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${supplierList}" var="supplier">
				<tr>
					<td>${supplier.id}</td>
					<td>${supplier.name}</td>
					<td>${supplier.description}</td>
					<td><a href="<c:url value='supplier/edit/${supplier.id}' />">Edit</a></td>
					<td><a href="<c:url value='supplier/remove/${supplier.id}' />">Delete</a></td>
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