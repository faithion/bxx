<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" deferredSyntaxAllowedAsLiteral="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>并夕夕后台管理</title>
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

<body>
	<div class="body-wrapper">
    <!-- partial:partials/_sidebar.html -->
    <aside class="mdc-persistent-drawer mdc-persistent-drawer--open">
      <nav class="mdc-persistent-drawer__drawer">
        <div class="mdc-persistent-drawer__toolbar-spacer">
          <a href="info.do" class="brand-logo">
						<img src="img/pdd.png" >
					</a>
        </div>
        <div class="mdc-list-group" >
          <nav class="mdc-list mdc-drawer-menu">
            <div class="mdc-list-item mdc-drawer-item">
              <a class="mdc-drawer-link" href="info.do">
                <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon" aria-hidden="true">desktop_mac</i>
                                             商品信息管理
              </a>
            </div>
           
            
            <div class="mdc-list-item mdc-drawer-item">
              <a class="mdc-drawer-link" href="#">
                <i class="material-icons mdc-list-item__start-detail mdc-drawer-item-icon" aria-hidden="true">grid_on</i>
                                        用户信息管理
              </a>
            </div>
          
          </nav>
        </div>
      </nav>
    </aside>
		<!-- 页头 -->
		 <header class="mdc-toolbar mdc-elevation--z4 mdc-toolbar--fixed">
      <div class="mdc-toolbar__row">
        <section class="mdc-toolbar__section mdc-toolbar__section--align-start">
          <a href="#" class="menu-toggler material-icons mdc-toolbar__menu-icon">menu</a>
          <span style="color: white;font-size: 28px;">欢迎来到并夕夕后台管理界面</span>
        </section>
        <section class="mdc-toolbar__section mdc-toolbar__section--align-end" role="toolbar">
          <div class="mdc-menu-anchor">
            <a href="#" class="mdc-toolbar__icon mdc-ripple-surface" data-mdc-auto-init="MDCRipple">
              <i class="material-icons">widgets</i>
            </a>
          </div>
          <div class="mdc-menu-anchor mr-1">
            <a href="#" class="mdc-toolbar__icon toggle mdc-ripple-surface" data-toggle="dropdown" toggle-dropdown="logout-menu" data-mdc-auto-init="MDCRipple">
              <i class="material-icons">more_vert</i>
            </a>
            <div class="mdc-simple-menu mdc-simple-menu--right" tabindex="-1" id="logout-menu">
                <ul class="mdc-simple-menu__items mdc-list" role="menu" aria-hidden="true">
                  <li class="mdc-list-item" role="menuitem" tabindex="0">
                    <i class="material-icons mdc-theme--primary mr-1">settings</i>
                                                             设置
                  </li>
                  <li class="mdc-list-item" role="menuitem" tabindex="0">
                    <i class="material-icons mdc-theme--primary mr-1">power_settings_new</i>
                                                            注销
                  </li>
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
				
				<center>
				<form action="queryht.do">
				<div class="form-group">
                                            <label style="font-size: 24px">搜索商品类别</label>
                                            <select class="form-control" name="classify">
                                                <option>--</option>
                                                <option>女装</option>
                                                <option>男装</option>
                                                <option>水果</option>
                                                <option>母婴</option>
                                                <option>首饰</option>
                                                <option>家电</option>
                                                <option>手机</option>
                                                <option>零食</option>
                                                <option>茶酒</option>    
                                            </select>
                                            
                                            <button type="submit" class="addCartButton1">搜索</button>
                                        </div>
                                        </form>
          </center>
					<div class="panel-heading">商品信息
					  <a href="addht.do"  style="float: right;">
					<button class="addCartButton1" type="button">+增加商品</button>
					</a>
					</div>
					<div class="panel-body">
						<div class="table-responsive">
							
							<table class="table table-striped table-bordered table-hover"
								id="dataTables-example" >
								<thead>
									<tr>
										<th>#</th>
										<th>商品编号</th>
										<th>商品名称</th>
										<th>商品价格</th>
										<th>商品图片</th>
										<th>商品库存</th>
										<th>商品分类</th>
										<th>商品详情#</th>
										<th>Actions操作</th>
									</tr>
								</thead>
								<c:forEach var="info" items="${information }" varStatus="i">
									<tbody>
										<tr class="odd gradeX">
											<td>${info.id }</td>
											<td>${info.no }</td>
											<td>${info.name}</td>
											<td class="center">${info.price }</td>
											<td class="center">${info.photo }</td>
											<td>${info.inventory }</td>
											<td>${info.classify }</td>
											<td>${info.specification.id }</td>
											<td><a href="modifyht.do?id=${info.id }">修改</a> <a href="info1.do?id=${info.id}"> 删除</a></td>
										</tr>
									</tbody>
								</c:forEach>
							</table>
						</div>

					</div>
				</div>

			</div>
			</main>
			<!-- 页脚 -->
			<footer> </footer>
		</div>
	</div>

	<script src="js/material-components-web.min.js"></script>
	<script src="js/material-components-web.min.js"></script>

	<script src="js/misc.js"></script>
	<script src="js/material.js"></script>
</body>
</html>