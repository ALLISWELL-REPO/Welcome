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

import com.citybank.statementdtls.dao.StatementDtlsDAO;
import com.citybank.statementdtls.dao.beans.StatementDtlsDAOReq;
import com.citybank.statementdtls.dao.beans.StatementDtlsDAORes;
import com.citybank.statementdtls.dao.beans.TransactionsDAO;
import com.citybank.statementdtls.dao.entities.ChannelDetails;
import com.citybank.statementdtls.dao.entities.ClientDetails;
import com.citybank.statementdtls.dao.entities.CustomerInfo;
import com.citybank.statementdtls.dao.entities.TransactionDetails;
import com.citybank.statementdtls.dao.util.BusinessException;
import com.citybank.statementdtls.dao.util.HibernateUtil;
import com.citybank.statementdtls.dao.util.SystemException;

public class StatementDtlsHibernateImpl implements StatementDtlsDAO {

	private SessionFactory sessionFactory = null;

	public StatementDtlsHibernateImpl() {
		sessionFactory = HibernateUtil.getSessionFactory();
	}

	public StatementDtlsDAORes getTransactions(StatementDtlsDAOReq daoReq)
			throws BusinessException, SystemException, ClassNotFoundException, SQLException {
		StatementDtlsDAORes daoRes = new StatementDtlsDAORes();
		daoRes = processRequest(daoReq);
		HibernateUtil.shutDown();
		return daoRes;
	}

