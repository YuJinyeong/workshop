<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ssafy.model.MemberDto"%>
<%
String root = request.getContextPath();

MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
if(memberDto == null)
	response.sendRedirect(root + "/main.do");
else {
%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>SSAFY-글작성성공</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" align="center">
	<div class="col-lg-8" align="right">
	<strong><%= memberDto.getUsername() %></strong>님 환영합니다.
	<a href="<%= root %>/main.do?act=logout">로그아웃</a>
	</div>
	<div class="col-lg-6">
	  <div class="jumbotron">
	    <h1>글작성 성공!!!</h1>      
	  </div>  
	  <p><a href="<%= root %>/main.do?act=list&key=&word=">글목록</a></p>
	</div>
</div>
</body>
</html>
<%
}
%>