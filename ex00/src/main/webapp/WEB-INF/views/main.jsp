<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	여기는 메인 페이지~~~~
	<form action="login">
		<input name="id" value="${param.id }">
		<input name="pw">
		<button>로그인</button>
	</form>
</body>
</html>