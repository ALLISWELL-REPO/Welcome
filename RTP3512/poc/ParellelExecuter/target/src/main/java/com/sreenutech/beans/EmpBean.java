package com.sreenutech.beans;

public class EmpBean {
	private String salary;
	private String officeAddress;
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EmpBean [salary=");
		builder.append(salary);
		builder.append(", officeAddress=");
		builder.append(officeAddress);
		builder.append("]");
		return builder.toString();
	}
	

}
