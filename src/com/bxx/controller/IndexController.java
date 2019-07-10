package com.bxx.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bxx.bean.Product;
import com.bxx.dao.ProductDao;
@Controller
public class IndexController {
	@Autowired
	private ProductDao productDao;
	@RequestMapping("index")
	public String index(HttpServletRequest request){
		List<Product> products=productDao.selectAll();
		request.setAttribute("products", products);
		return "index";
	}
}
