<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>ID: <%=request.getParameter("id") %></p>
<p>PW: <%=request.getParameter("pw") %></p>
<% String hobby[]=request.getParameterValues("hobby");%>

<p>취미:</p>
<%for (int i=0;i<hobby.length;i++) {%>
	<p>취미<%=hobby[i] %></p> 
<% } %>
<p>연령대: <%=request.getParameter("age") %></p>
<p>하고싶은 말: <%=request.getParameter("etc") %></p>

</body>
</html>