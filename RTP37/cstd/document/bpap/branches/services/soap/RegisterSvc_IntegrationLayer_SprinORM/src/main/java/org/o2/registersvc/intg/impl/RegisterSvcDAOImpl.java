package org.o2.registersvc.intg.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.o2.registersvc.entity.ChannelDetails;
import org.o2.registersvc.entity.CustomerDetails;
import org.o2.registersvc.intg.RegisterSvcDAO;
import org.o2.registersvc.intg.beans.RegisterSvcDAOReq;
import org.o2.registersvc.intg.beans.RegisterSvcDAORes;
import org.o2.registersvc.intg.util.BussinessException;
import org.o2.registersvc.intg.util.HibernateUtility;
import org.o2.registersvc.intg.util.SystemException;
import org.o2.registersvc.intg.util.UnknownException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.HibernateTemplate;

public class RegisterSvcDAOImpl implements RegisterSvcDAO {

	private Logger logger = Logger.getLogger(RegisterSvcDAOImpl.class);

	RegisterSvcDAORes daoResp = null;

	public RegisterSvcDAORes enrollment(RegisterSvcDAOReq daoReq)
			throws BussinessException, SystemException, UnknownException, SQLException {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext_hibernateTemplate.xml");
		HibernateTemplate hibernateTemplate = (HibernateTemplate) ctx.getBean("hibernateTempalate");
		daoResp = new RegisterSvcDAORes();
		Session session = hibernateTemplate.getSessionFactory().openSession();

		// Verifying mobile numb
		Query query = session.createQuery("from CustomerDetails where mobile_num=?");
		query.setLong(0, daoReq.getMobileNum());
		List<CustomerDetails> CustomerDetailsList = query.list();
		System.out.println("CustomerDetailsList::" + CustomerDetailsList);

		if (CustomerDetailsList.size() == 0) {
			daoResp.setDaoRespCode("10001");
			daoResp.setDaoRespMsg("Invalid mobNumb");
			return daoResp;
		}

		// verifying channelId
		Criteria criteria = session.createCriteria(ChannelDetails.class);
		criteria.add(Restrictions.eq("channel_id", daoReq.getChannelId()));
		List<ChannelDetails> channelList = criteria.list();
		if (channelList == null && (channelList.size() <= 0)) {
			daoResp.setDaoRespCode("RG101");
			daoResp.setDaoRespMsg("Invalid channelId");
		} 

		// customer Details

		/*
		 * Criteria criteria=session.createCriteria(ChannelDetails.class);
		 * criteria.add(Restrictions)
		 */ daoResp.setDaoRespCode("0000");
		daoResp.setDaoRespMsg("Sucess");
		session.close();
		HibernateUtility.shutdown();

		return null;

	}
}
