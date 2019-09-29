/**
 * NHS Technologies.All Rights are reserved @Copy Rights are reserved.
You should not disclose the information outside otherwise
 terms and conditions will apply
 */
package org.nhs.patientinfo.process.builders;

import org.nhs.patientinfo.dao.beans.PatientInfoDAOReq;
import org.nhs.patientinfo.process.valuebeans.PatientInfoProcessVbReq;

/**
 * @author: Stech
 * @Date : Feb 23, 2018 Description:
 */
public class PatientInfoProcessReqBuilder {

	/**
	 * @param vbReq
	 * @return
	 */
	public PatientInfoDAOReq buildDaoRequest(PatientInfoProcessVbReq vbReq) {
		PatientInfoDAOReq daoReq = new PatientInfoDAOReq();

		daoReq.setAddress(vbReq.getAddress());
		daoReq.setAge(vbReq.getAge());
		daoReq.setDob(vbReq.getDob());
		daoReq.setFname(vbReq.getFname());
		daoReq.setGender(vbReq.getGender());
		daoReq.setLname(vbReq.getLname());
		daoReq.setMobnum(vbReq.getMobnum());
		daoReq.setPatientId(vbReq.getPatientId());

		return daoReq;
	}

}
