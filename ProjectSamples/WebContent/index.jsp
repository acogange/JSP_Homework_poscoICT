 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
response.sendRedirect("login.jsp");//무조건 이동할때 쓰면 됨 아니면 javascript 의 location.href
%>
</body>
</html>