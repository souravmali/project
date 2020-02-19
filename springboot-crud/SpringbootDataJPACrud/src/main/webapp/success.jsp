<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function deleterecord()
{
	alert("DeleteRecord")
	document.myform.action="delete";
	document.myform.submit();
}

function UpdateRecord()
{
   alert("UpdateRecord");
   document.myform.action="edit";
	document.myform.submit();
   
}
</script>
</head>
<body  bgcolor="navyblue" align="center">

<form name="myform">

<table border="2" align="center">
<tr>
<td>eid</td>
<td>name</td>
<td>addr</td>

<td>mobileno</td>
<td>salary</td>
<td>username</td>
<td>password</td>
</tr>

<tr>
<s:forEach items="${data}" var="emp">
<td><input type ="radio" name="eid" value="<s:out value="${emp.eid}"></s:out>"></td>
<td><s:out value="${emp.name}"></s:out></td>
<td><s:out value="${emp.addr}"></s:out></td>

<td><s:out value="${emp.mobileno}"></s:out></td>
<td><s:out value="${emp.salary}"></s:out></td>
<td><s:out value="${emp.username}"></s:out></td>
<td><s:out value="${emp.password}"></s:out></td>
<td><input type ="button" value ="Delete" onclick="deleterecord()"></td>
<td><input type ="button" value ="Update" onclick="UpdateRecord()"></td>
</tr>
</s:forEach>

</table>
<a href="register.jsp"><h3>Add more record</h3></a>
</body>
</html>