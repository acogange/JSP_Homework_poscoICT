<%@page import="dao.BbsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    int seq = Integer.parseInt(request.getParameter("seq"));
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
boolean isS = dao.deleteAll( seq);
if(isS){
	//del이 1이면 title은 안띄워줌, title을 바꾸고 연결 끊어버리기
	%>
	<script type="text/javascript">
	alert("정상적으로 글이 삭제되었습니다");
	location.href = "bbslist.jsp";
	</script>
	<%
}else{	
	%>
	<script type="text/javascript">
	alert("삭제가 안됐습니다");
	location.href = "bbslist.jsp";
	</script>
	<%
}



%>
</body>
</html>