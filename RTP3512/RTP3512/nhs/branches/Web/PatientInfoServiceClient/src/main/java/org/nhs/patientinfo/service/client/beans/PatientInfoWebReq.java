package org.nhs.patientinfo.service.client.beans;

import javax.xml.datatype.XMLGregorianCalendar;

public class PatientInfoWebReq {
	protected String fname;
	protected String lname;
	protected XMLGregorianCalendar dob;
	protected String gender;
	protected int patientId;
	protected String mobnum;
	protected String address;
	protected String requestId;
	protected String sourceName;
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
	public XMLGregorianCalendar getDob() {
		return dob;
	}
	public void setDob(XMLGregorianCalendar dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getMobnum() {
		return mobnum;
	}
	public void setMobnum(String mobnum) {
		this.mobnum = mobnum;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRequestId() {
		return requestId;
	}
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PatientInfoWebReq [fname=");
		builder.append(fname);
		builder.append(", lname=");
		builder.append(lname);
		builder.append(", dob=");
		builder.append(dob);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", patientId=");
		builder.append(patientId);
		builder.append(", mobnum=");
		builder.append(mobnum);
		builder.append(", address=");
		builder.append(address);
		builder.append(", requestId=");
		builder.append(requestId);
		builder.append(", sourceName=");
		builder.append(sourceName);
		builder.append("]");
		return builder.toString();
	}
	

}
