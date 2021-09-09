<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
		<div class="form-group">
			<label>첨부파일</label>
			<c:forEach items="${board.attachList }" var="attach">
				<a href="download?uuid=${attach.uuid }">${attach.fileName }</a>
			</c:forEach>
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
				<i class="fa fa-comments fa-fw"></i> 댓글 <span class="replyCnt">${board.replyCnt }</span>개
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

	$(function () {
		//등록 처리
		$('#saveReply').on('click', function () {
			$.ajax({
				url: "../replies/",
				type: 'POST',
				data: $('#replyForm').serialize(),
				dataType: "json",
				success: function (data) {

					makeList(data);
					

				}
			})
		})

		//조회 처리
		$.ajax({
			url: "../replies/",
			data: {
				bno: bno
			},
			dataType: "json", //json으로 파싱해!
			success: function (datas) {
				console.log(datas);
				for (let data of datas) {

					makeList(data);

				}
			}
		})

		//삭제 처리
		$(document).on('click', '.delBtn', function() {
			const rno = $(this).data('rno');
			if (confirm('정말 삭제하시겠습니까?')) {
				$.ajax({
					url: "../replies/" + rno,
					type: "DELETE",
					dataType: "text",
					success: function (data) {
						data ? alert('삭제되었습니다.') : alert('에러 발생');
						$(this).parent().parent().remove();

					}
			})

			}
		})
	})

	function makeList(data) {
		// const comment = $('<div />').addClass("comment");
		const liTag = $('<li />').addClass("left clearfix");
		const divTag_1 = $('<div />').addClass("comment");
		const divTag_2 = $('<div />').addClass('header');
		const strong = $('<strong />').addClass('primary-font')
			.text(data.replyer + " ");
		const span_del = $('<span />').addClass('delBtn').text('삭제').attr(
			'data-rno', data.rno);
		const small = $('<small />').addClass(
			'pull-right text-muted').text(displayTime(data.replyDate));
		const pTag = $('<p />').text(data.reply);

		$('.chat').append(liTag, divTag_1);
		$(divTag_1).append(divTag_2, pTag);
		$(divTag_2).append(strong, span_del, small);
	}
	
	function displayTime(timeValue) {
		const today = new Date();

		const gap = today.getTime() - timeValue;

		const dateObj = new Date(timeValue);

		let str = "";

		if (gap < (1000 * 60 * 60 * 24)) {

			let hh = dateObj.getHours();
			let mi = dateObj.getMinutes();
			let ss = dateObj.getSeconds();

			return [ (hh > 9 ? '' : '0') + hh, ':', (mi > 9 ? '' : '0') + mi, ':', (ss > 9 ? '' : '0') + ss].join('');
		} else {
			let yy = dateObj.getFullYear();
			let mm = dateObj.getMonth() + 1;
			let dd = dateObj.getDate();
			return [ yy, '/', (mm > 9 ? '' : '0') + mm, '/', (dd > 9 ? '' : '0') + dd].join('');
		}
	}
	

</script>
<%@ include file="/WEB-INF/views/includes/footer.jsp"%>