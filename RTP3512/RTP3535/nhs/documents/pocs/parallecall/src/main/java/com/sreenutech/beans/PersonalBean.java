package com.sreenutech.beans;

public class PersonalBean {
	private String name;
	private String homeAddress;
	private String mobile;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "PersonalBean [name=" + name + ", homeAddress=" + homeAddress + ", mobile=" + mobile + "]";
	}

}
