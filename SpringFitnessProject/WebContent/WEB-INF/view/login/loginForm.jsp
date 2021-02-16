<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Star Fitness Login</title>
<link rel="stylesheet" type="text/css" href="/SpringFitnessProject/resource/css/login.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="icon" type="image/png" href="/SpringFitnessProject/resource/images/starry_logo.png"/>

</head>
<body>

<div class="white-box center-align">
	<div class="thick-box left-align">
		<br/><br/>
		<h1 class="go-to-main">Star Fitness</h1>
		<p>Log in to your Star Fitness account</p><br/><br/>
	</div>
	<form action="/SpringFitnessProject/login/loginPro.em" method="post">
		<c:if test="${cookie.cRemember.value!=null }">
			<div class="thick-box center-align">
				<input class="big-size email" name="email" type="text" value="${cookie.cEmail.value}" pattern="^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$" required><br/><br/>
				<input class="big-size pw" name="pw" type="password" value="${cookie.cPw.value}" pattern="(?=.*\d)(?=.*[a-z]).{5,}" required><br/><br/>
				<input class="big-size button" type="submit" value="Login">
			</div>
			<input type="checkbox" name="remember" value="remember" checked><p class="grey">Remember my ID</p>
		</c:if>
		<c:if test="${cookie.cRemember.value==null }">
			<div class="thick-box center-align">
				<input class="big-size email" name="email" type="text" placeholder="Email" pattern="^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$" required><br/><br/>
				<input class="big-size pw" name="pw" type="password" placeholder="Password" pattern="(?=.*\d)(?=.*[a-z]).{5,}" required><br/><br/>
				<input class="big-size button" type="submit" value="Login">
			</div>
			<input type="checkbox" name="remember" value="remember"><p class="grey">Remember my ID</p>
		</c:if>
	</form>
	
	<div class="thick-box center-row-align">
		<a class="forgot-username">Forgot UserName</a> 
		<pre>      </pre>
		<a class="forgot-password">Forgot Password</a>
	</div>
	<p>___ or ___</p>
	<div class="center-align login-api">
		<p>Login with <b>Facebook</b></p><br/>
		<p>Sign in with <b>Apple</b></p>
	</div>
	<p class="large-top-margin">Don't have an account yet? Click <a href="/SpringFitnessProject/registration/registration1.em">here</a> to register.</p>
</div>

<script src="/SpringFitnessProject/resource/js/jquery-3.2.1.min.js"></script>
<script src="/SpringFitnessProject/resource/js/main.js"></script>
<script src="/SpringFitnessProject/resource/js/homepage.js"></script>


</body>
</html>














