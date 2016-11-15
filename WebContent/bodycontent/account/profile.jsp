<jsp:include page="/header.jsp"></jsp:include>
<div class="container">
	<div class="row profile">
		<form action="showProfile" method="GET">
			<div class="col-md-6">
				<div class="profile-sidebar">

					<div class="profile-userpic">
						<img src="https://freeiconshop.com/files/edd/person-flat.png"
							width="100px" height="100px" class="img-responsive" alt="">
					</div>
					<br>
					<div class="profile-usermenu">
						<ul class="unstyled">
							<li><i class="glyphicon glyphicon-user"></i> User:
								:${user.name}</li>
							<li><i class="	glyphicon glyphicon-envelope"></i>
								Email:${user.email}</li>
							<li><i class="glyphicon glyphicon-user"></i> CreatAt
								:${user.createAt}</li>
							<li><i class="glyphicon glyphicon-pencil"></i> UpdateAt
								:${user.updateAt}</li>
						</ul>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>
<br>
<jsp:include page="/footer.jsp"></jsp:include>