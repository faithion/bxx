<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎来到并夕夕</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/index0.css">
<link rel="stylesheet"
	href="css/Font-Awesome-3.2.1/css/font-awesome.min.css">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bxxinit.js"></script>
<script>
	$(function() {
		/*
		 * interval为每个轮播项之间的切换时间
		 * wrap定义是否循环轮播
		 * */
		$("#carouselMenu").carousel({
			interval : 3000,
			wrap : true
		});
	})
</script>
<style>
</style>
</head>

<body>
	<div class="navbar">
		<ul>
			<li><i class="icon-chevron-up"></i></li>
			<li><i class="icon-chevron-down"></i></li>
			<li><i class="icon-btc"></i></li>
		</ul>
	</div>
	<div class="main">
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
		</div>
		<div class="top3 left-margin">
			<div class="kinds left">
				<ul class="leftnav right">
					<li><a href="classify.do?name=男装">男装</a><span>/</span><a href="classify.do?name=女装">女装</a></li>
					<li><a href="classify.do?name=零食">零食</a><span>/</span><a href="classify.do?name=水果">水果</a></li>
					<li><a href="classify.do?name=首饰">首饰</a><span>/</span><a href="classify.do?name=母婴">母婴</a></li>
					<li><a href="#">汽车</a><span>/</span><a href="#">配件</a></li>
					<li><a href="#">图书</a><span>/</span><a href="#">影像</a></li>
					<li><a href="#">零食</a><span>/</span><a href="#">茶酒</a></li>
					<li><a href="#">家饰</a><span>/</span><a href="#">鲜花</a></li>
					<li><a href="#">家电</a><span>/</span><a href="#">生活</a></li>
					<li><a href="#">母婴</a><span>/</span><a href="#">玩具</a></li>
					<li><a href="#">话费</a><span>/</span><a href="#">Q币</a></li>
				</ul>
			</div>
			<div class="content left">
				<div class="container" style="width: 100%">
					<div class="row" style="width: 100%">
						<div class="col-md-8" style="width: 100%">
							<div id="carouselMenu" class="carousel slide" style="width: 100%">
								<ol class="carousel-indicators">
									<li data-target="#carouselMenu" data-slide-to="0"
										class="active"></li>
									<li data-target="#carouselMenu" data-slide-to="1"></li>
									<li data-target="#carouselMenu" data-slide-to="2"></li>
								</ol>
								<div class="carousel-inner">
									<div class="item active">
										<img src="img/m6.jpg" alt="" />
									</div>
									<div class="item">
										<img src="img/m1.jpg" alt="" />
									</div>
									<div class="item">
										<img src="img/m2.jpg" alt="" />
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="top4">
		<c:forEach var="product" items="${products }" varStatus="i">
			<div class="products">
				<a href="/bxx/pro.do?id=${product.id}&name=${product.name}" class="product left"> <img src="${product.photo }" class="pimg">
					<div class="pname">${ product.name}</div>
					<div class="dollar">￥${product.price }</div>
				</a>
			</div>
		</c:forEach>
		<div class="clear"></div>
		</div>
	</div>
	<div id="footer"></div>
</body>
</html>