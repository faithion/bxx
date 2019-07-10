package com.bxx.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bxx.bean.User;
import com.bxx.dao.UserDao;

@Controller
public class UserController {
	@Autowired
	private UserDao userDao;
	@RequestMapping("modify")
	public String modify(HttpServletRequest request,String name,String password,String address,String contact){
		User user=(User) request.getSession().getAttribute("user");
		user.setContact(contact);
		user.setPassword(password);
		user.setName(name);
		user.setAddress(address);
		userDao.update(user);
		System.out.println("修改成功");
		return "self";
	}
}
