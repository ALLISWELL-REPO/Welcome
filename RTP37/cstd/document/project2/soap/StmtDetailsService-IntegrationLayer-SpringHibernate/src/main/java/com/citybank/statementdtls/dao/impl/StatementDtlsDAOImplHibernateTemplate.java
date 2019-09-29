package com.citybank.statementdtls.dao.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.citybank.statementdtls.dao.StatementDtlsDAO;
import com.citybank.statementdtls.dao.beans.StatementDtlsDAOReq;
import com.citybank.statementdtls.dao.beans.StatementDtlsDAORes;
import com.citybank.statementdtls.dao.beans.TrasactionDAO;
import com.citybank.statementdtls.dao.entities.ChannelDetails;
import com.citybank.statementdtls.dao.entities.ClientChannelMapping;
import com.citybank.statementdtls.dao.entities.ClientDetails;
import com.citybank.statementdtls.dao.entities.CustomerDetails;
import com.citybank.statementdtls.dao.entities.TransactionDetails;
import com.citybank.statementdtls.dao.util.BusinessException;
import com.citybank.statementdtls.dao.util.SessionFactoryUtil;
import com.citybank.statementdtls.dao.util.StringToDate;
import com.citybank.statementdtls.dao.util.SystemException;

public class StatementDtlsDAOImplHibernateTemplate implements StatementDtlsDAO {
	HibernateTemplate hibernateTempalate = null;

	public StatementDtlsDAOImplHibernateTemplate() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContextHibernateTemplate.xml");
		hibernateTempalate = context.getBean(HibernateTemplate.class, "hibernateTempalate");
	}

	public StatementDtlsDAORes getTrasactions(StatementDtlsDAOReq daoReq)
			throws BusinessException, SystemException, ClassNotFoundException, SQLException {
		System.out.println("Enter into integration layer");
		StatementDtlsDAORes daoRes = new StatementDtlsDAORes();
		daoRes = processRequest(daoReq);

		System.out.println("Exit from integration layer ");

		return daoRes;
	}

	private StatementDtlsDAORes processRequest(StatementDtlsDAOReq daoReq) {
		StatementDtlsDAORes daoRes = new StatementDtlsDAORes();

		// Client verification
		List<ClientDetails> clientlist = (List<ClientDetails>) hibernateTempalate
				.findByNamedParam("from ClientDetails where clientId=:clientId", "clientId", daoReq.getClientId());
		if (clientlist == null || clientlist.size() <= 0) {
			daoRes.setRespCode("101");
			daoRes.setRespMsg("CLIENT_ID IS INVALID");
			return daoRes;
		}
		// channel verification
		List<ChannelDetails> channellist = (List<ChannelDetails>) hibernateTempalate
				.findByNamedParam("from ChannelDetails where ChannelId=:ChannelId", "ChannelId", daoReq.getChannelId());
		if (channellist == null || channellist.size() <= 0) {
			daoRes.setRespCode("100");
			daoRes.setRespMsg("Channel_ID IS INVALID");
			return daoRes;
		}
		// client-channel verification

		List<ClientChannelMapping> channelMappingsList = (List<ClientChannelMapping>) hibernateTempalate
				.findByNamedParam("from ClientChannelMapping where clientId=:clientId and channelId=:channelId",
						new String[] { "clientId", "channelId" },
						new Object[] { daoReq.getClientId(), daoReq.getChannelId() });
		if (channelMappingsList == null || channelMappingsList.size() <= 0) {
			daoRes.setRespCode("102");
			daoRes.setRespMsg("Client Channel Mapping IS INVALID");
			return daoRes;
		}

		// customer details verification
		DetachedCriteria criteria = DetachedCriteria.forClass(CustomerDetails.class);
		criteria.add(Restrictions.eq("cardNumber", daoReq.getCardNum()));
		criteria.add(Restrictions.eq("cvvNumber", daoReq.getCvvNum()));
		criteria.add(Restrictions.eq("expDate", StringToDate.convertStringToDate(daoReq.getExpDate())));
		criteria.add(Restrictions.eq("NameOnCard", daoReq.getNameOnCard()));

		List<CustomerDetails> customerDetailsList = (List<CustomerDetails>) hibernateTempalate.findByCriteria(criteria);
		if (customerDetailsList == null || customerDetailsList.size() <= 0) {
			daoRes.setRespCode("103");
			daoRes.setRespMsg("Customer details are involid");
			return daoRes;
		}
		// criteria = session.createCriteria(TransactionDetails.class);
		// criteria.add(Restrictions.eq("cardNumber", daoReq.getCardNum()));

		criteria = DetachedCriteria.forClass(TransactionDetails.class);
		criteria.add(Restrictions.eq("cardNumber", daoReq.getCardNum()));

		List<TransactionDetails> transactionDetailslist = (List<TransactionDetails>) hibernateTempalate
				.findByCriteria(criteria);

		if (transactionDetailslist == null || transactionDetailslist.size() <= 0) {
			daoRes.setRespCode("104");
			daoRes.setRespMsg("There is no transactions for this account");
			return daoRes;
		} else {
			List<TrasactionDAO> TransDAOList = new ArrayList<TrasactionDAO>();
			for (TransactionDetails dao : transactionDetailslist) {
				TrasactionDAO transDao = new TrasactionDAO();
				transDao.setAmount(String.valueOf(dao.getAmount()));
				transDao.setDate(String.valueOf(dao.getDate()));
				transDao.setDesc(dao.getDescription());
				transDao.setId(String.valueOf(dao.getId()));
				transDao.setMerchantName(dao.getMerchantName());
				transDao.setName(dao.getName());
				transDao.setRemarks(dao.getRemarks());
				transDao.setStatus(dao.getStatus());
				TransDAOList.add(transDao);
			}
			daoRes.setRespCode("000");
			daoRes.setRespMsg("success");
			daoRes.setTransDAO(TransDAOList);
			return daoRes;
		}

	}

	public static void main(String[] args)
			throws ClassNotFoundException, BusinessException, SystemException, SQLException {
		StatementDtlsDAOImplHibernateTemplate daoImpl = new StatementDtlsDAOImplHibernateTemplate();
		StatementDtlsDAOReq daoReq = new StatementDtlsDAOReq();
		daoReq.setCardNum("45900500000321478");
		daoReq.setChannelId("online");
		daoReq.setClientId("web");
		daoReq.setCvvNum(514);
		daoReq.setExpDate("2018-04-03");
		daoReq.setNameOnCard("sunny");

		StatementDtlsDAORes res = daoImpl.getTrasactions(daoReq);
		System.out.println(res.getRespCode());
		System.out.println(res.getRespMsg());
		System.out.println(res.getTransDAO().get(0).getAmount());
	}

}
