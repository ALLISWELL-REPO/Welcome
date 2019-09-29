package org.o2.registersvc.intg.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.o2.registersvc.entity.AccountDetails;
import org.o2.registersvc.entity.ChannelDetails;
import org.o2.registersvc.entity.ClientDetails;
import org.o2.registersvc.entity.CustomerDetails;
import org.o2.registersvc.intg.RegisterSvcDAO;
import org.o2.registersvc.intg.beans.RegisterSvcDAOReq;
import org.o2.registersvc.intg.beans.RegisterSvcDAORes;
import org.o2.registersvc.intg.util.BussinessException;
import org.o2.registersvc.intg.util.HibernateUtility;
import org.o2.registersvc.intg.util.SystemException;
import org.o2.registersvc.intg.util.UnknownException;

public class RegisterSvcDAOImpl implements RegisterSvcDAO {

	private Logger logger = Logger.getLogger(RegisterSvcDAOImpl.class);

	RegisterSvcDAORes daoResp = null;

	public RegisterSvcDAORes enrollment(RegisterSvcDAOReq daoReq)
			throws BussinessException, SystemException, UnknownException, SQLException {

		SessionFactory factory=null;
		Session session=null;
		Transaction txn=null;
		
		try {
			// create Session Factory
		 factory = HibernateUtility.getSessionFactory();

			// crete session object
			session = factory.openSession();
			
			//cretae transaction
			txn = session.beginTransaction();


			// check client_id
			Criteria criteria2 = session.createCriteria(ClientDetails.class);
			criteria2.add(Restrictions.eq("clientId", daoReq.getClientId()));
			List clientId = criteria2.list();

			// check channel id
			Criteria criteria3 = session.createCriteria(ChannelDetails.class);
			criteria3.add(Restrictions.eq("channelId", daoReq.getChannelId()));
			List channelId = criteria3.list();

			Query query = session.createQuery("from AccountDetails where accId=? and mobNumb=?");
			query.setString(0, daoReq.getAccountNum());
			query.setLong(1, daoReq.getMobileNum());
			List<AccountDetails> accountDetails2 = query.list();

			if (clientId.size() > 0 && channelId.size() > 0 && accountDetails2.size() > 0) {

				// create customer details object
				CustomerDetails details = new CustomerDetails();

				// set customerdetails values
				details.setCardNumb(daoReq.getCardNum());
				details.setCvv(daoReq.getCvv());
				details.setExpDate(daoReq.getExpDate());
				details.setMobNumb(daoReq.getMobileNum());
				details.setNameOnCard(daoReq.getNameOnCard());


				Object sno = session.save(details);
                txn.commit();
				if (sno != null) {

					daoResp = new RegisterSvcDAORes();
					daoResp.setDaoRespCode("0000");
					daoResp.setDaoRespMsg("sucess");
				}
			} else if (clientId.size() == 0) {
				daoResp = new RegisterSvcDAORes();
				daoResp.setDaoRespCode("1001");
				daoResp.setDaoRespMsg("invalide clientId");
			} else if (channelId.size() == 0) {
				daoResp = new RegisterSvcDAORes();
				daoResp.setDaoRespCode("1002");
				daoResp.setDaoRespMsg("invalid channelId");
			} else if (accountDetails2.size() == 0) {
				daoResp = new RegisterSvcDAORes();
				daoResp.setDaoRespCode("1003");
				daoResp.setDaoRespMsg("invalideAcountId or mobileNo");
			}
			System.out.println(daoResp);
			
		} catch (Exception e) {
         txn.rollback();
		}
		return daoResp;
	}
}
