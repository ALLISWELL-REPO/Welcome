package com.citybank.statementdtls.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.StoredProcedure;

import com.citybank.statementdtls.dao.StatementDtlsDAO;
import com.citybank.statementdtls.dao.beans.StatementDtlsDAOReq;
import com.citybank.statementdtls.dao.beans.StatementDtlsDAORes;
import com.citybank.statementdtls.dao.beans.TransactionsDAO;
import com.citybank.statementdtls.dao.util.BusinessException;
import com.citybank.statementdtls.dao.util.SystemException;

public class StatementDtlsSpringImpl extends StoredProcedure implements StatementDtlsDAO, RowMapper {

	public StatementDtlsSpringImpl() {
		super(getJDbcTemplate(), "getTransactions");
		declareAllParam();
	}

	public static JdbcTemplate getJDbcTemplate() {
		// Activate IOC container
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// Get the JdbcTemplate object from container
		JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate", JdbcTemplate.class);
		// System.out.println("DataSource object)
		return jdbcTemplate;
	}

	// 3.compile the stored procedure
	private void declareAllParam() {

		declareParameter(new SqlParameter("CLIENT_ID", Types.VARCHAR));
		declareParameter(new SqlParameter("CHANNEL_ID", Types.VARCHAR));
		declareParameter(new SqlParameter("CARD_NUM", Types.VARCHAR));
		declareParameter(new SqlParameter("CVV_NUM", Types.VARCHAR));
		declareParameter(new SqlParameter("EXP_DT", Types.VARCHAR));
		declareParameter(new SqlParameter("NAMEONCARD", Types.VARCHAR));
		declareParameter(new SqlOutParameter("RESP_CODE", Types.VARCHAR));
		declareParameter(new SqlOutParameter("RESP_MSG", Types.VARCHAR));
		
		compile();

	}

	// private static DataSource JdbcTemplate;

	public StatementDtlsDAORes getTransactions(StatementDtlsDAOReq daoReq)
			throws BusinessException, SystemException, ClassNotFoundException, SQLException {

		StatementDtlsDAORes daoResp = new StatementDtlsDAORes();

		// 4.prepare SP request

		Map<String, String> reqMap = new HashMap<String, String>();
		reqMap.put("CLIENT_ID", daoReq.getClientId());
		reqMap.put("CHANNEL_ID", daoReq.getChannelId());
		reqMap.put("CARD_NUM", daoReq.getCardNum());
		reqMap.put("CVV_NUM", daoReq.getCvvNum());
		reqMap.put("EXP_DT", daoReq.getExpDate());
		reqMap.put("NAMEONCARD", daoReq.getNameOnCard());
		reqMap.put("RESP_CODE", daoResp.getRespCode());
		reqMap.put("RESP_MSG", daoResp.getRespMsg());

		// 5.execute the stored procedure

		Map<String, Object> respMsg = super.execute(reqMap);
		System.out.println("Response message " + respMsg);

		// 6.get the response code
		String dbRespoPRoCode = respMsg.get("RESP_CODE").toString();
		String dbRespoProMsg = respMsg.get("RESP_MSG").toString();
		// System.out.println("dbErrorCode " + dbRespoCode);
		// System.out.println("dbErrorMsg " + dbRespoMsg);

		// 7.retrive the ResultSet

		String dbRespCode = "0";
		String dbRespMsg = "success";

		if ("0".equals(dbRespCode)) {
			List<TransactionsDAO> transDtlsDAO = new ArrayList<TransactionsDAO>();
			respMsg.get("getTransactions");
			daoResp.setRespCode(dbRespoPRoCode);
			daoResp.setRespMsg(dbRespoProMsg);
			daoResp.setTransDAO(transDtlsDAO);
			System.out.println("ResponseCode " + daoResp.getRespCode());
			System.out.println("ResponseMsg " + daoResp.getRespMsg());
			
		} else if ("100".equals(dbRespCode) || "101".equals(dbRespCode) || "102".equals(dbRespCode)
				|| "103".equals(dbRespCode) || "104".equals(dbRespCode)) {
			// System.out.println("daoResponse" + dbRespCode);
			throw new BusinessException(dbRespCode, dbRespMsg);

		} else {
			System.out.println("daoResponse" + dbRespCode);
			throw new SystemException(dbRespCode, dbRespMsg);
		}

		System.out.println("Exit from Spring interation layer");
		// System.out.println("daoResp "+daoResp.getTransDAO().size());

		return daoResp;

	}
	
	// convert resultset object to transaction object
	public TransactionsDAO mapRow(ResultSet rs, int index) throws SQLException {

		TransactionsDAO transDao = new TransactionsDAO();
		transDao.setId(rs.getString(1));
		transDao.setName(rs.getString(2));
		transDao.setDate(rs.getString(3));
		transDao.setDesc(rs.getString(4));
		transDao.setMerchantname(rs.getString(5));
		transDao.setAmount(rs.getString(6));
		transDao.setStatus(rs.getString(7));
		transDao.setRemarks(rs.getString(8));

		return transDao;
	}

	// 2. create jdbctemplate object.it required Datasource object
	public static void main(String[] args)
			throws ClassNotFoundException, BusinessException, SystemException, SQLException {

		StatementDtlsDAO spDaoImpl = new StatementDtlsSpringImpl();
		StatementDtlsDAOReq daoReq1 = new StatementDtlsDAOReq();
		daoReq1.setClientId("web");
		daoReq1.setChannelId("online");
		daoReq1.setCardNum("578111000544594");
		daoReq1.setCvvNum("341");
		daoReq1.setExpDate("02-06-2015");
		daoReq1.setNameOnCard("nishant");

		System.out.println("daoMainmethod " + daoReq1);

		StatementDtlsDAORes daoRes1 = spDaoImpl.getTransactions(daoReq1);
		System.out.println(daoRes1.getRespCode());
		System.out.println(daoRes1.getRespMsg());

	}

}
