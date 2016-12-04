<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>category</title>
</head>
<style>
body {
	background-image: url("/resources/login.jpg");
	background-repeat: no-repeat;
	background-size: 600px;
}

div.category {
	text-align: center;
	border: 0px;
	margin-top: 100px;
	margin-left: 500px;
	margin-right: 500px;
	margin-bottom: 110px;
	padding: 20px;
}
</style>
<body>
<div class="category">
<h1>category</h1>
<form method="POST" action="addCategory" commandName="category">
<table>
<tr>
	<td><label for="id">CategoryId</label></td>
	<td>:</td>
	<td><input type="text" id="id" name="id"
						placeholder="CategoryId" path="categroyId"></td>
</tr>
<tr>
	<td><label for="name">CategoryName</label></td>
	<td>:</td>
	<td><input type="text" id="name" name="name"
						placeholder="CategoryName" path="categroyName"></td>
</tr>
<tr>
	<td><label for="description">Description</label></td>
	<td>:</td>
	<td><input type="text" id="description" name="description"
						placeholder="Description" path="categoryDesc"></td>
</tr>
 <tr>
         <td   align="center" colspan="3">
            <input type="submit" value="ADD"/>
         </td>
       </tr>
</table>
</form>
</div>

</body>
</html>