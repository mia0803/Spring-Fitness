<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Update Page</title>
<style>
html,body{
background: #e0e0e0;
color: black;
}
</style>
</head>
<body>

<script>
var location1 = "${location}";
alert("Updated!");
window.location="/SpringFitnessProject/region/editLocation.em?location="+location1;
</script>

<script src="/SpringFitnessProject/resource/js/jquery-3.2.1.min.js"></script>
<script src="/SpringFitnessProject/resource/js/main.js"></script>

</body>
</html>