<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.ssafy.model.MemberDto"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
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
  <title>SSAFY-글작성</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
  <script type="text/javascript">
  function writeArticle() {
	if(document.getElementById("subject").value == "") {
		alert("제목 입력!!!!");
		return;
	} else if(document.getElementById("content").value == "") {
		alert("내용 입력!!!!");
		return;
	} else {
	  	document.getElementById("writeform").action = "${root}/main.do";
	  	document.getElementById("writeform").submit();
	}
  }
  </script>
</head>
<body>

<div class="container" align="center">
	<div class="col-lg-8" align="right">
	<strong><%= memberDto.getUsername() %></strong>님 환영합니다.
	<a href="${root}/main.do?act=logout">로그아웃</a>
	</div>
	<div class="col-lg-6" align="center">
		<h2>방명록 글쓰기</h2>
		<form id="writeform" method="post" action="">
		<input type="hidden" name="act" id="act" value="write">
			<div class="form-group" align="left">
				<label for="subject">제목:</label>
				<input type="text" class="form-control" id="subject" name="subject">
			</div>
			<div class="form-group" align="left">
				<label for="content">내용:</label>
				<textarea class="form-control" rows="15" id="content" name="content"></textarea>
			</div>
			<button type="button" class="btn btn-primary" onclick="javascript:writeArticle();">글작성</button>
			<button type="reset" class="btn btn-warning">초기화</button>
		</form>
	</div>
</div>

</body>
</html>
<%
}
%>