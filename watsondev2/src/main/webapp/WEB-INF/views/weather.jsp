<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<!-- meta 정보의http-equiv="Content-Type" content="text/html가 지정되지 않을경우 문자열의 ?가 쿼리스트링에서 특수문자로 변경됨-->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<c:url value=""/>" />
<title>Insert title here</title>
<link rel="shortcut icon" href="/favicon.ico" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('button').click(function() {
			let param = $('form').serialize();
			param = decodeURIComponent(param);
			alert(param)
			$.ajax({
				url : "http://localhost:8088/watson/classifier",
				type : "POST",
				data : param,
				contentType : "application/json; charset=UTF-8",
				success : function(data) {
					if(data != null) {
						alert(data);
						$('#out').text(data);	
					} else{
						alert('data is null');
					}
				},
				error : function(request, status, error) {
					console.log("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
				}
			})
		})
	})
</script>

</head>
<body>
	<form name="classify_form">
		<textarea name="content" rows="30" cols="30"></textarea>
		<button type="button">확인</button>
	</form>

	<div id="out"></div>
</body>
</html>