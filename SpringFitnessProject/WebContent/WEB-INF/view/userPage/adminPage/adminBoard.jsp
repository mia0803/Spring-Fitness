<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html >
<head>
<meta charset="EUC-KR">
<title>Admin dashboard</title>
<link rel="stylesheet" type="text/css" href="/SpringFitnessProject/resource/css/my-account.css">
<link rel="icon" type="image/png" href="/SpringFitnessProject/resource/images/starry_logo.png"/>
</head>
<body id="main" >


<c:if test="${'admin'!=user }">
	<script>
	alert("Admin only accepted");
	window.location="/SpringFitnessProject/homepage/main.em";
	</script>
</c:if>

<div class="black-banner">
	<h2 class="vertical-center go-to-main">Starry Fitness</h2>
</div>

<div class="body-box">
	<jsp:include page="/resource/pages/adminMenuBar.jsp" />
	
	<div class="body-content">
		<div class="horz-center-box center">
			<h1>Administrator Dashboard</h1><br/>
			Main Page<br/><br/>
			<button class="go-to-main">Main</button> &nbsp;
			<button class="log-out-btn">Log out</button>
		</div>
	</div>
	
</div>

<script src="/SpringFitnessProject/resource/js/jquery-3.2.1.min.js"></script>
<script src="/SpringFitnessProject/resource/js/main.js"></script>
<script src="/SpringFitnessProject/resource/js/admin.board.js"></script>

</body>
</html>







