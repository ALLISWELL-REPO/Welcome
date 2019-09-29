package org.nhs.patientinfo.dao.hibernate;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.nhs.patientinfo.dao.PatientInfoDao;
import org.nhs.patientinfo.dao.Util.BeginessException;
import org.nhs.patientinfo.dao.Util.SystemException;
import org.nhs.patientinfo.dao.Util.UnKnownException;
import org.nhs.patientinfo.dao.beans.PatientInfoDaoReq;
import org.nhs.patientinfo.dao.beans.PatientInfoDaoRes;

public class DaoIntegrationWithHibernate implements PatientInfoDao {

	public PatientInfoDaoRes createPatient(PatientInfoDaoReq dreq)

			throws BeginessException, SystemException, UnKnownException {
		PatientInfoDaoReq request = new PatientInfoDaoReq();
		Configuration con;
		SessionFactory sessionFactory;
		Session session;
		Transaction transaction;
		con = new Configuration().configure();
		sessionFactory = con.buildSessionFactory();
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		String PatientName=(String)session.save(request);
		System.out.println("patinetInfo:"+PatientName);
		PatientInfoDaoRes res=new PatientInfoDaoRes();
		                  res.setResMsg("Sucsess");
		                  res.setRespCode("0");
		 

		return res;
	}

}
