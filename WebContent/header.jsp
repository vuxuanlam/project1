<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="assets/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<title>Project1</title>
</head>
<body>
	<nav class="navbar navbar-light" style="background-color: #ccf7ff;">
		<div class="container-fluid" style="margin-left: 200px">
			<div class="collapse navbar-collapse">
				<form class="navbar-form navbar-left search" method = "POST" action = "search">
					<div class="form-group">
						<input type="text" class="form-control"  name = "tagName" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="allPost">Home Page</a></li>
					<li><a href="createPost">Creat Post</a></li>
					<li><a href="myPost">My post</a>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-haspopup="true"
						aria-expanded="false">Account <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="showProfile">View Profile</a></li>
							<li><a href="changeProfile">Change Profile</a></li>

							<li><a href="logout">Log Out</a></li>

						</ul></li>
				</ul>
			</div>
		</div>
	</nav>