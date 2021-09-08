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
	let actionForm = $("#actionForm");
		$("tr .move").on("click", function(e) {
			e.preventDefault();
			
			let bno = $(this).attr('href');
			
			actionForm.append('<input type="hidden" name="bno" value="'+ bno +'">');
			actionForm.attr('action', "get");
			actionForm.submit();
		});

		$("#pageButton a").on("click", function(e) {
			e.preventDefault();
			let p = $(this).attr("href");
			$("[name='pageNum']").val(p);
			
			actionForm.submit();
		})
		//$('#board').DataTable();
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
						<tr>
							<td>${board.bno }</td>
							<td><a class="move" href="${board.bno }">${board.title }</a> <strong>[${board.replyCnt }]</strong></td>
							<td>${board.writer }</td>
							<td><fmt:formatDate value="${board.regdate }"
									pattern="yyyy-MM-dd HH:mm:ss" /></td>
							<td><fmt:formatDate value="${board.updatedate }"
									pattern="yyyy-MM-dd HH:mm:ss" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<form id="actionForm" action="list" method="get">
				<select name="type">
					<option value="" ${empty pageMaker.criteria.type ? 'selected' : "" }>선택</option>
					<option value="T" ${pageMaker.criteria.type=='T' ? 'selected' : "" }>제목</option>
					<option value="C" ${pageMaker.criteria.type=='C' ? 'selected' : "" }>내용</option>
					<option value="W" ${pageMaker.criteria.type=='W' ? 'selected' : "" }>작성자</option>
					<option value="TC" ${pageMaker.criteria.type=='TC' ? 'selected' : "" }>제목 or 내용</option>
					<option value="TW" ${pageMaker.criteria.type=='TW' ? 'selected' : "" }>제목 or 작성자</option>
					<option value="TCW" ${pageMaker.criteria.type=='TCW' ? 'selected' : "" }>제목 or 내용 or 작성자</option>
				</select>
				<input name="keyword" value="${pageMaker.criteria.keyword }"> 
				<input type="hidden" name="pageNum"
					value="${pageMaker.criteria.pageNum }">
					<input
					type="hidden" name="amount" value="${pageMaker.criteria.amount }">
					<button class="btn btn-outline btn-info">검색</button>
			</form>
			<div id="pageButton">
				<div class='pull-right'>
					<ul class="pagination">
						<c:if test="${pageMaker.prev }">
							<li class="paginate_button previous"><a
								href="${pageMaker.startPage - 1}" class="move">이전</a></li>
						</c:if>

						<c:forEach var="num" begin="${pageMaker.startPage }"
							end="${pageMaker.endPage }">
							<li class="paginate_button"><a href="${num }">${num }</a></li>
						</c:forEach>

						<c:if test="${pageMaker.next }">
							<li class="paginate_button next"><a
								href="${pageMaker.endPage + 1}" class="move">다음</a></li>
						</c:if>
					</ul>
				</div>
			</div>

			<button type="button" class="btn btn-outline btn-info"
				onclick="location.href='${pageContext.request.contextPath }/board/register'">등록</button>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/views/includes/footer.jsp"%>