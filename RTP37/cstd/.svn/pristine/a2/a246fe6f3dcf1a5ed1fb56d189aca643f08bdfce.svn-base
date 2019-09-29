
package org.o2.registersvc.service.builder;

import org.apache.log4j.Logger;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBRes;
import org.o2.registersvc.res.CreditCheckType;
import org.o2.registersvc.res.RegisterServiceResType;
import org.o2.registersvc.res.StatusBlockType;
import org.springframework.stereotype.Component;

@Component
public class RegisterSvcResBuilder {

	// create logger object
	private Logger logger = Logger.getLogger(RegisterSvcResBuilder.class);

	public RegisterServiceResType buildWSResponse(RegisterSvcProcessVBRes vbResp) {

		logger.info("enter into RegisterSvcResBuilder vbResp=" + vbResp);
		// prepare the statusblock
		StatusBlockType stBlock = new StatusBlockType();
		stBlock.setRespCode(vbResp.getRespCode());
		stBlock.setRespMsg(vbResp.getRespMsg());

		// prepare the creditcheck obj
		CreditCheckType creditCheck = new CreditCheckType();
		creditCheck.setCreditStatus(vbResp.getStatus());
		creditCheck.setRateOfPer(vbResp.getScore());

		RegisterServiceResType wsResp = new RegisterServiceResType();
		wsResp.setCreditCheck(creditCheck);
		wsResp.setStatusBlock(stBlock);
		
		logger.info("exit from RegisterSvcResBuilder wsResp=" + wsResp);
		return wsResp;
	}

}
