<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
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

		} else {                                     //user login la stu.length undefined yete why???
			//alert("stu Login");					//update delete kelya nantr tyach table mdhe add hote jo already page wrr aahe
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

				var table = document.getElementById("data");

				var row = table.insertRow(0);
				var cell1 = row.insertCell(0);

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

				var cell6 = row.insertCell(5);
				cell6.innerHTML = "Delete";

				//==================================================================================
				var stu = JSON.parse(req.responseText);
				alert(stu.length);
				//alert(stu.length);
				for (var i = 0; i < stu.length; i++) {
					//alert("in for");
					var row = table.insertRow();
					var cell1 = row.insertCell();
					var cell1 = row.insertCell(0);
					cell1.innerHTML = stu[i].rollno;
					//alert( stu[i].rollno );

					var cell2 = row.insertCell(1);
					cell2.innerHTML = stu[i].name;
					//alert(stu[i].name);

					var cell3 = row.insertCell(2);
					cell3.innerHTML = stu[i].email;
					//alert(stu[i].email);

					var cell4 = row.insertCell(3);
					cell4.innerHTML = stu[i].password;
					//alert(stu[i].password);

					var cell5 = row.insertCell(4);
					cell5.innerHTML = '<input type="button" id="'
							+ stu[i].rollno
							+ '"  onclick="EditData(this.id)" value="EDIT"> ';

					var cell6 = row.insertCell(5);
					cell6.innerHTML = '<input type="button" id="'
							+ stu[i].rollno
							+ '"  onclick="deleteData(this.id)" value="DELETE" >';
				}
			}

			/* 
				
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
		//alert("Edit Data");
		//alert(rollno);

		var req = new XMLHttpRequest();
		var url = "http://localhost:8096/edituser/" + rollno
		"";
		req.open("GET", url, true);
		req.send();

		req.onreadystatechange = function() {
			if (req.readyState == 4 && req.status == 200) {

				var stu = JSON.parse(req.responseText);
				//alert(stu);
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

				var cell5 = row.insertCell(4);
				cell5.innerHTML = "SUBMIT";
				//---------------------------------------------------------------------------------------------
				var row = table.insertRow();
				var cell1 = row.insertCell();

				var cell1 = row.insertCell(0);
				cell1.innerHTML = '<input type="hidden" value="'+stu.rollno+'" id="rollno1"> ';
				var rollno = cell1.innerHTML;
			//	alert(rollno);

				var cell2 = row.insertCell(1);
				cell2.innerHTML = '<input type="text" value="'+stu.name+'" id="name1"> ';
				var name = cell2.innerHTML;
			//	alert(name);

				var cell3 = row.insertCell(2);
				cell3.innerHTML = '<input type="text" value="' + stu.email+ '" id="email1"  >';
				var email = cell3.innerHTML;
				//alert(email);

				var cell4 = row.insertCell(3);
				cell4.innerHTML = '<input type="text" value="' + stu.password+ '" id="password1" >';
				var password = cell4.innerHTML;
				//alert(password);

				//alert(student);

				var cell5 = row.insertCell(4);
				cell5.innerHTML = '<input type="submit" onclick="UpdateData()" value="SUBMIT"> ';

			}
		}
	}

	function UpdateData() {
		//alert("Update function called");

		var rollno = document.getElementById("rollno1").value;
		var name = document.getElementById("name1").value;
		var email = document.getElementById("email1").value;
		var password = document.getElementById("password1").value;

	//	alert(name);
	//	alert(email);
		//alert(password);

		//alert(student);
		var student = {
			rollno : rollno,
			name : name,
			email : email,
			password : password
		};
		var s = JSON.stringify(student);
		//alert(s);
		var req1 = new XMLHttpRequest();

		var url1 = "http://localhost:8096/updateuser";
		req1.open("POST", url1, true);
		req1.setRequestHeader("Content-type", "application/JSON");

		//req1.setRequestHeader("content-type", "application/JSON");
		req1.send(s);

		req1.onreadystatechange = function() 
		{
			if (req1.readyState == 4 && req1.status == 200) 
			{
			
			//alert(req1.readyState);
			//alert(req1.status);
			//alert(req1.responseText);
			window.location.function=GetAllData();
			
			}
		}

	}

	function deleteData(rollno) {
	//	alert("Deleting data");
		//alert(rollno);

		var req = new XMLHttpRequest();
		var url = "http://localhost:8097/del/" + rollno
		"";
		req.open("GET", url, true);
		req.send();

		req.onreadystatechange = function() {
			//alert(req.readyState);
			//alert(req.status);
			if (req.readyState == 4 && req.status == 200) {

				var stu = req.responseText;
			//	alert(stu);
				window.location.function=GetAllData();
				//document.getElementById("data1").innerHTML = stu;
			}
		}

	}

	function GetAllData()
	{
		//alert("GetAllData Called!!!")
		var req = new XMLHttpRequest();
		var url = "http://localhost:8094/adminlogin";
		req.open("GET", url, true);
		req.send();

		req.onreadystatechange = function() {

			//alert(req.readyState);
			//alert(req.status);

			if (req.readyState == 4 && req.status == 200) {

				var table = document.getElementById("data2");

				var row = table.insertRow(0);
				var cell1 = row.insertCell(0);

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

				var cell6 = row.insertCell(5);
				cell6.innerHTML = "Delete";

				//==================================================================================
				var stu = JSON.parse(req.responseText);
				//alert(stu.length);
				for (var i = 0; i < stu.length; i++) {
					//alert("in for");
					var row = table.insertRow();
					var cell1 = row.insertCell();
					var cell1 = row.insertCell(0);
					cell1.innerHTML = stu[i].rollno;
					//alert( stu[i].rollno );

					var cell2 = row.insertCell(1);
					cell2.innerHTML = stu[i].name;
					//alert(stu[i].name);

					var cell3 = row.insertCell(2);
					cell3.innerHTML = stu[i].email;
					//alert(stu[i].email);

					var cell4 = row.insertCell(3);
					cell4.innerHTML = stu[i].password;
					//alert(stu[i].password);

					var cell5 = row.insertCell(4);
					cell5.innerHTML = '<input type="button" id="'
							+ stu[i].rollno
							+ '"  onclick="EditData(this.id)" value="EDIT"> ';

					var cell6 = row.insertCell(5);
					cell6.innerHTML = '<input type="button" id="'
							+ stu[i].rollno
							+ '"  onclick="deleteData(this.id)" value="DELETE" >';
				}
			}


		}

	}

	
</script>

</head>
<center>
	<body>
		<h1>Login Page</h1>

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

		<br>

		<table id="data" border="1">
			<br>
		</table>
		<br>
		<br>
		<table id="data1" border="1"></table>
		<br>
		<br>
		<table id="data2" border="1"></table>

	</body>
</center>
</html>