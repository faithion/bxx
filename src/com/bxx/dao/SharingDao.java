package com.bxx.dao;

import org.apache.ibatis.annotations.Param;

import com.bxx.bean.Sharing;
import com.bxx.bean.User;

public interface SharingDao {
	Sharing selectById(int id);
	Sharing selectByNo(String no);
	int insert(@Param("sharing")Sharing sharing);
	int delete(int id);
	int update(@Param("sharing")Sharing sharing);
}
