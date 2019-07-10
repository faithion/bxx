<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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



	<div class="reviewDiv">
	<div class="reviewProductInfoDiv">
		<div class="reviewProductInfoImg"><img width="400px" height="400px" src="${comments.product.photo }"></div>
		<div class="reviewProductInfoRightDiv">
			<div class="reviewProductInfoRightText">
				${comments.product.name}
			</div>
			<table class="reviewProductInfoTable">
				<tr>
					<td width="75px">价格:</td>
					<td><span class="reviewProductInfoTablePrice">${comments.product.price}</span> 元 </td>
				</tr>
				<tr>
					<td width="75px">月销量:</td>
					<td><span class="reviewProductInfoTablePrice">${comments.product.sales}</span> 件</td>
				</tr>
			</table>
		</div>
		<div style="clear:both"></div>
	</div>
	
	
	
	
	
		<div class="makeReviewDiv">
		<!-- 提交评论并跳转至评论成功页面 -->
		<form method="post" action="/bxx/comment.do?user_id=${comments.user.id }&product_id=${comments.product.id}">
			<div class="makeReviewText">其他买家，需要你的建议哦！</div>
			<table class="makeReviewTable">
				<tr>
					<td class="makeReviewTableFirstTD">评价商品</td>
					<td><textarea name="text" ></textarea></td>
				</tr>
			</table>
			<div class="makeReviewButtonDiv">
				<button type="submit">提交评价</button>
			</div>
		</form>
		</div>	
	

</div>



  <div id="footer"></div>
</body>

</html>



