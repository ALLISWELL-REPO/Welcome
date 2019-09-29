/**
 * NHS Technologies.All Rights are reserved @Copy Rights are reserved.
You should not disclose the information outside otherwise
 terms and conditions will apply
 */
package org.nhs.patientinfo.service.validator;

import org.apache.log4j.Logger;
import org.nhs.patientinfo.service.util.PatientInfoReqValidException;
import org.nhs.patientinfo.v1.schemas.req.PatientContextType;
import org.nhs.patientinfo.v1.schemas.req.PatientDetailsType;
import org.nhs.patientinfo.v1.schemas.req.PatientInfoReqType;

public class PatientInfoSvcValidator {

	private Logger logger=Logger.getLogger(PatientInfoSvcValidator.class);
	public void validateWSReq(PatientInfoReqType wsReq) throws PatientInfoReqValidException {
            logger.debug("validations started");
		if (wsReq == null || wsReq.getPatientContext() == null || wsReq.getPatientDetails() == null) {
			throw new PatientInfoReqValidException("pt001", "Req obj is null");
		}
		if (wsReq.getPatientContext().getRequestId() == null || "".equals(wsReq.getPatientContext().getRequestId())) {
			throw new PatientInfoReqValidException("pt002", "Request Id is invalid");
		}
		if (wsReq.getPatientContext().getSourceName() == null || "".equals(wsReq.getPatientContext().getSourceName())) {
			throw new PatientInfoReqValidException("pt003", "Source name is invalid");
		}

		if (wsReq.getPatientDetails().getFname() == null || "".equals(wsReq.getPatientDetails().getFname())) {
			throw new PatientInfoReqValidException("pt004", "Father name is invalid");
		}
		if (wsReq.getPatientDetails().getLname() == null || "".equals(wsReq.getPatientDetails().getLname())) {
			throw new PatientInfoReqValidException("pt005", "Last name is invalid");
		}
		if (wsReq.getPatientDetails().getDob() == 0 || "".equals(wsReq.getPatientDetails().getDob())) {
			throw new PatientInfoReqValidException("pt006", "DOB is invalid");
		}
		if (wsReq.getPatientDetails().getGender() == null || "".equals(wsReq.getPatientDetails().getGender())) {
			throw new PatientInfoReqValidException("pt007", "Gender is invalid");
		}
		if (wsReq.getPatientDetails().getPatientId() == 0 || "".equals(wsReq.getPatientDetails().getPatientId())) {
			throw new PatientInfoReqValidException("pt008", "Patient Id is invalid");
		}

		if (wsReq.getPatientDetails().getAge() == 0 || "".equals(wsReq.getPatientDetails().getAge())) {
			throw new PatientInfoReqValidException("pt009", "Age is invalid");
		}

		if (wsReq.getPatientDetails().getMobnum() == 0 || "".equals(wsReq.getPatientDetails().getMobnum())) {
			throw new PatientInfoReqValidException("pt010", "Mobile Number is invalid");
		}

		if (wsReq.getPatientDetails().getAddress() == null || "".equals(wsReq.getPatientDetails().getAddress())) {
			throw new PatientInfoReqValidException("pt011", "Address is invalid");
		}
		
        logger.debug("validations completed");

	}

}
