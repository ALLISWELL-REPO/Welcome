package com.citybank.statementdtls.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.citybank.statementdtls.dao.StatementDtlsDAO;
import com.citybank.statementdtls.dao.beans.StatementDtlsDAOReq;
import com.citybank.statementdtls.dao.beans.StatementDtlsDAORes;
import com.citybank.statementdtls.dao.beans.TransactionsDAO;
import com.citybank.statementdtls.dao.util.BusinessException;
import com.citybank.statementdtls.dao.util.SystemException;

public class StatementDtlsDAOImpl implements StatementDtlsDAO {
Logger logger=Logger.getLogger(StatementDtlsDAOImpl.class);

	public StatementDtlsDAORes getTransactions(StatementDtlsDAOReq daoReq)
			throws BusinessException, SystemException, ClassNotFoundException, SQLException {
		logger.debug("Enter into integration layer");
		// TODO Auto-generated method stub
		// 1.get the dao req from process layer
		// 2.prepare the db request
		// 3.call db and get the response
		/*
		 * StatementDtlsDAORes daoRes=new StatementDtlsDAORes();
		 * daoRes.setRespCode("0000"); daoRes.setRespMsg("success");
		 */
		StatementDtlsDAORes daoResp = null;

		String dbRespCode = "0";
		String dbRespMsg = "success";
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/RTP_3710", "root", "root");
		String sql = "{call getTransactions(?,?,?,?,?,?,?,?)}";
		CallableStatement csmt = (CallableStatement) con.prepareCall(sql);

		// register output parameter with jdbc types
		csmt.registerOutParameter(7, Types.VARCHAR);
		csmt.registerOutParameter(8, Types.VARCHAR);
		// set value to import parameter
		csmt.setString(1, daoReq.getClientId());
		csmt.setString(2, daoReq.getChannelId());
		csmt.setString(3, daoReq.getCardNum());
		csmt.setString(4, daoReq.getCvvNum());
		csmt.setString(5, daoReq.getExpDate());
		csmt.setString(6, daoReq.getNameOnCard());

		csmt.execute();

		dbRespCode = csmt.getString(7);
		dbRespMsg = csmt.getString(8);
		daoResp.setRespCode(dbRespCode);
		daoResp.setRespMsg(dbRespMsg);

		/*
		 * String respCode=csmt.getString(7); String respMsg=csmt.getString(8);
		 * System.out.println(respCode); System.out.println(respMsg);
		 */
		if ("0".equals(dbRespCode)) {

			logger.info("daoResponse " + dbRespCode);
			ResultSet rs = csmt.executeQuery();
			logger.info("ResultSet " + rs);
			if (rs != null) {

				List<TransactionsDAO> transDAOList = new ArrayList<TransactionsDAO>();
				while (rs.next()) {
					TransactionsDAO transDAO = new TransactionsDAO();
					transDAO.setId(rs.getString(1));
					transDAO.setName(rs.getString(2));
					transDAO.setDate(rs.getString(3));
					transDAO.setDesc(rs.getString(4));
					transDAO.setMerchantname(rs.getString(5));
					transDAO.setAmount(rs.getString(6));
					transDAO.setStatus(rs.getString(7));
					transDAO.setRemarks(rs.getString(8));

					daoResp.setTransDAO(transDAOList);
				}
			}
		} else if ("100".equals(dbRespCode) || "101".equals(dbRespCode) || "102".equals(dbRespCode)
				|| "103".equals(dbRespCode) || "104".equals(dbRespCode)) {
			System.out.println("daoResponse" + dbRespCode);
			throw new BusinessException(dbRespCode, dbRespMsg);

			
		} else {
			logger.info("daoResponse" + dbRespCode);
			throw new SystemException(dbRespCode, dbRespMsg);
		}

		logger.debug("Exit from interation layer");
		logger.info("daoResp "+daoResp.getTransDAO().size());
		logger.debug("Exit form integration layer");

		return daoResp;

	}

}
