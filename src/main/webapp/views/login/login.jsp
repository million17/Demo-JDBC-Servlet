<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<div class="d-flex justify-content-center h-100">
		<div class="card">
			<c:if test="${not empty message}">
				<div class="alert alert-${alert} my-3 mx-3" role="alert">
					${message}</div>
			</c:if>
			<div class="card-body">
				<form method="post" action="<c:url value='/login?action=login' /> "
					id="formLogin">
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-user"></i></span>
						</div>
						<input type="text" class="form-control" placeholder="username"
							name="userName" id="userName">

					</div>
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"><i class="fas fa-key"></i></span>
						</div>
						<input type="password" class="form-control" placeholder="password"
							name="password" id="password">
					</div>
					<div class="form-group">
						<input type="submit" value="Login"
							class="btn float-right login_btn">
					</div>
					<input type="hidden" name="action" id="action" value="login" />
				</form>
			</div>
		</div>
</body>