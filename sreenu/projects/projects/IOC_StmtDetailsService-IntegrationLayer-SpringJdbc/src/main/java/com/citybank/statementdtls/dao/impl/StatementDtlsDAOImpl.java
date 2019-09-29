package com.citybank.statementdtls.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

import com.citybank.statementdtls.dao.beans.StatementDtlsDAOReq;
import com.citybank.statementdtls.dao.beans.StatementDtlsDAORes;
import com.citybank.statementdtls.dao.beans.TransactionDAO;
import com.citybank.statementdtls.dao.config.DaoJavaConfig;
import com.citybank.statementdtls.dao.util.BusinessException;
import com.citybank.statementdtls.dao.util.SystemException;

public class StatementDtlsDAOImpl extends StoredProcedure implements
		StatementDtlsDAO, RowMapper<TransactionDAO> {

	JdbcTemplate jdbcTemplate;

	@Autowired
	Environment environment = null;

	public StatementDtlsDAOImpl(JdbcTemplate jdbcTemplate) {
		super(jdbcTemplate, "GET_TRANSACTIONS");
		registerINOUTParams();
	}

	public void registerINOUTParams() {

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

	@SuppressWarnings("unchecked")
	public StatementDtlsDAORes getTransactions(StatementDtlsDAOReq daoReq)
			throws BusinessException, SystemException, SQLException,
			ClassNotFoundException {

		System.out.println("Inside Spring-jdbc intg layer");
		String envName = environment.getProperty("enve");
		System.out.println("Env name" + envName);

		StatementDtlsDAORes daoRes = new StatementDtlsDAORes();
		String dbRespCode = "";
		String dbRespMsg = "";

		Map<String, Object> inputMap = new HashMap<String, Object>();

		inputMap.put("CLIENT_ID_IN", daoReq.getClientid());
		inputMap.put("CHANNEL_ID_IN", daoReq.getChannelid());
		inputMap.put("CARD_NUM_IN", daoReq.getCardnum());
		inputMap.put("CVV_IN", daoReq.getCvvnum());
		inputMap.put("EXPIRY_DATE_IN", daoReq.getExpdate());
		inputMap.put("NAME_ON_CARD_IN", daoReq.getNameoncard());

		Map<String, Object> outputMap = super.execute(inputMap);

		dbRespCode = outputMap.get("RESP_CODE_OUT").toString();
		dbRespMsg = outputMap.get("RESP_MESSAGE_OUT").toString();

		if ("000".equals(dbRespCode)) {

			// to avoid null pointer exception
			List<TransactionDAO> transdaoList = new ArrayList<TransactionDAO>();

			transdaoList = (List<TransactionDAO>) outputMap
					.get("transactionResultSet");
			daoRes.setTransDAO(transdaoList);

			System.out.println("Size of list" + transdaoList.size());

		}

		else if ("100".equals(dbRespCode) || "101".equals(dbRespCode)
				|| "102".equals(dbRespCode) || "103".equals(dbRespCode)

				|| "104".equals(dbRespCode)) {

			System.out.println("dbRespCode" + dbRespCode);
			throw new BusinessException(dbRespCode, dbRespMsg);

		} else {

			System.out.println("daoRespcode" + dbRespCode);
			throw new SystemException(dbRespCode, dbRespMsg);
		}

		daoRes.setExpncode(dbRespCode);
		daoRes.setExpmsg(dbRespMsg);

		System.out.println("Exit from integration layer");

		return daoRes;
	}

	public TransactionDAO mapRow(ResultSet rs, int arg1) throws SQLException {

		TransactionDAO transDao = new TransactionDAO();
		transDao.setTransid(rs.getString(1));
		transDao.setDate(rs.getString(2));
		transDao.setName(rs.getString(3));
		transDao.setDesc(rs.getString(4));
		transDao.setMerchantname(rs.getString(5));
		transDao.setAmount(rs.getString(6));
		transDao.setStatus(rs.getString(7));
		transDao.setRemarks(rs.getString(8));
		return transDao;
	}

	public static void main(String[] args) throws ClassNotFoundException,
			BusinessException, SystemException, SQLException {

		System.setProperty("spring.profiles.active", "test");
		ApplicationContext context = new AnnotationConfigApplicationContext(
				DaoJavaConfig.class);

		StatementDtlsDAO dao = context.getBean(StatementDtlsDAO.class);
		StatementDtlsDAOReq req = new StatementDtlsDAOReq();
		req.setCardnum("45900500000321478");
		req.setCvvnum("514");
		req.setClientid("web");
		req.setChannelid("online");
		req.setExpdate("2018-04-03");
		req.setNameoncard("arun");
		StatementDtlsDAORes res = dao.getTransactions(req);
		System.out.println("ListSize=" + res.getTransDAO().size());

	}

}
