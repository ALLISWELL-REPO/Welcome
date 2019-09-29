package org.nhs.patientinfo.controller.builders;

import java.util.ArrayList;
import java.util.List;

import org.nhs.patientdaodetails.beans.PatientDetailsDAORes;
import org.nhs.patientinfo.controller.beans.PatientDetailsRes;

public class PatientDetailsRsrcResBuilder {
	public List<PatientDetailsRes> buildDAORes(List<PatientDetailsDAORes> res) {
		List<PatientDetailsRes> detailsResp = new ArrayList<PatientDetailsRes>();
		PatientDetailsRes response = null;
		for (PatientDetailsDAORes patientDaoRes : res) {
			response = new PatientDetailsRes();
			response.setCreatedBy(patientDaoRes.getCreatedBy());
			response.setCreatedDate(patientDaoRes.getCreatedDate());
			response.setDOB(patientDaoRes.getDateofBirth());
			response.setFname(patientDaoRes.getFirstName());
			response.setGender(patientDaoRes.getGender());
			response.setId(patientDaoRes.getId());
			response.setLname(patientDaoRes.getLastName());
			response.setNationalIdentifierType(patientDaoRes.getNationalIdentifierType());
			response.setNationalPatientId(patientDaoRes.getNationalPatientId());
			response.setNhsNumber(patientDaoRes.getNhsNumber());
			response.setPostalCode(patientDaoRes.getPostalCode());
			response.setUpdatedBy(patientDaoRes.getUpdatedBy());
			response.setUpdatedDate(patientDaoRes.getUpdatedDate());
			detailsResp.add(response);
		}
		return detailsResp;
	}
}
