/**
 * NHS Technologies.All Rights are reserved @Copy Rights are reserved.
You should not disclose the information outside otherwise
 terms and conditions will apply
 */
package org.nhs.patientinfo.dao.impl;

import org.nhs.patientinfo.dao.PatientInfoDAO;
import org.nhs.patientinfo.dao.beans.PatientInfoDAOReq;
import org.nhs.patientinfo.dao.beans.PatientInfoDAORes;
import org.nhs.patientinfo.dao.util.BussinessException;
import org.nhs.patientinfo.dao.util.SystemException;
import org.nhs.patientinfo.dao.util.UnknownException;

/**
 * @author: Stech
 * @Date : Feb 23, 2018 Description:
 */
public class PatientInfoDAOImpl implements PatientInfoDAO {

	public PatientInfoDAORes createPatient(PatientInfoDAOReq daoreq) throws BussinessException, SystemException, UnknownException {
		System.out.println("Entered into Integration Layer"+daoreq);
		// 1. Get the request from process layer
		// 2. Prepare db request
		// 3. call DB by passing dbRequest
		// 4. Need to convert ResultSet object to PatientInfoDAORes object
		PatientInfoDAORes daoResp = new PatientInfoDAORes();
		System.out.println("Exited from Integration Layer"+daoreq);
		String dbRespcode="4657";
		String dbRespMsg="db bad error";
		if("0".equals(dbRespcode))
		{
			daoResp.setRespCode("0");
			daoResp.setRespMsg("SUCESS");
		}
		else if("100".equals(dbRespcode)||"101".equals(dbRespcode))
		{
			throw new BussinessException(dbRespcode, dbRespMsg);
		}
		else if("110".equals(dbRespcode)||"111".equals(dbRespcode))
		{
			throw new SystemException(dbRespcode, dbRespMsg);
		}
		else 
		{
			throw new UnknownException("db999", "unknown db error:"+dbRespMsg);
		}
		return daoResp;
	}

}
