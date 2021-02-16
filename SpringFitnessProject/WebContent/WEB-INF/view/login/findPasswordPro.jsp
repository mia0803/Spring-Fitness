<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Reset password</title>
<link rel="stylesheet" type="text/css" href="/SpringFitnessProject/resource/css/main.css">

<style>
html,body{
background: #e0e0e0;
color: black;
}
</style>

</head>
<body>

<c:if test="${user!=null }">
	<form action="/SpringFitnessProject/login/setPasswordPro.em" method="post">
		<div class="horz-center-box">
			<p>Set new password:</p>
			<input type="password" name="pw" pattern="(?=.*\d)(?=.*[a-z]).{5,}" title="Must contain at least one number and lowercase letter, and at least 5 or more characters" required>
			<input type="hidden" name="email" value="${email}">
			<div class="speech-bubble" id="message">
			  <p>Password must contain the following:</p>
			  <p >A <b>lowercase</b> letter</p>
			  <p >A <b>number</b></p>
			  <p >Minimum <b>5 characters</b></p>
			</div>
			
			<br/><br/>
			<input type="submit" value="Submit">
		</div>
	</form>
</c:if>
<c:if test="${user==null }">
	<script>
	alert("No matched result");
	window.location="/SpringFitnessProject/login/findPassword.em";
	</script>
</c:if>


</body>
</html>