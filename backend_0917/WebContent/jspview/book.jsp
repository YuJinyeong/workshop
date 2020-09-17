<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ssafy.move.BookDto"%>
<!DOCTYPE html>
<html>
<head>
<%
BookDto bookDto = (BookDto) request.getAttribute("bookinfo");
if(bookDto == null) {
%>
<script>
alert("Book 정보가 없습니다.");
</script>
<%	
} else {
%>

<meta charset="UTF-8">
<title>책정보</title>
</head>
<body>
<div>
<h3>[<%= bookDto.getBookName() %>] 정보</h3>
ISBN : <%= bookDto.getIsbn() %><br>
출판사 : <%= bookDto.getPublisher() %><br>
가격 : <%= bookDto.getPrice() %>원<br>
</div>
<%
}
%>
</body>
</html>