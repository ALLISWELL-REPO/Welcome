package org.o2.registersvc.process.builder;

import org.apache.log4j.Logger;
import org.o2.registersvc.creditcheck.beans.CreditCheckRequest;
import org.o2.registersvc.intg.beans.RegisterSvcDAOReq;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBReq;
import org.o2.registersvc.process.impl.RegisterSvcProcessImpl;
import org.springframework.stereotype.Component;

@Component
public class RegisterSvcProcessReqBuilder {

	// create logger object
	private Logger logger = Logger.getLogger(RegisterSvcProcessImpl.class);

	public CreditCheckRequest buildCreditCheckReq(RegisterSvcProcessVBReq vbreq) {
      
		logger.info("enter into RegisterSvcProcessReqBuilder  vbReq="+vbreq);
		CreditCheckRequest credCheckReq = new CreditCheckRequest();
		credCheckReq.setCardNum(vbreq.getCardNum());
		credCheckReq.setCvv(vbreq.getCvv());
		credCheckReq.setExpDate(vbreq.getExpDate());
		credCheckReq.setNameOnCard(vbreq.getNameOnCard());
		credCheckReq.setChannelId(vbreq.getChannelId());
		credCheckReq.setClientId(vbreq.getClientId());

		logger.info("exit from RegisterSvcProcessReqBuilder credCheckReq="+credCheckReq);
		return credCheckReq;
	}

	public RegisterSvcDAOReq buildDaoReq(RegisterSvcProcessVBReq vbreq) {
		logger.info("enter into RegisterSvcProcessReqBuilder  vbreq="+vbreq);
		RegisterSvcDAOReq daoReq = new RegisterSvcDAOReq();
		daoReq.setCardNum(vbreq.getCardNum());
		daoReq.setChannelId(vbreq.getChannelId());
		daoReq.setClientId(vbreq.getClientId());
		daoReq.setCvv(vbreq.getCvv());
		daoReq.setExpDate(vbreq.getExpDate());
		daoReq.setMobileNum(vbreq.getMobileNum());
		daoReq.setNameOnCard(vbreq.getNameOnCard());
		daoReq.setAccountNum(vbreq.getAccountNum());
		logger.info("exit from RegisterSvcProcessReqBuilder daoReq="+daoReq);
		return daoReq;
	}

}
