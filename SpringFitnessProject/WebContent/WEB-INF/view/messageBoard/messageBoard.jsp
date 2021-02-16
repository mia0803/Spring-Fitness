<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Community - Message board</title>
<link rel="stylesheet" type="text/css" href="/SpringFitnessProject/resource/css/main.css">
<link rel="stylesheet" type="text/css" href="/SpringFitnessProject/resource/css/table.css">
<link rel="stylesheet" type="text/css" href="/SpringFitnessProject/resource/css/qboard.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="icon" type="image/png" href="/SpringFitnessProject/resource/images/starry_logo.png"/>
<style>

.narrow-body-box{
	text-align: center;
	background: #d4d4d4;
	width: 1200px;
	margin: auto;
	border-radius: 15px;
	color: black;
	padding-top: 20px;
	padding-bottom:40px;
	margin-bottom:20px;
}
</style>
</head>
<body>

<div class="main-body" >

	<!-- top menu bar page -->
	<c:if test="${sessionEmail!=null }"><jsp:include page="/resource/pages/userTopMenuBar.jsp" /></c:if>
	<c:if test="${sessionEmail==null }"><jsp:include page="/resource/pages/topMenuBar.jsp" /></c:if>

	<div class="narrow-body-box">
	
		<h1>Message Board</h1>
		<c:if test="${'admin'==user }">
			<button class="go-to-write-post" id="${sessionEmail}">Write Announcement</button> <br/>
		</c:if>
		<table class="qboard-table">
			<tr>
				<th class="number">No.</th>
				<th class="title">Title</th>
				<th class="writer">Writer</th>
				<th class="date">Date</th>
				<th class="view">View</th>
			</tr>
			<c:forEach var="i" begin="0" end="${posts.size()-1 }" >
				<c:if test="${posts[i].announcement==1 }">
					<tr class="post_detail" id="${posts[i].id}">
						<td>${posts[i].id}</td>
						<td><i class="fa fa-bullhorn" aria-hidden="true"></i>${posts[i].title} [${post_comment_counts[i]}]</td>
						<td>${posts[i].email}</td>
						<td>${dateList[i]}</td>
						<td>${posts[i].post_view}</td>
					</tr> 
				</c:if>
				<c:if test="${posts[i].announcement!=1 }">
					<tr class="post_detail" id="${posts[i].id}">
						<td>${posts[i].id}</td>
						<td>${posts[i].title} [${post_comment_counts[i]}]</td>
						<td>${posts[i].email}</td>
						<td>${dateList[i]}</td>
						<td>${posts[i].post_view}</td>
					</tr>
				</c:if>
			</c:forEach>
		</table> <br/>
		<c:if test="${'member'==user }">
			<button class="go-to-write-post" id="${sessionEmail}">Write Post</button>  <br/><br/>
		</c:if>
		
		<c:if test="${currentBtnBox==1 }">
			<a class="not-clickable">← prev</a>
		</c:if>
		<c:if test="${currentBtnBox!=1 }">
			<a class="pagination" id="${(currentBtnBox-1)*buttons_on_page}" data-content="${searchContent}">← prev</a>
		</c:if>
		
		<c:if test="${currentBtnBox==totalBtnBox }">
			<c:forEach var="i" begin="${(currentBtnBox-1)*buttons_on_page+1 }" end="${total_page }">
				<c:if test="${i==current_page }">
				<a class="pagination selected" id="${i }" data-content="${searchContent}">${i }</a>
				</c:if>
				<c:if test="${i!=current_page }">
				<a class="pagination" id="${i }" data-content="${searchContent}">${i }</a>
				</c:if>
			</c:forEach>
		</c:if>
		
		<c:if test="${currentBtnBox<totalBtnBox }">
			<c:forEach var="i" begin="${(currentBtnBox-1)*buttons_on_page+1 }" end="${(currentBtnBox-1)*buttons_on_page+buttons_on_page }">
				<c:if test="${i==current_page }">
					<a class="pagination selected" id="${i}" data-content="${searchContent}">${i}</a>
				</c:if>
				<c:if test="${i!=current_page }">
					<a class="pagination" id="${i}" data-content="${searchContent}">${i }</a>
				</c:if>
			</c:forEach>
		</c:if>
		
		<c:if test="${currentBtnBox==totalBtnBox }">
			<a class="not-clickable">next →</a>
		</c:if>
		<c:if test="${currentBtnBox!=totalBtnBox }">
			<a class="pagination" id="${currentBtnBox*buttons_on_page+1}" data-content="${searchContent}">next →</a>
		</c:if>
		
		<br/><br/>
		<i class="fa fa-search"></i>&nbsp;&nbsp;
		<c:if test="${searchContent!=null }">
			<input type="text" class="search-box" id="board-input" value="${searchContent}">
		</c:if>
		<c:if test="${searchContent==null }">
			<input type="text" class="search-box" id="board-input" placeholder="Search relative topics..">
		</c:if>
		<button class="search-btn">Search</button>
	</div>
</div>

<script src="/SpringFitnessProject/resource/js/jquery-3.2.1.min.js"></script>
<script src="/SpringFitnessProject/resource/js/main.js"></script>
<script src="/SpringFitnessProject/resource/js/qboard.js"></script>

</body>
</html>