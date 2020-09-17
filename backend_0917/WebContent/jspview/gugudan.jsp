<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>구구단(JSP)</title>
	<style type="text/css">
		table {width:800px; height:800px;}
		.color1 {background-color : skyblue;}
		.color2 {background-color : pink;}
	</style>
</head>
<body>
	<div align="center">
	<h3>구구단(JSP)</h3>
	<table>
<%
	for(int dan=2;dan<10;dan++) {
%>
	<tr align="center">
<%
		String classname = dan % 2 == 0 ? "color1" : "color2";
		for(int i=1;i<10;i++) {
%>
	<td class="<%=classname%>"><%=dan%> * <%=i%> = <%=dan*i%></td>
<%
		}
%>
	</tr>
<%
	}
%>
	</table>
	</div>
</body>
</html>