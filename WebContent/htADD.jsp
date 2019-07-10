<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<title>information</title>
<!-- <link rel="stylesheet" href="css/materialdesignicons.min.css"> -->

<link rel="stylesheet" href="css/style1.css">
<link rel="stylesheet" href="css/product.css">

<!-- 表格样式 -->
<link href="assets/js/dataTables/dataTables.bootstrap.css"
	rel="stylesheet" />
<link href="assets/css/bootstrap.css" rel="stylesheet" />

<!-- jQuery Js -->
<script src="assets/js/jquery-1.10.2.js"></script>
</head>
<body style="background-color: ghostwhite">

	<aside class="mdc-persistent-drawer mdc-persistent-drawer--open">
	<nav class="mdc-persistent-drawer__drawer">
	<div class="mdc-persistent-drawer__toolbar-spacer">
		<a href="info.do" class="brand-logo"> <img src="img/pdd.png">
		</a>
	</div>
	<div class="mdc-list-group">
		<nav class="mdc-list mdc-drawer-menu">
		<div class="mdc-list-item mdc-drawer-item">
			<a class="mdc-drawer-link" href="info.do"> <i
				class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon"
				aria-hidden="true">desktop_mac</i> 商品信息管理
			</a>
		</div>


		<div class="mdc-list-item mdc-drawer-item">
			<a class="mdc-drawer-link" href="#"> <i
				class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon"
				aria-hidden="true">grid_on</i> 用户信息管理
			</a>
		</div>

		</nav>
	</div>
	</nav> </aside>
	<!-- 页头 -->
	<header class="mdc-toolbar mdc-elevation--z4 mdc-toolbar--fixed">
	<div class="mdc-toolbar__row">
		<section
			class="mdc-toolbar__section mdc-toolbar__section--align-start">
		<a href="#" class="menu-toggler material-icons mdc-toolbar__menu-icon">menu</a>
		<span style="color: white; font-size: 28px;">欢迎来到并夕夕后台管理界面</span> </section>
		<section class="mdc-toolbar__section mdc-toolbar__section--align-end"
			role="toolbar">
		<div class="mdc-menu-anchor">
			<a href="#" class="mdc-toolbar__icon mdc-ripple-surface"
				data-mdc-auto-init="MDCRipple"> <i class="material-icons">widgets</i>
			</a>
		</div>
		<div class="mdc-menu-anchor mr-1">
			<a href="#" class="mdc-toolbar__icon toggle mdc-ripple-surface"
				data-toggle="dropdown" toggle-dropdown="logout-menu"
				data-mdc-auto-init="MDCRipple"> <i class="material-icons">more_vert</i>
			</a>
			<div class="mdc-simple-menu mdc-simple-menu--right" tabindex="-1"
				id="logout-menu">
				<ul class="mdc-simple-menu__items mdc-list" role="menu"
					aria-hidden="true">
					<li class="mdc-list-item" role="menuitem" tabindex="0"><i
						class="material-icons mdc-theme--primary mr-1">settings</i> 设置</li>
					<li class="mdc-list-item" role="menuitem" tabindex="0"><i
						class="material-icons mdc-theme--primary mr-1">power_settings_new</i>
						注销</li>
				</ul>
			</div>
		</div>
		</section>
	</div>
	</header>

	<!-- partial -->
	<div class="page-wrapper mdc-toolbar-fixed-adjust">
		<main class="content-wrapper">
		<div class="mdc-layout-grid">

			<div class="panel panel-default">


				<div class="panel-heading">商品信息</div>
				<div class="panel-body">
					<div class="table-responsive">


						<center>
							<table border="1" cellpadding="5" cellspacing="0" width="500"
								height="350">
								<h1
									style="font-family: arial rounded mt bold; font-weight: 100;">
									<c:if test="${product.id==0}">
				添加商品信息
			</c:if>
									<c:if test="${product.id>0}">
				修改商品信息
			</c:if>
								</h1>
								<br />
								<c:if test="${product.id==0}">
									<form method="post" action="addhtsumbit.do">
										<tr>
											<td style="text-align: center;">no</td>
											<td><input type="text"
												style="border: 0px; text-align: center" size="60%" name="no">
											</td>
										</tr>
										<tr>
											<td style="text-align: center;">name</td>
											<td><input type="text"
												style="border: 0px; text-align: center" size="60%"
												name="name"></td>
										</tr>
										<tr>
											<td style="text-align: center;">price</td>
											<td><input type="text"
												style="border: 0px; text-align: center" size="60%"
												name="price"></td>
										</tr>
										<tr>
											<td style="text-align: center;">photo</td>
											<td><input type="text"
												style="border: 0px; text-align: center" size="60%"
												name="photo"></td>
										</tr>
										<tr>
											<td style="text-align: center;">inventory</td>
											<td><input type="text"
												style="border: 0px; text-align: center" size="60%"
												name="inventory"></td>
										</tr>
										<tr>
											<td style="text-align: center;">specification_id</td>
											<td><input type="text"
												style="border: 0px; text-align: center" size="60%"
												name="specification_id"></td>
										</tr>
										<tr>
											<td style="text-align: center;">classify</td>
											<td><input type="text"
												style="border: 0px; text-align: center" size="60%"
												name="classify"></td>
										</tr>
										<tr>
											<td colspan="2">
												<div align="center">
													<input type="submit" style="color:black" value="保存">
													<a href="manager.jsp" style="color:black"> <input
														type="submit" value="返回">
													</a>
												</div>

											</td>
										</tr>
									</form>
								</c:if>

								<c:if test="${product.id>0}">
									<form method="post" action="modifyhtsumbit.do">

										<tr>
											<td style="text-align: center;">no</td>
											<td><input type="text"
												style="border: 0px; text-align: center" size="60%"
												value="${product.no }" name="no"></td>
										</tr>
										<tr>
											<td style="text-align: center;">name</td>
											<td><input type="text"
												style="border: 0px; text-align: center" size="60%"
												value="${product.name }" name="name"></td>
										</tr>
										<tr>
											<td style="text-align: center;">price</td>
											<td><input type="text"
												style="border: 0px; text-align: center" size="60%"
												value="${product.price }" name="price"></td>
										</tr>
										<tr>
											<td style="text-align: center;">photo</td>
											<td><input type="text"
												style="border: 0px; text-align: center" size="60%"
												value="${product.photo }" name="photo"></td>
										</tr>
										<tr>
											<td style="text-align: center;">inventory</td>
											<td><input type="text"
												style="border: 0px; text-align: center" size="60%"
												value="${product.inventory }" name="inventory"></td>
										</tr>
										<tr>
											<td style="text-align: center;">specification_id</td>
											<td><input type="text"
												style="border: 0px; text-align: center" size="60%"
												value="${product.specification.id }" name="specification_id">
											</td>
										</tr>
										<tr>
											<td style="text-align: center;">classify</td>
											<td><input type="text"
												style="border: 0px; text-align: center" size="60%"
												value="${product.classify}" name="classify"></td>
										</tr>
										<tr>
											<td colspan="2">
                                              <div align="center">
												<input type="submit" style="color:black" value="修改">
												<a href="info.do" style="color:black"> <input
													type="submit" value="返回">
												</a>
											</div>
											</td>
										</tr>
									</form>
								</c:if>

							</table>
						</center>



					</div>

				</div>
			</div>

		</div>
		</main>
		<!-- 页脚 -->
		<footer> </footer>
	</div>


</body>
</html>
