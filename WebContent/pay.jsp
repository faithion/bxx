<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
	<title>并夕夕-提交订单</title>
	<link rel="stylesheet" type="text/css" href="css/reset.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	<script src="js/jquery.min.js"></script>
	<script src="js/bxxinit.js"></script>
</head>
<style>
	.col07{
		display:block;
		line-height: 120px;
	    float: left;
	    text-align: center;
	    width:10%;
	}
	.col07 input{
		width: 38px;
	    height: 28px;
	    text-align: center;
	    line-height: 30px;
	    border: 0px;
	    display: block;
	    float: left;
	    outline: none;
	    border-left: 1px solid #ddd;
	    border-right: 1px solid #ddd;
	}
	.col07 a{
		color:plum;
		width: 29px;
	    height: 28px;
	    line-height: 28px;
	    background-color: #f3f3f3;
	    font-size: 14px;
	    color: #666;
	}
</style>
<script type="text/javascript">
	function add(){
		var val=parseInt($("#tuanNum").val())
		if(val>=100){
			return;
		}
		$("#tuanNum").attr("value",val+1)
		$("#discount").attr("value",discount(val+1))
		$("#total").html(Math.round($("#price").val()*discount(val+1)))
		$("#tp").attr("value",Math.round($("#price").val()*discount(val+1)))
		
	}
	function sub(){
		var val=parseInt($("#tuanNum").val())
		if(val<=3){
			return;
		}
		$("#tuanNum").attr("value",val-1)
		$("#discount").attr("value",discount(val-1))
		$("#total").html(Math.round($("#price").val()*discount(val-1)))
		$("#tp").attr("value",Math.round($("#price").val()*discount(val-1)))
	}
	function discount(unum){
		return 1-(unum/(50+unum));
	}
</script>
<body>
	<div id="header"></div>	
	<div class="search_bar clearfix">
		<a href="index.html" class="logo fl"><img src="image/pdd.png"></a>
		<div class="sub_page_name fl">|&nbsp;&nbsp;&nbsp;&nbsp;提交订单</div>
		<!-- <div class="search_con fr">
			<input type="text" class="input_text fl" name="" placeholder="搜索商品">
			<input type="button" class="input_btn fr" name="" value="搜索">
		</div> -->		
	</div>
	
	<h3 class="common_title">确认收货地址</h3>

	<div class="common_list_con clearfix">
		<dl>
			<dt>寄送到：</dt>
			<dd><input type="radio" name="" checked=""><span>${user.address }</span>  <span>${user.contact }</span></dd>
		</dl>
		<a href="/bxx/self.jsp" class="edit_site">编辑收货地址</a>
		
	</div>
	
	<h3 class="common_title">支付方式</h3>	
	<div class="common_list_con clearfix">
		<div class="pay_style_con clearfix">
			<input type="radio" name="pay_style" checked>
			<label class="cash">货到付款</label>
			<input type="radio" name="pay_style">
			<label class="weixin">微信支付</label>
			<input type="radio" name="pay_style">
			<label class="zhifubao"></label>
			<input type="radio" name="pay_style">
			<label class="bank">银行卡支付</label>
		</div>
	</div>
	<form action="pay.do" method="get">
	<h3 class="common_title">商品列表</h3>
	
	<div class="common_list_con clearfix">
		<ul class="goods_list_th clearfix">
			<li class="col01">商品名称</li>
			<li class="col03">商品价格</li>
			<li class="col04">数量</li>
			<li class="col05">选择拼团人数</li>
			<li class="col06">小计</li>		
		</ul>
		<ul class="goods_list_td clearfix">
			<li class="col01">1</li>			
			<li class="col02"><img src="${product.photo }"></li>
			<li class="col03" style="overflow: hidden;white-space: nowrap;text-overflow: ellipsis;">${product.name }</li>
			<li class="col05">${product.price }</li>
			<li class="col06">${oderform.quantity }</li>
			<li class="col07">
				<div class="num_add">
				<a href="javascript:add();" class="add fl">+</a>
				<input id="tuanNum" name="tuanNum" type="text" class="num_show fl" value="3" onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'3');}).call(this)" onblur="this.v();">	
				<a href="javascript:sub();" class="minus fl">-</a>	
				<label style="float:left">折扣:</label>
				<input id="discount" name="discount" type="text" class="num_show fl" value="1.0">
			</div>
			</li>
			<li class="col08">${product.price }</li>	
		</ul>
	</div>

	<h3 class="common_title">总金额结算</h3>

	<div class="common_list_con clearfix">
		<div class="settle_con">
			<div class="total_goods_count">共<em>${oderform.quantity }</em>件商品，总金额<b id="total">${product.price * oderform.quantity}</b></div>
			<input type="hidden" id="price" value="${product.price * oderform.quantity }">
		</div>
	</div>
		<input type="hidden" name="total" id="tp" value="0">
		<input type="hidden" name="productId" value="${productId }">
		<input type="hidden" name="sharingId" value="${sharingId }">
		<input type="hidden" name="quantity" value="${quantity }">
		<input type="hidden" name="no" value="${oderform.no }">
		<input type="hidden" name="oid" value="${oderform.id }">
		<div class="order_submit clearfix">
			<input type="submit" value="确认付款" 
			style="width:160;height: 40px;line-height: 40px;text-align: center;
			background-color: plum;color: white;font-size:16px;display: block;float: right;">
		</div>	
	</form>
	<script>add();sub();</script>
	<div id="footer"></div>
</body>

</html>