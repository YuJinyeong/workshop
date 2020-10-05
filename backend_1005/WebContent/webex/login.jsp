<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="<%=request.getContextPath()%>/main">
		<input type="hidden" name="action" value="login">
		<input type="text" name="id">
		<input type="password" name="pass">
		<input type="submit">
	</form>
</body>
</html>
