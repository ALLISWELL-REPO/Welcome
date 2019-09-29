package org.o2.registersvc.process.builder;

import org.apache.log4j.Logger;
import org.o2.registersvc.creditcheck.beans.CreditCheckResponse;
import org.o2.registersvc.intg.beans.RegisterSvcDAORes;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBRes;
import org.o2.registersvc.process.impl.RegisterSvcProcessImpl;
import org.springframework.stereotype.Component;

@Component
public class RegisterSvcProcessResBuilder {

	 //create logger object
	private Logger logger=Logger.getLogger(RegisterSvcProcessImpl.class);
	
	public RegisterSvcProcessVBRes buildSerLayResp(CreditCheckResponse credCheckResp) {
		logger.info("enter into RegisterSvcProcessResBuilder credCheckResp"+credCheckResp);
		
		RegisterSvcProcessVBRes processVBRes = new RegisterSvcProcessVBRes();
		processVBRes.setRespCode(credCheckResp.getRespCode());
		processVBRes.setRespMsg(credCheckResp.getRespMsg());
		processVBRes.setScore(credCheckResp.getScore());
		processVBRes.setStatus(credCheckResp.getStatus());		
		
		logger.info("exit from RegisterSvcProcessResBuilder processVBRes"+processVBRes);
		return processVBRes;
	}


}
