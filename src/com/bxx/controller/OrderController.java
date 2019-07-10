package com.bxx.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.io.ResolverUtil.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bxx.bean.Oderform;
import com.bxx.bean.Product;
import com.bxx.bean.Sharing;
import com.bxx.bean.User;
import com.bxx.dao.OderformDao;
import com.bxx.dao.ProductDao;

@Controller
public class OrderController {
	@Autowired
	private OderformDao oderformDao;
	@Autowired
	private ProductDao productDao;
	
	//写入一个订单信息到数据库
	private void processOrder(HttpServletRequest request,int productId,int quantity,int sharingId){
		Product product=productDao.selectById(productId);
		request.setAttribute("product", product);
		User user=(User) request.getSession().getAttribute("user");
		SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间 
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");// a为am/pm的标记  
        Date date = new Date();// 获取当前时间 
        long no=date.getTime();
        String nowTime=sdf.format(date).toString();
		Oderform oderform=new Oderform();
		Sharing sharing=new Sharing();
		sharing.setId(sharingId);
		oderform.setSharing(sharing);
		oderform.setNo(Long.toString(no));
		oderform.setDate(nowTime);
		oderform.setQuantity(quantity);
		oderform.setStatus("未支付");
		oderform.setUser(user);
		oderform.setProduct(product);
		oderformDao.insert(oderform);
		oderform=oderformDao.selectByNo(oderform.getNo());
		request.setAttribute("oderform", oderform);
		System.out.println("订单已经生成!");
	}
	
	@RequestMapping("create")
	public String create(HttpServletRequest request,int productId,int quantity){
		processOrder(request, productId, quantity,-1);
		request.setAttribute("productId", productId);
		request.setAttribute("quantity", quantity);
		return "pay";
	}
	@RequestMapping("join")
	public String join(HttpServletRequest request,int sharingId,int productId,int quantity){
		processOrder(request, productId, quantity, sharingId);
		request.setAttribute("sharingId", sharingId);
		request.setAttribute("productId", productId);
		request.setAttribute("quantity", quantity);
		return "pay";
	}
	
	
	@RequestMapping("pay")
	//你需要的参数在这里接收
	public String pay(HttpServletRequest request,String no,int total){
		Oderform oderform=oderformDao.selectByNo(no);
		request.setAttribute("oid", oderform.getId());
		oderform.setTotal(total);
		System.out.println(oderform);
		oderform.setStatus("已支付");
		oderformDao.update(oderform);
		System.out.println(oderform);
		//这里代表已经成功支付了,以下直接处理sharing相关操作
		return "forward:createorder.do";
	}
	@RequestMapping("continuepay")
	public String continuePay(HttpServletRequest request,int oid){
		Oderform oderform=oderformDao.selectById(oid);
		System.out.println(oderform);
		if(oderform.getSharing().getId()!=-1){
			request.setAttribute("sharingId", oderform.getSharing().getId());
		}
		request.setAttribute("oid", oid);
		request.setAttribute("oderform", oderform);
		request.setAttribute("product", productDao.selectById(oderform.getProduct().getId()));
		request.setAttribute("productId", oderform.getProduct().getId());
		request.setAttribute("quantity", oderform.getQuantity());
		return "pay";
	}
}
