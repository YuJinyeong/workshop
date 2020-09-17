<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.Calendar" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

Hello World. here is jsp
<%=request.getAttribute("msg")%>

<%--
	<%
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
	%>
		Hello World. Here is jsp
		<br>
		<%
			if(hour < 12) {
		%>
		good morning
		<%
			}else{
		%>
		good afternoon
		<% 
			}
		%>
--%>


</body>
</html>