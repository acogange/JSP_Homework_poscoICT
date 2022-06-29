<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
	AJAX : Asynchronous JavaScript And XML(Json)
	
	AXIOS: view, react

	html
	<a href=
	<form submit
	
	JavaScript
	location.href=
	
	java
	forward
	sendRedirect
 --%>
 
 <p id="demo"></p>

<button type="button">button</button> 
 
 <script type="text/javascript">
 $(document).ready(function(){
	 $("button").click(function(){
		// $("#demo").load("default.html");//default.html에 있는 모든거 다 불러옴
		// $("#demo").load("default.html #ptag");//ptag라는 id만 불러옴
		// $("#demo").load("data.jsp","name=jhon&age=24");//파라미터로 넘기고 다시 값 가지고오기
		 
		 $("#demo").load("data.jsp",{name:"Tom",age:26} );//json으로 보내고 들고오기
		 $("#demo").load(
		"data.jsp",//불러올 파일
		{"name":"춘향이","age":16},//불러올 부분의 세팅값(없을수도 있음)
		function(data, status, xhr) {//작업의 결과
			//alert("success");
			//alert(data);//전부 다 나옴
			//alert(status);//상태 성공/에러
			alert(JSON.stringify(xhr));//json을 문자열로 바꿈
		}
		 )
	 });
	 
 });
 </script>
</body>
</html>