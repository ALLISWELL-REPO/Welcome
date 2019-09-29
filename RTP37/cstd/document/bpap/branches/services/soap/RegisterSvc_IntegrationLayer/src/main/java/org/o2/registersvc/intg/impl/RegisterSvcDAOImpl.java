package org.o2.registersvc.intg.impl;

import java.io.FileReader;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.o2.registersvc.intg.RegisterSvcDAO;
import org.o2.registersvc.intg.beans.RegisterSvcDAOReq;
import org.o2.registersvc.intg.beans.RegisterSvcDAORes;
import org.o2.registersvc.intg.util.BussinessException;
import org.o2.registersvc.intg.util.SystemException;
import org.o2.registersvc.intg.util.UnknownException;
import org.springframework.stereotype.Component;

@Component
public class RegisterSvcDAOImpl implements RegisterSvcDAO {

	
	 private Logger logger=Logger.getLogger(RegisterSvcDAOImpl.class);	
	
	 RegisterSvcDAORes daoResp = null;
	 
	 
	 public RegisterSvcDAORes enrollment(RegisterSvcDAOReq daoReq) throws BussinessException, SystemException, UnknownException, SQLException {
 
		logger.info(" enter into RegisterSvcDAOImpl layer"+daoReq);
		
		
		
		Connection con;
		 CallableStatement cs = null;

		try {
		
			Class.forName("com.mysql.jdbc.Driver");
            
			
			String env=System.getProperty("env");
			
			Properties properties=new Properties();
			InputStream reader = RegisterSvcDAOImpl.class.getClassLoader().getResourceAsStream("db_"+env+".properties");
			properties.load(reader);
			
			con = DriverManager.getConnection(properties.getProperty("db.url"), properties.getProperty("db.userName"), properties.getProperty("db.password"));
			// ps=con. ("select * from customerdetails ");
			String sql = "{call GET_ENROLLMENT(?,?,?,?,?,?,?,?,?,?)}";
			cs = (CallableStatement) con.prepareCall(sql);
			// register output parameters with JDBC types
			cs.registerOutParameter(9, Types.VARCHAR);
			cs.registerOutParameter(10, Types.VARCHAR);
			// Set values to input parameters
			cs.setString(1, daoReq.getClientId());
			cs.setString(2, daoReq.getChannelId());
			cs.setString(3, daoReq.getAccountNum());
			cs.setLong(4, daoReq.getMobileNum());
			cs.setString(5, daoReq.getCardNum());
			cs.setString(6, daoReq.getCvv());
			cs.setString(7, daoReq.getExpDate());
			cs.setString(8, daoReq.getNameOnCard());
			cs.execute();
			
			logger.info("ps response code ="+cs.getString(9));
			logger.info("ps response Msg ="+cs.getString(10));
			daoResp=new RegisterSvcDAORes();
			daoResp.setDaoRespCode(cs.getString(9));
			daoResp.setDaoRespMsg(cs.getString(10));
		}

		catch (SQLException se) {
			logger.error("SQLException ",se);
		} catch (ClassNotFoundException ce) {
			logger.error("ClassNotFoundException ",ce);
		}catch (Exception e) {
			logger.fatal("Exception",e);
		}

		//System.out.println("ps response code ="+cs.getString(9));
		
	
		
		logger.info("exit from RegisterSvcDAOImpl daoResp"+daoResp);
		return daoResp;

	}
}
