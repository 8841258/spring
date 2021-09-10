<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 리스트</title>
</head>
<body>
	사원 리스트
	<c:forEach var="list" items="${list }">
	
		${list.employeeId }<br>
	</c:forEach>
</body>
</html>