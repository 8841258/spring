<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<style>
tr:hover {
	cursor: pointer;
}
</style>

<script>
	$(function() {
		$('#board').DataTable();
	});
</script>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">게시판</h1>
	</div>


	<div class="row">
		<div class="col-lg-12">
			<table id="board" class="table table-hover">
				<thead>
					<tr>
						<th>글번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일자</th>
						<th>수정일자</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="board" items="${list }">
						<tr onclick="location.href='get?bno=${board.bno }'">
							<td>${board.bno }</td>
							<td>${board.title }</td>
							<td>${board.writer }</td>
							<td><fmt:formatDate value="${board.regdate }"
									pattern="yyyy-MM-dd HH:mm:ss" /></td>
							<td><fmt:formatDate value="${board.updatedate }"
									pattern="yyyy-MM-dd HH:mm:ss" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<button type="button" class="btn btn-outline btn-info" onclick="location.href='${pageContext.request.contextPath }/board/register'">등록</button>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/views/includes/footer.jsp"%>