<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Membership Payment</title>
<link rel="stylesheet" type="text/css" href="/SpringFitnessProject/resource/css/register.css">
<link rel="stylesheet" type="text/css" href="/SpringFitnessProject/resource/css/payment.css">
<link rel="icon" type="image/png" href="/SpringFitnessProject/resource/images/starry_logo.png"/>
</head>
<body>

<c:if test="${sessionEmail == null && newEmail == null }">
	<script>
	alert("Unapproved access");
	window.location="/SpringFitnessProject/homepage/main.em";
	</script>
</c:if>

<c:if test="${duplicate != null }">
	<script type="text/javascript">
	alert("Duplicate email or phone number!");
	window.history.back();
	</script>
</c:if>

<c:if test="${duplicate == null && newEmail != null }">
	<script>
	alert("You are registered!");
	</script>
</c:if>

<div class="right-align">
	<button class="go-to-main">Pay later</button>
</div>
<div class="content-body">
	<div class="header">Review and pay</div>
	<div class="narrow-box">
	<c:if test="${'one' == membership }">
		<div class="row-align one">
			<div>
				<p class="bigger">Total payment today</p>
				<p class="light-grey">Membership: Access to ${club }</p>
			</div>
			$${finalPayment}.00
		</div>
	</c:if>
	<c:if test="${'one' != membership }">
		<div class="row-align multiple">
			<div>
				<p class="bigger">Total payment today</p>
				<p class="light-grey">Membership: Access to ${location } </p>
			</div>
			$${finalPayment }.00
		</div>
	</c:if>
		<br/>
		<div class="row-align">
			<div> ${month } payment</div>
			$${membershipPayment }.00
		</div>
		<div class="row-align">
			<div>Initiation fee</div>
			$100.00
		</div>
	</div>
	<br/>
	<br/>
	<p class="small">This is our best rate, for both online and in-club. You can cancel without fees for up to 7 days, no questions asked.</p>
	<br/>
	<br/>
	
	<form action="/SpringFitnessProject/registration/registrationPro.em" class="validate-checkbox" method="post">
		<div>
			<div class="narrow-high-box">
				<h3>Home Address</h3>
			</div>
			<div class="thick-top-margin row-align">
				<div class="some-margin longer">
					First Name<br/>
					<input name="fname" type="text" value="${fname }">			
				</div>
				<div class="longer">
					Last Name<br/>
					<input name="lname" type="text" value="${lname }">
				</div>
			</div>
			<div class="thick-top-margin">
				Country<br>
				<input name="country" type="text" value="USA" readonly>
			</div>
			<div class="thick-top-margin">
				Postal Code<br/>
				<div class="underline-box">
					<input class="short-length" name="postal" type="text" placeholder="Postal code">&nbsp;
					<button type="button" class="address-srch-box">Search</button>
				</div>	
			</div>
			<div class="thick-top-margin">
				Street Address<br>
				<input name="address" type="text" placeholder="Street address">
			</div>
			<div class="thick-top-margin">
				Floor, Apt, Suite<br>
				<input name="address2" type="text" placeholder="Floor, Apt, Suite">
			</div>
			<div class="thick-top-margin row-align">
				<div class="some-margin longer">
					City<br/>
					<input name="city" type="text" placeholder="City">
				</div>
				<div class="longer">
					State<br/>
					<input name="state" type="text" placeholder="State">	
				</div>
				
			</div>
			
		</div>
		<br/>
		<br/>
		<br/>
		
		<div>
			<div class="narrow-high-box">
				<h3>Billing Address</h3>
			</div>
			<div class="thick-top-margin">
				Name on Card<br>
				<input name="name_on_card" type="text" required="required" placeholder="Name on Card">
			</div>
			<div class="thick-top-margin">
				Credit or Debit card number<br>
				<input name="card_number" type="text" required="required" placeholder="XXXX-XXXX-XXXX-XXXX">
			</div>
			<div class="thick-top-margin">
				Expiration(MM/YY)<br>
				<input name="expiration" type="text" required="required" placeholder="(MM/YY)">
			</div>
			
			<div class="thick-top-margin row-align">
				<div class="some-margin longer">
					CVC<br/>
					<input name="cvc" type="password" required="required" placeholder="CVC">			
				</div>
				<div class="longer">
					Postal Code<br/>
					<input name="card_postal" type="text" required="required" placeholder="Postal Code">
				</div>
			</div>
		</div>
		<br/><br/><br/><br/>
		
		You will be charged $${finalPayment }.00 today, and $${membershipPayment }.00 on the 23rd of each month. 
		<br/><br/><br/><br/>
		
		<input type="checkbox" class="agree-btn agree-btn1"> 
		I agree to the Membership <a href="#">Terms & Conditions</a>
		<br/>
		
		<p><input type="checkbox" class="agree-btn agree-btn2"> I understand that the monthly dues will be $${finalPayment }.00 excluding taxes and will be
		transferred on the 23rd day of each month beginning ${month} ${year} on the
		credit card used for payment today.</p>
		
		<br/><br/><br/><br/>
		<div class="align-right">
			<input class="big-next-btn " type="submit" value="Pay now $ ${finalPayment }.00">
		</div>
		
		
	</form>
		
	
	

</div>


<script src="/SpringFitnessProject/resource/js/jquery-3.2.1.min.js"></script>
<script src="/SpringFitnessProject/resource/js/main.js"></script>
<script src="/SpringFitnessProject/resource/js/homepage.js"></script>

</body>
</html>













