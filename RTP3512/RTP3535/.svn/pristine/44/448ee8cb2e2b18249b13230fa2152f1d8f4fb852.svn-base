package org.nhs.patientdaodetails.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "patient")
public class PatientDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column
	private String fname;

	@Column
	private String lname;

	@Column
	private String postalCode;

	@Column
	private String gender;

	@Column
	private String nationalIdentifierType;

	@Column
	private String nationalPatientId;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date DOB;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedDate;

	@Column
	private String createdBy;

	@Column
	private String updatedBy;

	@Column
	private String nhsNumber;

	@Column
	private String status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PatientDetails [id=");
		builder.append(id);
		builder.append(", fname=");
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
		builder.append(", status=");
		builder.append(status);
		builder.append(", getId()=");
		builder.append(getId());
		builder.append(", getFname()=");
		builder.append(getFname());
		builder.append(", getLname()=");
		builder.append(getLname());
		builder.append(", getPostalCode()=");
		builder.append(getPostalCode());
		builder.append(", getGender()=");
		builder.append(getGender());
		builder.append(", getNationalIdentifierType()=");
		builder.append(getNationalIdentifierType());
		builder.append(", getNationalPatientId()=");
		builder.append(getNationalPatientId());
		builder.append(", getDOB()=");
		builder.append(getDOB());
		builder.append(", getCreatedDate()=");
		builder.append(getCreatedDate());
		builder.append(", getUpdatedDate()=");
		builder.append(getUpdatedDate());
		builder.append(", getCreatedBy()=");
		builder.append(getCreatedBy());
		builder.append(", getUpdatedBy()=");
		builder.append(getUpdatedBy());
		builder.append(", getNhsNumber()=");
		builder.append(getNhsNumber());
		builder.append(", getStatus()=");
		builder.append(getStatus());
		builder.append(", getClass()=");
		builder.append(getClass());
		builder.append(", hashCode()=");
		builder.append(hashCode());
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}

}
