package com.bxx.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bxx.bean.Oderform;
import com.bxx.bean.Product;
import com.bxx.bean.Sharing;
import com.bxx.bean.User;
import com.bxx.bean.UserSharing;
import com.bxx.dao.OderformDao;
import com.bxx.dao.ProductDao;
import com.bxx.dao.SharingDao;
import com.bxx.dao.UserDao;
import com.bxx.dao.UserSharingDao;

@Controller
public class CreateOrderController {
	@Autowired
	private SharingDao sharingdao;
	@Autowired
	private UserDao userdao;
	@Autowired
	private UserSharingDao usdao;
	@Autowired
	private ProductDao pdao;
	@Autowired
	private OderformDao odao;
	
	@RequestMapping("createorder")
	public String create(HttpServletRequest request,int productId ,int quantity,Integer sharingId,Integer tuanNum,float discount) throws Exception {
		System.out.println(tuanNum);
		//product_no 为商品的no,tuan_num 为几人团,product_num 为购买的数量 float discount
		//需要接受的参数如下
		int tuan_num = 3;//默认3人团
		if(tuanNum!=null){
			tuan_num=tuanNum;
		}
//		float discount = 1-(tuan_num/(50+tuan_num));
		//对Sharing表进行操作
		//获取一个时间戳，转化为string类型，作为拼单时间
		//用product_no + 时间戳的形式拼接成一个no
		//在sharing表中插入一条记录，unum = 1，uleft = num - unum
		int oid = (int) request.getAttribute("oid");
		if (sharingId == null) {
			SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String datetime = tempDate.format(new java.util.Date());
			String sharing_no = datetime + "-" + productId;
			Sharing sharing = new Sharing();
			sharing.setNo(sharing_no);
			sharing.setUnum(tuan_num); //此拼单限定的 总人数
			sharing.setUleft(tuan_num - 1); //剩余人数
			sharing.setDiscount(discount);
			sharing.setTime(datetime);
			Product product = new Product();
			product = pdao.selectById(productId);
			System.out.println(product);
			sharing.setProduct(product);
			sharingdao.insert(sharing);
			
			//对usersharing表进行操作
			//1.通过user_no查出user_id
			//2.通过sharing_no查出sharing_id
			//3.将user_id和sharing_id插入到user_sharing表中
			UserSharing ushare = new UserSharing();
			User user =  (User)request.getSession().getAttribute("user");
			ushare.setUserId(user.getId());
			System.out.println(sharing_no);
			sharing = sharingdao.selectByNo(sharing_no);
			System.out.println(sharing);
			ushare.setSharingId(sharing.getId());
			usdao.insert(ushare);
	
			//对商品表进行操作 --- 销量 + product_num,库存量-product_num
			System.out.println(product);
			int sales = product.getSales();
			int inventory = product.getInventory();
			product.setSales(sales + quantity);
			product.setInventory(inventory - quantity);
			pdao.update(product);
			
			String string = "还差" + (tuan_num-1) + "人拼团成功…";
			request.setAttribute("status",string);
			System.out.println("创建---"+""+string);		
			
			//更新Oderform表中的订单状态为 "待评价"
			
			//sharing = sharingdao.selectById(sharingId);
//			List<Oderform> oList = sharing.getOderforms();
//			for (Oderform orderform : oList) {
//				System.out.println("发起拼单完成，正在准备更新oderform记录~");
//				orderform.setStatus("待评价");
//				orderform.setSharing(sharing);
//				odao.update(orderform);
//			}
			Oderform oderform = odao.selectById(oid);
			System.out.println("根据oid查找出来的oderform...");
			System.out.println(oderform);
			//oderform.setStatus("待评价");
			oderform.setSharing(sharing);
			odao.update(oderform);
			List<Oderform> oList = sharing.getOderforms();
			oList.add(oderform);//将此订单加入sharing中的oderform集合
			sharing.setOderforms(oList);
			sharingdao.update(sharing);
			
		}
		else {
			
			//传来的参数如下
			//product_id:商品编号,product_num:所拼商品的数量 ,sharing_id:拼单id
			
			Sharing sharing = new Sharing();
			sharing = sharingdao.selectById(sharingId);
			sharing.setUleft(sharing.getUleft() - 1);//拼单剩余人数-1
			sharingdao.update(sharing);
			
			//对商品表进行操作 --- 销量 + quantity,库存量 - quantity
			Product product = new Product();
			product = pdao.selectById(productId);
			int sales = product.getSales();
			int inventory = product.getInventory();
			product.setSales(sales + quantity);
			product.setInventory(inventory - quantity);
			pdao.update(product);
			
			String string;
			if (sharing.getUleft() == 0){
				string = "拼单已完成 ! ,正在准备发货，预计今日送达！";
				request.setAttribute("status",string);
				//从Sharing表、Usersharing表中删除与该订单有关的信息
				sharingdao.delete(sharingId);
				usdao.delete(sharingId);
				
				Oderform oderform = odao.selectById(oid);
				oderform.setStatus("待评价");
				oderform.setSharing(sharing);
				odao.update(oderform);
				List<Oderform> oList = sharing.getOderforms();
				oList.add(oderform);//将此订单加入sharing中的oderform集合
				sharing.setOderforms(oList);
				sharingdao.update(sharing);

			}
			else{
				string = "还差" + sharing.getUleft() + "人拼团成功…";
				request.setAttribute("status",string);
				
				Oderform oderform = odao.selectById(oid);
				//oderform.setStatus("待评价");
				oderform.setSharing(sharing);
				odao.update(oderform);
				List<Oderform> oList = sharing.getOderforms();
				oList.add(oderform);//将此订单加入sharing中的oderform集合
				sharing.setOderforms(oList);
				sharingdao.update(sharing);
			}
			//更新Oderform表中的订单状态为 "待评价"
//			sharing = sharingdao.selectById(sharingId);
//			List<Oderform> oList = sharing.getOderforms();
//			for (Oderform orderform : sharing.getOderforms()) {
//				System.out.println("加入拼单完成，正在准备更新oderform记录~");
//				orderform.setStatus("待评价");
//				orderform.setSharing(sharing);
//				odao.update(orderform);
//			}
//			
			
			
			System.out.println("加入---"+""+string);   
		}


		return "payok";
	}
}
