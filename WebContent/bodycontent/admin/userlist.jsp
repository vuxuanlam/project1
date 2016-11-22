<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/headerAdmin.jsp"></jsp:include>
<div class="well">
	<form action="adminManageUser" method="GET">
		<h1 class="text-center login-title">Welcome to project 1</h1>
		<br>
		<table class="table">

			<thead>
				<tr>
					<th>User Id</th>
					<th>User Name</th>
					<th>Email</th>
					<th>Creat At</th>
					<th>Update At</th>
					<th style="width: 36px;"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${userList}" var="user">
					<tr>
						<td>${user.userId}</td>
						<td>${user.name}</td>
						<td>${user.email}</td>
						<td>${user.createAt}</td>
						<td>${user.updateAt}</td>
						<td><a href="#"> <span class="glyphicon glyphicon-pencil"></span></a></td>
						<td><a href="#"> <span class="glyphicon glyphicon-trash"></span></a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<p style="color: red;">${errorString}</p>
	</form>
</div>
<script type="text/javascript" src="assets/js/jquery.js"></script>
<script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
</body>
</html>