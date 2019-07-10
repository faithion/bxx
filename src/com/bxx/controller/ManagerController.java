package com.bxx.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bxx.bean.Manager;
import com.bxx.bean.Product;
import com.bxx.bean.Specification;
import com.bxx.dao.ProductDao;
import com.bxx.dao.SpecificationDao;
import com.bxx.service.ManagerService;
import com.bxx.service.ProductService;

import net.sf.json.JSONObject;
import oracle.jrockit.jfr.ProducerDescriptor;

@Controller
public class ManagerController {
	@Resource
	private ProductDao productDao;
	@Resource
	private ProductService productService;
	@Resource
	private SpecificationDao specificationDao;
	@Resource
	private ManagerService managerService;
	
	
	
	
//	@RequestMapping("login")
//	public void login(HttpServletRequest request, HttpServletResponse response, String no, String password, String auto)
//			throws Exception {
//		CookieUtil cookieUtil = new CookieUtil(request, response);
//		if(request.getSession().getAttribute("user")!=null){
//			return;
//		}
//		if (no == null && password == null) {
//			// 查找是否有cookie
//			no = cookieUtil.getCookie("no");
//			password = cookieUtil.getCookie("password");
//		}
//		Manager manager = managerService.selectByNo(no);
//		if (manager != null && manager.getPassword().equals(password)) {
//			request.getSession().setAttribute("manager", manager);
//			System.out.println(manager);
//			// 到时候可以通过这种方式先把值保存起来,再通过jsp取出来
//			request.setAttribute("manager", manager);
//			JSONObject jsonObject = new JSONObject();
////			jsonObject.accumulate("name", manager.getName());
//			jsonObject.accumulate("no", no);
//			response.getWriter().println(jsonObject);
//			if (auto != null) {
//				cookieUtil.addCookie("no", no);
//				cookieUtil.addCookie("password", password);
//			}
//			System.out.println("登录成功");
//		} else {
//			System.out.println("登录失败");
//		}
//
//	}
	
	
	
	

	//搜索分类商品
	@RequestMapping("/queryht")
	public String queryht(String classify,Model model,HttpServletRequest req){
		req.getParameter("classify");
		System.out.println(classify);
		System.out.println("queryht测试测试");
		List<Product> information=null;
		if(classify.equals("=="))
		{information=productDao.selectAll();}
		else 
		{information=productDao.selectByClassify(classify);}
		model.addAttribute("information",information);
		return "manager";
	}

	
	
	
	
	//显示主页面
	@RequestMapping("/info")
	public String info(Model model) {
       List<Product> information = productDao.selectAll();		

		/*System.out.println(information);
		for(Product pro:information) {
			pro.setSpecification(specificationDao.selectById(pro.getSpecification().getId()));
		}*/
       
       	System.out.println(information);
       	Specification specification=new Specification();
   		for(Product pro:information) {
   			specification=pro.getSpecification();
   			if(specification!=null)
   			{
   				pro.setSpecification(specificationDao.selectById(specification.getId()));
   			}
   		}

		
		model.addAttribute("information", information);
		
		return "manager";
		
		
		
	}
	//删除
	@RequestMapping("/info1")
	public String info1(Model model,int id) {
		productDao.delete(id);
		System.out.println("success!");
		return "redirect:info.do?id="+id;
	}
	
	
	//添加
		@RequestMapping("/addht")
		public String  addht(Model model){
			System.out.println("addht����");
			Product product=new Product();
			model.addAttribute("product",product );
			return "htADD";
		}
		
		//修改
		@RequestMapping("/modifyht")
		public String  modifyht(int id,Model model) throws IOException{
			System.out.println("modifyht    ");
			Product product=productDao.selectById(id);
			System.out.println(product.toString()+"1");
			System.out.println(product.getSpecification()+"2");
		    product.setSpecification(specificationDao.selectById(product.getSpecification().getId()));
		    System.out.println(product.toString()+"3");
			model.addAttribute("product",product );
			return "htADD";
		}

		
		@RequestMapping("/addhtsumbit")
		public String addhtsj(String name,double price,String photo,int inventory,int specification_id,String classify,Model model){
			System.out.println("addhtsumbit����");
			Date now = new Date();
			String no=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(now);
			Specification specification=specificationDao.selectById(specification_id);
			System.out.println(specification_id);
			Product product=new Product();
			product.setNo(no);
			product.setPhoto(photo);
			product.setName(name);
			product.setPrice(price);
			product.setInventory(inventory);
			product.setSpecification(specification);
			product.setClassify(classify);
			System.out.println(product.toString());
			productDao.insert(product);
			return "redirect:info.do";
			
		}
		
		@RequestMapping("/modifyhtsumbit")
		public String modifyhtsj(String no,String name,double price,String photo,int inventory,int specification_id,String classify,Model model){
			System.out.println("modifyhtsumbit测试");
			Product product=productDao.selectByNo(no);
			int id=0;
			if (null != product){
			    id = product.getId();
			}
			/*System.out.println(product.toString()+"1");
			System.out.println(product.getSpecification()+"2");
		    System.out.println(product.toString()+"3");*/
			System.out.println(no+"=="+name+"=="+price+"=="+photo+"=="+inventory+"=="+specification_id+"=="+classify);
			productDao.u(id,no,name,price,photo,inventory,specification_id,classify);
			return "redirect:info.do";
			
		}

}
