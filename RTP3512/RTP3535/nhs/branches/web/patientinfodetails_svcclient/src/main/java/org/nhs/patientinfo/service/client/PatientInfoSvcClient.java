/**
 * NHS.All Rights are reserved @Copy Rights are reserved.
You should not disclose the information outside otherwise
 terms and conditions will apply
 */
package org.nhs.patientinfo.service.client;

import org.nhs.patientinfo.service.client.beans.PatientInfoWebReq;
import org.nhs.patientinfo.service.client.beans.PatientInfoWebResp;

/**
 * @author: Stech
 * @Date     :  Mar 6, 2018
 * Description:  
 */
public interface PatientInfoSvcClient {
PatientInfoWebResp createPatient(PatientInfoWebReq webReq);
}
