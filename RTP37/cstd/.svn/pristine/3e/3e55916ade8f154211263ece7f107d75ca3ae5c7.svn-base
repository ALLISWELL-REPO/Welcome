
package org.o2.registersvc.intg.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.o2.registersvc.integration.config.IntgSpringConfig;
import org.o2.registersvc.intg.RegisterSvcDAO;
import org.o2.registersvc.intg.beans.RegisterSvcDAOReq;
import org.o2.registersvc.intg.beans.RegisterSvcDAORes;
import org.o2.registersvc.intg.util.BussinessException;
import org.o2.registersvc.intg.util.SystemException;
import org.o2.registersvc.intg.util.UnknownException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Component;

@Component
public class RegisterSvcDAOImpl_Springjdbc extends StoredProcedure implements RegisterSvcDAO {

	static Logger logger = Logger.getLogger(RegisterSvcDAOImpl_Springjdbc.class);

	//@Autowired
	public RegisterSvcDAOImpl_Springjdbc(JdbcTemplate jt1) throws IOException {
		super(jt1, "GET_ENROLLMENT");
		compileSP();
	}

	// verify the store producer input & output parameters with their DataTypes

	public RegisterSvcDAORes enrollment(RegisterSvcDAOReq daoReq)
			throws BussinessException, SystemException, UnknownException, SQLException {
		RegisterSvcDAORes daoRes = new RegisterSvcDAORes();
		logger.debug("enter into RegisterSvcDAOImpl_Springjdbc class enrollment method with daoReq::" + daoReq);
		// prepare the store StoredProcedure input
		Map<String, Object> inputMap = new HashMap<String, Object>();
		inputMap.put("clinet_id", daoReq.getClientId());
		inputMap.put("channel_id", daoReq.getChannelId());
		inputMap.put("accountNum", daoReq.getAccountNum());
		inputMap.put("mob_numb", daoReq.getMobileNum());
		inputMap.put("card_numb", daoReq.getCardNum());
		inputMap.put("cvv", daoReq.getCvv());
		inputMap.put("exp_date", daoReq.getExpDate());
		inputMap.put("name_on_card", daoReq.getNameOnCard());

		// execute StoredProcedure
		logger.debug("excecuting StoredProcedure by passing input parameters");
		final Map<String, Object> returnMap = super.execute(inputMap);
		final String respCode = returnMap.get("respCode").toString();
		final String respMsg = returnMap.get("respMsg").toString();

		logger.info("respCode From PS:" + respCode);
		logger.info("respMsg from ps:" + respMsg);

		try {
			if ("0000".equals(respCode)) {
				daoRes.setDaoRespCode(respCode);
				daoRes.setDaoRespMsg(respMsg);
			} else if ("1000".equals(respCode)) {
				throw new BussinessException(respCode, respMsg);
			} else if ("1001".equals(respCode)) {
				throw new BussinessException(respCode, respMsg);
			} else if ("1002".equals(respCode)) {
				throw new BussinessException(respCode, respMsg);
			} else if ("1003".equals(respCode)) {
				throw new BussinessException(respCode, respMsg);
			}
		} catch (Exception e) {
			logger.fatal("Exception", e);
		}

		return daoRes;
	}

	
	private void compileSP() {

		logger.debug("enter into compileSP() ");
		// input parameters verifying
		declareParameter(new SqlParameter("clinet_id", Types.VARCHAR));
		declareParameter(new SqlParameter("channel_id", Types.VARCHAR));
		declareParameter(new SqlParameter("accountNum", Types.VARCHAR));
		declareParameter(new SqlParameter("mob_numb", Types.BIGINT));
		declareParameter(new SqlParameter("card_numb", Types.VARCHAR));
		declareParameter(new SqlParameter("cvv", Types.VARCHAR));
		declareParameter(new SqlParameter("exp_date", Types.VARCHAR));
		declareParameter(new SqlParameter("name_on_card", Types.VARCHAR));

		// output parameters verifying
		declareParameter(new SqlOutParameter("respCode", Types.VARCHAR));
		declareParameter(new SqlOutParameter("respMsg", Types.VARCHAR));

		logger.debug("going for compilation ");
		// compilation
		//compile();

		logger.debug(" exit from compileSP methods");
	}
	
	/*private static JdbcTemplate getTemplate() throws IOException   {
		
		
			logger.debug("enter into jdbcTemplte");

	
		//	String env=System.getProperty("env");
			
		ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
		JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jt");
			 Properties properties=new Properties();
			InputStream reader = RegisterSvcDAOImpl_Springjdbc.class.getClassLoader().getResourceAsStream("db_"+env+".properties");
			properties.load(reader);
			
			dataSource.setDriverClassName(properties.getProperty("db.driver"));
			dataSource.setUrl(properties.getProperty("db.url"));
			dataSource.setUsername(properties.getProperty("db.userName"));
			dataSource.setPassword(properties.getProperty("db.password"));
			
			//creating  jdbcTemplate object
			JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
			ApplicationContext context=new AnnotationConfigApplicationContext(org.o2.registersvc.config.SpringConfig.class);
			//JdbcTemplate jdbcTemplate=context.getBean("jt",JdbcTemplate.class);
			JdbcTemplate jdbcTemplate=(JdbcTemplate) context.getBean("getTemplate");
			logger.debug("exit from jdbc template::");
		
		return jdbcTemplate;

	}
*/
}
