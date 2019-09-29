/**
 * NHS Technologies.All Rights are reserved @Copy Rights are reserved.
You should not disclose the information outside otherwise
 terms and conditions will apply
 */
package org.nhs.patientinfo.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.Logger;
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
/**
 * @author stech6
 *
 */
/**
 * @author stech6
 *
 */
public class PatientInfoDAOImpl implements PatientInfoDAO {

	private Logger logger = Logger.getLogger(PatientInfoDAOImpl.class);

	public PatientInfoDAORes createPatient(PatientInfoDAOReq daoreq)
			throws BussinessException, SystemException, UnknownException {
		logger.info("Entered into Integration Layer" + daoreq);
		// 1. Get the request from process layer
		// 2. Prepare db request
		// 3. call DB by passing dbRequest
		// 4. Need to convert ResultSet object to PatientInfoDAORes object
		Connection con = null;
		Statement st = null;
		Properties props = new Properties();
		String env = System.getProperty("env");
		logger.info("env=" + env);
		// String sql="insert into getDetails(id,name) values(10,'sindhu')";
		String sql = "{call getDetails()}";
		try {
			props.load(PatientDaoMain.class.getClassLoader()
					.getResourceAsStream("properties/patient_" + env + "_db.properties"));
			String driver = props.getProperty("DB_DRIVER");
			String url = props.getProperty("DB_URL");
			String username = props.getProperty("DB_USERNAME");
			String pwd = props.getProperty("DB_PASSWORD");
			logger.info("url=" + url);
			logger.info(" username=" + username);
			logger.info("password =" + pwd);
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, pwd);
			st = con.createStatement();
			int count = st.executeUpdate(sql);
			logger.info(count);

			logger.info(url);
			PatientInfoDAORes daoResp = new PatientInfoDAORes();

			String dbRespcode = "4657";
			String dbRespMsg = "db bad error";
			if ("0".equals(dbRespcode)) {
				daoResp.setRespCode("0");
				daoResp.setRespMsg("SUCESS");
			} else if ("100".equals(dbRespcode) || "101".equals(dbRespcode)) {
				throw new BussinessException(dbRespcode, dbRespMsg);
			} else if ("110".equals(dbRespcode) || "111".equals(dbRespcode)) {
				throw new SystemException(dbRespcode, dbRespMsg);
			} else {
				throw new UnknownException("db999", "unknown db error:" + dbRespMsg);
			}
			logger.info("Exited from Integration Layer" + daoreq);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logger.error("IOException", e);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			logger.error("ClassNotFoundException", e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("SQLException", e);
		} catch (Exception e) {
			logger.fatal("Exception", e);
		}

		return daoResp;
	}

	/*
	 * public static void main(String[] args) throws BussinessException,
	 * SystemException, UnknownException { PatientInfoDAOImpl impl = new
	 * PatientInfoDAOImpl(); PatientInfoDAOReq daoreq = new PatientInfoDAOReq();
	 * 
	 * PatientInfoDAORes createPatient = impl.createPatient(daoreq);
	 * 
	 * }
	 */

}
