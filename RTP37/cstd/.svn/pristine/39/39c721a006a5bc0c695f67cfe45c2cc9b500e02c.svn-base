package org.o2.registersvc.service.builder;

import org.apache.log4j.Logger;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBReq;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBRes;
import org.o2.registersvc.schema.req.RegisterServiceReqType;
import org.o2.registersvc.schema.res.RegisterServiceResType;
import org.o2.registersvc.service.impl.RegisterServiceImpl;
import org.springframework.stereotype.Component;


public class RegisterSvcReqBuilder {

	//create logger object
	private Logger logger=Logger.getLogger(RegisterSvcReqBuilder.class);
	
	public RegisterSvcProcessVBReq buildProcessRequest(RegisterServiceReqType wsReq) {
        
		logger.debug("enter into RegisterSvcReqBuilder class");
		RegisterSvcProcessVBReq req = new RegisterSvcProcessVBReq();
	
		req.setClientId(wsReq.getClientDetails().getClientId());
		req.setChannelId(wsReq.getClientDetails().getChannelId());
		req.setAccountNum(wsReq.getAccountDetails().getAccNumber());
		req.setMobileNum(wsReq.getAccountDetails().getMobNumber());
		req.setCardNum(wsReq.getCardDetails().getCardNum());
		req.setCvv(wsReq.getCardDetails().getCvv());
		req.setExpDate(wsReq.getCardDetails().getExpDate());
		req.setNameOnCard(wsReq.getCardDetails().getNameOnCard());
        
		logger.debug("exit from RegisterSvcReqBuilder class vbReq"+req);
		return req;
	}

	

}
