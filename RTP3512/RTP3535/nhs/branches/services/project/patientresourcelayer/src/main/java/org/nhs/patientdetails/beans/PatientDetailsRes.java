package org.nhs.patientdetails.beans;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;


@JsonSerialize(include=Inclusion.NON_NULL)
public class PatientDetailsRes {

	@JsonProperty("f_Name")
	private String fname;
	@JsonProperty("l_Name")
	private String lname;
	@JsonProperty("postal_Code")
	private String postalCode;
	@JsonProperty("gender")
	private String gender;
	@JsonProperty("national_Identifier_Type")
	private String nationalIdentifierType;
	@JsonProperty("national_Patient_Id")
	private String nationalPatientId;
	@JsonProperty("DOB")
	private String DOB;
	@JsonProperty("id")
	private String id;
	@JsonProperty("created_Date")
	private String createdDate;
	@JsonProperty("updated_Date")
	private String updatedDate;
	@JsonProperty("created_By")
	private String createdBy;
	@JsonProperty("updated_By")
	private String updatedBy;
	@JsonProperty("nhs_Number")
	private String nhsNumber;
	@JsonProperty("h_Num")
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
		builder.append("PatientDetailsReq [fname=");
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
