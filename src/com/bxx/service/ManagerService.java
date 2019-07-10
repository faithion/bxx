package com.bxx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bxx.bean.Manager;
import com.bxx.dao.ManagerDao;

@Service
public class ManagerService {
	@Autowired
	private ManagerDao managerDao;
	public List<Manager> selectAllManagers(){
		return managerDao.selectAll();
	}
	public Manager selectByNo(String no) {
		
		return null;
	}

}
