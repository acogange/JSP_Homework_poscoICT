<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<style type="text/css">
.center{
   margin: auto;
   width: 60%;
   border:3px solid #0000ff;
   padding: 10px;
   
}

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="http://lab.alexcican.com/set_cookies/cookie.js" type="text/javascript" ></script>
</head>
<body>
<h2>login page</h2>
<div class = "center">
<form action="loginAf.jsp" method = "post">
<table border="1">
<tr>
   <th>아이디</th>
   <td>
      <input type="text" id="id" name="id" size="20"><br>
      
      <input type="checkbox" id="chk_save_id">아이디 저장
   </td>
</tr>
<tr>
   <th>패스워드</th>
   <td>
      <input type="password" name="pwd" size="20"><br>
      
   </td>
</tr>
<tr>
   <td colspan="2">
      <input type="submit" value="로그인" onclick="btnfunc()">
      <a href="regi.jsp">회원가입</a>
   </td>
</tr>
</table>
</form>
</div>
<script type="text/javascript">
let user_id=$.cookie("user_id");//쿠키에 저장한 아이디 꺼내오기
let pwd=request.getParameter("pwd");
if(user_id!=null)
	{
	$("#id").val(user_id);
	$("#chk_save_id").prop("checked",true);
	

	}
$("#chk_save_id").click(function(){
	if($("#chk_save_id").is(":checked")){//체크되었을때
		if($("#id").val().trim()==""){
			alert("아이디를 입력해주십시오");
			$("#chk_save_id").prop("checked",false);
		}else{
			//cookie에 저장
			$.cookie("user_id",$("#id").val().trim(),{expires:2,path:"/"})//기본경로에 2일동안 저장
		}
	}
	else{//쿠키 삭제
		$.removeCookie("user_id",{path:"/"});
		
	}
	

});


</script>
</body>
</html>