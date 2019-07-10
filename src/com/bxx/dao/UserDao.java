package com.bxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bxx.bean.User;

public interface UserDao {
	List<User> selectAll();
	User selectById(int id);
	User selectByNo(String no);
	int insert(@Param("user")User user);
	int delete(int id);
	int update(@Param("user")User user);
}
