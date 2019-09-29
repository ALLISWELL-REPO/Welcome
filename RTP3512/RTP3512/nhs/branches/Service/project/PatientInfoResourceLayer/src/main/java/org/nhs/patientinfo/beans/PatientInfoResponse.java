package org.nhs.patientinfo.beans;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
@JsonSerialize(include=Inclusion.NON_NULL)
public class PatientInfoResponse {
	@JsonProperty("patient_Id")
	private int patientId;
	@JsonProperty("first_name")
	private String FirstName;
	@JsonProperty("last_name")
	private String Lastname;
	@JsonProperty("date_of_birth")
	private Date Date_of_birth;
	@JsonProperty("gender")
	private String gender;
	@JsonProperty("nhs_number")
	private int nhs_number;
	@JsonProperty("postal_code")
	private int postal_code;
	@JsonProperty("created_by")
	private String createdBy;
	@JsonProperty("created_ate")
	private Date createdDate;
	@JsonProperty("update_by")
	private String update_by;
	@JsonProperty("update_date")
	private  Date update_date;
}
