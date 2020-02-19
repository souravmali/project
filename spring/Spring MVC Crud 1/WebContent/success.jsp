<%@page import="com.cjc.model.Student"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function deleterecord()
{
alert("deleterecord");
document.myform.action="delete";
document.myform.submit();
}
function editrecord()
{
alert("updaterecord");
document.myform.action="edit";
document.myform.submit();
}
</script>
<h1> this is the success page </h1>
</head>
<body bgcolor="white">
<form name="myform">

<table border="2" >
<tr>
<th>rollno</th>
<th>name</th>
<th>address</th>
<th>username</th>
<th>password</th>
<th>delete</th>
<th>update</th>
</tr>

<%List<Student> s1=(List)request.getAttribute("data");
for(Student s2:s1)
{%>
<tr>
<td><input type="radio"  name="rollno" value="<%=s2.getRollno() %>"><%=s2.getRollno() %></td>
<td><%=s2.getName() %></td>
<td><%=s2.getAddress() %></td>
<td><%=s2.getUsername() %></td>
<td><%=s2.getPassword() %></td>
<td><input type="button" value="delete" onclick="deleterecord()"></td>
<td><input type="button" value="update" onclick="editrecord()"></td>
</tr>
<%} %>


</table>

</form>
<a href="register.jsp"> Add more record</a>

</body>
</html>