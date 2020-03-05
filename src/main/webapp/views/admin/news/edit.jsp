<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-new" />
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<div class="row">
		<div class="col-5 grid-margin stretch-card">
			<div class="card">
				<div class="card-body">
					<h4 class="card-title">Edit News</h4>
					<p class="card-description">Basic form edits</p>
					<c:if test="${not empty message}">
						<div class="alert alert-${alert} my-3 mx-3" role="alert">
							${message}</div>
					</c:if>
					<form id="formSubmit">
						<div class="form-group">
							<label for="titile">Title</label> <input type="text"
								class="form-control" id="title" name="title" placeholder="title"
								value="${vm.title}">
						</div>
						<div class="form-group">
							<label for="exampleFormControlSelect1">Category</label> <select
								class="form-control" id="categoryCode" name="categoryCode">
								<c:if test="${empty vm.categoryCode }">
									<option value="">Select Category</option>
									<c:forEach var="item" items="${categories}">
										<option value="${ item.code}">${item.name}</option>
									</c:forEach>
								</c:if>
								<c:if test="${not empty vm.categoryCode }">
									<option value="">Select Category</option>
									<c:forEach var="item" items="${categories}">
										<option value="${item.code }"
											<c:if test="${ item.code == vm.categoryCode}">selected="selected"</c:if>>
											${item.name }</option>
									</c:forEach>
								</c:if>
							</select>
						</div>
						<div class="form-group">
							<label for="thumbnail">Thumbnail</label> <input type="text"
								class="form-control" id="thumbnail" placeholder="thumbnail"
								value="${vm.thumbnail}">
						</div>
						<div class="form-group">
							<label for="shortDesc">Short Description</label> <input
								type="text" class="form-control" id="shortDesc"
								placeholder="Password" name="shortDesc" value="${vm.shortDesc}">
						</div>
						<div class="form-group">
							<label for="content">Content</label> <input type="text"
								class="form-control" id="content" name="content"
								placeholder="content" value="${vm.content}">
						</div>
						<c:if test="${empty vm.id}">
							<input type="button" class="btn btn-success" value="Add" id="btnAddOrEdit" />
						</c:if>
						<c:if test="${not empty vm.id}">
							<input type="button" class="btn btn-light" value="Update" id="btnAddOrEdit" />
						</c:if>
						<button class="btn btn-light">Cancel</button>
						<input type="hidden" value="${vm.id}" id="id" />
					</form>
				</div>
			</div>
		</div>
	</div>
	<script>
		$("#btnAddOrEdit").click(function(e) {
			e.preventDefault();
			//get Dulieu tu client dai nen dung form data
			// var title = $('#title').val();
			// var categoryCode = $('#categoryCode').val();
			// var thumbnail = $('#thumbnail').val();
			// var shortDesc = $('#shortDesc').val();
			// var content = $('#content').val();
			var data = {};
			var formData = $('#formSubmit').serializeArray();
			$.each(formData, function (i, v) { 
				 data[""+ v.name +""] = v.value;
			});
			var id = $('#id').val();
			if(id == ""){
				addNew(data);
			} else {
				updateNew(data);
			}
		});
		function addNew(data) {
			$.ajax({
				url: '${APIurl}',
				type: 'POST',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function(result){
					console.log(result);
					
				},
				error : function(error) {
					console.log(error);
				}

			});
		}
		function updateNew(data) {
			$.ajax({
				url: '${APIurl}',
				type: 'PUT',
				contentType : 'application/json',
				data : JSON.stringify(data),
				dataType : 'json',
				success : function (result) {
					console.log(result);
				},
				error : function (error) { 
					console.log(error);
				}
			});
		}
	</script>
</body>
</html>