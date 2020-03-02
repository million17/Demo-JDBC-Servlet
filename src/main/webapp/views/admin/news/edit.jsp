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
		<a href="#" class="btn btn-gradient-primary btn-icon-text mr-4">
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
							<button type="button" class="btn btn-gradient-dark btn-icon-text">
                         		<i class="mdi mdi-file-check btn-icon-append"></i>                          
                        	</button></td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		
		</div>
	</form>
</body>

</html>