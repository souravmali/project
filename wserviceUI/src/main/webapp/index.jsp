<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript">
function login()
{
	var un=document.getElementById("name").value;
	alert("1");
	var pw=document.getElementById("pass").value;
	var req=new XmlHttpRequest();
	var Url="http://localhost:8082/log/"+un+"/"+pass+"/req.open("POST",url,true)";
	req.send();
	}
</script>
<body>
Username:-<input type="text" name="uname" id="name">
password:-<input type="text" name="pass" id="pass">

<input type="button" value="login" onclick="login()"/>

</body>
</html>