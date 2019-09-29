/**
 * NHS.All Rights are reserved @Copy Rights are reserved.
You should not disclose the information outside otherwise
 terms and conditions will apply
 */
package org.nhs.patientinfo.controller;

import org.nhs.patientinfo.service.client.PatientInfoSvcClient;
import org.nhs.patientinfo.service.client.beans.PatientInfoWebReq;
import org.nhs.patientinfo.service.client.beans.PatientInfoWebResp;
import org.nhs.patientinfo.service.client.impl.PatientInfoSvcClientImpl;

/**
 * @author: Stech
 * @Date : Mar 6, 2018 Description:
 */
public class PatientInfoController {

	public String patientInfo() {
		// 1. Get the csv file
		// 2. Iterate the data from file and prepare svcClientReq
		// call the service client
		PatientInfoWebReq webReq = new PatientInfoWebReq();
		PatientInfoSvcClient svcClient = new PatientInfoSvcClientImpl();
		PatientInfoWebResp webResp = svcClient.createPatient(webReq);
		//Store this webResp into session or reqscope
		//send to success.jsp or error.jsp
		return null;
	}
}
