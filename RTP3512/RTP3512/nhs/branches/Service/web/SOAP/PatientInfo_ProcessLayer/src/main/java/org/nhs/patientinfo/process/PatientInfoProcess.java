package org.nhs.patientinfo.process;

import org.nhs.patientinfo.dao.Util.BeginessException;
import org.nhs.patientinfo.dao.Util.SystemException;
import org.nhs.patientinfo.dao.Util.UnKnownException;
import org.nhs.patientinfo.process.ValueBeans.PatientInfoProcessVbReq;
import org.nhs.patientinfo.process.ValueBeans.PatientInfoProcessVbRes;

public interface PatientInfoProcess {
	
 public PatientInfoProcessVbRes createPatient(PatientInfoProcessVbReq req) throws BeginessException, SystemException, UnKnownException;
	
}
