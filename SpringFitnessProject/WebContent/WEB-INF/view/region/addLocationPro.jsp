<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Add Location</title>
<link rel="stylesheet" type="text/css" href="/SpringFitnessProject/resource/css/main.css">
<style>
html,body{
background: #e0e0e0;
color: black;
}
</style>
</head>
<body>

<c:if test="${rdto == null }">
	<div class="horz-center-box">
		<h1>New Location Added!</h1><br/><br/>
		<button class="close-btn">Close</button>
	</div>
</c:if>
<c:if test="${rdto != null }">
	<script>
		alert("Submitted location already exist!");
		window.location="/SpringFitnessProject/region/addLocation.em";
	</script>
</c:if>


<script src="/SpringFitnessProject/resource/js/jquery-3.2.1.min.js"></script>
<script src="/SpringFitnessProject/resource/js/main.js"></script>

</body>
</html>