<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
   
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Find username</title>
<link rel="stylesheet" type="text/css" href="/SpringFitnessProject/resource/css/main.css">

<style>
html,body{
background: #e0e0e0;
color: black;
}
</style>

</head>
<body>

<c:if test="${email!=null }">
	<div class="horz-center-box">
		<h1>This is your email:</h1><br/>
		<p>${email}</p>
		<br/><br/>
		<button class="close-btn">Close</button>
	</div>
</c:if>
<c:if test="${email==null }">
	<script>
	alert("No matched information!");
	window.location="/SpringFitnessProject/login/findUsername.em";
	</script>
</c:if>

<script src="/SpringFitnessProject/resource/js/jquery-3.2.1.min.js"></script>
<script src="/SpringFitnessProject/resource/js/main.js"></script>

</body>
</html>