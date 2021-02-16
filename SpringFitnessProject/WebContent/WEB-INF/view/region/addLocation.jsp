<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Add Location</title>
<link rel="stylesheet" type="text/css" href="/SpringFitnessProject/resource/css/main.css">

<style>
html,body{
background: #e0e0e0;
color: black;
}
</style>

</head>

<body>

<form action="/SpringFitnessProject/region/addLocationPro.em" method="post" enctype="multipart/form-data">
	<div class="horz-center-box">
		<div>
			<h1>Add Location</h1>
		</div>
		<div>
			New Location: <input type="text" name="location"><br/>
		</div>
		<div class="top-align">
			Description: &nbsp; 
			<textarea class="desc" name="loc_desc"></textarea>
		</div>
		<div>
			Photo: <input type="file" name="mf_img">
		</div>
		<div>
			<input type="submit" name="Submit">
		</div>
	</div>
</form>





</body>
</html>