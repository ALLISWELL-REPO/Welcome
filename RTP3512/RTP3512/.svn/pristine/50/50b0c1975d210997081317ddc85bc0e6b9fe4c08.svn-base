package org.nhs.patientinfo.process.Impl;

import org.apache.log4j.Logger;
import org.nhs.patientinfo.dao.PatientInfoDao;
import org.nhs.patientinfo.dao.Impl.PatientInfoDaoImpl;
import org.nhs.patientinfo.dao.Util.BeginessException;
import org.nhs.patientinfo.dao.Util.SystemException;
import org.nhs.patientinfo.dao.Util.UnKnownException;
import org.nhs.patientinfo.dao.beans.PatientInfoDaoReq;
import org.nhs.patientinfo.dao.beans.PatientInfoDaoRes;
import org.nhs.patientinfo.process.PatientInfoProcess;
import org.nhs.patientinfo.process.ValueBeans.PatientInfoProcessVbReq;
import org.nhs.patientinfo.process.ValueBeans.PatientInfoProcessVbRes;
import org.springframework.beans.factory.annotation.Autowired;


public class PatientInfoProcessImpl implements PatientInfoProcess {
	@Autowired
	private PatientInfoDaoReq daoReq;
	@Autowired
	private PatientInfoDaoRes daoRes;
	@Autowired
	private PatientInfoProcessVbRes vbres;
	private Logger logger = Logger.getLogger("PatientInfoProcessImpl.class");

	public PatientInfoProcessVbRes createPatient(PatientInfoProcessVbReq vreq)
			throws BeginessException, SystemException, UnKnownException {

		logger.info("enter into ProcessLayer:" + vreq);

		// 1.get the Request from ServiceLayer .
		// 2.Prepare the request DaoReq.
		// 3.Call The dao By passing Dao Request

		// PatientInfoDaoReq daoReq = new PatientInfoDaoReq();
		daoReq.setPatientId(vreq.getPatientId());
		daoReq.setFname(vreq.getFname());
		daoReq.setLname(vreq.getLname());
		daoReq.setDob(vreq.getDob());
		daoReq.setAddress(vreq.getAddress());
		daoReq.setGender(vreq.getGender());
		;
		daoReq.setMobnum(vreq.getMobnum());
		daoReq.setRequestId(vreq.getRequestId());
		daoReq.setSourceName(vreq.getSourceName());
		// 4pass the ReqObject
		logger.debug("this is complited ");
		PatientInfoDao dao = new PatientInfoDaoImpl();
		// 5.get the Response
		// PatientInfoDaoRes daoRes = dao.createPatient(daoReq);
		// 6.We Need To Convert DaoResponse to process Response.
		PatientInfoProcessVbRes vbres = new PatientInfoProcessVbRes();
		vbres.setResMsg(daoRes.getResMsg());
		vbres.setRespCode(daoRes.getRespCode());
		logger.info("exit is ProcessLayer:" + vbres);

		return vbres;

	}

}
