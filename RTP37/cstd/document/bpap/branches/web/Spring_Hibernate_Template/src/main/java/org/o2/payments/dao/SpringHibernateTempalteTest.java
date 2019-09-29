package org.o2.payments.dao;

import org.o2.payment.model.RegisterHbRequest;
import org.o2.payment.model.RegisterHbResponse;

public class SpringHibernateTempalteTest {

	public static void main(String[] args) {
		SpringHiberanteTemplateDAOImpl ht=new SpringHiberanteTemplateDAOImpl();
		RegisterHbRequest req=new RegisterHbRequest();
		req.setCardName("hhh");
			req.setCvvNum("898");
			req.setExpDate("332");
			req.setMobileNum(1221);
			req.setCardNum("33");
			RegisterHbResponse resp=ht.enrollment(req);
			System.out.println(resp);

	}

}
