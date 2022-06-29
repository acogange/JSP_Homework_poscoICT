<%@page import="dto.MemberDto"%>
<%@page import="dao.MemberDao"%>

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
String id=request.getParameter("id");
String pwd=request.getParameter("pwd");


MemberDao dao=MemberDao.getInstance();

MemberDto dto=dao.login(new MemberDto(id,pwd,null,null,0));

if(dto!=null&& !dto.getId().equals("")){
	session.setAttribute("login", dto);
	//session.setMaxInactiveInterval(60*60*2);//2시간 후 세션 만료


%>
<script type="text/javascript">
	alert("안녕하세요 <%=dto.getId()%>님");
	location.href="bbslist.jsp";
</script>
<%
	}
	else{

%>
<script type="text/javascript">
	alert("id나 password를 확인하세요");
	location.href="login.jsp";
	</script>
<%
}

%>
</body>
</html>