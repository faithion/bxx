package com.bxx.dao;

import java.util.List;

import com.bxx.bean.Manager;

public interface ManagerDao {
	
	List<Manager> selectAll();
	Manager selectById(int id);
	Manager selectByNo(String no);
}
