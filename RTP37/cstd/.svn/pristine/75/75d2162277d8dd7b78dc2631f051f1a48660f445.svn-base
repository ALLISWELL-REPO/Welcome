package com.citybank.statementdtls.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.object.StoredProcedure;

import com.citybank.statementdtls.dao.StatementDtlsDAO;
import com.citybank.statementdtls.dao.beans.StatementDtlsDAOReq;
import com.citybank.statementdtls.dao.beans.StatementDtlsDAORes;
import com.citybank.statementdtls.dao.beans.TrasactionDAO;
import com.citybank.statementdtls.dao.config.DaoJavaConfig;
import com.citybank.statementdtls.dao.util.BusinessException;
import com.citybank.statementdtls.dao.util.SystemException;

public class StatementDtlsDAOImpl extends StoredProcedure implements StatementDtlsDAO, RowMapper<TrasactionDAO> {
	
	JdbcTemplate jdbcTemplate;
	
	public StatementDtlsDAOImpl(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate, "GET_TRANSACTIONS");
		registerINOUTParams();
	}

	private void registerINOUTParams() {
		declareParameter(new SqlParameter("CLIENT_ID_IN", Types.VARCHAR));
		declareParameter(new SqlParameter("CHANNEL_ID_IN", Types.VARCHAR));
		declareParameter(new SqlParameter("CARD_NUM_IN", Types.VARCHAR));
		declareParameter(new SqlParameter("CVV_IN", Types.VARCHAR));
		declareParameter(new SqlParameter("EXPIRY_DATE_IN", Types.VARCHAR));
		declareParameter(new SqlParameter("NAME_ON_CARD_IN", Types.VARCHAR));

		declareParameter(new SqlOutParameter("RESP_CODE_OUT", Types.VARCHAR));
		declareParameter(new SqlOutParameter("RESP_MESSAGE_OUT", Types.VARCHAR));

		declareParameter(new SqlReturnResultSet("transactionResultSet", this));
		compile();
	}

	

	public StatementDtlsDAORes getTrasactions(StatementDtlsDAOReq daoReq)
			throws BusinessException, SystemException, ClassNotFoundException, SQLException {
		System.out.println("enter into spring jdbc integrations");
		StatementDtlsDAORes daoRes = new StatementDtlsDAORes();
		String dbRespCode = "";
		String dbRespMsg = "";
		Map<String, Object> inputMap = new HashMap<String, Object>();
		inputMap.put("CLIENT_ID_IN", daoReq.getClientId());
		inputMap.put("CHANNEL_ID_IN", daoReq.getChannelId());
		inputMap.put("CARD_NUM_IN", daoReq.getCardNum());
		inputMap.put("CVV_IN", daoReq.getCvvNum());
		inputMap.put("EXPIRY_DATE_IN", daoReq.getExpDate());
		inputMap.put("NAME_ON_CARD_IN", daoReq.getNameOnCard());
		Map<String, Object> outputMap = super.execute(inputMap);

		dbRespCode = outputMap.get("RESP_CODE_OUT").toString();
		dbRespMsg = outputMap.get("RESP_MESSAGE_OUT").toString();

		if ("000".equals(dbRespCode)) {
			//to avoid null pointer exception
			List<TrasactionDAO> transdaoList=new ArrayList<TrasactionDAO>();
			
		    transdaoList = (List<TrasactionDAO>) outputMap.get("transactionResultSet");
			daoRes.setTransDAO(transdaoList);
			System.out.println("transdao " + transdaoList.size());
		} else if ("100".equals(dbRespCode) || "101".equals(dbRespCode) || "102".equals(dbRespCode)
				|| "103".equals(dbRespCode) || "104".equals(dbRespCode)) {
			System.out.println(" dbRespCode " + dbRespCode);
			throw new BusinessException(dbRespCode, dbRespMsg);
		} else {
			System.out.println(" dbRespCode " + dbRespCode);
			throw new SystemException(dbRespCode, dbRespMsg);
		}
		daoRes.setRespCode(dbRespCode);
		daoRes.setRespMsg(dbRespMsg);

		System.out.println("Exit from integration layer hiiiiii");
		return daoRes;
	}

	public TrasactionDAO mapRow(ResultSet rs, int arg1) throws SQLException {
		TrasactionDAO transDao = new TrasactionDAO();
		transDao.setId(rs.getString(1));
		transDao.setDate(rs.getString(2));
		transDao.setName(rs.getString(3));
		transDao.setDesc(rs.getString(4));
		transDao.setMerchantName(rs.getString(5));
		transDao.setAmount(rs.getString(6));
		transDao.setStatus(rs.getString(7));
		transDao.setRemarks(rs.getString(8));
		return transDao;
	}
	public static void main(String[] args) throws ClassNotFoundException, BusinessException, SystemException, SQLException {
		ApplicationContext context=new AnnotationConfigApplicationContext(DaoJavaConfig.class);
		StatementDtlsDAO dao=context.getBean(StatementDtlsDAO.class);
		StatementDtlsDAOReq req=new StatementDtlsDAOReq();
		req.setCardNum("45900500000321478");
		req.setClientId("web");
		req.setChannelId("online");
		req.setCvvNum(514);
		req.setExpDate("2018-04-03");
		req.setNameOnCard("arun");
		StatementDtlsDAORes res = dao.getTrasactions(req);
		System.out.println("Listsize "+res.getTransDAO().size());
	}

	

}
