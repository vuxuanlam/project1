<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
	<form action="allPost" method="GET">
		<div class="col-md-10">
			<div class="profile-sidebar">
				<br>
				<c:forEach items="${postList}" var="posts">
					<div class="panel-group">
						<div class="panel panel-primary">
							<div class="panel-heading">${posts.post.name}-
								#Post${posts.post.postId}</div>
							<div class="panel-body">
								<ul class="unstyled">
									<li>${posts.post.content}</li>
									<li>Create At: ${posts.post.createAt} - Update
										At:${posts.post.updateAt} - User Id:${posts.post.userId}</li>
									<li><a
										href="createComment?commentPostId=${posts.post.postId}">
											Comment</a></li>
								</ul>
								<c:forEach items="${posts.listUserComment}" var="usercomment">
									<table>
										<tr>
											<td>${usercomment.comment.content}</td>
										</tr>
										<tr>
											<table class="table">
												<tr>
													<td>${usercomment.comment.createAt}</td>
													<td>${usercomment.user.name}</td>
												</tr>
											</table>
										</tr>
									</table>
								</c:forEach>
							</div>
						</div>
					</div>

				</c:forEach>
				<p style="color: red;">${errorString}</p>
			</div>
		</div>
	</form>
</div>
<script type="text/javascript" src="assets/js/jquery.js"></script>
<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
</body>
</html>