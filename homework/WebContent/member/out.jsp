<%@page import="dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<script src="http://lab.alexcican.com/set_cookies/cookie.js"
	type="text/javascript"></script>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<%
Object object=session.getAttribute("login");
MemberDto dto=(MemberDto) object;
%>
<style type="text/css">
.container {
	width: 90%;
	height: 100vh;
	padding: 100px;
		background-color: rgba(255, 255, 255, 0.7);
	font-family: Times New Roman;
	color: black;
}

#video {
	backgroundcolor: black;
	opacity: 0.5;
	position: absolute;
	top: 0px;
	left: 0px;
	min-width: 100%;
	min-height: 100%;
	width: auto;
	height: auto;
	z-index: -1;
	overflow: hidden;
}

#login span {
	cursor: pointer;
	display: inline-block;
	position: relative;
	transition: 0.5s;
}

#login span:after {
	content: '\00bb';
	position: absolute;
	opacity: 0;
	top: 0;
	right: -20px;
	transition: 0.5s;
}

#login:hover span {
	padding-right: 25px;
}

#login:hover span:after {
	opacity: 1;
	right: 0;
}
</style>
</head>
<body>
<video id="video" preload="auto" autoplay="true" loop="loop" muted="muted" volume="0">
      <source src="./sea.mp4">

</video>
	<div id="full">
		<div class="container">

			<h2>
				<b>HyoJeong 's Delete account page . . .</b>
			</h2>
			<p style="line-height: 12px;"></p>
			<h3>This is your infomation</h3>
			<h5>ID: <%=dto.getId() %></h5>
			<h5>Name: <%=dto.getName() %></h5>
			<h5>Birth: <%=dto.getBirth() %></h5>
			<h5>Address: <%=dto.getDaum() %></h5>
			<h5>Height: <%=dto.getHeight() %></h5>
			<br>
			
			<p>
				To delete Account Fill in the blank with your ID and PWD
			</p>
			

			<form action="../cont" method="post">
				<input type="hidden" name="param" value="outAf">
				<input type="hidden" name="id"  value=<%=dto.getId() %>>
				
				<div class="row">
					<div class="col">
						<br> <b>PW </b> <input type="text" class="form-control"
							id="password" name="password" placeholder="If you want to delete your account, Enter Password" > <br>
					</div>
				</div>
					<div class="row">

						<div class="col">
							<input class="form-control" type="submit" value="delete account">
							<!--  <button class="form-control" id="login" onclick="okLogin()"><span>Login </span></button> -->
						</div>
					</div>

				</form>
				<br>

				<p>
					If you don't want delete account <a href="../cont?param=login">
						click this link . . .</a>
				</p>
				<form>
					<div class="form-row"></div>
				</form>
		</div>
	</div>

</body>
</html>