<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Registration Step 1</title>
<link rel="stylesheet" type="text/css" href="/SpringFitnessProject/resource/css/register.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="icon" type="image/png" href="/SpringFitnessProject/resource/images/starry_logo.png"/>
</head>



<body>

<div class="black-banner">
	<h2 class="vertical-center go-to-main">Starry Fitness</h2>
</div>

<div class="left-leaning">
	<div class="narrow-high-box">
		<h1>Choose your membership</h1>
	</div>
	<div class="thick-top-margin row-align">
	Select a Club to continue &nbsp;
	<a class="small-underline select-btn">select club</a>
	</div>
	<div class="thick-top-margin">
		<input class="big-next-btn reg1-btn" type="submit" value="Next">
	</div>
	
</div>

<div class="theModal">
	<div class="modal-content">
		<div class="modal-header">
			<div class="in-line">
		  		<span class="close" aria-hidden="true">&times;</span>
		  	</div>
			<div class="narrow-high-box">
				<h1>100+ Clubs worldwide</h1>
				Choose a club for your membership
			</div>
			<div class="underline-box">
				<i class="fa fa-search"></i>&nbsp;&nbsp;
				<input class="search-btn" type="text" name="location" placeholder="Enter State">
			</div>
		</div>
		
		<div class="modal-body">
			<c:forEach var="club" items="${clubs }">
				<div class="large-box ${club.location}">
					<p class="header club">${club.club_name }</p>
					<p class="narrow-box"> ${club.address }</p>
					${club.phone } <br/>
					${club.location } 
				</div>
			</c:forEach>
		</div>
		
	</div>
</div>


<script src="/SpringFitnessProject/resource/js/jquery-3.2.1.min.js"></script>
<script src="/SpringFitnessProject/resource/js/main.js"></script>
<script src="/SpringFitnessProject/resource/js/homepage.js"></script>

</body>
</html>