package org.nhs.patientdaodetails.services;

import java.text.ParseException;
import java.util.List;

import org.nhs.patientdaodetails.beans.PatientDetailsDAOReq;
import org.nhs.patientdaodetails.beans.PatientDetailsDAORes;

public interface NHSPatientDetailsService {

	Integer createPatient(PatientDetailsDAOReq req) throws ParseException;

	List<PatientDetailsDAORes> searchPatient(PatientDetailsDAOReq req) throws ParseException;

	List<PatientDetailsDAORes> getPatient(Integer pid);

	void updatePatient(PatientDetailsDAOReq req) throws ParseException;
}
