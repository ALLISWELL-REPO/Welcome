package com.sreenutech.beans;

public class EmpBean {
	private String empName;
	private float salary;
	private String officeAddress;

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
		return "EmpBean [empName=" + empName + ", salary=" + salary + ", officeAddress=" + officeAddress + "]";
	}

}
