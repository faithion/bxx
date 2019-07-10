<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/index0.css">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bxxinit.js"></script>
<style>
</style>
</head>

<body>
	<div id="header"></div>
	<div class="top2 left-margin">
		<div class="logo left">
			<img src="img/pdd.png" style="height: 100%; width: 100%">
		</div>
		<div class="search center">
			<div style="margin-left: 300px; margin-top: 50px">
				<form action="classify.do" method="get">
					<input type="text" class="text left st" name="name"> <input
						id="searchbtn" type="submit" class="submit left sb" value="搜索">
					<div class="clear"></div>
				</form>
			</div>
		</div>
		<!-- <div class="clear"></div> -->
	</div>
	<div class="top4">
		<c:forEach var="product" items="${list }" varStatus="i">
			<div class="products">
				<a href="/bxx/pro.do?id=${product.id}&name=${product.name}"
					class="product left"> <img src="${product.photo }" class="pimg">
					<div class="pname">${ product.name}</div>
					<div class="dollar">￥${product.price }</div>
				</a>
			</div>
		</c:forEach>
		<div class="clear"></div>
	</div>
	<div id="footer"></div>
</body>
</html>