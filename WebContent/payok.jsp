<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<script src="js/jquery.min.js"></script>
<link href="css/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap.min.js"></script>
<link href="css/style.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<script src="js/bxxinit.js"></script>
<title>确认订单</title>
<style type="text/css">
	#footer{
		position:absolute;bottom:0;width:100%;
	}
</style>
</head>
<body>
	<div id="header"></div>
	<div class="payedDiv">
		<div class="payedTextDiv">
			<img src="image/paySuccess.png"> <span>您已成功付款</span>

		</div>
		<div class="payedAddressInfo">
			<ul>
				<li>收货地址： <span>${user.address }</span></li>
				<li>联系方式： <span>${user.contact }</span></li>
				<li>当前状态： <span>${status }</span></li>
<!-- 				<li>预计今日送达</li> -->
			</ul>

			<div class="paedCheckLinkDiv">
				您可以 <a class="payedCheckLink" href="alloderform.do?user_id=${user.id }">查看已买到的宝贝</a>
			</div>

		</div>

		<div class="payedSeperateLine"></div>

		<div class="warningDiv">
			<img src="image/warning.png"> <b>安全提醒：</b>下单后，<span
				class="redColor boldWord">用QQ给您发送链接办理退款的都是骗子！</span>并夕夕不存在系统升级，订单异常等问题，谨防假冒客服电话诈骗！
		</div>
	</div>

<div id="footer"></div>
</body>

</html>



