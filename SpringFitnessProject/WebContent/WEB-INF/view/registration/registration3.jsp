<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.*" %> 
<%@ page import="java.lang.String" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Registration Step 3</title>
<link rel="stylesheet" type="text/css" href="/SpringFitnessProject/resource/css/register.css">
<link rel="icon" type="image/png" href="/SpringFitnessProject/resource/images/starry_logo.png"/>
</head>
<body>

<div class="black-banner">
	<h2 class="vertical-center go-to-main">Starry Fitness</h2>
</div>

<div class="body-box">
	<form action="/SpringFitnessProject/registration/registration4.em" method="post" class="email-validation" >
		<div class="left-leaning">
			<div class="narrow-high-box">
				<h1>Tell Us About Yourself</h1>
			</div>
			<div class="thick-top-margin row-align">
				<div class="some-margin long">
					First name<br/>
					<input name="fname" type="text" placeholder="First name">			
				</div>
				<div class="long">
					Last name<br/>
					<input name="lname" type="text" placeholder="Last name">
				</div>
			</div>
			<div class="thick-top-margin">
				Email address<br>
				<div class="email-box">
					<input name="email" id="email" type="text" placeholder="Email address" pattern="^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$" required>
					<button class="email-validate-btn" type="button">Validate</button>
				</div>
				<span class="email-check" id="false"></span>
			</div>
			<div class="thick-top-margin">
				Password<br>
				<input name="pw" type="password" placeholder="Password" pattern="(?=.*\d)(?=.*[a-z]).{5,}" title="Must contain at least one number and lowercase letter, and at least 5 or more characters" required>
			</div>
			<div class="thick-top-margin">
				Phone number<br>
				<input name="phone" type="text" placeholder="000-000-0000" required>
			</div>
			<div class="thick-top-margin row-align">
				<input class="big-next-btn" type="submit" value="Next">
				<pre>    </pre>
				<p class="small-box">By continuing, I agree to share my contact information with a Membership Advisor.</p>
			</div>
		</div>
	</form>
	
	
	<div class="speech-bubble" id="message">
	  <p>Password must contain the following:</p>
	  <p >A <b>lowercase</b> letter</p>
	  <p >A <b>number</b></p>
	  <p >Minimum <b>5 characters</b></p>
	</div>

</div>



<script src="/SpringFitnessProject/resource/js/jquery-3.2.1.min.js"></script>
<script src="/SpringFitnessProject/resource/js/main.js"></script>
<script src="/SpringFitnessProject/resource/js/homepage.js"></script>

</body>
</html>