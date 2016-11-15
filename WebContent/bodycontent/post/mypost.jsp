<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="/header.jsp"></jsp:include>
<form action="myPost" method="GET">
	<div class="col-md-6">
		<div class="profile-sidebar">
			<br>
			<c:forEach items="${postList}" var="post">
				<div class="profile-usermenu">
					<ul class="unstyled">
						<li><i class="glyphicon glyphicon-user"></i> UserId:
							${post.userId}</li>
						<li><i class="	glyphicon glyphicon-envelope"></i> Post
							Name:${post.name}</li>
						<li><i class="glyphicon glyphicon-user"></i> Content
							:${post.content}</li>
						<li><i class="glyphicon glyphicon-user"></i> Create at
							:${post.createAt}</li>
						<li><i class="glyphicon glyphicon-user"></i> Content
							:${post.updateAt}</li>

					</ul>
				</div>

			</c:forEach>
			<p style="color: red;">${errorString}</p>
		</div>
	</div>
</form>
<script type="text/javascript" src="assets/js/jquery.js"></script>
<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
</body>
</html>