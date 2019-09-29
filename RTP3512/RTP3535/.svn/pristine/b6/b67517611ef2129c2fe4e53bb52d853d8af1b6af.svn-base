package org.nhs.patientdaodetails.builders;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.nhs.patientdaodetails.beans.PatientDetailsDAOReq;
import org.nhs.patientdaodetails.entities.PatientDetails;

public class PatientDetailsDAOReqBuilder {
	PatientDetails pd_Dtls = new PatientDetails();

	public PatientDetails buildPatientDetailsReq(PatientDetailsDAOReq req) throws ParseException {
		Date createdDate = null;
		Date updatedDate = null;
		Date dob = null;
		if (req.getCreatedDate() != null && req.getUpdatedDate() != null && req.getDateofBirth() != null) {
			createdDate = new SimpleDateFormat("dd-MM-yyyy").parse(req.getCreatedDate());
			updatedDate = new SimpleDateFormat("dd-MM-yyyy").parse(req.getUpdatedDate());
			dob = new SimpleDateFormat("dd-MM-yyyy").parse(req.getDateofBirth());
		}
		pd_Dtls.setCreatedBy(req.getCreatedBy());

		pd_Dtls.setCreatedDate(createdDate);
		pd_Dtls.setUpdatedDate(updatedDate);
		pd_Dtls.setDOB(dob);

		pd_Dtls.setId(Integer.parseInt(req.getId()));
		pd_Dtls.setFname(req.getFirstName());
		pd_Dtls.setGender(req.getGender());
		pd_Dtls.setLname(req.getLastName());
		pd_Dtls.setNationalIdentifierType(req.getNationalIdentifierType());
		pd_Dtls.setNationalPatientId(req.getNationalPatientId());
		pd_Dtls.setNhsNumber(req.getNhsNumber());
		pd_Dtls.setPostalCode(req.getPostalCode());
		pd_Dtls.setUpdatedBy(req.getUpdatedBy());

		return pd_Dtls;

	}

	public PatientDetails buildPatientDetailsSearchReq(PatientDetailsDAOReq req) throws ParseException {
		Date dob1 = null;
		if (req.getDateofBirth() != null) {
			dob1 = new SimpleDateFormat("dd-MM-yyyy").parse(req.getDateofBirth());
		}
		pd_Dtls.setDOB(dob1);
		pd_Dtls.setNhsNumber(req.getNhsNumber());
		pd_Dtls.setFname(req.getFirstName());
		pd_Dtls.setLname(req.getLastName());
		pd_Dtls.setGender(req.getGender());
		pd_Dtls.setPostalCode(req.getPostalCode());
		return pd_Dtls;
	}
}
