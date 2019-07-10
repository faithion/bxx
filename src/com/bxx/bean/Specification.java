package com.bxx.bean;

public class Specification {
	private int id;
	private String no;
	private String cailiao;
	private String guige;
	private String color;
	private String pinpai;
	private String shiheage;
	@Override
	public String toString() {
		return "Specification [id=" + id + ", no=" + no + ", cailiao=" + cailiao + ", guige=" + guige + ", color="
				+ color + ", pinpai=" + pinpai + ", shiheage=" + shiheage + ", shangshitime=" + shangshitime
				+ ", weight=" + weight + ", producer=" + producer + ", shelf_life=" + shelf_life + ", product="
				+ product + ", gongneng=" + gongneng + ", others=" + others + ", getId()=" + getId() + ", getNo()="
				+ getNo() + ", getCailiao()=" + getCailiao() + ", getGuige()=" + getGuige() + ", getColor()="
				+ getColor() + ", getPinpai()=" + getPinpai() + ", getShiheage()=" + getShiheage()
				+ ", getShangshitime()=" + getShangshitime() + ", getWeight()=" + getWeight() + ", getProducer()="
				+ getProducer() + ", getShelf_life()=" + getShelf_life() + ", getProduct()=" + getProduct()
				+ ", getGongneng()=" + getGongneng() + ", getOthers()=" + getOthers() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
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
	public String getCailiao() {
		return cailiao;
	}
	public void setCailiao(String cailiao) {
		this.cailiao = cailiao;
	}
	public String getGuige() {
		return guige;
	}
	public void setGuige(String guige) {
		this.guige = guige;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getPinpai() {
		return pinpai;
	}
	public void setPinpai(String pinpai) {
		this.pinpai = pinpai;
	}
	public String getShiheage() {
		return shiheage;
	}
	public void setShiheage(String shiheage) {
		this.shiheage = shiheage;
	}
	public String getShangshitime() {
		return shangshitime;
	}
	public void setShangshitime(String shangshitime) {
		this.shangshitime = shangshitime;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public String getShelf_life() {
		return shelf_life;
	}
	public void setShelf_life(String shelf_life) {
		this.shelf_life = shelf_life;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getGongneng() {
		return gongneng;
	}
	public void setGongneng(String gongneng) {
		this.gongneng = gongneng;
	}
	public String getOthers() {
		return others;
	}
	public void setOthers(String others) {
		this.others = others;
	}
	private String shangshitime;
	private String weight;
	private String producer;
	private String shelf_life;
	private Product product;
	private String gongneng;
	private String others;

	
}
