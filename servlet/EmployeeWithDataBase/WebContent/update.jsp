<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="edit">
<input type="hidden"name="eid" value="${e.eid}"><br>
Name:-<input type="text" name="name" value="${e.name}"><br>
Addr:-<input type="text" name="address" value="${e.address}"><br>
Email:-<input type="text" name="email" value="${e.email}"><br>
UName:-<input type="text" name="uname" value="${e.uname}"><br>
Pass:-<input type="text" name="pass" value="${e.pass}"><br>
<input type="submit" value="Update">


</form>
</body>
</html>