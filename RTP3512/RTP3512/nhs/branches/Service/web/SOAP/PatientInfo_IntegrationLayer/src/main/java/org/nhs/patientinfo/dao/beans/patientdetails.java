package org.nhs.patientinfo.dao.beans;

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
@Table(name = "patientdetails")
public class patientdetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int patientId;
	@Column(name = "first_name")
	private String first_name;
	@Column(name = "last_name")
	private String last_name;
	@Column(name = "gender")
	private String gender;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_of_birth;
	@Column(name = "nhs_number")
	private int nhs_number;
	@Column(name = "postal_code")
	private int postal_code;
	@Column(name = "created_by")
	private String created_by;
	@Column(name = "update_by")
	private String update_by;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_date;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date update_date;
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
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
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public String getUpdate_by() {
		return update_by;
	}
	public void setUpdate_by(String update_by) {
		this.update_by = update_by;
	}
	public Date getCreated_date() {
		return created_date;
	}
	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	@Override
	public String toString() {
		return "patientdetails [patientId=" + patientId + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", gender=" + gender + ", date_of_birth=" + date_of_birth + ", nhs_number=" + nhs_number
				+ ", postal_code=" + postal_code + ", created_by=" + created_by + ", update_by=" + update_by
				+ ", created_date=" + created_date + ", update_date=" + update_date + "]";
	}
	 

}
