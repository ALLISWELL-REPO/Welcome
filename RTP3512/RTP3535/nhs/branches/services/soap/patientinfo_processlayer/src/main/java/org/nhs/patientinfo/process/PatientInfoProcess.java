/**
 * NHS Technologies.All Rights are reserved @Copy Rights are reserved.
You should not disclose the information outside otherwise
 terms and conditions will apply
 */
package org.nhs.patientinfo.process;

import org.nhs.patientinfo.dao.util.BussinessException;
import org.nhs.patientinfo.dao.util.SystemException;
import org.nhs.patientinfo.dao.util.UnknownException;
import org.nhs.patientinfo.process.valuebeans.PatientInfoProcessVbReq;
import org.nhs.patientinfo.process.valuebeans.PatientInfoProcessVbRes;

/**
 * @author: Stech
 * @Date : Feb 23, 2018 Description:
 */
public interface PatientInfoProcess {
	PatientInfoProcessVbRes createPatient(PatientInfoProcessVbReq vbReq) throws BussinessException, SystemException, UnknownException;
}
