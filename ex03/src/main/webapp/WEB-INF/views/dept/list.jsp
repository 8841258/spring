<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>department</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
	<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
	<script src="../resources/js/json.min.js"></script>
</head>

<body>
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">부서번호</th>
					<th scope="col">부서이름</th>
					<th scope="col">매니저번호</th>
					<th scope="col">위치번호</th>
				</tr>
			</thead>
			<tbody id="deptList">

			</tbody>
		</table>
		<!-- Button trigger modal -->
		<!-- Button trigger modal -->
		<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">
			부서등록
		</button>
	</div>

	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">부서 등록</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form id="frm" name="frm" method="GET" action="insert">
						부서번호 : <input type="text" id="departmentId" name="departmentId">
						부서이름 : <input type="text" id="departmentName" name="departmentName">
						매니저번호 : <input type="text" id="managerId" name="managerId">
						위치번호 : <input type="text" id="locationId" name="locationId">
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
					<button type="button" class="btn btn-primary" id="insertBtn">등록</button>
				</div>
			</div>
		</div>
	</div>

</body>

<script>
	$(function () {
		//페이지 로딩 시 ajax로 리스트 뽑기
		deptList();

		//등록 버튼 클릭시 등록 모달
		$("#insertBtn").on('click', function () {
			deptInsert();
		})

		$(document).on('click', '#deleteBtn', function () {
			const btnId = $(this).data("id");

			deptDelete(btnId);
		})
	})


	//리스트 조회
	function deptList() {
		$.ajax({
			url: "deptList",
			dataType: "json",
			success: function (datas) {
				$.each(datas, function (i, data) {
					listFnc(data);
				})

			}

		}) //ajax 끝

	}

	//등록
	function deptInsert() {
		$.ajax({
			url: "insert",
			type: "POST",
			data: JSON.stringify($("#frm").serializeObject()),
			contentType: "application/json",
			success: function (data) {
				listFnc(data);
				$('#exampleModal').modal('hide');
			}
		}) //ajax 끝

	}

	//삭제
	function deptDelete(btnId) {
		if (confirm('삭제하시겠습니까?')) {
			$.ajax({
				url: "delete/" + btnId,
				type: "DELETE",
				contentType: "application/json",
				success: function (result) {
					if (result == 1) {
						alert('삭제되었습니다.');
						$('#deleteBtn').data("id", btnId).parent().parent().remove();
					} else {
						alert('삭제 실패');
					}
				}
			})
		}

	}

	function listFnc(data) {
		$("<tr />")
			.append(
				$("<td>")
				.text(
					data.departmentId))
			.append(
				$("<td>")
				.text(
					data.departmentName))
			.append(
				$("<td>")
				.text(
					data.managerId))
			.append(
				$("<td>")
				.text(
					data.locationId))
			.append(
				$("<td>")
				.html(
					$("<button class='btn btn-primary' id='deleteBtn' data-id=" + data.departmentId +
						">")
					.text("삭제")))
			.appendTo($("#deptList"));
	}
</script>

</html>