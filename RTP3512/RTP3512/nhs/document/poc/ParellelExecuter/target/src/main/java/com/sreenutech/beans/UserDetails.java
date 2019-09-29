package com.sreenutech.beans;

public class UserDetails {
	private String salary;
	private String officeAddress;
	private String uId;
	private String Fname;
	private String Lname;
	private String HomeAddress;
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public String getHomeAddress() {
		return HomeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		HomeAddress = homeAddress;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserDetails [salary=");
		builder.append(salary);
		builder.append(", officeAddress=");
		builder.append(officeAddress);
		builder.append(", uId=");
		builder.append(uId);
		builder.append(", Fname=");
		builder.append(Fname);
		builder.append(", Lname=");
		builder.append(Lname);
		builder.append(", HomeAddress=");
		builder.append(HomeAddress);
		builder.append("]");
		return builder.toString();
	}

}
