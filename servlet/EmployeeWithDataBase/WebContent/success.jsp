
<%@page import="java.util.List"%>
<%@page import="com.model.cjc.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function deleteRecord() 
{
	alert("delete");
	document.myform.action="delete";
	document.myform.submit();
}
function updateRecord()
{
	alert("updata");
	document.myform.action="update";
	document.myform.submit();
}
</script>

</head>
<body>
<h1>Employee info.....</h1>
<form name="myform"> 



<table border="2">
<tr>
<th>Eid</th>
<th>Ename</th>
<th>Address</th>
<th>Email</th>
<th>Username</th>
<th>Password</th>
</tr>
<tr>
<%
List<Employee> list=(List)request.getAttribute("data");
for(Employee e:list)
	{%>
	<td>
	<input type="radio" name="eid" value="<%=e.getEid() %>" > 
	<%=e.getEid() %></td>
	<td><%=e.getName() %></td>
	<td><%=e.getAddress() %></td>
	<td><%=e.getEmail() %></td>
	<td><%=e.getUname() %></td>
	<td><%=e.getPass() %></td>
	<td><input type="submit" value="Delete" onclick="deleteRecord()">
	</td>
	<td><input type="submit" value="Update"  onclick="updateRecord()">
	</td>
	<td><input type="submit" value="AddNew" onclick="addRecord()">
	</td>
	</tr>
	<%} %>
	</table>
	<br>
	</form>
<br>	<a href="login.jsp">Logout</a><br>
</body>
</html>