<%@page import="sample01.YouClass"%>
<%@page import="sample01.Human"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
    //response.sendRedirect("http://naver.com");//1. 외부로 이동 가능
    //response.sendRedirect("./index.jsp");//2. 가능
    //response.sendRedirect("./index2.jsp?name=김효정&age=16&hobby=그림그리기");//3. 값전달 가능

    String hobby[]={"음악감상","잠자기"};
    Human human=new Human("성춘향",16,hobby);
    
    //짐싸
    //request.setAttribute("human", human);
    session.setAttribute("human", human);//1. 세션
    request.getSession().setAttribute("human", human);//2. request
    //이동
    //pageContext.forward("index4.jsp");
    
    response.sendRedirect("index4.jsp");
    
    %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>