package com.bxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bxx.bean.Comment;

import java.util.Date;

public interface CommentDao {
	
	List<Comment> selectAll();
	Comment selectById(int id);
	Comment selectByNo(String no);
	int delete(int id);
	List<Comment> selectByP_Id(int product_id);
	Comment selectByP_id_U_id(@Param("product_id")int product_id, @Param("user_id")int user_id);
	void  updateStatus(int product_id);
	int insert(@Param("no")String no, @Param("time")String time, @Param("text")String text, @Param("product_id")int product_id,@Param("user_id")int user_id);
	int update(@Param("id")int id,@Param("no")String no, @Param("time")String time, @Param("text")String text, @Param("product_id")int product_id,@Param("user_id")int user_id);
}
