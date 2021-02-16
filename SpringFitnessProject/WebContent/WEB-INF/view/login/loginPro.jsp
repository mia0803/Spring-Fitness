<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Login process</title>
</head>
<body>
<c:if test="${sessionEmail != null }">
	<c:if test="${user == 'member' && notPaid == null }">
		<c:if test="${deactive == 0 }">
			<script>
			var pagePath= '${pagePath}';
			if(pagePath != ""){
				window.location = "/SpringFitnessProject/homepage/leadPage.em";
			} else if(pagePath == "") {
				window.location = "/SpringFitnessProject/homepage/main.em";
			}
			</script>
		</c:if>
		<c:if test="${deactive == 1 }">
			<script>
			alert('Account has activated! Welcome back!');
			
			var pagePath= '${pagePath}';
			if(pagePath != null){
				window.location = "/SpringFitnessProject/homepage/leadPage.em";
			} else{
				window.location = "/SpringFitnessProject/homepage/main.em";
			}
			</script>
		</c:if>
	</c:if>
	<c:if test="${user == 'admin'}">
		<script>
		alert('Admin mode');
		
		var pagePath= '${pagePath}';
		if(pagePath != null){
			window.location = "/SpringFitnessProject/homepage/leadPage.em";
		} else{
			window.location = "/SpringFitnessProject/homepage/main.em";
		}
		</script>
	</c:if>
	<c:if test="${user == 'teacher'}">
		<script>
		alert('Welcome teacher!');
		
		var pagePath= '${pagePath}';
		if(pagePath != null){
			window.location = "/SpringFitnessProject/homepage/leadPage.em";
		} else{
			window.location = "/SpringFitnessProject/homepage/main.em";
		}
		</script>
	</c:if>
	<c:if test="${user == 'member' && notPaid != null}">
		<script>
		alert('Please finish the payment first');
		window.location="/SpringFitnessProject/registration/registration4.em";
		</script>
	</c:if>
</c:if>

<c:if test="${sessionEmail == null }">
	<script>
	alert("Wrong email or password!");
	window.location="/SpringFitnessProject/login/loginForm.em";
	</script>
</c:if>

</body>
</html>