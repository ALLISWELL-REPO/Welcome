package org.nhs.patientdaodetails.services;

import java.io.Serializable;
import java.text.ParseException;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.nhs.patientdaodetails.beans.PatientDetailsDAOReq;
import org.nhs.patientdaodetails.beans.PatientDetailsDAORes;
import org.nhs.patientdaodetails.builders.PatientDetailsDAOReqBuilder;
import org.nhs.patientdaodetails.builders.PatientDetailsDAOResBuilder;
import org.nhs.patientdaodetails.entities.PatientDetails;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.HibernateTemplate;

public class NHSPatientDetailsServiceImpl implements NHSPatientDetailsService {

	private HibernateTemplate hibernateTemplate = null;
	PatientDetailsDAOReqBuilder reqBuilder = new PatientDetailsDAOReqBuilder();
	PatientDetailsDAOResBuilder resBuild = new PatientDetailsDAOResBuilder();

	public NHSPatientDetailsServiceImpl() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		hibernateTemplate = applicationContext.getBean("hibernateTemplate", HibernateTemplate.class);
	}

	public List<PatientDetailsDAORes> searchPatient(PatientDetailsDAOReq req) throws ParseException {

		PatientDetails dtls = reqBuilder.buildPatientDetailsSearchReq(req);

		DetachedCriteria criteria = DetachedCriteria.forClass(PatientDetails.class);
		if (dtls.getFname() != null) {
			System.out.println("fname"+dtls.getFname());
			criteria.add(Restrictions.eq("fname", dtls.getFname()));
			System.out.println(criteria);
		}
		if (dtls.getLname() != null) {
			System.out.println("lname"+dtls.getLname());
			criteria.add(Restrictions.eq("lname", dtls.getLname()));
			System.out.println(criteria);
		}
		if (dtls.getNhsNumber() != null) {
			System.out.println("nhsNumber"+ dtls.getNhsNumber());
			criteria.add(Restrictions.eq("nhsNumber", dtls.getNhsNumber()));
			System.out.println(criteria);
		}
		if (dtls.getPostalCode() != null) {
			System.out.println("postalCode"+ dtls.getPostalCode());
			criteria.add(Restrictions.eq("postalCode", dtls.getPostalCode()));
			System.out.println(criteria);
		}
		if (dtls.getDOB() != null) {
			System.out.println("DOB"+ dtls.getDOB());
			criteria.add(Restrictions.eq("DOB", dtls.getDOB()));
			System.out.println(criteria);
		}
		if (dtls.getGender() != null) {
			System.out.println("gender"+ dtls.getGender());
			criteria.add(Restrictions.eq("gender", dtls.getGender()));
			System.out.println(criteria);
	
		}
		System.out.println(criteria);
		List<PatientDetails> pdtls = (List<PatientDetails>) hibernateTemplate.findByCriteria(criteria);
		PatientDetailsDAOResBuilder resBuild = new PatientDetailsDAOResBuilder();
		List<PatientDetailsDAORes> resp = resBuild.buildPatientDetailsRes(pdtls);
		return resp;
	}

	public Integer createPatient(PatientDetailsDAOReq req) throws ParseException {
		PatientDetailsDAOReqBuilder request = new PatientDetailsDAOReqBuilder();
		PatientDetails pt_Dtls = request.buildPatientDetailsReq(req);
		if (pt_Dtls.getCreatedBy() != null && pt_Dtls.getCreatedDate() != null && pt_Dtls.getDOB() != null
				&& pt_Dtls.getFname() != null && pt_Dtls.getGender() != null && pt_Dtls.getLname() != null
				&& pt_Dtls.getNationalIdentifierType() != null && pt_Dtls.getNationalPatientId() != null
				&& pt_Dtls.getNationalPatientId() != null && pt_Dtls.getNhsNumber() != null
				&& pt_Dtls.getPostalCode() != null) {
			pt_Dtls.setStatus("Completed");
		} else {
			pt_Dtls.setStatus("Draft");
		}
		int pt_id = (Integer) hibernateTemplate.save(pt_Dtls);
		System.out.println("Patient Record created");
		return pt_id;
	}

	public void updatePatient(PatientDetailsDAOReq req) throws ParseException {
		PatientDetailsDAOReqBuilder request = new PatientDetailsDAOReqBuilder();
		PatientDetails pt_Dtls = request.buildPatientDetailsReq(req);
		if (pt_Dtls.getCreatedBy() != null && pt_Dtls.getCreatedDate() != null && pt_Dtls.getDOB() != null
				&& pt_Dtls.getFname() != null && pt_Dtls.getGender() != null && pt_Dtls.getLname() != null
				&& pt_Dtls.getNationalIdentifierType() != null && pt_Dtls.getNationalPatientId() != null
				&& pt_Dtls.getNationalPatientId() != null && pt_Dtls.getNhsNumber() != null
				&& pt_Dtls.getPostalCode() != null) {
			pt_Dtls.setStatus("Completed");
		} else {
			pt_Dtls.setStatus("Draft");
		}

		hibernateTemplate.save((pt_Dtls));

		System.out.println("Patient Record Updated");

	}

	public List<PatientDetailsDAORes> getPatient(Integer pid) {
		DetachedCriteria criteria = DetachedCriteria.forClass(PatientDetails.class);
		criteria.add(Restrictions.eq("id", pid));
		List<PatientDetails> pDetails = (List<PatientDetails>) hibernateTemplate.findByCriteria(criteria);
		List<PatientDetailsDAORes> daoRes = resBuild.buildPatientDetailsRes(pDetails);
		return daoRes;
	}

	public static void main(String[] args) throws ParseException {
		NHSPatientDetailsServiceImpl impl = new NHSPatientDetailsServiceImpl();

		PatientDetailsDAOReq daoReq = new PatientDetailsDAOReq();
		daoReq.setCreatedBy("s4");
		daoReq.setCreatedDate("12-05-2010");
		daoReq.setDateofBirth("12-05-2010");
		daoReq.setFirstName("vinni");
		daoReq.setGender("male");
		daoReq.setId("18");
		daoReq.setLastName("anand");
		daoReq.setNhsNumber("nhs1234");
		daoReq.setPostalCode("postal2343");
		daoReq.setUpdatedBy("ytor");
		daoReq.setUpdatedDate("12-05-2010");

		// req.setDOB("12-05-2010");
		/*
		 * int id = impl.createPatient(daoReq); System.out.println(id);
		 */
		/*
		 * PatientDetailsDAOReq req=new PatientDetailsDAOReq();
		 * req.setFirstName("vineet"); req.setLastName("anand");
		 * List<PatientDetailsDAORes> list = impl.searchPatient(req);
		 * 
		 * 
		 * for(PatientDetailsDAORes res:list) { System.out.println("sad");
		 * System.out.println(res.getFirstName());
		 * System.out.println(res.getLastName()); }
		 * System.out.println(list.size());
		 * 
		 * List<PatientDetailsDAORes> res = impl.getPatient(9);
		 * System.out.println(res);
		 * 
		 * 
		 */
		impl.updatePatient(daoReq);
	}

}
