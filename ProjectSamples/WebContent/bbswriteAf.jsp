<%@page import="dto.BbsDto"%>
<%@page import="dao.BbsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>

<%
String id = request.getParameter("id");
String title = request.getParameter("title");
String content = request.getParameter("content");
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
BbsDao dao = BbsDao.getInstance();

boolean isS = dao.writeBbs(new BbsDto(id, title, content));
if(isS){
	%>
	<script type="text/javascript">
	alert("정상적으로 글이 추가되었습니다");
	location.href = "bbslist.jsp";
	</script>
	<%
}else{	
	%>
	<script type="text/javascript">
	alert("다시 작성해 주십시오");
	location.href = "bbswrite.jsp";
	</script>
	<%
}
%>


</body>
</html>









<%-- <%@page import="dao.BbsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String id=request.getParameter("id");
    String title=request.getParameter("title");
    String content=request.getParameter("content");
    
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
BbsDao dao=BbsDao.getInstance();
boolean isS=dao.writeBbs(new BbsDto(id, title, content));
if(isS){	
	%>
	<script type="text/javascript">
	
	</script>
	<%
	
}else
 {%> 

	<script type="text/javascript">
	
	</script>


%<
}
%>
</body>
</html> --%>