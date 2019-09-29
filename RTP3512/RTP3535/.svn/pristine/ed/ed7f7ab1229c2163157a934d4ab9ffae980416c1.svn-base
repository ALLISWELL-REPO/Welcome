package org.nhs.patientdaodetails.builders;

import java.util.ArrayList;
import java.util.List;

import org.nhs.patientdaodetails.beans.PatientDetailsDAORes;
import org.nhs.patientdaodetails.entities.PatientDetails;

public class PatientDetailsDAOResBuilder {

	public List<PatientDetailsDAORes> buildPatientDetailsRes(List<PatientDetails> res) {

		List<PatientDetailsDAORes> pdaoRes = new ArrayList<PatientDetailsDAORes>();
		PatientDetailsDAORes response = null;
		for (PatientDetails pd : res) {
			response = new PatientDetailsDAORes();
			response.setCreatedBy(pd.getCreatedBy());
			if (pd.getCreatedDate() != null && pd.getUpdatedDate() != null & pd.getId() != null
					&& pd.getDOB() != null) {
				response.setCreatedDate(pd.getCreatedDate().toString());
				response.setId(pd.getId().toString());
				response.setDateofBirth(pd.getDOB().toString());
				response.setUpdatedDate(pd.getUpdatedDate().toString());
			}

			response.setFirstName(pd.getFname());
			response.setGender(pd.getGender());

			response.setLastName(pd.getLname());
			response.setNationalIdentifierType(pd.getNationalIdentifierType());
			response.setNationalPatientId(pd.getNationalPatientId());
			response.setNhsNumber(pd.getNhsNumber());
			response.setPostalCode(pd.getPostalCode());
			response.setUpdatedBy(pd.getUpdatedBy());

			pdaoRes.add(response);

		}
		return pdaoRes;

	}

}
