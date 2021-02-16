<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Post Deletion Process</title>
</head>
<body>

<c:if test="${post_sid != null }">
	<script>
	alert("Post has deleted!");
	window.location="/SpringFitnessProject/community/messageBoard.em";
	</script>
</c:if>


</body>
</html>