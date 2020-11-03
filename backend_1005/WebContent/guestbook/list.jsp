<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.ssafy.model.*"%>
<%
	String root = request.getContextPath();

MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
if(memberDto == null)
	response.sendRedirect(root + "/main.do");
else {
	List<ProductDto> list = (List<ProductDto>)request.getAttribute("articles");
%>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<title>SSAFY-글목록</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
		<script type="text/javascript">
		function movewrite() {
			location.href="<%=root%>/main.do?act=mvwrite";
		}
		function searchArticle() {
			if(document.getElementById("word").value == "") {
				alert("모든 목록 조회!!");
			}
			document.getElementById("searchform").action = "<%=root%>/main.do";
			document.getElementById("searchform").submit();
		}
		</script>
	</head>
	<body>	
	<div class="container" align="center">
		<div class="col-lg-8" align="right">
		<strong><%=memberDto.getUsername()%></strong>님 환영합니다.
		<a href="<%=root%>/main.do?act=logout">로그아웃</a>
		</div>
	  <div class="col-lg-8" align="center">
	  <h2>글목록</h2>
	  <p>좋은글 많이 올려 주세요!!!!!</p>  
	  <table class="table table-borderless">
	  	<tr>
	  		<td align="right"><button type="button" class="btn btn-link" onclick="javascript:movewrite();">글쓰기</button></td>
	  	</tr>
	  </table>
	  <form id="searchform" method="get" class="form-inline" action="">
	  <input type="hidden" name="act" id="act" value="list">
	  <table class="table table-borderless">
	  	<tr>
	  		<td align="right">
		  	  <select class="form-control" name="key" id="key">
			    <option value="userid" selected="selected">아이디</option>
			    <option value="articleno">글번호</option>
			    <option value="subject">제목</option>
			  </select>
			  <input type="text" class="form-control" placeholder="검색어 입력." name="word" id="word">
			  <button type="button" class="btn btn-primary" onclick="javascript:searchArticle();">검색</button>
			</td>
	  	</tr>
	  </table>
	  </form>
	  <%
	  	if(list.size() != 0) {
	  	  	for(ProductDto guestBookDto : list) {
	  %>
	  <table class="table table-active">
	    <tbody>
	      <tr class="table-info">
	        <td>작성자 : <%= guestBookDto.getUserid() %></td>
	        <td align="right">작성일 : <%= guestBookDto.getRegtime() %></td>
	      </tr>
	      <tr>
	        <td colspan="2" class="table-danger"><strong><%= guestBookDto.getArticleno() %>. <%= guestBookDto.getSubject() %></strong></td>
	      </tr>
	      <tr>
	        <td colspan="2"><%= guestBookDto.getContent() %></td>
	      </tr>
	      <%
	      if(guestBookDto.getUserid().equals(memberDto.getUserid())) {
	      %>
	      <tr>
	        <td colspan="2">
			<a href="<%= root %>/main.do?act=mvmodify&articleno=<%= guestBookDto.getArticleno()%>">수정</a>
			<a href="<%= root %>/main.do?act=delete&articleno=<%= guestBookDto.getArticleno()%>">삭제</a>
			</td>
	      </tr>
	      <%
	      }
	      %>
	    </tbody>
	  </table>
	  <%
	  	}
	  } else {
	  %>
	  <table class="table table-active">
	    <tbody>
	      <tr class="table-info" align="center">
	        <td>작성된 글이 없습니다.</td>
	      </tr>
	    </tbody>
	  </table>
	  <%
	  }
	  %>
	  </div>
	</div>
	</body>
</html>
<%
}
%>