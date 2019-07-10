package com.bxx.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.bxx.bean.Oderform;
import com.bxx.bean.Product;
import com.bxx.bean.Sharing;
import com.bxx.bean.User;
import com.bxx.bean.UserSharing;
import com.bxx.dao.OderformDao;
import com.bxx.dao.ProductDao;
import com.bxx.dao.SharingDao;
import com.bxx.dao.UserDao;
import com.bxx.dao.UserSharingDao;
@Component
public class SpringBean {
	@Autowired
	private UserDao userDao;
	@Autowired
	private SharingDao sharingDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private UserSharingDao userSharingDao;
	@Autowired
	private OderformDao oderformDao;
	public static void main(String[] args) {
		ApplicationContext  applicationContext=new FileSystemXmlApplicationContext("WebContent/WEB-INF/spring.xml");
		SpringBean springBean=(SpringBean) applicationContext.getBean("springBean");
		
		
//		Sharing sharing=springBean.sharingDao.selectById(1);
//		List<Oderform> oderforms = sharing.getOderforms();
//		System.out.println();
		
		Oderform oderform=springBean.oderformDao.selectById(82);
		System.out.println(oderform.getSharing().getId());
		
//		UserSharing userSharing=springBean.userSharingDao.selectById(2);
//		UserSharing userSharing2=new UserSharing();
//		userSharing2.setSharingId(3);
//		userSharing2.setUserId(1);
//		springBean.userSharingDao.insert(userSharing2);
//		System.out.println(userSharing2);
//		Product product=springBean.productDao.selectById(1);
//		System.out.println(product);
//		System.out.println(product);
//		springBean.productDao.insert(product);
//		User user=springBean.userDao.selectById(27);
//		System.out.println(user);
//		user.setNo("iiii");
//		springBean.userDao.insert(user);
		
//		System.out.println("aaa".equals((springBean.userDao.selectById(26).getId())));
//		User user=springBean.userDao.selectByNo("aaa");
//		System.out.println(user);
//		Sharing sharing=springBean.sharingDao.selectById(1);
//		System.out.println(sharing);
//		Sharing sharing=new Sharing();
//		sharing.setId(1);
//		user.setSharing(sharing);
//		springBean.userDao.update(user);
//		user.setAddress("qd");
//		springBean.userDao.update(user);
//		springBean.userDao.delete(5);
//		springBean.userDao.delete(6);
//		springBean.userDao.insert(user);
	}
}
