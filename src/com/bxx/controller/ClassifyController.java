package com.bxx.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bxx.bean.Product;
import com.bxx.bean.User;
import com.bxx.dao.ProductDao;
import com.bxx.service.UserService;
import com.bxx.util.CookieUtil;

@Controller
public class ClassifyController {
	@Autowired
	private ProductDao productDao;

	@RequestMapping("classify")
	public String login(HttpServletRequest request, HttpServletResponse response, String name) throws Exception {
		System.out.println(name);
		List<Product> pList = productDao.selectByClassify(name);
		System.out.println(pList);
		request.setAttribute("list", pList);
		for(Product product:pList)
			System.out.println(product);

		return "classify";
	}

}
