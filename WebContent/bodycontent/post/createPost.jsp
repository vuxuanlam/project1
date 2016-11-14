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
	<form class="form-horizontal" action="creatPost" method="POST">
		<h1 class="text-center signup-title">Creat Post Form</h1>
		<div class="col-sm-6 col-md-5 col-md-offset-4">
			<br> <br>
			<div class="control-group">
				<div class="controls">
					<input type="text" class="form-control" name="name"
						placeholder="PostName" required="required">
					<p class="help-block">Please Write Post Name</p>
					<input type="text" class="form-control" name="content"
						placeholder="Content" required="required"><br>
					<button class="btn btn-lg btn-primary btn-block" type="submit">
						Creat</button>
					<br>
				</div>
			</div>
			<p style="color: red;">${errorString}</p>
		</div>

	</form>

</body>
</html>