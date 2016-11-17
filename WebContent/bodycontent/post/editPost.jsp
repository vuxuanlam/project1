<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/header.jsp"></jsp:include>

<div class="container">
	<div class="row">
		<h3 class="text-center">Edit Post</h3>
		<br> <br>
		<div class="col-md-8 col-md-offset-1">
			<form class="form-horizontal" method="POST"
				action="editPost?editPostId=${editPostId }">

				<div class="form-group">
					<label for="name" class="col-md-3 control-label"> Post Name
					</label>
					<div class="col-md-9">
						<input type="text" class="form-control" id="name" name="name"
							placeholder="Name of Post" required="required">
					</div>
				</div>
				<br> <br>
				<div class="form-group">
					<label for="Content" class="col-md-3 control-label"> Post
						Content </label>
					<div class="col-md-9">
						<textarea class="form-control" rows="9" id="content"
							placeholder="Content of Post" name="content" required="required"></textarea>
					</div>
				</div>


				<div class="form-group">
					<div class="col-sm-offset-3 col-md-9">
						<br>
						<button type="submit" class="btn btn-primary btn-block">Save</button>
					</div>
				</div>
			</form>
		</div>
		<p style="color: red;">${errorString}</p>
	</div>
</div>
<jsp:include page="/footer.jsp"></jsp:include>