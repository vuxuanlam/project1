<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
	<form action="allPost" method="GET">
		<div class="col-md-10">
			<div class="profile-sidebar">
				<br>
				<c:forEach items="${postList}" var="post">
					<div class="panel-group">
						<div class="panel panel-primary">
							<div class="panel-heading">${post.name}-
								#Post${post.postId}</div>
							<div class="panel-body">
								<ul class="unstyled">
									<li>${post.content}</li>
									<li>Create At: ${post.createAt} - Update
										At:${post.updateAt} - User Id:${post.userId}</li>
								</ul>
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