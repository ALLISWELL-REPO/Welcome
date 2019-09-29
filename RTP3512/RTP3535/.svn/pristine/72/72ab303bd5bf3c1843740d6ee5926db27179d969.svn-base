/**
 * NHS Technologies.All Rights are reserved @Copy Rights are reserved.
You should not disclose the information outside otherwise
 terms and conditions will apply
 */
package org.nhs.patientinfo.process.impl;

import org.apache.log4j.Logger;
import org.nhs.patientinfo.dao.PatientInfoDAO;
import org.nhs.patientinfo.dao.beans.PatientInfoDAOReq;
import org.nhs.patientinfo.dao.beans.PatientInfoDAORes;
import org.nhs.patientinfo.dao.impl.PatientInfoDAOImpl;
import org.nhs.patientinfo.dao.util.BussinessException;
import org.nhs.patientinfo.dao.util.SystemException;
import org.nhs.patientinfo.dao.util.UnknownException;
import org.nhs.patientinfo.process.PatientInfoProcess;
import org.nhs.patientinfo.process.builders.PatientInfoProcessReqBuilder;
import org.nhs.patientinfo.process.builders.PatientInfoProcessResBuilder;
import org.nhs.patientinfo.process.valuebeans.PatientInfoProcessVbReq;
import org.nhs.patientinfo.process.valuebeans.PatientInfoProcessVbRes;


/**
 * @author: Stech
 * @Date : Feb 23, 2018 Description:
 */
public class PatientInfoProcessImpl implements PatientInfoProcess {

	private Logger logger=Logger.getLogger(PatientInfoProcessImpl.class);
	public PatientInfoProcessVbRes createPatient(PatientInfoProcessVbReq vbReq)
			throws BussinessException, SystemException, UnknownException {
		logger.info("Entered into Process Layer" + vbReq);
		// 1. Get the request from Service Layer
		// 2. Prepare the DAO request
		PatientInfoProcessReqBuilder reqProcessBuilder = new PatientInfoProcessReqBuilder();
		PatientInfoDAOReq daoReq = reqProcessBuilder.buildDaoRequest(vbReq);
		
		// 3. call the Dao Layer by passing DaoReq
		PatientInfoDAO dao = new PatientInfoDAOImpl();
		PatientInfoDAORes daoResp = dao.createPatient(daoReq);
		
		// 4. Need to convert daoResp to Process layer RespType
		PatientInfoProcessResBuilder respProcessBuilder = new PatientInfoProcessResBuilder();
		PatientInfoProcessVbRes vbResp= respProcessBuilder.buildvbResp(daoResp);
		logger.info("Exited from Process Layer" + vbReq);
		return vbResp;
	}

}
