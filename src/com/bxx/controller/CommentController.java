package com.bxx.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;








import com.bxx.bean.Comment;
import com.bxx.dao.CommentDao;
import com.bxx.dao.ProductDao;
import com.bxx.dao.UserDao;
import com.bxx.service.CommentService;
import com.bxx.service.ProductService;




@Controller
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	@Resource
	private ProductService productService;
	@Autowired
	private UserDao userDao;
	@Resource
	private CommentDao commentDao;
	
	
	
	//在Comment表创建新的评论信息
		@RequestMapping("/commentcj")
		public String commentMesscj(int user_id,int product_id,Model model){
			System.out.println("commentcontroller测试");
			//查询数据
			Date now = new Date();
			String time=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(now);
			String no=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(now);
			System.out.println(no);
			System.out.println(time);
	        System.out.println(now.getSeconds());
			System.out.println(now);
			String text=null;
			if(commentService.add(no,time,text,product_id,user_id)>0)
			{
				System.out.println("创建评论成功！");
				return "redirect:comments.do?user_id="+user_id+"&product_id="+product_id;
			}
			else{
				System.out.println("评论失败！");
				return "MyOders";
			}
		}
		
	
	//显示评论页面其他信息
	@RequestMapping("/comments")
	public String commentMess(int user_id,int product_id,Model model){
		System.out.println("commentcontroller测试");
		//查询数据
		Comment comment=commentService.selectByP_id_U_id(product_id,user_id);
		System.out.println(comment);
		model.addAttribute("comments", comment);
		return "Comment";
	}
	
	
	

	//评论
	@RequestMapping("/comment")
	public String  comment(int user_id,int product_id,String text,Model model){
		int id=commentDao.selectByP_id_U_id(product_id,user_id).getId();
		/*comment.setNo(commentDao.selectByP_id_U_id(product_id,user_id).getNo());*/
		System.out.println("comment.do测试");
		String no=commentDao.selectByP_id_U_id(product_id, user_id).getNo();
		String time=commentDao.selectByP_id_U_id(product_id, user_id).getTime();
		if(commentDao.update(id,no,time,text,product_id,user_id)>0)
		{
			System.out.println("评论成功！");
			return "CommentOK";
		}
		else{
			System.out.println("评论失败！");
			return "MyOders";
		}
	}

	

}
