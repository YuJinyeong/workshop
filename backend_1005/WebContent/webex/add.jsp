<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=session.getAttribute("loginUser")%>
	님 반갑습니다.
	<a href="<%=request.getContextPath()%>/main?action=logout">로그아웃</a>
	<!-- web page에서 /의 의미: container root : localhost:8080, 호출 되려면 project 즉 context root가 필요 -->
	<form method="get" action="/backend_k02/main">
		<input type="hidden" name="action" value="add">
		<input type="text" name="num1">
		<input type="number" name="num2">
		<input type="submit">
	</form>
</body>
</html>
