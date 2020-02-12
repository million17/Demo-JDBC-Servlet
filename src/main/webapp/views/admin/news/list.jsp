<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<div class="table-responsive">
		<table class="table">
			<thead>
				<tr>
					<th>Title</th>
					<th>Thumbnail</th>
					<th>Short Desc</th>
					<th>Content</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>Fund is not recieved</td>
					<td><label class="badge badge-gradient-success">DONE</label></td>
					<td>Dec 5, 2017</td>
					<td>WD-12345</td>
				</tr>
			</tbody>
		</table>
		<ul class="pagination d-flex justify-content-center" id="pagination"></ul>
	</div>
	<script type="text/javascript">
		$(function() {
			window.pagObj = $('#pagination').twbsPagination({
				totalPages : 10,
				visiblePages : 5,
				onPageClick : function(event, page) {
					console.info(page + ' (from options)');
				}
			}).on('page', function(event, page) {
				console.info(page + ' (from event listening)');
			});
		});
	</script>
</body>

</html>