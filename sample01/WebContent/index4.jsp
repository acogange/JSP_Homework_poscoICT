<%@page import="sample01.Human"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    //Human human =(Human)request.getAttribute("human");
    Human human =(Human)session.getAttribute("human");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
name:<%=human.getName() %>
<br>
age:<%=human.getAge() %>
<br>
<%
for (String s:human.getHobby()){
	%>
	hobby:<%=s %>
	<%
}

%>
</body>
</html>