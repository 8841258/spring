<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<h1>Upload with Ajax</h1>
	<div>
		<form name="frm">
			<input type="file" name="uploadFile" multiple="multiple" />
			<input type="text" name="writer">
			<input type="text" name="content">
		</form>
	</div>
	<button type="button" id="uploadBtn">업로드</button>

	<script src="${pageContext.request.contextPath }/resources/vendor/jquery/jquery.min.js"></script>

	<script>
		$(function () {
			$("#uploadBtn").on('click', function () {
				let formData = new FormData(document.frm);

				let inputFile = $("input[name='uploadFile']");

				let files = inputFile[0].files;

				console.log(files);

				for (let i = 0; i < files.length; i++) {
					if (!checkExtension(files[i].name, files[i].size)) {
						return; //나감
					} 
						formData.append("uploadFile", files[i]);

				}

				$.ajax({
					processData: false,
					contentType: false,
					url: 'uploadAjaxAction',
					data: formData,
					type: 'POST',
					success: function (result) {
						console.log(typeof result);
						if (result == true) {
							alert("업로드되었습니다.");
						} else {
							alert("업로드 실패");
						}
					}
				})

				
				function checkExtension(fileName, fileSize) {
					var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
					var maxSize = 5242880; //5MB
					
					if (fileSize >= maxSize) {
						alert("파일 사이즈 초과");
						return false;
					}

					if (regex.test(fileName)) {
						alert("해당 종류의 파일은 업로드할 수 없습니다.");
						return false;
					}
					return true;
				}


			})
		})
	</script>
</body>

</html>