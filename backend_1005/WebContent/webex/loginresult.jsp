<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=session.getAttribute("loginUser") %> 님 반갑습니다.
	<a href="<%=request.getContextPath() %>/main?action=logout">로그아웃</a>
</body>
</html>
