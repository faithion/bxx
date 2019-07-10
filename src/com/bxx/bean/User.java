package com.bxx.bean;

import java.util.List;

public class User {
	private int id;
	private String no;
	private String name;
	private String password;
	private String contact;
	private String address;
	private List<Sharing> sharings;
	private List<Oderform> oderforms;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Sharing> getSharings() {
		return sharings;
	}

	public void setSharings(List<Sharing> sharings) {
		this.sharings = sharings;
	}

	public List<Oderform> getOderforms() {
		return oderforms;
	}

	public void setOderforms(List<Oderform> oderforms) {
		this.oderforms = oderforms;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", no=" + no + ", name=" + name + ", password=" + password + ", contact=" + contact
				+ ", address=" + address + ", sharings=" + sharings + ", oderforms=" + oderforms + "]";
	}
}
