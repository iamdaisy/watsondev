<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
<script src="<c:url value="/resources/js/jquery-3.2.1.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<title>Insert title here</title>
<link rel="shortcut icon" href="/favicon.ico" />
</head>
<body>
${msg}<br/>
<c:forEach items="${voices}" var="voice">
${voice.description}<br/>
</c:forEach>
<hr/>
<table border="1">
<tr>
	<th>no</th>
	<th>statement</th>
	<th>lang</th>
</tr>

<c:forEach items="${list}" var="vo">
<tr>
	<td>${vo.no}</td>
	<td>${vo.statement}</td>
	<td>${vo.lang}</td>
</tr>
</c:forEach>

</table>
</body>
</html>