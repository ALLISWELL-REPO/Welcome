package org.nhs.patientinfo.dao.builder;

import java.util.Date;

import org.nhs.patientinfo.dao.beans.PatientInfoDaoReq;
import org.nhs.patientinfo.dao.beans.patientdetails;

public class PatientInfoRequestBuilder {
	public patientdetails createPatient(PatientInfoDaoReq daoReq) {
		patientdetails details = new patientdetails();
		details.setCreated_date(new Date());
		details.setCreated_by("deepak");
		details.setUpdate_by("deepak");
		details.setUpdate_date(new Date());
		details.setFirst_name(daoReq.getFname());
		details.setLast_name(daoReq.getLname());
		details.setGender(daoReq.getGender());
		// details.setDate_of_birth(daoReq.getDob());
		details.setPatientId(daoReq.getPatientId());
		details.setPostal_code(1251627);
		
		return details;

	}

}
