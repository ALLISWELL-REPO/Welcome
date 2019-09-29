package org.nhs.patientinfosrv.service.builders;

import org.apache.log4j.Logger;
import org.nhs.patientinfo.process.ValueBeans.PatientInfoProcessVbReq;
import org.nhs.patientinfo.v1.schemas.req.PatientInfoReqType;

public class PatientInfoReqBuilder {

	public PatientInfoProcessVbReq buildProcessReq(PatientInfoReqType wsReq) {
		Logger logger = Logger.getLogger(PatientInfoReqBuilder.class);
		logger.debug("enter into Request Builder");
		PatientInfoProcessVbReq vReq = new PatientInfoProcessVbReq();
		vReq.setPatientId(wsReq.getPatientDetails().getPatientId());
		vReq.setFname(wsReq.getPatientDetails().getFname());
		vReq.setLname(wsReq.getPatientDetails().getLname());
		vReq.setDob(wsReq.getPatientDetails().getDob());
		vReq.setGender(wsReq.getPatientDetails().getGender());
		vReq.setAddress(wsReq.getPatientDetails().getAddress());
		vReq.setMobnum(wsReq.getPatientDetails().getMobnum());
		vReq.setRequestId(wsReq.getPatientContext().getRequestId());
		vReq.setSourceName(wsReq.getPatientContext().getSourceName());
		logger.debug("complite Building");
		return vReq;
	}

	/*
	 * public PatientInfoReqType buildProcessReq(PatientInfoReqType wsReq) {
	 * PatientInfoProcessVbReq vReq=new PatientInfoProcessVbReq();
	 * vReq.setPatientId(wsReq.getPatientDetails().getPatientId());
	 * vReq.setFname(wsReq.getPatientDetails().getFname());
	 * vReq.setLname(wsReq.getPatientDetails().getLname());
	 * vReq.setDob(wsReq.getPatientDetails().getDob());
	 * vReq.setGender(wsReq.getPatientDetails().getGender());
	 * vReq.setAddress(wsReq.getPatientDetails().getAddress());
	 * vReq.setMobnum(wsReq.getPatientDetails().getMobnum());
	 * vReq.setRequestId(wsReq.getPatientContext().getRequestId());
	 * vReq.setSourceName(wsReq.getPatientContext().getSourceName());
	 * 
	 * 
	 * return vReq;
	 */

}
