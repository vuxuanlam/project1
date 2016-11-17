<jsp:include page="/header.jsp"></jsp:include>
<div class="container">
	<h1>Edit Profile</h1>
	<hr>
	<div class="row">
		<!-- left column -->
		<div class="col-md-3">
			<div class="text-center">
				<img src="https://freeiconshop.com/files/edd/person-flat.png"
					class="avatar img-circle" alt="avatar">
				<h6>Upload a different photo...</h6>

				<input class="form-control" type="file">
			</div>
		</div>

		<!-- edit form column -->
		<div class="col-md-9 personal-info">

			<form class="form-horizontal" role="form" action="changeProfile"
				method="POST">
				<div class="form-group">
					<label class="col-lg-3 control-label">Email:</label>
					<div class="col-lg-8">
						<input class="form-control" type="text" name="email">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label">Password:</label>
					<div class="col-md-8">
						<input class="form-control" type="password" name="password"
							id="password" pattern=".{6,20}">
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label">Confirm password:</label>
					<div class="col-md-8">
						<input class="form-control" type="password" name="confirmpassword"
							id="confirmpassword" pattern=".{6,20}" onkeyup="checkPass(); ">
						<span id="confirmMessage" class="confirmMessage"></span>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label"></label>
					<div class="col-md-8">
						<input type="submit" class="btn btn-primary" value="Save Changes">
						<span></span> <input type="reset" class="btn btn-default"
							value="Cancel">
					</div>

				</div>
				<br>
				<p style="color: blue;">${errorString}</p>

				<script type="text/javascript">
					function checkPass() {
						var pass1 = document.getElementById('password');
						var pass2 = document.getElementById('confirmpassword');
						var message = document.getElementById('confirmMessage');
						if ((pass1 != null) && (pass2 != null)) {
							if (pass1.value == pass2.value) {
								message.style.color = "#1d78ba";
								message.innerHTML = "Password Match!"
							} else {
								message.style.color = "#d13636";
								message.innerHTML = "Please retype confirm password!"
							}
						}
					}
				</script>
			</form>
		</div>
	</div>
</div>
<hr>
<jsp:include page="/footer.jsp"></jsp:include>