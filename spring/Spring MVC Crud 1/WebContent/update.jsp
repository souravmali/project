<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.cjc.model.Student" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="update">
<table>
<% Student s= (Student)request.getAttribute("data"); %>
<tr>
<td>Rollno</td>
<td><input type="text" name="rollno" value=<%= s.getRollno()%>> </td>
</tr>


<tr>
<td>Name</td>
<td><input type="text" name="name" value=value=<%= s.getName()%> > </td>
</tr>

<tr>
<td>Address</td>
<td><input type="text" name="address" value=<%= s.getAddress()%>>></td>
</tr>

<tr>
<td>Username</td>
<td><input type="text" name="username" value=<%= s.getUsername()%>>></td>
</tr>

<tr>
<td>Password</td>
<td><input type="text" name="password" value=<%= s.getPassword() %>>></td>
</tr>
</table>
<input type="submit" value="submit update">
</form>
</body>
</html>