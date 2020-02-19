<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="com.cjc.Model.Student" %>
	
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function EditData() {
	 alert("Edit Data");               //maz database mdhun data aala particular rollno cha aani aata updating chalu aahe

		var rollno = document.getElementById("rollno").value;
		alert(rollno);

		var req = new XMLHttpRequest();
		var url = "http://localhost:8092/updatedata/edituser/" + rollno
		"";
		req.open("GET", url, true);
		req.send();

		req.onreadystatechange = function() 
		{
			alert(req.readyState);
			alert(req.status);
			if (req.readyState == 4 && req.status == 200) 
				{

				var stu = req.responseText;
				alert(stu);
				document.getElementById("data").innerHTML = stu;
			}
		} 
	}

function UpdateData()
{
 alert("hiii");





}

	
</script>

</head>
<center>

	<h1>**Edit Data**</h1>
	<body>

		Rollno:
		<input type="number" id="rollno">
		<br>

		<input type="button" onclick="EditData()" value="Submit">
		<br>
		<br>
		<div id="data"></div>
		<%-- <%Student s=(Student)request.getAttribute("data"); %> --%>
		Name: <input type="text">
		<br>
		Email: <input type="text" >
		<br>
		Password: <input type="text" >
		<br>
		<input type="button" onclick="UpdateData()" value="Update">

	</body>
</center>
</html>