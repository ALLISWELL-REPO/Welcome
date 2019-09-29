package com.sreenutech.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OffersBean {
	
	//@JsonProperty("order_id")
	private String oid;
	@JsonProperty("order_name")
	private String ordername;
	@JsonProperty("o_desc")
	private String desc;
	@JsonProperty("type")
	private String type;
	private String instock;
	public String getOid() {
		return oid;
	}
	
	@JsonSetter("order_id")
	public void setOid(String oid) {
		this.oid = oid;
	}
	
	public String getOrdername() {
		return ordername;
	}
	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getInstock() {
		return instock;
	}
	public void setInstock(String instock) {
		this.instock = instock;
	}
	@Override
	public String toString() {
		return "OffersBean [oid=" + oid + ", ordername=" + ordername + ", desc=" + desc + ", type=" + type
				+ ", instock=" + instock + "]";
	}
	
	

}
