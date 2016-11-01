<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="assets/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<script type="text/javascript” src=”bootstrap/js/bootstrap.min.js"></script>
<title>login</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-6 col-md-4 col-md-offset-4">
				<h1 class="text-center login-title">Welcome to project 1</h1>
				</br>
				<div class="account-wall">
					<form class="form-signin" method="POST" action="login">
						<input type="text" class="form-control" name="name"
							 placeholder="Username" required autofocus>
						</br> <input type="password" class="form-control" name="password"
							placeholder="Password"
							required="required" pattern=".{6,20}"></br>
						<button class="btn btn-lg btn-primary btn-block" type="submit">
							Sign in</button>
						</br> <label class="checkbox pull-left"> <input type="checkbox"
							value="remember-me"> Remember me
						</label> <a href="#" class="pull-right new-account">Create an account
						</a><span class="clearfix"></span>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>