<jsp:include page="header.jsp"></jsp:include>
<form action="showAllPost" method="GET">
	<div class="col-md-6">
		<div class="profile-sidebar">
			<br>
			<div class="profile-usermenu">
				<ul class="unstyled">
					<li><i class="glyphicon glyphicon-user"></i> UserId:
						${user.userId}</li>
					<li><i class="	glyphicon glyphicon-envelope"></i> Post
						Name:${post.name}</li>
					<li><i class="glyphicon glyphicon-user"></i> Content
						:${post.content}</li>

				</ul>
			</div>
		</div>
	</div>
</form>
