package org.o2.registersvc.creditcheck.impl;

import org.apache.log4j.Logger;
import org.o2.registersvc.creditcheck.CreditCheckSvcClient;
import org.o2.registersvc.creditcheck.beans.CreditCheckRequest;
import org.o2.registersvc.creditcheck.beans.CreditCheckResponse;
import org.springframework.stereotype.Component;

@Component
public class CreditCheckSvcClientImpl implements CreditCheckSvcClient {

	 //create logger object
	private Logger logger=Logger.getLogger(CreditCheckSvcClientImpl.class);	
	
	public CreditCheckResponse getCreditScore(CreditCheckRequest req) {
		logger.info("enter into CreditCheckSvcClientImpl req="+req);
		CreditCheckResponse creditCheckResp =new CreditCheckResponse();
		creditCheckResp.setRespCode("000");
		creditCheckResp.setRespMsg("success");
		creditCheckResp.setScore(60.0f);
		creditCheckResp.setStatus("good");
		
		logger.info("exit from CreditCheckSvcClientImpl creditCheckResp="+creditCheckResp);
		return creditCheckResp;
	}

}
