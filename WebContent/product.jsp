<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" deferredSyntaxAllowedAsLiteral="true"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script src="js/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link type="text/css" href="css/product.css" rel="stylesheet" />
		<script src="js/bxxinit.js"></script>
		<title>产品页</title>
	</head>
	<script>
// 图片交互
$(function(){
	$("img.smallImage").mouseenter(function(){
		var bigImageURL = $(this).attr("bigImageURL");
        $("img.bigImg").attr("src",bigImageURL);
	});
	$("img.bigImg").load(
		function(){
			$("img.smallImage").each(function(){
				var bigImageURL = $(this).attr("bigImageURL");
				img = new Image();
				img.src = bigImageURL;
				img.onload = function(){
					console.log(bigImageURL);	
					$("div.img4load").append($(img));
				};
			});		
		}
	);

});
// 商品详情与评价交互
$(function(){	
	$("div.productReviewDiv").hide();
	$("a.productDetailTopReviewLink").click(function(){
		$("div.productReviewDiv").show();
		$("div.productDetailDiv").hide();
	});
	$("a.productReviewTopPartSelectedLink").click(function(){
		$("div.productReviewDiv").hide();
		$("div.productDetailDiv").show();		
	});
})
// 修改价格,上不能超过最大库存，下不能小于1，超过库存为最大库存
$(function(){
    var stock =${inventory };
    $(".productNumberSetting").keyup(function(){
        var num= $(".productNumberSetting").val();
        num = parseInt(num);
        if(isNaN(num))
            num= 1;
        if(num<=0)
            num = 1;
        if(num>stock)
            num = stock;
        $(".productNumberSetting").val(num);
    });
     
    $(".increaseNumber").click(function(){
        var num= $(".productNumberSetting").val();
        num++;
        if(num>stock)
            num = stock;
        $(".productNumberSetting").val(num);
    });
    $(".decreaseNumber").click(function(){
        var num= $(".productNumberSetting").val();
        --num;
        if(num<=0)
            num=1;
        $(".productNumberSetting").val(num);
    });
     
});
function jp(sharingId,productId){
	window.location.href="join.do?sharingId="+sharingId+"&productId="+productId+"&quantity="+$("#inventory").val();
}
</script>
	<body>
		<div id="header"></div>
		<div class="imgAndInfo">
			<div class="imgInimgAndInfo">
				<img width="100px" class="bigImg" src="${photo }">
				<div class="smallImageDiv">
					<img width="100px" class="smallImage" src="${photo }" bigImageURL="${photo }">
					<img width="100px" class="smallImage" src="${photo }" bigImageURL="${photo }">
					<img width="100px" class="smallImage" src="${photo }" bigImageURL="${photo }">
					<img width="100px" class="smallImage" src="${photo }" bigImageURL="${photo }">
					<img width="100px" class="smallImage" src="img/pdd.png" bigImageURL="img/pdd.png">
				</div>
				<div class="img4load hidden"></div>
			</div>
			
			<div class="infoInimgAndInfo">
				<div class="productTitle">
					${name}
				</div>
				<div class="productSubTitle">
					高端定制  现货即发 加购物车 领优惠卷
				</div>
				<div class="productPrice">
					<div class="juhuasuan">
						<span class="juhuasuanBig">聚划算</span>
						<span>此商品即将参加聚划算，<span class="juhuasuanTime">1天19小时</span>后开始，</span>
					</div>
					<div class="productPriceDiv">
						<div class="gouwujuanDiv"><img height="16px" src="img/gouwujuan.png">
							<span> 并夕夕实物商品通用</span>
						</div>
						<div class="promotionDiv">
							<span class="promotionPriceDesc">促销价 </span>
							<span class="promotionPriceYuan">¥</span>
							<span class="promotionPrice">
								${price}
							</span>
						</div>
					</div>
				</div>
				<div class="productSaleAndReviewNumber">
					<div>销量 <span class="redColor boldWord"> ${sales }</span></div>
					<div>累计评价 <span class="redColor boldWord">${pnum }</span></div>
				</div>
				<!--  <div class="productSize">
					<span>尺码</span>
					<span class="arrow1">
						<a herf="#" style="color: #999;"><button class="productNumberSettingButton" >S</button></a>
						<a herf="#" style="color: #999;"><button class="productNumberSettingButton">M</button></a>
						<a herf="#" style="color: #999;"><button class="productNumberSettingButton">L</button></a>
						<a herf="#" style="color: #999;"><button class="productNumberSettingButton">X</button></a>
						<a herf="#" style="color: #999;"><button class="productNumberSettingButton">XL</button></a>	
					</span>
				</div>-->
			<form action="create.do">
				<div class="productNumber">
					<span>数量</span>
					<span>
						<span class="productNumberSettingSpan">
							<input id="inventory" type="text" value="1" class="productNumberSetting" name="quantity">
						</span>
						<span class="arrow">
							<a class="increaseNumber" href="#nowhere">
								<span class="updown">
									<img src="img/increase.png">
								</span>
							</a>
							<span class="updownMiddle"> </span>
							<a class="decreaseNumber" href="#nowhere">
								<span class="updown">
									<img src="img/decrease.png">
								</span>
							</a>
						</span>
						件</span>
					<span>库存<span>${inventory }</span>件</span>
				</div>
				<div class="serviceCommitment">
					<span class="serviceCommitmentDesc">服务承诺</span>
					<span class="serviceCommitmentLink">
						<a href="realthing.html">正品保证</a>
						<a href="#nowhere">极速退款</a>
						<a href="#nowhere">赠运费险</a>
						<a href="#nowhere">七天无理由退换</a>
					</span>
				</div>
				<div >
					<span>${people }人正在拼单，可直接参与</span>
					<span  style="float: right;">
					<a href="#nowhere">查看更多</a>
					
					</span>
				</div>
				<c:forEach var="shar" items="${sharings}" varStatus="i" >
					<div class="productSaleAndReviewNumber">
						<div>拼单队伍<span>${i.count }</span> </div>
						<div>这是<span>${shar.unum }</span>人团 ，剩<span>${shar.uleft }</span>人满团，开始时间:<span class="juhuasuanTime">${shar.time }</span>
						<a href="#" onclick="jp('${shar.id }','${id}')" class="jumpCartButton" style="float: right;">加入拼单</a>
						</div>
					</div>
				</c:forEach>
				<div class="buyDiv">
					<input name="productId" value="${id}" style="display: none;"/>
					<button class=" addCartButton" type="submit" >发起拼单</button>
				</div>
			</form>
			</div>
			
		</div>

		<div class="productDetailDiv" style="display: block;">
			<div class="productDetailTopPart">
				<a class="productDetailTopPartSelectedLink selected" href="#nowhere">商品详情</a>
				<a class="productDetailTopReviewLink" href="#nowhere">累计评价 <span class="productDetailTopReviewLinkNumber">${pnum }</span>
				</a>
			</div>
			
			<div class="productParamterPart">
				<div class="productParamter">产品参数：</div>
				
				<div class="productParamterList">
					<span>材质成分: ${specification.cailiao }</span>
					<span>品牌: ${specification.pinpai }</span>
					<span>货号: ${specification.no } </span>
					<span>尺码: ${specification.guige } </span>
					<span>上市年份季节: ${specification.shangshitime } </span>
					<span>颜色分类: ${specification.color } </span>
					<span>适用年龄: ${specification.shiheage }</span>
					<span>地区:${specification.producer }</span>
				</div>
				
				<div style="clear:both"></div>
			</div>
			
			<div class="productDetailImagesPart">
				<img src="${photo }">
			</div>
		</div>

		<div class="productReviewDiv" style="display: block;">
			<div class="productReviewTopPart">
				<a class="productReviewTopPartSelectedLink" href="#nowhere">商品详情</a>
				<a class="selected" href="#nowhere">累计评价 <span class="productReviewTopReviewLinkNumber">${pnum }</span> </a>
			</div>
			
			<div class="productReviewContentPart">
			<c:forEach var="com" items="${comments}" varStatus="i" >
				<div class="productReviewItem">
					<div class="productReviewItemDesc">
						<div class="productReviewItemContent">
							<span>${com.text }</span>
						</div>
						<div class="productReviewItemDate"><span>${com.time }</span></div>
					</div>
					<div class="productReviewItemUserInfo">
						user_<span>${i.index }</span><span class="userInfoGrayPart">（匿名）</span>
					</div>
					<div style="clear:both"></div>
				</div>
				</c:forEach>
			</div>
		</div>
	</body>
<div id="footer"></div>
</html>