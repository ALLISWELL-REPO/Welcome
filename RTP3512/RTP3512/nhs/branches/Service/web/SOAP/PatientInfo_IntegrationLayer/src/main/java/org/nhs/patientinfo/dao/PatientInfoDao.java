package org.nhs.patientinfo.dao;

import org.nhs.patientinfo.dao.Util.BeginessException;
import org.nhs.patientinfo.dao.Util.SystemException;
import org.nhs.patientinfo.dao.Util.UnKnownException;
import org.nhs.patientinfo.dao.beans.PatientInfoDaoReq;
import org.nhs.patientinfo.dao.beans.PatientInfoDaoRes;

public interface PatientInfoDao {
	public PatientInfoDaoRes createPatient(PatientInfoDaoReq dreq) throws BeginessException, SystemException, UnKnownException;

}
