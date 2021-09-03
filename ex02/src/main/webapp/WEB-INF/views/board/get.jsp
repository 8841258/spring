<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<h3>게시글 상세보기</h3>
<table border="1" style="border-collapse: collapse;">
	<tr>
		<td>${board.bno }</td>
		<td width="500">${board.title }</td>
		<td>${board.writer }</td>
	</tr>
	<tr>
		<td></td>
		<td><fmt:formatDate value="${board.regdate }"
				pattern="yyyy-MM-dd HH:mm:ss" /></td>
		<td><fmt:formatDate value="${board.updatedate }"
				pattern="yyyy-MM-dd HH:mm:ss" /></td>
	</tr>
	<tr>
		<td colspan="3" height="500">${board.content }</td>
	</tr>
</table>
<button type="button" class="btn btn-outline btn-info"
	onclick="location.href='${pageContext.request.contextPath }/board/register'">등록</button>
<form method="POST"
	action="${pageContext.request.contextPath }/board/modifyForm">
	<input type="hidden" name="bno" value="${board.bno }"> <input
		type="hidden" name="title" value="${board.title }"> <input
		type="hidden" name="writer" value="${board.writer }">
	<button class="btn btn-outline btn-info">수정</button>
	<button class="btn btn-outline btn-info"
	formaction="${pageContext.request.contextPath }/board/delete">삭제</button>
</form>
<%@ include file="/WEB-INF/views/includes/footer.jsp"%>