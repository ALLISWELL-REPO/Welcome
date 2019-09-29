package com.sreenutech.beans;

import org.codehaus.jackson.annotate.JsonIgnoreType;
@JsonIgnoreType
public class Order {
	private int oid;
	private String oname;
	private String otype;
	private boolean delviered;
	
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	public String getOtype() {
		return otype;
	}
	public void setOtype(String otype) {
		this.otype = otype;
	}
	public boolean isDelviered() {
		return delviered;
	}
	public void setDelviered(boolean delviered) {
		this.delviered = delviered;
	}
	
	
	
	

}
