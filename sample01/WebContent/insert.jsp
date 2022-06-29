<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="insertAf.jsp" method="get">
ID  <input type="text" name="id"><br>
PW <input type="text" name="pw">
<br>
<br>취미<br>
<input type="checkbox" name="hobby" value="sleep">잠자기
<input type="checkbox" name="hobby" value="sing">노래
<input type="checkbox" name="hobby" value="game">게임
<br><br>연령대<br>
<input type="radio" id="age" name="age" value="10대">10대
<input type="radio" id="age"  name="age" value="20대"checked="checked">20대
<input type="radio" id="age"  name="age" value="30대">30대
<input type="radio" id="age"  name="age" value="40대">40대
<input type="radio" id="age"  name="age" value="50대">50대
<input type="radio" id="age"  name="age" value="60대">60대이상

<br><br>
기타 하고싶은 말<br><input type="text" name="etc">

<br><br>
<input type="submit" value"전송">
<button type="button" onclick="nofunc()" value"취소">취소</button>
</form>
<script type="text/javascript">
function nofunc(){
	
	
}
</script>
</body>
</html>