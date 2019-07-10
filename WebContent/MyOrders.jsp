<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8"></meta>
	<title>并夕夕-用户中心</title>
	<link rel="stylesheet" type="text/css" href="css/reset.css"></link>
	<link rel="stylesheet" type="text/css" href="css/main.css"></link>
	<script src="js/jquery.min.js"></script>
	<script src="js/bxxinit.js"></script>

</head>
<body >
	<div id="header"></div>

	<div class="search_bar clearfix">
		<a href="index.html" class="logo fl"><img src="image/pdd.png"></img></a>
		<div class="sub_page_name fl">|&nbsp;&nbsp;&nbsp;&nbsp;用户中心</div>
		<!-- <div class="search_con fr">
			<input type="text" class="input_text fl" name="" placeholder="搜索商品">
			<input type="button" class="input_btn fr" name="" value="搜索">
		</div>	 -->	
	</div>

	<div class="main_con clearfix">
		<div class="left_menu_con clearfix">
			<h3>用户中心</h3>
			<ul>
				<li><a href="self.jsp">· 个人信息</a></li>
				<li><a href="#" class="active">· 全部订单</a></li>
			</ul>
		</div>
		
		<div class="right_content clearfix" >
		<h3 class="common_title2" >全部订单</h3>
		<c:forEach var="oderform" items="${oderforms }"  varStatus="i"> 
			<ul class="order_list_th w978 clearfix" >
					<li class="col01">${oderform.date}</li>
					<li class="col02">订单号：${oderform.no }</li>	
			</ul>
			
			
			<ul class="order_list_ths w978 clearfix">
			 	<li class="cols01">商品名称</li>
			 	<li class="cols02">单价</li>	
			 	<li class="cols03">数量</li>
			 	<li class="cols04">总价</li>	
			 	<li class="cols05">状态</li>
			 </ul>
			<table class="order_list_table w980">
					<tbody>
						<tr>
							<td width="65%" >
								<ul class="order_goods_list clearfix" >					
									<li class="col01"><a href="/bxx/pro.do?id=${oderform.product.id }&name=${oderform.product.name}"><img src="${oderform.product.photo }"></img></a></li>
									<li class="col02"><a href="/bxx/pro.do?id=${oderform.product.id }&name=${oderform.product.name}">${oderform.product.name }</a></li>	
									<li class="col03">${oderform.product.price }元</li>
									<li class="col04">${oderform.quantity }</li>
								</ul>
							</td>
							<td width="10%">${oderform.total }元</td>
							<td width="10%">${oderform.status }</td>
							<td width="15%">
							<!-- 跳转到付款页面 -->
							<c:if test="${oderform.status =='未支付' }">
							<a href="continuepay.do?oid=${oderform.id }" class="oper_btn">去付款</a>
							</c:if>
							<!-- 显示拼团情况 -->
							<c:if test="${oderform.status =='已支付' }">
								剩余${oderform.sharing.uleft}人即可完成拼单
							</c:if>
							<!-- 跳转至确认收货页面 -->
							<c:if test="${oderform.status =='待评价' }">
							<a href="commentcj.do?user_id=${oderform.user.id }&product_id=${oderform.product.id}" class="oper_btn">去评价</a>
							</c:if>
						</td>
							
						</tr>
					</tbody>
				</table>
	
		</c:forEach>
		</div>


	<div style="clear: both;"></div>
	<div id="footer"></div>
</body>
	
</html>
