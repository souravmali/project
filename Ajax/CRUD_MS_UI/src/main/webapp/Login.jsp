<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Login V4</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/util.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
<!--===============================================================================================-->


<script type="text/javascript">
	function LoginCheck() {
		var email = document.getElementById("email").value;
		var password = document.getElementById("password").value;
		//alert(email);
		//	alert(password);

		if (email == "admin" && password == "admin") {
			//alert("admin");
			var req = new XMLHttpRequest();
			var url = "http://localhost:8094/adminlogin";
			req.open("GET", url, true);
			req.send();
			//window.location.href="/"
				

		} else {
			alert("stu Login");
			var req = new XMLHttpRequest();
			var url = "http://localhost:8095/login/" + email + "/" + password;
			req.open("GET", url, true);
			req.send();
			//window.location.href="/"
				
		}

		req.onreadystatechange = function() {

			//alert(req.readyState);
			//alert(req.status);

			if (req.readyState == 4 && req.status == 200) {
				var stu = JSON.parse(req.responseText);
				//	alert("haa aaata");
				//alert(stu);

				var table = document.getElementById("data");

				var row = table.insertRow(0);
				var cell1 = row.insertCell(0);
				cell1.innerHTML = "Rollno";

				var cell2 = row.insertCell(1);
				cell2.innerHTML = "Name";

				var cell3 = row.insertCell(2);
				cell3.innerHTML = "Email";

				var cell4 = row.insertCell(3);
				cell4.innerHTML = "Password";

				var cell5 = row.insertCell(4);
				cell5.innerHTML = "Edit";

				var cell6 = row.insertCell(4);
				cell6.innerHTML = "Delete";


				//==================================================================================

				var row = table.insertRow();
				var cell1 = row.insertCell();
				//alert(stu.rollno);
				
				

				var cell1 = row.insertCell(1);
				cell1.innerHTML = stu.rollno;
				var name = cell1.innerHTML;

				var cell2 = row.insertCell(2);
				cell2.innerHTML = stu.name;
				var name = cell2.innerHTML;

				var cell3 = row.insertCell(3);
				cell3.innerHTML = stu.email;
				var email = cell3.innerHTML;

				var cell4 = row.insertCell(4);
				cell4.innerHTML = stu.password;
				var password = cell4.innerHTML;

				cell5.innerHTML = '<input type="button" id="' + stu.rollno
				+ '"  onclick="EditData(this.id)"> ';

				cell6.innerHTML = '<input type="button" id="' + stu.rollno
				+ '"  onclick="deleteData(this.id)"> ';
				
			}

			/* for (var i = 0; i < stu.length; i++) 
				{
				
				var row = table.insertRow();
				var cell1 = row.insertCell();
				
				cell1.innerHTML = '<input type="radio" id="' + stu[i].rollno
					+ '"  onclick="EditData(this.id)"> ';
				
				var cell2 = row.insertCell(1);
				cell2.innerHTML = stu[i].rollno;
				var name = cell2.innerHTML;
				

				var cell3 = row.insertCell(2);
				cell3.innerHTML = stu[i].name;
				var name = cell3.innerHTML;

				var cell4 = row.insertCell(3);
				cell4.innerHTML = stu[i].email;
				var email = cell3.innerHTML;

				var cell5 = row.insertCell(4);
				cell5.innerHTML = stu[i].password;
				var password = cell4.innerHTML;
			} */
		}
	}

	function EditData(rollno) {
		alert("Edit Data");
		alert(rollno);

		var req = new XMLHttpRequest();
		var url = "http://localhost:8096/edituser/" + rollno
		"";
		req.open("GET", url, true);
		req.send();

		req.onreadystatechange = function() {
			if (req.readyState == 4 && req.status == 200) {

				var stu = JSON.parse(req.responseText);
				alert(stu);
				var table = document.getElementById("data1");

				var row = table.insertRow(0);
				var cell1 = row.insertCell(0);
				cell1.innerHTML = "Rollno";

				var cell2 = row.insertCell(1);
				cell2.innerHTML = "Name";

				var cell3 = row.insertCell(2);
				cell3.innerHTML = "Email";

				var cell4 = row.insertCell(3);
				cell4.innerHTML = "Password";

				var row = table.insertRow();
				var cell1 = row.insertCell();

				var cell1 = row.insertCell(0);
				cell1.innerHTML = stu.rollno;
				var rollno = cell1.innerHTML;
				alert(rollno);

				var cell2 = row.insertCell(1);
				cell2.innerHTML = '<input type="text" value="'+stu.name+'"> ';
				var name = cell2.innerHTML;
				alert(name);

				var cell3 = row.insertCell(2);
				cell3.innerHTML = '<input type="text" value="' + stu.email+ '"  >';
				var email = cell3.innerHTML;
				alert(email);

				var cell4 = row.insertCell(3);
				cell4.innerHTML = '<input type="text" value="' + stu.password+ '" >';
				var password = cell4.innerHTML;
				alert(password);

			}
		}
	}

	function deleteData(rollno) {
		alert("Deleting data");
		alert(rollno);

		var req = new XMLHttpRequest();
		var url = "http://localhost:8097/del/" + rollno
		"";
		req.open("GET", url, true);
		req.send();

		req.onreadystatechange = function() {
			alert(req.readyState);
			alert(req.status);
			if (req.readyState == 4 && req.status == 200) {

				var stu = req.responseText;
				alert(stu);
				document.getElementById("data1").innerHTML = stu;
			}
		}

	}
