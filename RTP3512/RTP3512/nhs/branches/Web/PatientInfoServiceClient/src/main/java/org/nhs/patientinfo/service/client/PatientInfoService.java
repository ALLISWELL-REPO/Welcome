package org.nhs.patientinfo.service.client;

import org.nhs.patientinfo.service.client.beans.PatientInfoWebReq;
import org.nhs.patientinfo.service.client.beans.PatientInfoWebRes;

public interface PatientInfoService {
	public PatientInfoWebRes createPatient(PatientInfoWebReq wReq);

}
