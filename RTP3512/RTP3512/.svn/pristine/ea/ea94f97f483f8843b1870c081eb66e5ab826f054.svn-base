package org.nhs.patientinfo.dao.Impl;

import org.apache.log4j.Logger;
import org.nhs.patientinfo.dao.PatientInfoDao;
import org.nhs.patientinfo.dao.Util.BeginessException;
import org.nhs.patientinfo.dao.Util.SystemException;
import org.nhs.patientinfo.dao.Util.UnKnownException;
import org.nhs.patientinfo.dao.beans.PatientInfoDaoReq;
import org.nhs.patientinfo.dao.beans.PatientInfoDaoRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class PatientInfoDaoImpl implements PatientInfoDao {
	@Autowired
	private PatientInfoDaoRes dbRes;
   Logger logger=Logger.getLogger("PatientInfoDaoImpl.class");
	// 1.get the Request from ProsessLayer
	// 2.Prepare for Request from Database;
	// 3.Call the dataBase and get the ResultSet;
	// 4.Convert ResultSet Object To PateintInfoDaoResObject
	public PatientInfoDaoRes createPatient(PatientInfoDaoReq dreq)
			throws BeginessException, SystemException, UnKnownException {
		         
		String respCode = "0";
		String respMsg = "success";
		if ("0".equals(respCode))

		{
			logger.info("response:" + respMsg);
		}

		else if ("100".equals(respCode) || "101".equals(respCode)
				|| "103".equals(respCode)) {
			throw new BeginessException(respCode, respMsg);
		} else if ("110".equals(respCode) || "112".equals(respCode)
				|| "124".equals(respCode)) {
			throw new SystemException(respCode, respMsg);
		} else {
			throw new UnKnownException(respCode, respMsg);
		}

		logger.info("this is integration layer");
		dbRes.setResMsg("successful inserted data in table");
		dbRes.setRespCode("P1000243");
		logger.info("exit in integration layer" + dbRes);
		return dbRes;
	}

}