</script>

</head>
<center>

<!-- 	<h1>**Login Page**</h1>
 -->
	<body>
	<div class="limiter">
		<div class="container-login100" style="background-image: url('${pageContext.request.contextPath}/resources/images/bg-01.jpg');">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
				<form class="login100-form validate-form">
					<span class="login100-form-title p-b-49">
						Login
					</span>

					<div class="wrap-input100 validate-input m-b-23" data-validate = "Username is reauired">
						<span class="label-input100">Username</span>
						<input class="input100" type="text" name="email" id="email" placeholder="Type your username">
						<span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Password is required">
						<span class="label-input100">Password</span>
						<input class="input100" type="password" name="password" id="password" placeholder="Type your password">
						<span class="focus-input100" data-symbol="&#xf190;"></span>
					</div>
					
					<div class="text-right p-t-8 p-b-31">
						<a href="/">
							Forgot password?
						</a>
					</div>
					
					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn" onclick="LoginCheck()">
								Login
							</button>
						</div>
					</div>

					<div class="txt1 text-center p-t-54 p-b-20">
						<span>
							Or Sign Up Using
						</span>
					</div>

					<div class="flex-c-m">
						<a href="/reg" class="login100-social-item bg1">
							<i class="fa fa-facebook"></i>
						</a>

						<a href="#" class="login100-social-item bg2">
							<i class="fa fa-twitter"></i>
						</a>

						<a href="#" class="login100-social-item bg3">
							<i class="fa fa-google"></i>
						</a>
					</div>

					<div class="flex-col-c p-t-155">
						<span class="txt1 p-b-17">
							Or Sign Up Using
						</span>

						<a href="/reg" class="txt2">
							Sign Up
						</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
	
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/resources/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/popper.js"></script>
	<script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/resources/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/resources/vendor/daterangepicker/moment.min.js"></script>
	<script src="${pageContext.request.contextPath}/resources/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/resources/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>

	

	<!-- 	<br>
		<br> Email :
		<input type="text" id="email">
		<br>
		<br> Password:
		<input type="text" id="password">
		<br>
		<br>
		<input type="button" onclick="LoginCheck()" value="Login">
		<br>
		<a href="reg">Register here</a>
		<br>
		<br>
 -->		<!-- 		<a href="edit">Editdata</a>
 -->
	<!-- 	<br>
		<br>

		<table id="data" border="1">
			<input type="button" onclick="EditData()" value="rollno" id="rollno">
		<br>
		<input type="button" onclick="deleteData()" value="Delete" id="rollno">
		</table>
		<br>
		<br>
		<table id="data1" border="1"></table>
 --></center>
</body>
</html>