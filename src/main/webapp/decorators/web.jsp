<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title><dec:title default="Home Web" /></title>

<!-- Bootstrap core CSS -->
<link
	href="<c:url value= '/template/web/bootstrap/css/bootstrap.min.css' />"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<c:url value= '/template/web/css/style.css '/>" rel="stylesheet">

</head>
<body>

	<!-- header -->
	<%@ include file="/common/web/header.jsp"%>
	<!-- end header -->

	<div class="container">
		<dec:body />
	</div>

	<!-- footer -->
	<%@ include file="/common/web/footer.jsp"%>
	<!-- end footer -->
	<!-- Bootstrap core JavaScript -->
	<script src="<c:url value='/template/web/jquery/jquery.min.js' />"></script>
	<script
		src="<c:url value='/template/web/bootstrap/js/bootstrap.bundle.min.js' /> "></script>
</body>
</html>