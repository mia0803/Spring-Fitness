<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Error page</title>
</head>
<body>

<script type="text/javascript">
var pagePath= '${pagePath}'; // To use EL in Javascript

alert('Login required');
window.location="/SpringFitnessProject/login/loginForm.em";
</script>
	
	
</body>
</html>



