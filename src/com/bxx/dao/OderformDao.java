package com.bxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bxx.bean.Oderform;


public interface OderformDao {
	List<Oderform> selectAll();
	Oderform selectById(int id);
	Oderform selectByNo(String no);
	int insert(@Param("oderform")Oderform oderform);
	int delete(int id);
	int update(@Param("oderform")Oderform oderform);
	List<Oderform> selectByUser_d(int user_id);
}
