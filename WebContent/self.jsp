<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>并夕夕-用户中心</title>
	<link rel="stylesheet" type="text/css" href="css/reset.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bxxinit.js"></script>
<script type="text/javascript">
	function submitform(){
		$.ajax({
			url : "/bxx/modify.do",
			type : "post",
			traditional : true,
			data : $("#userform").serialize(),
			success : function(result) {
				alert("修改成功!");
			},
			error : function() {
				alert("修改失败!")
			}
		})		
	}
</script>
</head>

<body>
	<div id="header"></div>

	<div class="search_bar clearfix">
		<a href="index.html" class="logo fl"><img src="images/pdd.png"></a>
		<div class="sub_page_name fl">|&nbsp;&nbsp;&nbsp;&nbsp;用户中心</div>	
	</div>

	<div class="main_con clearfix">
		<div class="left_menu_con clearfix">
			<h3>用户中心</h3>
			<ul>
				<li><a href="#" class="active">· 个人信息</a></li>
				<li><a href="alloderform.do?user_id=${user.id }">· 全部订单</a></li>
			</ul>
		</div>
		
		
		<div class="right_content clearfix">
				<h3 class="common_title2">编辑信息</h3>
				<div class="site_con"></div>
				<div class="site_con">
					<form id="userform" action="#">
						<input type="hidden" name="id" value="${user.id }">
						<input type="hidden" name="no" value="${user.no }">
						<div class="form_group">
							<label>用户名：</label>
							<input type="text" name="name" value="${user.name}" maxlength="11">
						</div>
						<div class="form_group">
							<label>地址：</label>
							<input type="text" name="address" value="${user.address}">
						</div>
						<div class="form_group">
							<label>密码：</label>
							<input type="text" name="password" value="${user.password}" maxlength="11">
						</div>
						<div class="form_group">
							<label>联系方式：</label>
							<input type="text" name="contact" value="${user.contact}">
						</div>
					</form>
					<button class="info_submit" onclick="submitform()">修改</button>
				</div>
		</div>
	</div>
</body>
<div id="footer"></div>
</html>