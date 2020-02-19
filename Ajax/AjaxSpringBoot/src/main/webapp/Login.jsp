<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
	function getCountry()
	{
		var req = new XMLHttpRequest();
		req.open("GET", "country", true);
		req.send();

		var country = document.getElementById("cid");
		var op = document.createElement("option");
		op.text = "---Select Country---";
		country.add(op);

		req.onreadystatechange = function()
		{
			
			if (req.readyState == 4 && req.status == 200)
				{
					
				var countryList = JSON.parse(req.responseText);
				//var country = document.getElementById("cid");

				for (var i = 0; i < countryList.length; i++)
					{

					var option = document.createElement("option");
					option.value = countryList[i].cid;
					option.text = countryList[i].cname;
					country.add(option);
					}
				}
	}

	function getState() {
		var cid = document.getElementById("cid").value;
		var req = new XMLHttpRequest();
		alert(cid);

		req.open("GET", "state/" + cid, true);
		req.send();
		var state = document.getElementById("sid");
		var op = document.createElement("option");
		op.text = "---Select State---";
		state.add(op);

		req.onreadystatechange = function() {
			alert(req.readyState);
			alert(req.status);
			if (req.readyState == 4 && req.status == 200) {
				var stateList = JSON.parse(req.responseText);
				alert(stateList);

				for (var i = 0; i < stateList.length; i++) {
					alert("in for");
					var option = document.createElement("option");

					option.value = stateList[i].sid;
					alert(stateList[i].sid);
					option.text = stateList[i].sname;
					alert(stateList[i].sname);
					state.add(option);
				}

			}
		}
	}

	function getCity() {
		var sid = document.getElementById("sid").value;
		var req = new XMLHttpRequest();
		alert(sid);

		req.open("GET", "city/" + sid, true);
		req.send();

		var city = document.getElementById("cityId");
		var op = document.createElement("option");
		op.text = "---Select City---";
		city.add(op);
		alert(req.status);
		req.onreadystatechange = function() {
			alert(req.readyState);
			alert(req.status);
			if (req.readyState == 4 && req.status == 200) {
				var cityList = JSON.parse(req.responseText);
				alert(cityList);

				for (var i = 0; i < cityList.length; i++) {
					alert("in for");
					var option = document.createElement("option");

					option.value = cityList[i].cityId;
					alert(cityList[i].cityId);
					option.text = cityList[i].cityName;
					alert(cityList[i].cityName);
					city.add(option);
				}

			}
		}
	}
</script>
<h1>Select</h1>

</head>
<body onload="getCountry()">

	Country:
	<select id="cid" onchange="getState()">
		<option>select country</option>

	</select>
	<br> State:
	<select id="sid" onchange="getCity()">
		<option>select state</option>
	</select>


	<br> City:
	<select id="cityId">
		<option>select city</option>

	</select>


</body>
</html>