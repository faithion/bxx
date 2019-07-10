package com.bxx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bxx.bean.Comment;
import com.bxx.bean.Oderform;
import com.bxx.service.CommentService;


@Controller
public class CommentOKController {
	@Autowired
	private CommentService commentService;
	
	@RequestMapping("commentok")
	public String commentok(int product_id,Model model){
		System.out.println(product_id);
		//查询数据
		List<Comment> comment=commentService.selectByP_id(product_id);
		System.out.println(comment);
		model.addAttribute("comments", comment);
		return "commentok";
	}
	

}
