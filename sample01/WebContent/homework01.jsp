<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!int num1=0; %>
<%int num2=0;
num2++;
num1++;
%>

<p>num1:<%=num1 %></p>
<p>num2:<%=num2 %></p>
</body>
</html>