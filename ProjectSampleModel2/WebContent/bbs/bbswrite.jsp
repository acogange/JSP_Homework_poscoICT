<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
Object obj = session.getAttribute("login");
if(obj == null){
	%>
	<script>
	alert("로그인해 주십시오");
	location.href = "login.jsp";
	</script>	
	<%
}
MemberDto mem = (MemberDto)obj;
%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bbswrite.jsp</title>
</head>
<body>

<h2>글쓰기</h2>

<div align="center">


<form action="../bbs" method="post">
<input type="hidden" name="id" value="<%=mem.getId() %>">
<input type="hidden" name="param" value="bbswriteAf">

<table border="1">
<col width="200"><col width="400">
<tr>
	<th>아이디</th>
	<td><%=mem.getId() %></td>
</tr>
<tr>
	<th>제목</th>
	<td>
		<input type="text" name="title" size="60">
	</td>
</tr>
<tr>
	<th>내용</th>
	<td>
		<textarea rows="20" cols="50" name="content"></textarea>
	</td>
</tr>
<tr>
	<td colspan="2" align="center">
		<input type="submit" value="작성완료">
	</td>
</tr>
</table>

</form>
</div>

</body>
</html>




<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="dto.MemberDto"%>
<%@page import="dao.MemberDao"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	MemberDto mem = new MemberDto();
	%>
	<h2>글쓰기 page</h2>
	<div align="center"></div>
	<form action="writeBbsAf.jsp" method="post">

		<input type="hidden" name="id value="<%=mem.getId()%>">

		<table border="1">
			<tr>
				<th>작성자</th>
				<td><%=mem.getId()%></span></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" id="title" name="title" size="40"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea rows="40" cols="50" name="content"></td>
			</tr>

			<tr>

				<td colspan="2"><input type="subbit" value="작성완료"></td>
			</tr>

		</table>
	</form>
	<script type="text/javascript">
		
	</script>
	</div>
</body>
</html> --%>