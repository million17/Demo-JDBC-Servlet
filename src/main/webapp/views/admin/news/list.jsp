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
				totalPages : (totalPages==0) ? 1 : totalPages,
				visiblePages :10,
				startPage : currentPages,
				onPageClick : function(event, page) {
					if(currentPage != page){
						$('#maxPageItem').val(limit);
						$('#page').val(page);
						$('#sortName').val('title');
						$('#sortBy').val('ASC');
						$('#type').val('list');
						$('#formSubmit').submit();
					}
					
				}
			});
		});
	</script>
</body>

</html>