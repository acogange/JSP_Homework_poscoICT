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

if (proc.equals("login")){
	String msg=request.getParameter("msg");
	
	if(msg.equals("OK")){
		%>
		<script type="text/javascript">
		alert("성공적으로 로그인되었습니다");
		
		location.href="./cont?param=out";
		</script>
		<%
		}else{
		%>
		<script type="text/javascript">
		alert("아이디 비밀번호를 확인해주세요")
		location.href="./cont?param=login";</script>
		<%
		}
	}
else if (proc.equals("makeaccount")){
	String msg=request.getParameter("msg");
	
	if (msg.equals("OK")){
		%>
		<script type="text/javascript">
		alert("성공적으로 가입되었습니다");
		location.href="./cont?param=login";
		</script>
		<%
		}else{
		%>
		<script type="text/javascript">
		alert("다시 가입해주세요");
		location.href="./cont?param=makeaccount";</script>
		<%
	}
}
else if(proc.equals("out")){
	String msg=request.getParameter("msg");
	if (msg.equals("OK")){
		%>
		<script type="text/javascript">
		alert("탈퇴되었습니다");
		location.href="./cont?param=login";
		</script>
		<%
		}else{
		%>
		<script type="text/javascript">
		alert("탈퇴에 실패했습니다");
		location.href="./cont?param=out";</script>
		<%
	}
}
	%>
	
</body>
</html>