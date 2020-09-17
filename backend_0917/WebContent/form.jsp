<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login.do" method="post">
		ID : <input type="text" name="id"><br>
		PW : <input type="password" name="pw">
		<input type="hidden" name="my" value="Hong">
		<input type="submit" value="제출">
	</form>
</body>
</html>