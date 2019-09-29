package org.nhs.patientinfo.controller.builders;

import org.nhs.patientdaodetails.beans.PatientDetailsDAOReq;
import org.nhs.patientinfo.controller.beans.PatientDetailsReq;

public class PatientDetailsRsrcReqBuilder {

	public PatientDetailsDAOReq buildDAOReq(PatientDetailsReq req) {
		PatientDetailsDAOReq daoReq = new PatientDetailsDAOReq();
		daoReq.setFirstName(req.getFname());
		daoReq.setLastName(req.getLname());
		daoReq.setPostalCode(req.getPostalCode());
		daoReq.setGender(req.getGender());
		daoReq.setNhsNumber(req.getNhsNumber());
		if(req.getDOB()!=null && req.getCreatedDate()!=null && req.getUpdatedDate()!=null )
		{
		daoReq.setDateofBirth(req.getDOB());
		daoReq.setCreatedDate(req.getCreatedDate());
		daoReq.setUpdatedDate(req.getUpdatedDate());
		}
		daoReq.setId(req.getId());
		
		daoReq.setCreatedBy(req.getCreatedBy());
		
		daoReq.setUpdatedBy(req.getUpdatedBy());
		daoReq.setNationalIdentifierType(req.getNationalIdentifierType());
		daoReq.setNationalPatientId(req.getNationalPatientId());
		return daoReq;
	}
}
