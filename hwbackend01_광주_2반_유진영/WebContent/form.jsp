<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>상품을 등록 해 주세요.</h2>
	<form action="register.do" method="post">
		상품명 : <input type="text" name="pName"><br> 
		상품 가격 : <input type="text" name="pPrice"> 
		상품 설명 : <input type="text" name="pCont">
		<button>저장</button> 
		<button>취소</button> 
	</form>
</body>
</html>