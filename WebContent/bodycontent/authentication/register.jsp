<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="assets/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>

<title>Register</title>
</head>
<body>
	<form class="form-horizontal" action="register" method="POST">
		<h1 class="text-center signup-title">Register Form</h1>
		<div class="col-sm-6 col-md-5 col-md-offset-4">
			</br> </br>
			<div id="legend"></div>
			<div class="control-group">
				<div class="controls">
					<input type="text" class="form-control" name="name"
						placeholder="UserName" required="required">
					<p class="help-block">Username can contain any letters or
						numbers, without spaces</p>
					<input type="email" class="form-control" name="email"
						placeholder="Email" required="required""></br>
					<p class="help-block">Please provide your E-mail</p>
					<input type="password" id="password" class="form-control"
						name="password" placeholder="Password" required="required"
						pattern=".{6,20}">
					<p class="help-block">Password should be at least 4 characters</p>
					<input type="password" id="confirmpassword" class="form-control"
						name="confirmpassword" placeholder="ConfirmPasswor"
						onkeyup="checkPass();" required="required" pattern=".{6,20}">
					<span id="confirmMessage" class="confirmMessage"></span>
					<p class="help-block">Please confirm your password</p>
					</br>
					<button class="btn btn-lg btn-primary btn-block" type="submit">
						Register</button>
					</br>
				</div>
			</div>
			<p style="color: red;">${errorString}</p>
		</div>
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

</body>
</html>