<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!
String name;

public void init(){
	name = "안효인";
}

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Hello ssafy!<br>
안녕 싸피!!!<br>
안녕 <% out.print(name); %>
안녕 <%= name %>!!!
</body>
</html>