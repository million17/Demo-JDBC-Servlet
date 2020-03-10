<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-new" />
<c:url var="NEWurl" value="/admin-new" />
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<div class="d-flex justify-content-end">
		<a href="<c:url value = "/admin-new?type=edit "/>" class="btn btn-gradient-primary btn-icon-text mr-4">
            <i class="mdi mdi-file-check btn-icon-prepend"></i>
            Add News
        </a>
        <button id="btnDelete" type="button" class="btn btn-gradient-dark mr-4">
            <i class="mdi mdi-file-check btn-icon-prepend"></i>
            Delete
         </button>
    </div>
	<form action="<c:url value = '/admin-new/' /> " id="formSubmit"
		method="get">
		<div class="table-responsive">
			<table class="table">
				<thead>
					<tr>
						<th><input type="checkbox" id="checkAll" /></th>
						<th>Title</th>
						<th>Thumbnail</th>
						<th>Short Description</th>
						<th>Content</th>
						<th>Edit</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${vm.listResult}">
						<tr>
							<td><input type="checkbox" id="checkbox_${item.id}" value="${item.id}" /></td>
							<td>${ item.title }</td>
							<td>${ item.thumbnail }</td>
							<td>${ item.shortDesc }</td>
							<td>${ item.content }</td> 
							<td>
							<c:url var="editURL" value="/admin-new">
								<c:param name="type" value="edit" />
								<c:param name="id" value="${ item.id }" />
							</c:url>
							<a class="btn btn-gradient-dark btn-icon-text" href="${editURL}">
                         		<i class="mdi mdi-file-check btn-icon-append"></i>                          
                        	</a></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
			<ul class="pagination d-flex justify-content-center" id="pagination"></ul>
			<input type="hidden" value="" id="page" name="page"/>
			<input type="hidden" value="" id="maxPageItem " name="maxPageItem"/>
			<input type="hidden" value="" id="sortName" name="sortName"/>
			<input type="hidden" value="" id="sortBy " name="sortBy"/>
			<input type="hidden" value="" id="type " name="type"/>
		</div>
	</form>
	<script type="text/javascript">
		
		var totalPages = ${vm.totalPage};
		var currentPages = ${vm.page};
		/*var visiblePage = ${vm.maxPageItem}; */
		var limit = 2;
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : totalPages,
				visiblePages :10,
				startPage : currentPages,
				onPageClick : function(event, page) {
					if(currentPage != page){
						$('#maxPageItem').val(limit);
						$('#page').val(page);
						$('#sortName').val('title');
						$('#sortBy').val('desc');
						$('#type').val('list');
						$('#formSubmit').submit();
					}
					
				}
			});
		});
		$( '#btnDelete' ).click(function() {
		  	var data = {};
		  	var ids = $('tbody input[type=checkbox]:checked').map(function(){
		  		return $(this).val();
		  	}).get();
		  	data ['ids']= ids;
		  	deleteNew(data);
		});

		function deleteNew(data){
			$.ajax({
				url : '${APIurl}',
				type : 'DELETE',
				contentType : 'application/json',
				data : JSON.stringify(data),
				success : function(result) {
					window.location.href = "${NEWurl}?type=list&page=1&maxPageItem=3&sortName=title&sortBy=desc";
				},
				error :function(error) {
					console.log(error);
				}
			});
		}
	</script>
</body>

</html>