	private StatementDtlsDAORes processRequest(StatementDtlsDAOReq daoReq) {
		Session session = sessionFactory.openSession();
		StatementDtlsDAORes daoRes = new StatementDtlsDAORes();

		// client verification
		Query query = session.createQuery("from ClientDetails where clientid=:clientid");
		query.setParameter("clientid", daoReq.getClientId());

		List<ClientDetails> clientList = query.list();
		if (clientList == null || clientList.size() <= 0) {
			daoRes.setRespCode("0001");
			daoRes.setRespMsg("client id not found");
			return daoRes;
		}

		// channel verification
		query = session.createQuery("from ChannelDetails where channelid=:channelid");
		query.setParameter("channelid", daoReq.getChannelId());

		List<ChannelDetails> channelList = query.list();
		if (channelList == null || channelList.size() <= 0) {
			daoRes.setRespCode("0002");
			daoRes.setRespMsg("channel id not found");
			return daoRes;
		}

		/*// client-channel verification
		query = session.createQuery("from ClientChannelMapping where channelid=:channelid");
		query.setParameter("channelid", daoReq.getChannelId());

		List<ChannelDetails> channelList = query.list();
		if (channelList == null || channelList.size() <= 0) {
			daoRes.setRespCode("0002");
			daoRes.setRespMsg("channel id not found");
			return daoRes;
		}*/

		//cutomer details verification
		Criteria criteria=session.createCriteria(CustomerInfo.class);
		criteria.add(Restrictions.eq("Card_num", daoReq.getCardNum()));
		criteria.add(Restrictions.eq("Cvv_num", daoReq.getCvvNum()));
		criteria.add(Restrictions.eq("Name_on_card", daoReq.getNameOnCard()));
		criteria.add(Restrictions.eq("Exp_Date", daoReq.getExpDate()));

		List<CustomerInfo> customerList=criteria.list();
		if (customerList == null || customerList.size() <= 0) {
			daoRes.setRespCode("0004");
			daoRes.setRespMsg("verify customer details");
			return daoRes;
		}

		criteria=session.createCriteria(TransactionDetails.class);
		criteria.add(Restrictions.eq("Card_num", daoReq.getCardNum()));
		List<TransactionDetails> transList=criteria.list();
		if (transList == null || transList.size() <= 0) {
			daoRes.setRespCode("0005");
			daoRes.setRespMsg("Transaction is empty");
			return daoRes;
		}else{
			List<TransactionsDAO> transactionDaoList=new ArrayList<TransactionsDAO>();
			for
				(TransactionDetails transDetails : transList) {
					TransactionsDAO transactionDAO = new TransactionsDAO();
					//transactionDAO.setTransId(transDetails.getTrans_id());
					//transactionDAO.setDate(transDetails.getDate());
					transactionDAO.setDesc(transDetails.getDescription());
					transactionDAO.setAmount(transDetails.getAmount());
					transactionDAO.setMerchantname(transDetails.getMerchantname());
					transactionDAO.setRemarks(transDetails.getRemark());
					transactionDAO.setStatus(transDetails.getStatus());
					transactionDaoList.add(transactionDAO); 
					} 
			
			daoRes.setRespCode("0000"); 
			daoRes.setRespMsg("sucess");
		}

	return null;
}

/*
 * StatementDtlsDAORes daoResp = new StatementDtlsDAORes();
 * 
 * // Create the Configuration object Configuration cfg = new
 * Configuration().configure();
 * 
 * // Create the SessionFactory object // Creating SessionFactory like this is
 * deprecated from HB 4.x // SessionFactory sessionFactory =
 * cfg.buildSessionFactory(); SessionFactory sessionFactory =
 * HibernateUtil.getSessionFactory();
 * 
 * // Create the Session object Session session = sessionFactory.openSession();
 * 
 * // Create the Criteria object Criteria criteria =
 * session.createCriteria(ClientDetails.class);
 * criteria.add(Restrictions.eq("clientId", daoReq.getClientId()));
 * 
 * // criteria.add(Restrictions.eq("description", "desc1")); List<ClientDetails>
 * clientDetailsList = criteria.list();
 * 
 * if (!(clientDetailsList != null) || clientDetailsList.size() <= 0) {
 * daoResp.setRespCode("1000"); daoResp.setRespMsg("CLIENT ID IS INVALID");
 * return daoResp; } criteria = session.createCriteria(ChannelDetails.class);
 * criteria.add(Restrictions.eq("channelId", daoReq.getChannelId()));
 * List<ChannelDetails> channelDetailslist = criteria.list(); if
 * (!(channelDetailslist != null) || channelDetailslist.size() <= 0) {
 * daoResp.setRespCode("1001"); daoResp.setRespMsg("CHANNEL ID IS INVALID"); }
 * 
 * // HQL query for customerInfo String customerInfoHql =
 * "from CustomerInfo where cardNumber=:cardNumber AND cvvNumber=:cvvNumber AND expiryDate=:expiryDate"
 * ; // Create the Query object Query query =
 * session.createQuery(customerInfoHql); // Set the parameter in the query
 * query.setParameter("cardNumber", daoReq.getCardNum());
 * query.setParameter("cvvNumber", daoReq.getCvvNum());
 * query.setParameter("expiryDate", daoReq.getExpDate());
 * 
 * // execute the query List<CustomerInfo> customerInfoList = query.list();
 * 
 * if (!(customerInfoList != null) || customerInfoList.size() <= 0) {
 * daoResp.setRespCode("1002"); daoResp.
 * setRespMsg("Please verify the CardNumber or CvvNumber or ExpiryDate"); return
 * daoResp; }
 * 
 * // HQL query for transactionDetails String transactionDetailsHql =
 * "from TransactionDetails where cardNumber=:cardNumber";
 * 
 * query = session.createQuery(transactionDetailsHql); // set the parameter in
 * the query query.setParameter("cardNumber", daoReq.getCardNum());
 * List<TransactionDetails> transactionDetailslist = query.list();
 * 
 * List<TransactionsDAO> transactionDAOList = new ArrayList<TransactionsDAO>();
 * if (!(transactionDetailslist != null) || transactionDetailslist.size() <= 0)
 * { daoResp.setRespCode("9999"); daoResp.setRespMsg("NO TRANSACTION FOUND..");
 * return daoResp; } else { daoResp.setRespCode("0");
 * daoResp.setRespMsg("SUCCESS"); for (TransactionDetails transDetails :
 * transactionDetailslist) { TransactionsDAO transactionDAO = new
 * TransactionsDAO(); transactionDAO.setTransId(transDetails.getTrans_id());
 * transactionDAO.setDate(transDetails.getDate());
 * transactionDAO.setDesc(transDetails.getDescription());
 * transactionDAO.setAmount(transDetails.getAmount());
 * transactionDAO.setMerchantName(transDetails.getMerchantName());
 * transactionDAO.setRewards(transDetails.getRewards());
 * transactionDAO.setRemarks(transDetails.getRemark());
 * transactionDAO.setStatus(transDetails.getStatus());
 * transactionDAOList.add(transactionDAO); } }
 * daoResp.setTransDAO(transactionDAOList); HibernateUtil.shutDown(); return
 * daoResp; }
 * 
 * public static void main(String[] args) throws ClassNotFoundException,
 * BusinessException, SystemException, SQLException {
 * 
 * StatementDtlsHibernateImpl hibernateImpl = new StatementDtlsHibernateImpl();
 * // create daoReq object StatementDtlsDAOReq daoReqType = new
 * StatementDtlsDAOReq(); daoReqType.setClientId("web");
 * daoReqType.setChannelId("flipkart"); daoReqType.setCardNum("");
 * daoReqType.setCvvNum("123"); daoReqType.setNameOnCard("nishant");
 * daoReqType.setExpDate("12-02-2019");
 * 
 * StatementDtlsDAORes daoResType = hibernateImpl.getTransactions(daoReqType); }
 * 
 * private static Date getDate(String stringDate) throws ParseException { Date
 * sdf = new SimpleDateFormat("yyyy-MM-dd").parse(stringDate); return sdf;
 * 
 * }
 */

}
