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
String proc = request.getParameter("proc");

if(proc.equals("regi")){
	String msg = request.getParameter("msg");
	
	if(msg.equals("OK")){
	%>
	<script type="text/javascript">
		alert("성공적으로 가입되었습니다");
		location.href = "member?param=login";
	</script>
	<%
	}else{
		%>
	<script type="text/javascript">
		alert("다시 기입해 주십시오");
		location.href = "member?param=regi";
	</script>
	<%
	}
}else if(proc.equals("login")){
	String msg = request.getParameter("msg");
	
	if(msg.equals("OK")){
	%>
	<script type="text/javascript">
		alert("환영합니다");
		location.href = "bbs?param=bbslist";
	</script>
	<%
	}else{
		%>
	<script type="text/javascript">
		alert("아이디나 비밀번호가 틀렸습니다. 다시 기입해 주십시오");
		location.href = "member?param=login";
	</script>
	<%
	}
}else if(proc.equals("bbswrite")){
	String msg = request.getParameter("msg");
	if(msg.equals("OK")){
	%>
	<script type="text/javascript">
		alert("글쓰기 완료");
		location.href = "bbs?param=bbslist";
	</script>
	<%
	}else{
	%>
	<script type="text/javascript">
		alert("글 쓰기에 오류발생했습니다. 다시 쓰세요");
		location.href = "bbs?param=bbswrite";
	</script>
	<% 
	}
}

else if(proc.equals("update")){
	String msg=request.getParameter("msg");	
	if (msg.equals("OK")){%>
	<script type="text/javascript">
		alert("수정쓰기 완료");
		location.href = "bbs?param=bbslist";
	</script>
	<%
	}else{
		%>
	<script type="text/javascript">
		alert("글 수정에 오류발생했습니다. ");
		location.href = "bbs?param=bbslist";
	</script>
	<%
	}
}
else if(proc.equals("delete"))
{
	String msg=request.getParameter("msg");	
	if (msg.equals("OK")){%>
	<script type="text/javascript">
		alert("삭제 완료");
		location.href = "bbs?param=bbslist";
	</script>
	<%
	}else{
		%>
	<script type="text/javascript">
		alert("글 삭제에 오류발생했습니다. ");
		location.href = "bbs?param=bbslist";
	</script>
	<%
	}
}
else if(proc.equals("answer")){
	String seq=request.getParameter("seq");
	String msg=request.getParameter("msg");	
	
	if (msg.equals("OK")){%>
	<script type="text/javascript">
		alert("답글 완료");
		location.href = "bbs?param=bbslist";
	</script>
	<%
	}else{
		%>
	<script type="text/javascript">
		alert("답글 작성에 오류가 발생했습니다");
		location.href = "bbs?param=bbslist";
	</script>
	<%
	}
}
%>




</body>
</html>





