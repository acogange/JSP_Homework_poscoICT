<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>regi</title>

<style type="text/css">
.center{
   margin:auto;
   width: 60%;
   border: 3px solid #0000ff;
   padding: 10px;
}

</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

</head>
<body>

<h2>회원가입</h2>

<div class="center">

<form action="regiAf.jsp" method="post">
<table border="1">
<tr>
   <th>아이디</th>
   <td>
      <input type="text" id="id" name="id" size="20"><br>
      <p id="idcheck" style="font-size:8px"></p>
      <input type="button" id="btn" value="아이디확인">
   </td>
</tr>
<tr>
   <th>패스워드</th>
   <td>
      <input type="text" name="pwd" size="20">
   </td>
</tr>
<tr>
   <th>이름</th>
   <td>
      <input type="text" name="name" size="20">
   </td>
</tr>
<tr>
   <th>이메일</th>
   <td>
      <input type="text" name="email" size="20">
   </td>
</tr>
<tr>
   <td colspan="2">
      <input type="submit" value="회원가입">
   </td>
</tr>


</table>
</form>

</div>

<script type="text/javascript">
$(document).ready(function(){
	$(btn).click(function(){
		if($("#id").val().trim()==true){
			alert('id를 입력하시오');
		}
		else{
		$.ajax({
			url:"checkid.jsp",
			type:"post",
			data:{"id":$("#id").val()},
			success:function(data){
				alert('yes');
				let json=JSON.parse(str.trim());
			
				if (data.trim()=="ok"){
					$("#idcheck").css("color","blue");
					$("#idcheck").text("사용가능한 아이디입니다");
				}else{
					$("#idcheck").css("color","red");
					$("#idcheck").text("사용중인 아이디입니다");
					$("#id").val("");
				}
			},
			error:function(){
				
				alert('error');
			}
		})
		}
	});
});


</script>
</body>
</html>