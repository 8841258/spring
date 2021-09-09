<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<input type="text" id="pass" name="pass">
<button type="button" id="btnCheck">확인</button>


<script src="${pageContext.request.contextPath }/resources/vendor/jquery/jquery.min.js"></script>
<script>
    let passRule = /^[A-Za-z0-9]{6,12}$/;
    $('#btnCheck').on('click', function() {
        if (!passRule.test($("#pass").val())) {
            alert("error");
            return false;
        } else {
        	alert("good");
        	return true;
        }
    })
</script>
</body>
</html>