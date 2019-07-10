package com.bxx.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bxx.bean.Manager;
import com.bxx.bean.User;
import com.bxx.dao.ManagerDao;
import com.bxx.service.UserService;
import com.bxx.util.CookieUtil;

@Controller
public class LogController {
	@Autowired
	private UserService userService;
	@Autowired
	private ManagerDao managerDao;
	@RequestMapping("login")
	public void login(HttpServletRequest request, HttpServletResponse response, String no, String password, String auto)
			throws Exception {
		CookieUtil cookieUtil = new CookieUtil(request, response);
		if(request.getSession().getAttribute("user")!=null){
			return;
		}
		if (no == null && password == null) {
			// 查找是否有cookie
			no = cookieUtil.getCookie("no");
			password = cookieUtil.getCookie("password");
		}
		User user = userService.selectByNo(no);
		if (user != null && user.getPassword().equals(password)) {
			request.getSession().setAttribute("user", user);
			System.out.println(user);
			// 到时候可以通过这种方式先把值保存起来,再通过jsp取出来
			request.setAttribute("user", user);
			JSONObject jsonObject = new JSONObject();
			jsonObject.accumulate("name", user.getName());
			jsonObject.accumulate("no", no);
			response.getWriter().println(jsonObject);
			if (auto != null) {
				cookieUtil.addCookie("no", no);
				cookieUtil.addCookie("password", password);
			}
			System.out.println("登录成功");
		} else {
			System.out.println("登录失败");
		}

	}
	
	@RequestMapping("logout")
	public void login(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.getSession().removeAttribute("user");
		System.out.println("退出成功");
	}

	@RequestMapping("register")
	public void signup(HttpServletResponse response,User user) throws IOException{
		if(userService.insert(user)>0){
			response.getWriter().println("ok");
			System.out.println("注册成功");
		}else{
			System.out.println("注册失败");
		}
	}
	
	@RequestMapping("checkDuplicate")
	public void checkDuplicate(HttpServletResponse response,String no) throws IOException{
		if(userService.selectByNo(no)==null){
			response.getWriter().println("ok");
		}
	}
	
	@RequestMapping("getUserInfo")
	public void getUserInfo(HttpServletResponse response,HttpServletRequest request) throws Exception{
		JSONObject jsonObject = new JSONObject();
		User user=(User) request.getSession().getAttribute("user");
		if(user==null){
			return;
		}
		jsonObject.accumulate("name", user.getName());
		jsonObject.accumulate("no", user.getNo());
		response.getWriter().println(jsonObject);
	}
	@RequestMapping("adminlogin")
	public String adminlogin(HttpServletRequest request,String no,String password){
		Manager manager=managerDao.selectByNo(no);
		if(manager!=null&&manager.getPassword().equals(password)){
			System.out.println("管理员登录成功");
			return "forward:info.do";
		}
		System.out.println("管理员登录失败");
		request.setAttribute("msg", "账号或密码错误");
		return "login";
	}
}
