package com.citybank.statementdtls.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.citybank.statementdtls.dao.StatementDtlsDAO;
import com.citybank.statementdtls.dao.beans.StatementDtlsDAOReq;
import com.citybank.statementdtls.dao.beans.StatementDtlsDAORes;
import com.citybank.statementdtls.dao.beans.TrasactionDAO;
import com.citybank.statementdtls.dao.util.BusinessException;
import com.citybank.statementdtls.dao.util.SystemException;

public class StatementDtlsDAOImpl implements StatementDtlsDAO {
	public StatementDtlsDAORes getTrasactions(StatementDtlsDAOReq daoReq)
			throws BusinessException, SystemException, ClassNotFoundException, SQLException {
		System.out.println("Enter into integration layer");
		StatementDtlsDAORes daoResp = new StatementDtlsDAORes();

		String dbRespCode = "";
		String dbRespMsg = "";

		Connection connection = getConnection();

		String sql = "{call GET_TRANSACTIONS(?,?,?,?,?,?,?,?)}";
		CallableStatement cs = connection.prepareCall(sql);

		cs.registerOutParameter(7, Types.VARCHAR);
		cs.registerOutParameter(8, Types.VARCHAR);

		cs.setString(1, daoReq.getClientId());
		cs.setString(2, daoReq.getChannelId());
		cs.setString(3, daoReq.getCardNum());
		cs.setLong(4, daoReq.getCvvNum());
		cs.setString(5, daoReq.getExpDate());
		cs.setString(6, daoReq.getNameOnCard());

		cs.execute();

		dbRespCode = cs.getString(7);
		dbRespMsg = cs.getString(8);
		
		if ("000".equals(dbRespCode)) {

			System.out.println(" dbRespCode " + dbRespCode);
			ResultSet rs = cs.executeQuery();
			System.out.println("Resuluset "+rs);
			List<TrasactionDAO> transdaoList = new ArrayList<TrasactionDAO>();
			if (!rs.wasNull()) {
				System.out.println("in side rs if condition");
				
				while (rs.next()) {
					System.out.println("from result");
					TrasactionDAO transDao = new TrasactionDAO();
					transDao.setId(rs.getString(1));
					transDao.setDate(rs.getString(2));
					transDao.setName(rs.getString(3));
					transDao.setDesc(rs.getString(4));
					transDao.setMerchantName(rs.getString(5));
					transDao.setAmount(rs.getString(6));
					transDao.setStatus(rs.getString(7));
					transDao.setRemarks(rs.getString(8));
					transdaoList.add(transDao);
				}
				System.out.println("transdao "+	transdaoList.size());
				daoResp.setTransDAO(transdaoList);
			}

		} else if ("100".equals(dbRespCode) || "101".equals(dbRespCode) || "102".equals(dbRespCode)
				|| "103".equals(dbRespCode) || "104".equals(dbRespCode)) {
			System.out.println(" dbRespCode " + dbRespCode);
			throw new BusinessException(dbRespCode, dbRespMsg);
		} else {
			System.out.println(" dbRespCode " + dbRespCode);
			throw new SystemException(dbRespCode, dbRespMsg);
		}
		daoResp.setRespCode(dbRespCode);
		daoResp.setRespMsg(dbRespMsg);

		System.out.println("Exit from integration layer hiiiiii");

		return daoResp;
	}

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/RTP3735", "root", "root");
		return connection;
	}

}
