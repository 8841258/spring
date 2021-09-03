<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>


<div class="row">
	<div class="col-lg-6">
		<form role="form" method="POST"
			action="${pageContext.request.contextPath }/board/register">
			<div class="form-group">
				<label>제목</label> <input class="form-control" id="title" name="title" required>
			</div>
			<div class="form-group">
				<label>작성자</label> <input class="form-control" id="writer" name="writer" required>
			</div>
			<div class="form-group">
				<label>내용</label>
				<textarea class="form-control" id="content" name="content" rows="10" required></textarea>
			</div>
			<button class="btn btn-outline btn-info">등록</button>
			<button class="btn btn-default" type="button" onclick="">취소</button>
		</form>
	</div>
</div>



<%@ include file="/WEB-INF/views/includes/footer.jsp"%>