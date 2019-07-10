package com.bxx.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

import javax.annotation.Resource;

import com.bxx.bean.Comment;
import com.bxx.dao.CommentDao;
import com.bxx.dao.ProductDao;
import com.bxx.dao.UserDao;
@Service
public class CommentService {
	@Autowired
	private CommentDao commentDao;
	@Resource
	private ProductDao productDao;
	@Autowired
	private UserDao userDao;
	
	public List<Comment> selectAllComment(){
		return commentDao.selectAll();
	}
	public List<Comment> selectByP_id(int product_id) {
		return commentDao.selectByP_Id(product_id);
	}
	public Comment selectByP_id_U_id(int product_id,int user_id) {
		return commentDao.selectByP_id_U_id(product_id,user_id);
	}
	public int add(String no, String time, String text, int product_id,int user_id) {
		System.out.println("add测试");
		int flag=commentDao.insert(no,time,text,product_id,user_id);
		if(flag==1)
		commentDao.updateStatus(product_id);
		return flag;
	}
	
	
}
