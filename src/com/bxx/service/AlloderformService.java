package com.bxx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bxx.bean.Oderform;
import com.bxx.dao.OderformDao;


@Service
public class AlloderformService {
	
	@Autowired
	private OderformDao oderformDao;
	

	public List<Oderform> selectOderformByUser_d(int user_id) {
		System.out.println("oderformservice测试");
		return oderformDao.selectByUser_d(user_id);
	}


	

}
