<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:url var="root" value="/"></c:url>
	
	${root }
	<form method="post" action="<%=request.getContextPath()%>/main">
		<input type="hidden" name="action" value="login">
		<input type="text" name="id">
		<input type="password" name="pass">
		<input type="submit">
	</form>

	<h1>쿠키 생성 호출</h1>
	<a href="${root }main?action=makeCookie">쿠키 생성</a><br>
	<a href="${root }main?action=checkCookie">쿠키 확인</a>
	
</body>
</html>
