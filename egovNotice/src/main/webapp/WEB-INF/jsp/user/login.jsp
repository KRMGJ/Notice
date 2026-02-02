<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<title>로그인</title>

<link rel="stylesheet" href="<c:url value='/resources/css/login.css'/>" />

<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script src="<c:url value='/resources/js/user/login.js'/>"></script>
</head>
<body>
	<div class="login-wrap">
		<h1>로그인</h1>

		<div class="row">
			<label for="userId">아이디</label> 
			<input type="text" id="userId" autocomplete="username" />
		</div>

		<div class="row">
			<label for="password">비밀번호</label> 
			<input type="password" id="password" autocomplete="current-password" />
		</div>

		<button type="button" id="btnLogin">로그인</button>

		<p class="msg" id="msg"></p>
	</div>
</body>
</html>
