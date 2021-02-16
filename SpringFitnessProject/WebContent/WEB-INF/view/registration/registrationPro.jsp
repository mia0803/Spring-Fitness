<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Registration on Process</title>
</head>
<body>

<c:if test="${changeMembership == null }">
	<script type="text/javascript">
	
	alert("Payment success");
	
	var pagePath= '${pagePath}';
	if(pagePath != null){
		window.location = "/SpringFitnessProject/" + pagePath;
	} else{
		window.location = "/SpringFitnessProject/homepage/main.em";
	}
	</script>
</c:if>

<c:if test="${sessionEmail != null && changeMembership != null }">
	<script type="text/javascript">
	alert("Changed membership successfully");
	
	var pagePath= '${pagePath}';
	if(pagePath != null){
		window.location = "/SpringFitnessProject/" + pagePath;
	} else{
		window.location = "/SpringFitnessProject/memberPage/memberBoard.em";
	}
	</script>
</c:if>

<c:if test="${sessionEmail != null && changeMembership == null }">
	<script type="text/javascript">
	alert("Unapproved access");
	window.location = "/SpringFitnessProject/homepage/main.em";
	</script>
</c:if>

</body>
</html>