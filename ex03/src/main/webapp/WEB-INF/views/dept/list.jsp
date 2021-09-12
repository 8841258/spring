<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>department</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="../resources/js/json.min.js"></script>
<style>
tr:hover {
	background-color: #efefef;
}
</style>
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
		<button type="button" class="btn btn-primary" data-toggle="modal"
			data-target="#exampleModal">부서등록</button>
	</div>


	<!-- 등록 모달 -->
	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">부서 등록</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form id="insertFrm" name="insertFrm" method="GET" action="insert">
						<br> 부서번호 : <input type="text" id="departmentId"
							name="departmentId"><br> 부서이름 : <input type="text"
							id="departmentName" name="departmentName"><br> 매니저번호
						: <input type="text" id="managerId" name="managerId"><br>
						위치번호 : <input type="text" id="locationId" name="locationId">
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">닫기</button>
					<button type="button" class="btn btn-primary" id="insertBtn">등록</button>
				</div>
			</div>
		</div>
	</div>

	<!-- 수정 모달 -->
	<div class="modal fade" id="updateModal" tabindex="-1"
		aria-labelledby="updateModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="updateModalLabel">부서 수정</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form id="updateFrm" name="updateFrm">
						<br> 부서번호 : <input type="text" id="upDepartmentId"
							name="upDepartmentId" disabled><br> 부서이름 : <input type="text"
							id="upDepartmentName" name="upDepartmentName"><br> 매니저번호
						: <input type="text" id="upManagerId" name="upManagerId"><br>
						위치번호 : <input type="text" id="upLocationId" name="upLocationId">
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">닫기</button>
					<button type="button" class="btn btn-primary" id="updateBtn">수정</button>
				</div>
			</div>
		</div>
	</div>

</body>

<script>
	$(function() {
		//페이지 로딩 시 ajax로 리스트 뽑기
		deptList();

		//등록 버튼 클릭시 등록 모달
		$("#insertBtn").on('click', function() {
			deptInsert();
		})

		//삭제 버튼 클릭시
		$(document).on('click', '#deleteBtn', function() {
			const btnId = $(this).data("id");

			deptDelete(btnId);
		})

		//tr 클릭시 수정 모달 띄우기
		$(document).on('click', 'tr', function() {
			const deptId = $(this).data("num");

			deptUpdate(deptId);

			
		})

	})

	//리스트 조회
	function deptList() {
		$.ajax({
			url : "deptList",
			dataType : "json",
			success : function(datas) {
				$.each(datas, function(i, data) {
					listFnc(data);
				})

			}

		}) //ajax 끝

	}

	//등록
	function deptInsert() {
		$.ajax({
			url : "insert",
			type : "POST",
			data : JSON.stringify($("#insertFrm").serializeObject()),
			contentType : "application/json",
			success : function(data) {
				deptList();
				$('#exampleModal').modal('hide');
			}
		}) //ajax 끝

	}

	//삭제
	function deptDelete(btnId) {
		if (confirm('삭제하시겠습니까?')) {
			$.ajax({
				url : "delete/" + btnId,
				type : "DELETE",
				contentType : "application/json",
				success : function(result) {
					if (result == 1) {
						alert('삭제되었습니다.');
						// $('#deleteBtn').data("id", btnId).parent().parent().remove();
						deptList();
					} else {
						alert('삭제 실패');
					}
				}
			})
		}
	}

	//수정
	function deptUpdate(deptId) {
		//모달창에 데이터 띄우기
		$.ajax({
			url: "read/" + deptId,
			success: function(data) {
				const updateModal = $('#updateModal');
				$(updateModal).modal('show');
				$('#upDepartmentId').val(data.departmentId);
				$('#upDepartmentName').val(data.departmentName);
				$('#upManagerId').val(data.managerId);
				$('#upLocationId').val(data.locationId);

				//모달창의 수정 버튼 클릭시
				$('#updateBtn').on('click', function() {
					
					const updateDid = $('#upDepartmentId').val();
					const updateName = $('#upDepartmentName').val();
					const updateMid = $('#upManagerId').val();
					const updateLid = $('#upLocationId').val();
					
					$.ajax({
						url: "update",
						type: "PUT",
						data: JSON.stringify({
							departmentId : updateDid,
							departmentName : updateName,
							managerId : updateMid,
							locationId : updateLid
						}),
						contentType: "application/json",
						success: function(data) {
							$('#updateModal').modal('hide');
							
							
							
							deptList();
							
						}
					})
					
				})
			}
		})


		

	}

	function listFnc(data) {

		$("<tr />")
				.data('num', data.departmentId)
				.append($("<td>").text(data.departmentId))
				.append($("<td>").text(data.departmentName))
				.append($("<td>").text(data.managerId))
				.append($("<td>").text(data.locationId))
				.append(
						$("<td>")
								.html(
										$(
												"<button class='btn btn-primary' id='deleteBtn' data-id=" + data.departmentId +
						">")
												.text("삭제"))).appendTo(
						$("#deptList"));

	}
</script>

</html>