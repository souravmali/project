<%@page import="com.cjc.CRUD_MVC.model.Student"%>
<%@page import="java.util.List"%>
<html>
<head>
<%-- <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
<script type="text/javascript">

function deleterecord()
{
	alert("delete");
	 document.myform.action="delete";
	 document.myform.submit();
	}
	
function updaterecord()
{
	 alert("edit");
	 document.myform.action="edit";
	 document.myform.submit();
}
</script>
 

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="myform">
<table border="2" style="border-color:lime;">
<tr> <th>Roll No</th> <th>Name</th> <th>Address</th> <th>Email Id</th> <th>Username</th> <th>Password</th> </tr>
<tbody>
<tr>

	<% List<Student> sl=(List<Student>)request.getAttribute("data");
	for(Student s:sl)
	{%>
		<td><input type="radio" name="rollno" value="<%=s.getRollno() %>"> <%=s.getRollno() %> </td>
		<td> <%=s.getName() %> </td>
		<td> <%=s.getAddress() %> </td>
		<td> <%=s.getEmail()%> </td>
		<td> <%=s.getUsername() %> </td>
		<td> <%=s.getPassword() %> </td>
<td>
<input type="button" value="Delete" onclick="deleterecord()"></td>
<td>

<input type="button" value="Update" onclick="updaterecord()">

</td>
</tr>
	
<% } %>
</tbody>
</table>
</form>


</body>
</html>