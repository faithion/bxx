package com.bxx.bean;

public class Oderform {
	private int id;
	private String no;
	private String date;
	private int quantity;
	private String photo;
	private String status;
	private int total;
	private Product product;
	private User user;
	private Sharing sharing;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Sharing getSharing() {
		return sharing;
	}
	public void setSharing(Sharing sharing) {
		this.sharing = sharing;
	}
	@Override
	public String toString() {
		return "Oderform [id=" + id + ", no=" + no + ", date=" + date + ", quantity=" + quantity + ", photo=" + photo
				+ ", status=" + status + ", total=" + total + ", product=" + product + ", user=" + user + ", sharing="
				+ sharing + "]";
	}
    
	
}
