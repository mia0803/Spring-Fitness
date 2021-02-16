<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Starry Fitness</title>
<link rel="stylesheet" type="text/css" href="/SpringFitnessProject/resource/css/main.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="icon" type="image/png" href="/SpringFitnessProject/resource/images/starry_logo.png"/>
<style>
.main-img2{
	width: 100%;
	
}
</style>
</head>
<body>
<div class="main-body" >

	<!-- top menu bar page -->
	<c:if test="${sessionEmail!=null }"><jsp:include page="/resource/pages/userTopMenuBar.jsp" /></c:if>
	<c:if test="${sessionEmail==null }"><jsp:include page="/resource/pages/topMenuBar.jsp" /></c:if>
	
	<div class="container">
		<b class="uppercase left">Studio Pilates</b>
		<img class="main-img2" alt="Starry personal training img" src="/SpringFitnessProject/resource/images/pilates2.jpg">
	</div>
	
	<div class="narrow-body-box">
		<div class="row-align bottom-margin">
			<div class="left-box"><b class="uppercase">About pilates at Starry fitness</b></div>
			<div class="right-box">
				<h3>Small Moves. Big Changes.</h3>
				<p>At its core, Studio Pilates tightens what’s loose and loosens what’s tight. By working evenly with subtle moves, no muscles are ever over or under–trained, creating balance in the body.</p>
			</div>
		</div>
	</div>
</div>

<script src="/SpringFitnessProject/resource/js/jquery-3.2.1.min.js"></script>
<script src="/SpringFitnessProject/resource/js/main.js"></script>
<script src="/SpringFitnessProject/resource/js/homepage.js"></script>

</body>
</html>