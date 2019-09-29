package com.citybank.statementsdtls.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.citybank.statementsdtls.dao.StatementDtlsDAO;
import com.citybank.statementsdtls.dao.beans.StatementDtlsDAOReq;
import com.citybank.statementsdtls.dao.beans.StatementDtlsDAORes;
import com.citybank.statementsdtls.dao.beans.TransactionsDAo;
import com.citybank.statementsdtls.dao.entity.ChannelDetails;
import com.citybank.statementsdtls.dao.entity.ClientDetails;
import com.citybank.statementsdtls.dao.entity.CustomerDetails;
import com.citybank.statementsdtls.dao.entity.TransactionDetails;
import com.citybank.statementsdtls.dao.util.BusinessException;
import com.citybank.statementsdtls.dao.util.HibernateUtility;
import com.citybank.statementsdtls.dao.util.SystemException;

public class StatementDtlsDAOImpl implements StatementDtlsDAO {

	public StatementDtlsDAORes getTransactions(StatementDtlsDAOReq daoReq)
			throws BusinessException, SystemException, ClassNotFoundException, SQLException {

		// create DAORes
		StatementDtlsDAORes daoResponse = new StatementDtlsDAORes();
		// create the configuration object
		Configuration configuration = new Configuration().configure();

		// Create the SessionFactory object
		// Creating SessionFactory like this is deprecated from HB 4.x
		// SessionFactory sessionFactory = cfg.buildSessionFactory();
		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
		// create the session object
		Session session = sessionFactory.openSession();
		// create the criteria
		Criteria criteria = session.createCriteria(ClientDetails.class);
		criteria.add(Restrictions.eq("Client_id", daoReq.getClientId()));
		criteria.add(Restrictions.eq("desc", "desc1"));
		List<ClientDetails> clientDetailsList = criteria.list();
		if (!(clientDetailsList != null) || clientDetailsList.size() <= 0) {
			daoResponse.setResCode("1000");
			daoResponse.setResMsg("CLIENT ID IS INVALID");
			return daoResponse;
		}

		criteria = session.createCriteria(ChannelDetails.class);
		criteria.add(Restrictions.eq("channel_id", daoReq.getChannelId()));
		List<ChannelDetails> channelDetailsList = criteria.list();
		if (!(channelDetailsList != null) || channelDetailsList.size() <= 0) {
			daoResponse.setResCode("1001");
			daoResponse.setResMsg("Channel id is Invalid");
		}
		// HQL query for customerDetails
		String customer_detailshql = "from customer_details where cardNum=:cardNum AND Cvv=:Cvv AND NameOnCard=:NameOnCard AND ExpDate=:ExpDate AND StartDate=:StartDate AND EndDate=:EndDate";
		Query query = session.createQuery(customer_detailshql);
		query.setParameter("CardNum", daoReq.getCardNum());
		query.setParameter("Cvv", daoReq.getCvvNum());
		query.setParameter("NameOnCard", daoReq.getNameOncard());
		query.setParameter("ExpDate", daoReq.getExpDate());
		query.setParameter("StartDate", daoReq.getStartDate());
		query.setParameter("EndDate", daoReq.getEndDate());
		// execute the Query
		List<CustomerDetails> customerDetailsList = query.list();
		if (!(customerDetailsList != null) || customerDetailsList.size() <= 0) {
			daoResponse.setResCode("1002");
			daoResponse.setResMsg("Please verify the CardNumber or CvvNumber or ExpiryDate");

			return daoResponse;
		}
		// HQL query for transactionDetails
		String transactionDetailsHql = "from Trans_details where cardNum=:cardNum";
		query = session.createQuery(transactionDetailsHql);
		// set the parameter in the query
		query.setParameter("cardNumber", daoReq.getCardNum());
		List<TransactionDetails> transactionDetailslist = query.list();

		List<TransactionsDAo> transactionDAoList = new ArrayList<TransactionsDAo>();
		if (!(transactionDetailslist != null) || transactionDetailslist.size() <= 0) {
			daoResponse.setResCode("1003");
			daoResponse.setResMsg("NO TRANSACTION FOUND..");
			return daoResponse;
		} else {
			daoResponse.setResCode("0");
			daoResponse.setResMsg("success");
			for (TransactionDetails transDetails : transactionDetailslist) {
				TransactionsDAo transactionDAO = new TransactionsDAo();
				transactionDAO.setId(String.valueOf(transDetails.getId()));
				transactionDAO.setDate(transDetails.getDate());
				transactionDAO.setDesc(transDetails.getDesc());
				transactionDAO.setAmount(transDetails.getAmount());
				transactionDAO.setMerchantname(transDetails.getMerchantName());
				transactionDAO.setStatus(transDetails.getStatus());
				transactionDAO.setRemarks(transDetails.getRemarks());
				transactionDAoList.add(transactionDAO);
			}
		}
		daoResponse.setTransDAO(transactionDAoList);
		HibernateUtility.shutdown();
		return daoResponse;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException, BusinessException, SystemException {
		StatementDtlsDAOReq daoReq = new StatementDtlsDAOReq();
		daoReq.setClientId("web");
		daoReq.setChannelId("online");
		daoReq.setCardNum("23097987543");
		daoReq.setCvvNum("12/19");
		daoReq.setExpDate("12/19");
		daoReq.setNameOncard("kumar");
		StatementDtlsDAOImpl daoimpl = new StatementDtlsDAOImpl();
		
		StatementDtlsDAORes transaction = daoimpl.getTransactions(daoReq);
		System.out.println(transaction);
	
}



}
