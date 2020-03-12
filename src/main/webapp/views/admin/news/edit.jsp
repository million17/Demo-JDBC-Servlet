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
					<c:if test="${not empty messageResponse}">
						<div class="alert alert-${alert} my-3 mx-3" role="alert">
							${messageResponse}</div>
					</c:if>
					<form id="formSubmit">
						<div class="form-group">
							<label for="titile">Title</label> <input type="text"
								class="form-control" id="title" name="title" placeholder="title"
								value="${vm.title}">
						</div>
						<div class="form-group">
							<label for="thumbnail">Thumbnail</label> <input type="text"
								class="form-control" id="thumbnail" name="thumbnail" placeholder="thumbnail"
								value="${vm.thumbnail}">
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
							<label for="shortDesc">Short Description</label> <input
								type="text" class="form-control" id="shortDesc"
								placeholder="Password" name="shortDesc" value="${vm.shortDesc}">
						</div>
						<div class="form-group">
							<label for="content">Content</label>
							<textarea name="content" id="content" cols="30" rows="10" value="${vm.content}"></textarea>
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
		var editor = '';
		$( document ).ready(function() {
		    editor = CKEDITOR.replace('content');
		});
		$("#btnAddOrEdit").click(function(e) {
			e.preventDefault();
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
					window.location.href = "${NEWurl}?type=edit&id="+result.id+"&message=insert_success";
					
				},
				error : function(error) {
					window.location.href = "${NEWurl}?type=list&page=1&maxPageItem=3&message=error_system";
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
					window.location.href = "${NEWurl}?type=edit&id="+result.id+"&message=update_success";
				},
				error : function (error) { 
					window.location.href = "${NEWurl}?type=list&page=1&maxPageItem=3&message=error_system";
				}
			});
		}
	</script>
</body>
</html>