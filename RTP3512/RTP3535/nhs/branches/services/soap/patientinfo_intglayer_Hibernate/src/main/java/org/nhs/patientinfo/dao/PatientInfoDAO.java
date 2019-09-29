/**
 * NHS Technologies.All Rights are reserved @Copy Rights are reserved.
You should not disclose the information outside otherwise
 terms and conditions will apply
 */
package org.nhs.patientinfo.dao;

import org.nhs.patientinfo.dao.beans.PatientInfoDAOReq;
import org.nhs.patientinfo.dao.beans.PatientInfoDAORes;
import org.nhs.patientinfo.dao.util.BussinessException;
import org.nhs.patientinfo.dao.util.SystemException;
import org.nhs.patientinfo.dao.util.UnknownException;

/**
 * @author: Stech
 * @Date     :  Feb 23, 2018
 * Description:  
 */
public interface PatientInfoDAO {

	PatientInfoDAORes createPatient(PatientInfoDAOReq daoreq) throws BussinessException, SystemException, UnknownException;
}
