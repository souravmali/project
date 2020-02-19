<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	alert("update");
	document.myform.action="update";
	document.myform.submit();
}
</script>
</head>
<body>
<h1>Employee info.....</h1>
<form name="myform" method="post"> 
<table border="2">
<tr>
<th>Eid</th>
<th>name</th>
<th>Address</th>
<th>Gender</th>
<th>Deparment</th>
<th>MobNo</th>
<th>Email</th>
<th>Date Of Joining</th>
<th>Salary</th>
<th>Uname</th>
<th>Password</th>
</tr>

<c:forEach items="${data}" var="emp">
<tr>
<td><input type="radio" name="eid" value="<c:out value="${emp.eid}"></c:out>" /> </td>
<%-- <td><c:out value="${emp.eid}"></c:out></td> --%>
<td><c:out value="${emp.name}"></c:out></td>
<td><c:out value="${emp.address}"></c:out></td>
<td><c:out value="${emp.gender}"></c:out></td>
<td><c:out value="${emp.dept}"></c:out></td>
<td><c:out value="${emp.mobno}"></c:out></td>
<td><c:out value="${emp.email}"></c:out></td>
<td><c:out value="${emp.doj}"></c:out></td>
<td><c:out value="${emp.salary}"></c:out></td>
<td><c:out value="${emp.uname}"></c:out></td>
<td><c:out value="${emp.pass}"></c:out></td>
<td><input type="submit" value="delete" onclick="deleteRecord()">
	</td>
	<td><input type="submit" value="update" onclick="updateRecord()">
	</td>
</tr>
</c:forEach>

</table>
</form>
</body>
</html>