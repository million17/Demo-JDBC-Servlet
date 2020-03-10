<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><dec:title default="Home Admin" /></title>
<!-- bootstrap -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css">
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<!-- end bootstrap -->
<!-- plugins:css -->
<link rel="stylesheet"
	href="<c:url value= '/template/admin/vendors/iconfonts/mdi/css/materialdesignicons.min.css'/>">
<link rel="stylesheet"
	href="<c:url value= '/template/admin/vendors/css/vendor.bundle.base.css' />">
<!-- endinject -->
<!-- inject:css -->
<link rel="stylesheet"
	href="<c:url value= '/template/admin/css/style.css' /> ">
<!-- endinject -->
<link rel="shortcut icon"
	href="<c:url value= '/template/admin/images/favicon.png' /> " />
	
</head>
<body>
	<div class="container-scroller">
		<!-- header -->
		<%@ include file="/common/admin/header.jsp"%>
		<!-- end header -->

		<div class="container-fluid page-body-wrapper">
			<!-- nav -->
			<nav class="sidebar sidebar-offcanvas" id="sidebar">
				<%@ include file="/common/admin/nav.jsp"%>
			</nav>
			<!-- end nav -->
			<!-- container-body -->
			<div class="main-panel">
				<dec:body />
			</div>
			<!-- end container body -->
		</div>

		<!-- footer -->
		<%@ include file="/common/admin/footer.jsp"%>
		<!-- end footer -->
	</div>
	<script src="<c:url value= '/ckeditor/ckeditor.js' /> "></script>
	<!-- plugins:js -->
	<script
		src="<c:url value='/template/admin/vendors/js/vendor.bundle.base.js'/>"></script>
	<script
		src="<c:url value='/template/admin/vendors/js/vendor.bundle.addons.js ' /> "></script>
	<!-- endinject -->
	<!-- Plugin js for this page-->
	<!-- End plugin js for this page-->
	<!-- inject:js -->
	<script src="<c:url value='/template/admin/js/off-canvas.js' />"></script>
	<script src="<c:url value='/template/admin/js/misc.js' />"></script>
	<!-- endinject -->
	<!-- Custom js for this page-->
	<script src="<c:url value='/template/admin/js/dashboard.js' /> "></script>
	<!-- End custom js for this page-->

	<!-- js and jquery -->
	
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"></script>
	<script src="<c:url value='/template/pagination/jquery.twbsPagination.js' /> " type="text/javascript"></script>
	<!-- end js and jquery -->

</body>
</html>