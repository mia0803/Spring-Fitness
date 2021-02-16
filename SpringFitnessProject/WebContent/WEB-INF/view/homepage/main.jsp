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

.main-body{
	width: 1200;
	margin: auto;
}
</style>

</head>
<body>

<div class="main-body" >


	<!-- top menu bar page -->
	<c:if test="${sessionEmail!=null }"><jsp:include page="/resource/pages/userTopMenuBar.jsp" /></c:if>
	<c:if test="${sessionEmail==null }"><jsp:include page="/resource/pages/topMenuBar.jsp" /></c:if>

	
	<div class="align-center">
		<br/><br/><h1>Welcome to the Starry Fitness</h1>
	</div>
	<!-- slideshow -->
	<div class="slideshow-container">
		<div class="mySlides fade">
			<img class="main-img" alt="Starry fitness img" src="/SpringFitnessProject/resource/images/main3.jpg">
		</div>
		<div class="mySlides fade">
			<img class="main-img" alt="Starry fitness img" src="/SpringFitnessProject/resource/images/main5.jpg">
		</div>
		<div class="mySlides fade">
			<img class="main-img" alt="Starry fitness img" src="/SpringFitnessProject/resource/images/main6.png">
		</div>
	</div>
	
	<div class="narrow-body-box">
		<div class="row-align bottom-margin">
			<div class="left-box"><b class="uppercase">Membership Transformed</b></div>
			<div class="right-box">
				<p>Starry is more than a place where high performers come to be their best. </p>
				<p>We've transformed every aspect of our membership to encompass integrated digital and in-club offerings to keep you at your best-all the time, any time.  </p>
				<p>Discover the offerings below, plus The Starry Standard for health, safety, and cleanliness. </p>
			</div>
		</div>
		<div class="row-align">
			<div class="left-box">
				<b class="uppercase">Starry+</b>
				<p>You can now experience Equinox-however, whenever, and wherever you want it-with seamlessly integrated and always-on physical and digital programming.</p>
			
			</div>
			<div class="right-box row-align">
				<div class="feature-box">
					<img class="main-body-img" alt="Starry fitness img" src="/SpringFitnessProject/resource/images/main1.PNG">
					<h4>Variis by Starry</h4>
					<p class="light-grey">Now included in your membership, the Variis by Equinox app offers classes from Equinox and our leading brands SoulCycle, Precision Run, PURE Yoga, HeadStrong, and more. Currently available in U.S. markets only.</p>
				</div>
				<div class="feature-box">
					<img class="main-body-img" alt="Starry fitness img" src="/SpringFitnessProject/resource/images/main2.PNG">
					<h4>Unlimited Group Fitness</h4>
					<p class="light-grey">Enjoy our unparalleled classes like Firestarter, MetCon, Best Abs Ever, and more in the club with room to move for safety or on-demand on the Variis app.</p>
				</div>
			</div>
		</div>
	</div>
</div>


<script src="/SpringFitnessProject/resource/js/jquery-3.2.1.min.js"></script>
<script src="/SpringFitnessProject/resource/js/main.js"></script>
<script src="/SpringFitnessProject/resource/js/homepage.js"></script>

</body>
</html>





















