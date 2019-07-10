package com.bxx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bxx.bean.Product;

public interface ProductDao {
	List<Product> selectAll();
	Product selectById(int id);
	Product selectByNo(String no);
	List<Product> selectByClassify(String name);
	int insert(@Param("product")Product product);
	int delete(int id);
	int update(@Param("product")Product product);
	int u(@Param("id")int id,@Param("no")String no,@Param("name")String name,@Param("price")double price,
    		@Param("photo")String photo,@Param("inventory")int inventory,@Param("specification_id")int specification_id,
    		@Param("classify") String classify);
	
}
