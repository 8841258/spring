<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="row">
	<div class="col-lg-6">

		<h3>게시글 상세보기</h3>

		<div class="form-group">
			<label>제목</label> <input class="form-control" id="title" name="title"
				value="${board.title }" disabled>
		</div>
		<div class="form-group">
			<fmt:formatDate var="regdate" value="${board.regdate }" type="DATE"
				pattern="yyyy-MM-dd" />
			<label>작성일자</label> <input class="form-control" id="title"
				name="title" value="${regdate}" disabled>
		</div>
		<div class="form-group">
			<fmt:formatDate var="updatedate" value="${board.updatedate }"
				type="DATE" pattern="yyyy-MM-dd" />
			<label>수정일자</label> <input class="form-control" id="title"
				name="title" value="${updatedate}" disabled>
		</div>
		<div class="form-group">
			<label>작성자</label> <input class="form-control" id="writer"
				name="writer" value="${board.writer }" disabled>
		</div>
		<div class="form-group">
			<label>내용</label>
			<textarea class="form-control" id="content" name="content" rows="10"
				disabled>${board.content }</textarea>
		</div>

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
			<button type="button" class="btn btn-outline btn-info"
				onclick="location.href='pageNum=${criteria.pageNum}&amount=${criteria.amount}'">목록으로</button>
		</form>

		<!-- 댓글 등록 -->
		<div class="panel-heading">
			<form id="replyForm">
				<input type="hidden" name="bno" value="${board.bno }"> <input
					name="replyer"> <input name="reply">

				<button type="button" id="saveReply">댓글 등록</button>
			</form>
		</div>


		<!-- 댓글 목록 -->
		<h3>댓글 목록</h3>

		<div class="panel panel-default">

			<div class="panel-heading">
				<i class="fa fa-comments fa-fw"></i> 댓글
			</div>

			<div class="panel-body">
				<ul class="chat">

				</ul>
			</div>

		</div>
	</div>
</div>
<script src="../resources/js/reply.js"></script>
<script>
	let bno = "${board.bno}";
	
	$(function() {
		//등록 처리
		
		$('#saveReply').on('click', function() {
				replyService.add(saveCallback);
			});
		
		function saveCallback(data) {

			console.log(data);

			const liTag = $('<li />').addClass("left clearfix").attr(
					'data-rno', '12');
			const divTag_1 = $('<div />');
			const divTag_2 = $('<div />').addClass('header');
			const strong = $('<strong />').addClass('primary-font')
					.text(data.replyer);
			const small = $('<small />').addClass(
					'pull-right text-muted').text(data.replyDate);
			const pTag = $('<p />').text(data.reply);

			$('.chat').append(liTag, divTag_1);
			$(divTag_1).append(divTag_2, pTag);
			$(divTag_2).append(strong, small);

	}

		replyService.getList({bno:bno}, listCallback);
		
		function listCallback(datas) {

				console.log(datas);
				for (let data of datas) {

					const liTag = $('<li />').addClass("left clearfix").attr(
							'data-rno', '12');
					const divTag_1 = $('<div />');
					const divTag_2 = $('<div />').addClass('header');
					const strong = $('<strong />').addClass('primary-font')
							.text(data.replyer);
					const small = $('<small />').addClass(
							'pull-right text-muted').text(data.replyDate);
					const pTag = $('<p />').text(data.reply);

					$('.chat').append(liTag, divTag_1);
					$(divTag_1).append(divTag_2, pTag);
					$(divTag_2).append(strong, small);

			}
		}
	})
	
	
</script>
<%@ include file="/WEB-INF/views/includes/footer.jsp"%>