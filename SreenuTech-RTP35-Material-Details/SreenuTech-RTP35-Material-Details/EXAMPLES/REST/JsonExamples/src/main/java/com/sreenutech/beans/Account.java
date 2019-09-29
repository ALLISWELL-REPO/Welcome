package com.sreenutech.beans;

import org.codehaus.jackson.annotate.JsonIgnoreType;

@JsonIgnoreType
public class Account {
	private double bal;
	private String accNum;
	public double getBal() {
		return bal;
	}
	public void setBal(double bal) {
		this.bal = bal;
	}
	public String getAccNum() {
		return accNum;
	}
	public void setAccNum(String accNum) {
		this.accNum = accNum;
	}
	

}
