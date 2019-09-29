package org.o2.payments.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.o2.payment.entities.ChannelDetails;
import org.o2.payment.entities.CustomerDetails;
import org.o2.payment.model.RegisterHbRequest;
import org.o2.payment.model.RegisterHbResponse;
import org.o2.payment.utils.HibernateUtility;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate4.HibernateTemplate;

public class SpringHiberanteTemplateDAOImpl implements SpringHibernateTemplateDAO{

	public RegisterHbResponse enrollment(RegisterHbRequest req) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext_hibernateTemplate.xml");
		HibernateTemplate hibernateTemplate = (HibernateTemplate)ctx.getBean("hibernateTempalate");
		RegisterHbResponse res=new RegisterHbResponse();
		Session session=hibernateTemplate.getSessionFactory().openSession();
		//mobile num using hql
		/*Query query = session.createQuery("from CustomerDetails where mobile_num=?");
		query.setLong(0,req.getMobileNum());
		List<CustomerDetails> CustomerDetailsList=query.list();
		System.out.println("CustomerDetailsList::"+CustomerDetailsList);
		if(CustomerDetailsList.size()<0){
			res.setRespCode("Reg999");
			res.setRespMsg("Invalid mob num");
			return res;
		}//if
		else{
			for(CustomerDetails cd:CustomerDetailsList){
				int mobilenum=cd.getMobile_num();
				break;
			}//for
		}//else
*/		
		//channel id using criteria
		
				/*Criteria criteria = session.createCriteria(ChannelDetails.class);
				criteria.add(Restrictions.eq("channel_id",
						req.getChannelId()));
				List<ChannelDetails> channelList = criteria.list();
				if (channelList == null && (channelList.size() <= 0)) {
					res.setRespCode("RG101");
					res.setRespMsg("INVALID CHANNEL ID");
					return res;
				} else {
					for (ChannelDetails channel : channelList) {
						String channel_id = channel.getChannel_id();
						break;
					}
				}*/
		
		//customer Details
		
		Criteria criteria2 = session.createCriteria(CustomerDetails.class);
		criteria2.add(Restrictions.eq("card_num", req.getCardNum()));
		criteria2.add(Restrictions.eq("cvv", req.getCvvNum()));
		List<CustomerDetails> customerDetails = criteria2.list();
		System.out.println("customerDetails"+customerDetails);
		if (customerDetails == null && (customerDetails.size() <= 0)) {
			res.setRespCode("RG1002");
			res.setRespMsg("INVALID CARD NUM or CVV Number or Exp date");
			return res;
		}
				
		/*Criteria criteria=session.createCriteria(ChannelDetails.class);
		criteria.add(Restrictions)
*/		res.setRespCode("reg000");
		res.setRespMsg("Sucess");
		session.close();
		HibernateUtility.shutdown();
		return res;
	}
	
	
	
}
