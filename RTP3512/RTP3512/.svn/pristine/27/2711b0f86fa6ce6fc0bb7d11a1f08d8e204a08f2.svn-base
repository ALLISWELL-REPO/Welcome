package org.nhs.patientinfo.dao.Impl1;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.nhs.patientinfo.dao.beans.PatientInfoDaoReq;
import org.nhs.patientinfo.dao.beans.PatientInfoDaoRes;
import org.nhs.patientinfo.dao.beans.patientdetails;
import org.nhs.patientinfo.dao.builder.PatientInfoRequestBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class SpringOrm {
	private HibernateTemplate hibernateTemplate = null;
	private patientdetails details = null;
	private PatientInfoDaoRes daores = null;
	PatientInfoRequestBuilder builder = new PatientInfoRequestBuilder();

	public SpringOrm() {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		hibernateTemplate = context.getBean(HibernateTemplate.class);
	}

	public int createPatient(PatientInfoDaoReq req) {
		PatientInfoRequestBuilder builder = new PatientInfoRequestBuilder();
		patientdetails details = builder.createPatient(req);

		if (details.getPatientId() == 0 && details.getNhs_number() == 0 && details.getCreated_by() != null
				&& details.getFirst_name() != null && details.getLast_name() != null && details.getPostal_code() == 0) {
			int patientid = (Integer) hibernateTemplate.save(details);
			System.out.println("this is patientDetails:" + patientid);
		}

		return 0;

	}

	public List<PatientInfoDaoRes> searchpatient(int PatientId) {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(patientdetails.class);
		            
		return (List<PatientInfoDaoRes>) daores;

	}

}
