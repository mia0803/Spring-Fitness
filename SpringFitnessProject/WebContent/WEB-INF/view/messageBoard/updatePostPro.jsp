<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Update Post Process</title>
</head>
<body>



<%



%>
<script>
var postId = "${dto.id}";
alert("Post updated!");
window.location="/SpringFitnessProject/community/editContent.em?post_id=" + postId;
</script>
<%

%>




</body>
</html>