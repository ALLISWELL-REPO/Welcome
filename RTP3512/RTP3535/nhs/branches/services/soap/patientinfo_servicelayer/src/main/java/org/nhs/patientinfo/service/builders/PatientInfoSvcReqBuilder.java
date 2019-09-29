/**
 * NHS Technologies.All Rights are reserved @Copy Rights are reserved.
You should not disclose the information outside otherwise
 terms and conditions will apply
 */
package org.nhs.patientinfo.service.builders;

import org.nhs.patientinfo.process.valuebeans.PatientInfoProcessVbReq;
import org.nhs.patientinfo.v1.schemas.req.PatientInfoReqType;

public class PatientInfoSvcReqBuilder {

	public PatientInfoProcessVbReq buildProcessRequest(final PatientInfoReqType wsReq) {

		final PatientInfoProcessVbReq vbReq = new PatientInfoProcessVbReq();
		
		vbReq.setAddress(wsReq.getPatientDetails().getAddress());
		vbReq.setAge(wsReq.getPatientDetails().getAge());
		vbReq.setDob(wsReq.getPatientDetails().getDob());
		vbReq.setFname(wsReq.getPatientDetails().getFname());
		vbReq.setGender(wsReq.getPatientDetails().getGender());
		vbReq.setLname(wsReq.getPatientDetails().getLname());
		vbReq.setMobnum(wsReq.getPatientDetails().getMobnum());
		vbReq.setPatientId(wsReq.getPatientDetails().getPatientId());
		return vbReq;
		// TODO Auto-generated method stub

	}

}
