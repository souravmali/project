<%@page import="java.util.Optional"%>
<%@page import="com.cjc.main.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<h1> this  is update page</h1>
</head>
<body  bgcolor="skyblue" align="center">
<form action="update">
<table border="2">
<tr>
<th>eid</th>
<th>name</th>
<th>addr</th>

<th>mobileno</th>
<th>salary</th>
<th>username</th>
<th>password</th>
</tr>
<%Employee emp=(Employee)request.getAttribute("data"); %>
<tr>
<td><input type ="hidden" name="eid" value=<%=emp.getEid() %>><%=emp.getEid() %></td>
<td><input type="text" name="name" value=<%=emp.getName() %>></td>
<td><input type="text" name="addr" value=<%=emp.getAddr() %>></td>
<td><input type="text" name="mobileno" value=<%=emp.getMobileno() %>></td>
<td><input type="text" name="salary" value=<%=emp.getSalary() %>></td>
<td><input type="text" name="username" value=<%=emp.getUsername() %>></td>
<td><input type="text" name="password" value=<%=emp.getPassword() %>></td>
<td><input type="submit" value="update"></td>
</tr>

</table>
</form>
</body>
</html>