package org.nhs.patientinfo.beans;

import java.util.Date;


public class PatientInfoDaoRequest {
		
	private int patientId;
	
	private String FirstName;
	
	private String Lastname;
	
	private Date Date_of_birth;
	
	private String gender;
	
	private int nhs_number;
	
	private int postal_code;

	private String createdBy;
	
	private Date createdDate;
	
	private String update_by;
	
	private  Date update_date;

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String lastname) {
		Lastname = lastname;
	}

	public Date getDate_of_birth() {
		return Date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		Date_of_birth = date_of_birth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getNhs_number() {
		return nhs_number;
	}

	public void setNhs_number(int nhs_number) {
		this.nhs_number = nhs_number;
	}

	public int getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(int postal_code) {
		this.postal_code = postal_code;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdate_by() {
		return update_by;
	}

	public void setUpdate_by(String update_by) {
		this.update_by = update_by;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	@Override
	public String toString() {
		return "PatientInfoDaoRequest [patientId=" + patientId + ", FirstName=" + FirstName + ", Lastname=" + Lastname
				+ ", Date_of_birth=" + Date_of_birth + ", gender=" + gender + ", nhs_number=" + nhs_number
				+ ", postal_code=" + postal_code + ", createdBy=" + createdBy + ", createdDate=" + createdDate
				+ ", update_by=" + update_by + ", update_date=" + update_date + "]";
	}
	
	
}
