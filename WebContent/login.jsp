<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理员登录</title>
<style type="text/css">
body {
	margin: 0;
	background-color: rgb(225, 224, 199);
	
}

.text-box {
	border: solid 1px aqua;
	width: 80%;
	height: 100%;
	margin: 10px;
}

span{
	font-size:12px;
	color:red;
    text-align: center;
    float: right;
    margin-right: 60px;
}

.blk {
	margin: 50px;
	width: 90%;
	height: 30px;
}

.login-div {
	padding-top: 20px;
	margin: auto;
	margin-top: 200px;
	width: 400px;
	height:300px;
	background-color: #f7f7f7;
	border-radius: 20px;
	box-shadow: gray 2px 2px 2px 2px;
}

.button {
	margin: 10px;
	width: 80%;
	height: 30px;
	background-color: cyan;
	border: none;
	color: white;
	font-size: 15px;
}

label {
	font-size: 14px;
	color:
}
</style>
</head>

<body background="img/8.jpg">
	<!-- 整体框架 -->
	<div id="main-div">
		<div class="login-div">
			<form method="post" action="info.do">
				<div class="login-box">
					<div class="blk">
						<input name="no" class="text-box" type="text" placeholder="账号">
					</div>
					<div class="blk">
						<input name="passwrod" class="text-box" type="password"
							placeholder="密码">
					</div>
					<div class="blk">
						<input class="button" type="submit">
					</div>
					<div class="blk">
						<span>${msg }&nbsp</span>
					</div>
				</div>
			</form>
		</div>
	</div>
	<div></div>
</body>
</html>