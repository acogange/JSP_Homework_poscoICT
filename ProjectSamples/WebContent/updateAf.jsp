<%@page import="dto.BbsDto"%>
<%@page import="dao.BbsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%
int seq = Integer.parseInt(request.getParameter("seq"));
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
boolean isS = dao.updateAll( title, content, seq);
if(isS){
	%>
	<script type="text/javascript">
	alert("정상적으로 글이 수정되었습니다");
	location.href = "bbsdetail.jsp?seq=" +<%=seq%>;
	</script>
	<%
}else{	
	%>
	<script type="text/javascript">
	alert("수정이 안됐습니다");
	location.href = "bbslist.jsp";
	</script>
	<%
}

%>
</body>
</html>