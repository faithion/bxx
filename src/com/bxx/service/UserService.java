package com.bxx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bxx.bean.User;
import com.bxx.dao.UserDao;
@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	public User selectByNo(String no){
		return userDao.selectByNo(no);
	}
	public int insert(User user){
		return userDao.insert(user);
	}
}
