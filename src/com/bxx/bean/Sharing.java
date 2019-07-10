package com.bxx.bean;

import java.util.List;

public class Sharing {
	private int id;
	private String no;
	private Product product;
	private int unum;
	private int uleft;
	private float discount;
	private String time;
	private List<User> users;
	private List<Oderform> oderforms;
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getUnum() {
		return unum;
	}
	public void setUnum(int unum) {
		this.unum = unum;
	}
	public int getUleft() {
		return uleft;
	}
	public void setUleft(int uleft) {
		this.uleft = uleft;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	@Override
	public String toString() {
		return "Sharing [id=" + id + ", no=" + no + ", product=" + product + ", unum=" + unum + ", uleft=" + uleft
				+ ", discount=" + discount + ", time=" + time + ", users=" + users + ", oderforms=" + oderforms + "]";
	}
	public List<Oderform> getOderforms() {
		return oderforms;
	}
	public void setOderforms(List<Oderform> oderforms) {
		this.oderforms = oderforms;
	}
	
	
}
