package org.nhs.patientdetails.beans;

import java.util.List;

public class PatientInfo {

	public List<PatientDetailsReq> patientInfo;

	public List<PatientDetailsReq> getPatientInfo() {
		return patientInfo;
	}

	public void setPatientInfo(List<PatientDetailsReq> patientInfo) {
		this.patientInfo = patientInfo;
	}

	@Override
	public String toString() {
		return "PatientInfo [patientInfo=" + patientInfo + "]";
	}
	
}
