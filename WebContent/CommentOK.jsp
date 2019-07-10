<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>


<html>

<head>
<script src="js/jquery.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap.min.js"></script>
<link href="css/style.css" rel="stylesheet">
<script src="js/bxxinit.js"></script>
</head>

<body>

	<div id="header"></div>
	<div class="orderFinishDiv">
		<div class="orderFinishTextDiv">
			<img src="../image/paySuccess.png"> <span>评论成功！</span>
		</div>
	</div>
	<div id="footer"></div>
</body>
</html>




