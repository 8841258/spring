<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="dept" items="${list }">
	<br>
		${dept.department_id }<br>
		${dept.department_name }<br>
		${dept.location_id }<br>
		${dept.manager_id }<br>
	</c:forEach>
</body>
</html>