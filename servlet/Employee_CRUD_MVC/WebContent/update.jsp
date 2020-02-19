<%@page import="com.cjc.Crud_Mvc.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="edit" method="post">
<%Employee e=(Employee)request.getAttribute("data"); %>
<input type="hidden"name="eid" value="<%=e.getEid()%>"><br>
<!-- Eid:<input type="text" name="eid"  placeholder="Enter emp Id"><br><br> -->
Name:<input type="text" name="name" value="<%=e.getName()%>"><br><br>
Address:<select name="address">
<option value="<%=e.getAddress()%>"><%=e.getAddress()%></option>
<option value="Pune">Pune</option>
<option value="Mumbai">Mumbai</option>
<option value="Latur">Latur</option>
</select>
<br>
<%-- Gender:<input type="radio" name="gender" value="<%=e.getGender()%>">male<br>
<input type="radio" name="gender" value="female">female<br>
<!-- <input type="radio" name="gender" value="other">other<br> --> --%>
Gender:
<% if(e.getGender().equalsIgnoreCase("male")) {%>
<input type="radio" name="gender" value="male" checked="checked">male<br>
<input type="radio" name="gender" value="female">female<br>
<%} 
else
{ %>
<input type="radio" name="gender" value="female" checked="checked">female<br>
<input type="radio" name="gender" value="male">male<br>
<%} %>

Dept:&nbsp;<input type="checkbox" name="dept" value="<%=e.getDept()%>">Development<br>
<input type="checkbox" name="dept" value="testing">Testing<br>
<input type="checkbox" name="dept" value="HR">HR<br>
Mobno:<input type="text" name="mobno" value="<%=e.getMobno()%>"><br><br>
Email:<input type="text" name="email" value="<%=e.getEmail()%>"><br><br>
Date Of Joining:<input type="date" value="<%=e.getDoj()%>" name="doj"><br><br>
Salary:<input type="text" name="salary" value="<%=e.getSalary()%>"><br><br>
Uname:<input type="text" name="uname" value="<%=e.getUname()%>"><br><br>
Password:<input type="password" name="pass" value="<%=e.getPass()%>"><br><br>
<input type="submit" value="Update">
</form>
</body>

</html>