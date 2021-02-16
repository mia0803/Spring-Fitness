<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Post Content</title>
<link rel="stylesheet" type="text/css" href="/SpringFitnessProject/resource/css/main.css">
<link rel="stylesheet" type="text/css" href="/SpringFitnessProject/resource/css/qboard.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="icon" type="image/png" href="/SpringFitnessProject/resource/images/starry_logo.png"/>
<style>

.narrow-body-box{
	background: #d4d4d4;
	width: 1000px;
	margin: auto;
	margin-top:10px;
	border-radius: 15px;
	color: black;
	padding: 20px;
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

	<div class="narrow-body-box align-center">
		<div class="post-content-box">
			<button class="go-to-qboard">Main Q & A board</button>
			<div class="row-align">
				<div class="post-title">
					<p>Post Title:</p>
					<p>Writer: </p>
					<p>Content:</p>
				</div>
				<div class="post-contents">
					<c:if test="${post.email == sessionEmail }">
						<form action="/SpringFitnessProject/community/updatePostPro.em" method="post">
							<input name="title" type="text" value="${post.title}"> <br/><br/>
							<input name="email" type="text" value="${post.email}" readonly><br/><br/>
							<textarea name="content" class="post-content-box">${post.content}</textarea><br/><br/>
							<div class="btn-box">
								<input class="post-btn" type="submit" value="Update" >
								<input class="post-btn post-delete-btn" id="${post.id}" type="button" value="Delete">
							</div>
							<input name="id" type="hidden" value="${post.id}">
						</form>
					</c:if>
					<c:if test="${post.email != sessionEmail && user == 'admin' }">
						<input type="text" value="${post.title}" readonly> <br/><br/>
						<input type="text" value="${post.email}" readonly><br/><br/>
						<textarea class="post-content-box lock" >${post.content}</textarea><br/>
						<div class="btn-box-some-padding">
							<input class="post-btn post-delete-btn" id="${post.id}" type="button" value="Delete">
						</div>
					</c:if>
					<c:if test="${post.email != sessionEmail && user != 'admin' }">
						<input type="text" value="${post.title}" readonly> <br/><br/>
						<input type="text" value="${post.email}" readonly><br/><br/>
						<textarea class="post-content-box lock" >${post.content}</textarea><br/>
					</c:if>
				</div>
			</div>
		</div>
			
			
		<!-- Comment area -->
		<div class="comment-box">
			<div class="row-align write-comment">
				<div class="left-box1">
					<h4><i class="fa fa-comment fa-flip-horizontal" aria-hidden="true"></i> Comment &nbsp; &nbsp;</h4>
					<c:if test="${sessionEmail != null }">
						<span class="length">${sessionEmail} | &nbsp;</span> 
					</c:if>
				</div>
				
				<!-- Write comment -->
				<div class="right-box1 relative">
					<div class="absolute bottom">
						<c:if test="${sessionEmail != null }">
							<form class="comment-length-check" action="/SpringFitnessProject/community/commentPro.em?action=comment" method="post" >
								<input class="comment-content" name="post_comment"  type="text" placeholder="Comment..."> 
								<input name="post_id" type="hidden" value="${post.id}">
								<input name="email" type="hidden" value="${sessionEmail}">
								<input name="original_comment_id" type="hidden" value="0">
								<input type="submit" value="Send">
							</form>
						</c:if>
					</div>
				</div>
			</div>
			
			<!-- Read comment -->
			<c:forEach var="i" begin="0" end="${comments.size() }">
				<c:if test="${comments[i].reply == 0 }">
					<div class="comment-history-box">
						<div class="comment-box2">
							<div class="left-box">
								<span class="bold">${comments[i].email }</span> <span> | ${dateList[i] }</span> 
							</div>
							<div class="right-box">
								<div class="comment-disiplay-box">
									<div class="comment-display-length">${comments[i].post_comment } </div>
									<div>
										<c:if test="${sessionEmail!=null }">
											<button class="reply-btn" id="${comments[i].id }">Reply</button>&nbsp;
										</c:if>
										<c:if test="${comments[i].email == sessionEmail || user == 'admin'  }">
											<button class="delete-comment" id="${comments[i].id }" name="${comments[i].post_id }">Delete</button>
										</c:if>
									</div>
								</div>
							</div>
						</div>
					</div>
					
					<!-- Write reply -->
					<div class="reply-box ${comments[i].id }">
						<div class="row-align-center">
							<div class="reply-left-box1 ">
								<p class="row-align-center">
									<i class="fa fa-reply-all fa-rotate-180" aria-hidden="true"></i>
									<span class="bold"> &nbsp; ${sessionEmail }</span> &nbsp; | &nbsp;
								</p>
							</div>
							<div>
								<div>
									<form class="comment-length-check" action="/SpringFitnessProject/community/commentPro.em?action=reply" method="post" >
										<input class="comment-content" name="post_comment"  type="text" placeholder="Reply..."> 
										<input name="post_id" type="hidden" value="${post.id }">
										<input name="email" type="hidden" value="${sessionEmail }">
										<input name="original_comment_id" type="hidden" value="${comments[i].id }">
										<input type="submit" value="Send">
									</form>
								</div>
							</div>
						</div>
					</div>
				</c:if>
				
				<!-- Read reply -->
				<c:if test="${comments[i].reply == 1 }">
					<div class="reply-history-box">
						<div class="comment-box2">
							<div class="reply-left-box">
								<i class="fa fa-reply fa-rotate-180" aria-hidden="true"></i>
								<span class="bold">${comments[i].email } </span> <span> | ${dateList[i] }</span>
							</div>
							
							<div class="reply-right-box relative row-align">
								<div class="comment-display-length">${comments[i].post_comment } &nbsp; </div>
								<div>
								<c:if test="${comments[i].email == sessionEmail || user == 'admin' }">
									<button class="delete-comment" id="${comments[i].id }" name="${comments[i].post_id }">Delete</button>
								</c:if>
								</div>
							</div>
						</div>
					</div>
				</c:if>
			</c:forEach>
		</div>
	</div>
</div>

<script src="/SpringFitnessProject/resource/js/jquery-3.2.1.min.js"></script>
<script src="/SpringFitnessProject/resource/js/main.js"></script>
<script src="/SpringFitnessProject/resource/js/qboard.js"></script>

</body>
</html>


