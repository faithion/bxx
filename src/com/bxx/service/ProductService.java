package com.bxx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bxx.bean.Product;
import com.bxx.dao.ProductDao;
@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;
	
	
	//注入DAO方法
	//private ProductDao productDao;
	public List<Product> selectProducts(){
		return productDao.selectAll();
	}
	public String selectPhoto(int id) {
		
		return productDao.selectById(id).getPhoto();
	}

//查名字
	public String selectName(int id){
		return productDao.selectById(id).getName();
	}
	
//查价格
	public double selectPrice(int id) {
		
		return productDao.selectById(id).getPrice();
	}

//查销量
	public int addSales(int id) {
		
		return productDao.selectById(id).getSales();
	}

//查库存
	public int selectInventory(int id) {
		
		return productDao.selectById(id).getInventory();
	}

	



	



	


	
	
	
	
	

}
