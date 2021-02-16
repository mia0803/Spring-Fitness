<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Write Post</title>
<link rel="stylesheet" type="text/css" href="/SpringFitnessProject/resource/css/main.css">
<link rel="stylesheet" type="text/css" href="/SpringFitnessProject/resource/css/qboard.css">
<link rel="icon" type="image/png" href="/SpringFitnessProject/resource/images/starry_logo.png"/>
<style>

.narrow-body-box{
	text-align: center;
	background: #d4d4d4;
	width: 1000px;
	margin: auto;
	margin-top:10px;
	border-radius: 15px;
	color: black;
	padding: 20px;
	padding-bottom:40px;
	margin-bottom:20px;
}

</style>

</head>
<body>
<div class="main-body" >

	<!-- top menu bar page -->
	<c:if test="${sessionEmail!=null }"><jsp:include page="/resource/pages/userTopMenuBar.jsp" /></c:if>
	<c:if test="${sessionEmail==null }"><jsp:include page="/resource/pages/topMenuBar.jsp" /></c:if>
	
	<div class="narrow-body-box">

		<div class="post-content-box">
			<button class="go-to-qboard">Main board</button>
			<form action="/SpringFitnessProject/community/writePostPro.em" method="post" class="length-check">
				<div class="row-align">
					<div class="post-title">
						<p>Post Title:</p>
						<p>Writer: </p>
						<p>Content:</p>
					</div>
					<div class="post-contents">
						<c:if test="${user == 'admin' }">
							<input name="title" type="text" value="[Announcement] ">  <br/><br/>
							<input name="email" type="text" value="${sessionEmail }" readonly><br/><br/>
							<textarea name="content" rows="10" cols="20" placeholder="Content..."></textarea><br/>
							<input name="announcement"  type="hidden" value="1">
						</c:if>
						<c:if test="${user != 'admin' }">
							<input name="title" type="text" placeholder="Title...">  <br/><br/>
							<input name="email" type="text" value="${sessionEmail }" readonly><br/><br/>
							<textarea name="content" rows="10" cols="20" placeholder="Content..."></textarea><br/>
							<input name="announcement"  type="hidden" value="0">
						</c:if>
					</div>
				</div>
				<div class="full-box">
					<input type="submit" value="Post">
				</div>
			</form>
		</div>
	</div>
</div>





<script src="/SpringFitnessProject/resource/js/jquery-3.2.1.min.js"></script>
<script src="/SpringFitnessProject/resource/js/main.js"></script>
<script src="/SpringFitnessProject/resource/js/qboard.js"></script>

</body>
</html>