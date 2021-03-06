<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HyoJeong.account</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
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

#account span {
	cursor: pointer;
	display: inline-block;
	position: relative;
	transition: 0.5s;
}

#account span:after {
	content: '\00bb';
	position: absolute;
	opacity: 0;
	top: 0;
	right: -20px;
	transition: 0.5s;
}

#account:hover span {
	padding-right: 25px;
}

#account:hover span:after {
	opacity: 1;
	right: 0;
}
</style>
</head>
<body>
	<video id="video" preload="auto" autoplay="true" loop="loop"
		muted="muted" volume="0">
		<source src="./sea.mp4">

	</video>
	<div class="container">

		<h2>
			<b>HyoJeong 's Account page . . .</b>
		</h2>
		<p>
			Welcome to hyojeong's page ! ! ! This is account page . . .<br>If
			you want to make account, fill in the blank . . .
		</p>

		<form action="../cont" method="post">
			<input type="hidden" name="param" value="makeaccountAf">
			<div class="row">
				<div class="col">
					<b>ID</b> <input type="text" class="form-control" id="id"
						placeholder="Enter ID" name="id">
				</div>
			</div>

			<div class="row">
				<div class="col">
					<p style="line-height: 12px;"></p>
					<b>PW </b> <input type="text" class="form-control"
						id="password" placeholder="Enter Password" name="password">
				</div>
			</div>


			<div class="row">
				<div class="col">
					<p style="line-height: 12px;"></p>
					<b>Name</b> <input type="text" class="form-control"
						id="name" placeholder="Enter Name" name="name">
				</div>
			</div>

			<div class="row">
				<div class="col">
					<p style="line-height: 12px;"></p>
					<b>Birth</b> <br> <input type="text" id="datepicker" name="birth"
						class="form-control" placeholder="yyyy-mm-dd">
					<!-- class="form-control" placeholder="choice birth" name="birth"> -->
				</div>
			</div>

			<div class="row">
				<div class="col">
					<p style="line-height: 12px;"></p>
					<b>Address</b><br>
					<input type="text" class="form-control" id="address" placeholder="Enter Address" name="address">
				</div>
			</div>

			<div class="row">
				<div class="col">
					<br> <b>Height</b> <input type="text" class="form-control"
						id="height" placeholder="Enter height" name="height">
				</div>
			</div>

			<div class="row">
				<div class="col">
					<br>

					<!--    <button class="form-control" id="account" onclick="okAccount()"><span>make account </span></button>
        -->
					<input type="submit" class="form-control" value="make account">
				</div>
			</div>
		</form>
		<br>


		<form>
			<div class="form-row"></div>
		</form>
	</div>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
window.onload = function(){
    document.getElementById("address").addEventListener("click", function(){ 
        new daum.Postcode({
            oncomplete: function(data) {
                document.getElementById("address").value = data.address;
            }
        }).open();
    });
}
</script>
	
	
</body>
</html>