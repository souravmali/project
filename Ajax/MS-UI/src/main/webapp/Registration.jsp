<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script>
	function regData() 
	{
		alert("Welcome!!");

		var rollno = document.getElementById("rollno").value;
		var name = document.getElementById("name").value;
		var email = document.getElementById("email").value;
		var password = document.getElementById("password").value;

		var stu = {
			rollno : rollno,
			name : name,
			email : email,
			password : password
		};

		var student = JSON.stringify(stu);
		alert(student);
		var req = new XMLHttpRequest();
		var url = "http://localhost:8093/routingconsume/consume";
		 		
		req.open("POST", url, true);

		req.setRequestHeader("Content-type","application/json");
		req.send(student);

		req.onreadystatechange = function() 
		{
			if (req.readyState == 4 && req.status == 200) 
				{
				var stu=req.responseText;
				alert(stu);
				alert(req.readyState);
				alert(req.status);

				document.getElementById("data").innerHTML=stu;


				
			}

		}

	}
</script>

</head>
<body>

	Rollno:
	<input type="text" id="rollno">
	<br> Name:
	<input type="text" id="name">
	<br> Email:
	<input type="text" id="email">
	<br> Password:
	<input type="text" id="password">
	<br>
	<input type="submit" onclick="regData()" value="Submit">
	
	<br>
	<br>
	<div id="data"></div>

</body>
</html>