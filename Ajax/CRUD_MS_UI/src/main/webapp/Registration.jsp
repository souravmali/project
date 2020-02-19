<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>

<script type="text/javascript">
	function submitData() 
	{
	//	alert("Started");
		var req = new XMLHttpRequest();
		var rollno = document.getElementById("rollno").value;
		var name = document.getElementById("name").value;
		var email = document.getElementById("email").value;
		var password = document.getElementById("password").value;

		//alert(rollno);
		//alert(name);

		var stu = {
			rollno : rollno,
			name : name,
			email : email,
			password : password
		};
		//alert(stu);

		var ss = JSON.stringify(stu);
	//	alert(ss);
		var url = "http://localhost:8093/add";
		req.open("POST", url, true);
		req.setRequestHeader("Content-type", "application/JSON");

		req.send(ss);

		req.onreadystatechange=function()
		{
			if(req.readyState==4 && req.status==200)
				{
					//	alert("Registration Successful!!")
						window.location.href="/"
						
				}



		}

	}
</script>
</head>
	<center>

<h1>**Registration Page**</h1>

<body>

		Rollno: <input type="text" id="rollno"> <br> Name: <input
			type="text" id="name"> <br> Email: <input type="text"
			id="email"> <br> Password: <input type="text"
			id="password"> <br> <input type="button"
			onclick="submitData()" value="Submit">
	</center>

</body>

</html>