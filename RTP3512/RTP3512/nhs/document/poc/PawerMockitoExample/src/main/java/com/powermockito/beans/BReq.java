package com.powermockito.beans;

public class BReq {
	private int nhsNumber;
	private int patientid;
	private String firstName;
	private String lastName;
	private String gender;
	public int getNhsNumber() {
		return nhsNumber;
	}
	public void setNhsNumber(int nhsNumber) {
		this.nhsNumber = nhsNumber;
	}
	public int getPatientid() {
		return patientid;
	}
	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "BReq [nhsNumber=" + nhsNumber + ", patientid=" + patientid + ", firstName=" + firstName + ", lastName="
				+ lastName + ", gender=" + gender + "]";
	}
	
}
