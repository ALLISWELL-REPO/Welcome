package com.citybank.statementdtls.dao.impl;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.citybank.statementdtls.dao.StatementDtlsDAO;
import com.citybank.statementdtls.dao.beans.StatementDtlsDAOReq;
import com.citybank.statementdtls.dao.beans.StatementDtlsDAORes;
import com.citybank.statementdtls.dao.beans.TransactionsDAO;
import com.citybank.statementdtls.dao.entities.ChannelDetails;
import com.citybank.statementdtls.dao.entities.ClientChannelMapping;
import com.citybank.statementdtls.dao.entities.ClientDetails;
import com.citybank.statementdtls.dao.entities.CustomerInfo;
import com.citybank.statementdtls.dao.entities.TransactionDetails;
import com.citybank.statementdtls.dao.util.BusinessException;
import com.citybank.statementdtls.dao.util.SystemException;

public class StatementDtlsSpringOrmImpl implements StatementDtlsDAO {

	public StatementDtlsDAORes getTransactions(StatementDtlsDAOReq daoReq)
			throws BusinessException, SystemException, ClassNotFoundException, SQLException {

		StatementDtlsDAORes daoResp = new StatementDtlsDAORes();

		// Activate the IOC container
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// Create the SessionFactory object
		SessionFactory sessionFactory = context.getBean("sessionFactory", SessionFactory.class);

		// Create the Session object
		Session session = sessionFactory.openSession();

		// Create the Criteria object
		Criteria criteria = session.createCriteria(ClientDetails.class);
		criteria.add(Restrictions.eq("clientid", daoReq.getClientId()));

		// criteria.add(Restrictions.eq("description", "desc1"));
		List<ClientDetails> clientDetailsList = criteria.list();

		if (!(clientDetailsList != null) || clientDetailsList.size() <= 0) {
			daoResp.setRespCode("1000");
			daoResp.setRespMsg("CLIENT ID IS INVALID");
			return daoResp;
		}
		criteria = session.createCriteria(ChannelDetails.class);
		criteria.add(Restrictions.eq("channelid", daoReq.getChannelId()));
		List<ChannelDetails> channelDetailslist = criteria.list();
		if (!(channelDetailslist != null) || channelDetailslist.size() <= 0) {
			daoResp.setRespCode("1001");
			daoResp.setRespMsg("CHANNEL ID IS INVALID");
		}

		// HQL query for customerInfo
		String customeHql = "from TransactionDetails  where Card_num=?";
		// Create the Query object
		Query query = session.createQuery(customeHql);
		// Set the parameter in the query
		query.setParameter(0, daoReq.getCardNum());
		// query.setParameter(1, daoReq.get);
		// query.setParameter(2, daoReq.getExpDate());

		// execute the query
		List<CustomerInfo> customerInfoList = query.list();
		System.out.println("HqlQuery");
		if (!(customerInfoList != null) || customerInfoList.size() <= 0) {
			daoResp.setRespCode("1002");
			daoResp.setRespMsg("Please verify the CardNumber or CvvNumber or ExpiryDate");
			return daoResp;
		}

		// HQL query for transactionDetails
		String transactionDetailsHql = "from TransactionDetails where Card_num=?";

		query = session.createQuery(transactionDetailsHql);
		// set the parameter in the query
		query.setParameter(0, daoReq.getCardNum());
		// query.setParameter(1, daoReq.getCvvNum());
		// query.setParameter(2, daoReq.getExpDate());
		List<TransactionDetails> transactionDetailslist = query.list();

		List<TransactionsDAO> transactionDAOList = new ArrayList<TransactionsDAO>();
		if (!(transactionDetailslist != null) || transactionDetailslist.size() <= 0) {
			daoResp.setRespCode("9999");
			daoResp.setRespMsg("NO TRANSACTION FOUND..");
			return daoResp;
		} else {
			daoResp.setRespCode("0");
			daoResp.setRespMsg("SUCCESS");
			for (TransactionDetails transDetails : transactionDetailslist) {
				TransactionsDAO transactionDAO = new TransactionsDAO();
				transactionDAO.setId(transDetails.getId());
				// transactionDAO.setDate(transDetails.getDate_value());
				transactionDAO.setDesc(transDetails.getDescription());
				transactionDAO.setAmount(transDetails.getAmount());
				transactionDAO.setMerchantname(transDetails.getMerchantname());
				transactionDAO.setRemarks(transDetails.getRemark());
				transactionDAO.setStatus(transDetails.getStatus());
				transactionDAOList.add(transactionDAO);
			}
		}
		daoResp.setTransDAO(transactionDAOList);
		return daoResp;
	}

	public static void main(String[] args)
			throws ClassNotFoundException, BusinessException, SystemException, SQLException {
		StatementDtlsSpringOrmImpl spOrmImpl = new StatementDtlsSpringOrmImpl();

		StatementDtlsDAOReq daoReq1 = new StatementDtlsDAOReq();
		daoReq1.setClientId("web");
		daoReq1.setChannelId("online");
		daoReq1.setCardNum("578111000544594");
		daoReq1.setCvvNum("341");
		daoReq1.setExpDate("2025-02-02");
		daoReq1.setNameOnCard("nishant");

		System.out.println("daoMainmethod " + daoReq1);

		StatementDtlsDAORes daoRes1 = spOrmImpl.getTransactions(daoReq1);
		System.out.println(daoRes1.getRespCode());
		System.out.println(daoRes1.getRespMsg());
	}
}