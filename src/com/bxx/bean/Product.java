package com.bxx.bean;

import java.util.List;

public class Product {
	private int id;
	private String no;
	private String name;
	private double price;
	private String photo;
	private String size;
	private int sales;
	private int inventory;
	private String classify;
	private List<Comment> comments;
	private Specification specification;
	private List<Sharing> sharings;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	public int getInventory() {
		return inventory;
	}
	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public Specification getSpecification() {
		return specification;
	}
	public void setSpecification(Specification specification) {
		this.specification = specification;
	}
	public List<Sharing> getSharings() {
		return sharings;
	}
	public void setSharings(List<Sharing> sharings) {
		this.sharings = sharings;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", no=" + no + ", name=" + name + ", price=" + price + ", photo=" + photo
				+ ", size=" + size + ", sales=" + sales + ", inventory=" + inventory + ", classify=" + classify
				+ ", comments=" + comments + ", specification=" + specification + ", sharings=" + sharings + "]";
	}
	public String getClassify() {
		return classify;
	}
	public void setClassify(String classify) {
		this.classify = classify;
	}
	
}	
