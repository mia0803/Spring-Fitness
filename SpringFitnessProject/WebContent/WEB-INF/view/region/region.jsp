<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Find a Club</title>
<link rel="stylesheet" type="text/css" href="/SpringFitnessProject/resource/css/main.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="icon" type="image/png" href="/SpringFitnessProject/resource/images/starry_logo.png"/>

</head>

<body>

<div class="main-body">

	<!-- top menu bar page -->
	<c:if test="${sessionEmail!=null }"><jsp:include page="/resource/pages/userTopMenuBar.jsp" /></c:if>
	<c:if test="${sessionEmail==null }"><jsp:include page="/resource/pages/topMenuBar.jsp" /></c:if>


	<div class="body-box">
		<div class="total-clubs">
			<h1>We have total ${totalCount } Club(s) nationwide!</h1>
		</div>
		<div class="add-box">
			<c:if test="${user == 'admin' }">
				<button class="add-btn" type="submit">Add Region</button>
			</c:if>
		</div>
		<c:forEach var="i" begin="0" end="${allRegions.size()-1 }">
			<div class="top-align">
				<div class="content-box location-box" id="${allRegions[i].location }">
					<div class="loc-desc">
						<h2>${allRegions[i].location } </h2>
						<p>${allRegions[i].loc_desc }</p>
						<a>-> View all ${totalNList[i]} clubs</a>
					</div>
					<div class="vert-center-box">
						<img src="data:image/jpeg;base64,${imageList[i] }" class="img-size" alt="Location Image" >
					</div>
				</div>
				<c:if test="${user == 'admin' }">
					<div class="vert-center-box">
						<div class="btn-box">
							<button class="edit-btn" id="${allRegions[i].location}">Edit</button>
							<button class="delete-btn" id="${allRegions[i].location}">Delete</button>
						</div>
					</div>
				</c:if>
			</div>
		</c:forEach>
	</div>
</div>

<script src="/SpringFitnessProject/resource/js/jquery-3.2.1.min.js"></script>
<script src="/SpringFitnessProject/resource/js/main.js"></script>
<script src="/SpringFitnessProject/resource/js/locations.js"></script>

</body>
</html>



















