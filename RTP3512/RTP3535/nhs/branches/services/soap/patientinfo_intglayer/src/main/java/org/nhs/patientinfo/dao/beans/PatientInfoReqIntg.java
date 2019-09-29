package org.nhs.patientinfo.dao.beans;

public class PatientInfoReqIntg {

	private String fname;
	private String lname;
	private String dob;
	private String sex;
	private Integer postalCode;
	private Integer hCode;
	private Integer hNum;

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}

	public Integer gethCode() {
		return hCode;
	}

	public void sethCode(Integer hCode) {
		this.hCode = hCode;
	}

	public Integer gethNum() {
		return hNum;
	}

	public void sethNum(Integer hNum) {
		this.hNum = hNum;
	}

}
