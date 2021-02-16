<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Find username</title>
<link rel="stylesheet" type="text/css" href="/SpringFitnessProject/resource/css/main.css">
</head>

<style>
html,body{
background: #e0e0e0;
color: black;
}
</style>

</head>

<body>

<form action="/SpringFitnessProject/login/findUsernamePro.em" method="post">
	<div class="horz-center-box">
		<div>
			<h1>Find Username</h1>
		</div>
		<div>
			First name: <input type="text" name="fname"><br/>
		</div>
		<div>
			Last name: <input type="text" name="lname"><br/>
		</div>
		<div>
			Phone number: <input type="text" name="phone"><br/>
		</div>
		<div>
			<input type="submit" name="Submit">
		</div>
	</div>
</form>




</body>
</html>