package com.sreenutech.beans;

public class UserDetails {
	private String uid;
	private String name;
	private String homeAddress;
	private String mobile;
	private String empName;
	private float salary;
	private String officeAddress;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
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
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public String getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}
	@Override
	public String toString() {
		return "UserDetails [uid=" + uid + ", name=" + name + ", homeAddress=" + homeAddress + ", mobile=" + mobile
				+ ", empName=" + empName + ", salary=" + salary + ", officeAddress=" + officeAddress + "]";
	}


	

}
