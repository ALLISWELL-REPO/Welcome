/**
 * NHS Technologies.All Rights are reserved @Copy Rights are reserved.
You should not disclose the information outside otherwise
 terms and conditions will apply
 */
package org.nhs.patientinfo.service.builders;

import org.nhs.patientinfo.process.valuebeans.PatientInfoProcessVbRes;
import org.nhs.patientinfo.v1.schemas.resp.PatientInfoResType;
import org.nhs.patientinfo.v1.schemas.resp.StatusType;

public class PatientInfoSvcResBuilder {

	/**
	 * @param vbResp
	 * @return
	 */
	public PatientInfoResType buildwsResp(final PatientInfoProcessVbRes vbResp) {
		final PatientInfoResType wsResp = new PatientInfoResType();
		final StatusType status = new StatusType();
		status.setResCode(vbResp.getRespCode());
		status.setRespMsg(vbResp.getRespMsg());
		wsResp.setStatus(status);
		return wsResp;
	}

}
