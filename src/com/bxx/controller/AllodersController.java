package com.bxx.controller;

import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bxx.bean.Oderform;
import com.bxx.dao.SharingDao;
import com.bxx.service.AlloderformService;


@Controller
public class AllodersController {
	@Autowired
	private AlloderformService alloderformService;
	@Autowired
	private SharingDao sharingDao;
	
	@RequestMapping("alloderform")
	public String list(int user_id,Model model){
		System.out.println("alloderform测试");
		List<Oderform> oderform=alloderformService.selectOderformByUser_d(user_id);
		Collections.reverse(oderform);
		System.out.println(oderform);
		int len=oderform.size();
		model.addAttribute("oderforms", oderform);
		model.addAttribute("length",len);
		return "MyOrders";
	}
	
}