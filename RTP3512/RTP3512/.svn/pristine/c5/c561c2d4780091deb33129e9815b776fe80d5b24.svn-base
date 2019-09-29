package org.nhs.patientinfo.beans;

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
	private String FirstName;
	@Column(name = "last_name")
	private String Lastname;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date Date_of_birth;
	@Column(name = "gender")
	private String gender;
	@Column(name = "nhs_number")
	private int nhs_number;
	@Column(name = "postal_code")
	private int postal_code;
	@Column(name = "created_by")
	private String createdBy;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@Column(name = "update_by")
	private String update_by;
	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date update_date;

}
