package org.patientdetails.controller.bean;

public class ResponseBean {
	private String fname;
	private String lname;
	private String postalCode;
	private String gender;
	private String nationalIdentifierType;
	private String nationalPatientId;
	private String DOB;
	private String id;
	private String createdDate;
	private String updatedDate;
	private String createdBy;
	private String updatedBy;
	private String nhsNumber;
	private String hnum;
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
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNationalIdentifierType() {
		return nationalIdentifierType;
	}
	public void setNationalIdentifierType(String nationalIdentifierType) {
		this.nationalIdentifierType = nationalIdentifierType;
	}
	public String getNationalPatientId() {
		return nationalPatientId;
	}
	public void setNationalPatientId(String nationalPatientId) {
		this.nationalPatientId = nationalPatientId;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getNhsNumber() {
		return nhsNumber;
	}
	public void setNhsNumber(String nhsNumber) {
		this.nhsNumber = nhsNumber;
	}
	public String getHnum() {
		return hnum;
	}
	public void setHnum(String hnum) {
		this.hnum = hnum;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ResponseBean [fname=");
		builder.append(fname);
		builder.append(", lname=");
		builder.append(lname);
		builder.append(", postalCode=");
		builder.append(postalCode);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", nationalIdentifierType=");
		builder.append(nationalIdentifierType);
		builder.append(", nationalPatientId=");
		builder.append(nationalPatientId);
		builder.append(", DOB=");
		builder.append(DOB);
		builder.append(", id=");
		builder.append(id);
		builder.append(", createdDate=");
		builder.append(createdDate);
		builder.append(", updatedDate=");
		builder.append(updatedDate);
		builder.append(", createdBy=");
		builder.append(createdBy);
		builder.append(", updatedBy=");
		builder.append(updatedBy);
		builder.append(", nhsNumber=");
		builder.append(nhsNumber);
		builder.append(", hnum=");
		builder.append(hnum);
		builder.append("]");
		return builder.toString();
	}
}
