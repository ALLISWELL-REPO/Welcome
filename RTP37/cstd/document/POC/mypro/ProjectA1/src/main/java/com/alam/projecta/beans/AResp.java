package com.alam.projecta.beans;

public class AResp {
	private String desc;
	private float price;
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "AResp [desc=" + desc + ", price=" + price + "]";
	}
	

}
