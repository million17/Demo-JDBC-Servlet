<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<div class="row">
		<div class="col-12 grid-margin stretch-card">
			<div class="card">
				<div class="card-body">
					<h4 class="card-title">Edit News</h4>
					<p class="card-description">Basic form edits</p>
					<c:if test="${not empty message}">
						<div class="alert alert-${alert} my-3 mx-3" role="alert">
							${message}</div>
					</c:if>
					<form class="forms-sample">
						<div class="form-group">
							<label for="titile">Title</label> 
							<input type="text"
								class="form-control" id="titile" name="title" placeholder="title">
						</div>
						<div class="form-group">
							<label for="thumbnail">Thumbnail</label> <input
								type="text" class="form-control" id="thumbnail"
								placeholder="thumbnail">
						</div>
						<div class="form-group">
							<label for="shortDesc">Short Description</label> <input
								type="text" class="form-control" id="shortDesc"
								placeholder="Password" name="shortDesc">
						</div>
						<div class="form-group">
							<label for="content">Content</label> <input type="text"
								class="form-control" id="content" name="content"
								placeholder="content">
						</div>
						<div class="form-group">
							<label for="exampleFormControlSelect1">Category</label>
							<select class="form-control form-control-lg" id="categoryCode" name="categoryCode">
							<option value ="1">1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
							</select>
						</div>
						<button type="submit" class="btn btn-gradient-primary mr-2">Submit</button>
						<button class="btn btn-light">Cancel</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>