<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Location Deletion Processing</title>
<link rel="stylesheet" type="text/css" href="/SpringFitnessProject/resource/css/main.css">

<style>
html,body{
background: #e0e0e0;
color: black;
}
</style>
</head>
<body>

<c:if test="${clubCount == 0 }">
	<div class="horz-center-box">
		<h1>Successfully deleted.</h1><br/><br/>
		<button class="close-btn">Close</button>
	</div>
</c:if>
<c:if test="${clubCount != 0 }">
	<div class="horz-center-box">
		<h1 class="warning-msg">(Failed)<br/>Remove club(s) of the location first.</h1><br/><br/>
		<button class="close-btn">Close</button>
	</div>
</c:if>

<script src="/SpringFitnessProject/resource/js/jquery-3.2.1.min.js"></script>
<script src="/SpringFitnessProject/resource/js/main.js"></script>

</body>
</html>