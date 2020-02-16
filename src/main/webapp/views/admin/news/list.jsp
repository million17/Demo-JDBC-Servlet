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
					</tr>
				</thead>
				<tbody>
					<c:forEach var="item" items="${vm.listResult}">
						<tr>
							<td>${ item.title }</td>
							<td>${ item.thumbnail }</td>
							<td>${ item.shortDesc }</td>
							<td>${ item.content }</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
			<ul class="pagination d-flex justify-content-center" id="pagination"></ul>
			<input type="hidden" value="" id="page" name="page"/>
			<input type="hidden" value="" id="maxPageItem " name="maxPageItem"/>
		</div>
	</form>
	<script type="text/javascript">
		
		var totalPages = ${vm.totalPage};
		var currentPages = ${vm.page};
		/*var visiblePage = ${vm.maxPageItem}; */
		var limit = 2;
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : (totalPages==0)?1:totalPages,
				visiblePages :10,
				startPage : currentPages,
				onPageClick : function(event, page) {
					if(currentPage != page){
						$('#maxPageItem').val(limit);
						$('#page').val(page);
						$('#formSubmit').submit();
					}
					
				}
			});
		});
	</script>
</body>

</html>