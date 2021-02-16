<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Edit Location </title>
<link rel="stylesheet" type="text/css" href="/SpringFitnessProject/resource/css/main.css">

<style>
html,body{
background: #e0e0e0;
color: black;
}
</style>
</head>

<body>
<form action="/SpringFitnessProject/region/editLocationPro.em" method="post" enctype="multipart/form-data">
	<div class="horz-center-box">
		<div>
			<h1>Edit Location</h1>
		</div>
		<div>
			Location: ${regionDTO.location }<br/>
		</div>
		<div class="top-align">
			Description: &nbsp; 
			<textarea class="desc" name="loc_desc">${regionDTO.loc_desc }</textarea>
		</div>
		<div>
			<img class="loc-img" alt="Location Image" src="data:image/jpeg;base64,${img }">
		</div>
		<div>
			Update Image: &nbsp; 
			<input type="file" name="mf_img">
		</div>
		<div>
			<input type="hidden" name="location" value="${regionDTO.location }">
			<input type="hidden" name="id" value="${regionDTO.id }">
			<input type="submit" value="Update">&nbsp;
			<button class="close-btn">Close</button>
		</div>
	</div>
</form>

<script src="/SpringFitnessProject/resource/js/jquery-3.2.1.min.js"></script>
<script src="/SpringFitnessProject/resource/js/main.js"></script>

</body>
</html>