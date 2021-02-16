<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Delete Comment</title>
</head>
<body>

<script type="text/javascript">
var post_id = "${post_id}";
window.location = "/SpringFitnessProject/community/editContent.em?post_id=" + post_id;
</script>

</body>
</html>