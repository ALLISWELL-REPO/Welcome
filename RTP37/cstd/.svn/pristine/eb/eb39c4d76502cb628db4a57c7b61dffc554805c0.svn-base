package org.o2.registersvc.process.impl;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.o2.registersvc.creditcheck.beans.CreditCheckRequest;
import org.o2.registersvc.creditcheck.beans.CreditCheckResponse;
import org.o2.registersvc.creditcheck.impl.CreditCheckSvcClientImpl;
import org.o2.registersvc.intg.beans.RegisterSvcDAOReq;
import org.o2.registersvc.intg.beans.RegisterSvcDAORes;
import org.o2.registersvc.intg.impl.RegisterSvcDAOImpl;
import org.o2.registersvc.intg.util.BussinessException;
import org.o2.registersvc.intg.util.SystemException;
import org.o2.registersvc.intg.util.UnknownException;
import org.o2.registersvc.process.RegisterSvcProcess;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBReq;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBRes;
import org.o2.registersvc.process.builder.RegisterSvcProcessReqBuilder;
import org.o2.registersvc.process.builder.RegisterSvcProcessResBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterSvcProcessImpl implements RegisterSvcProcess {

	private Logger logger = Logger.getLogger(RegisterSvcProcessImpl.class);

	@Autowired
	private CreditCheckSvcClientImpl clientimpl;
	
	@Autowired
	private RegisterSvcDAORes daoResp;

	@Autowired
	private RegisterSvcDAOImpl daoimpl;

	@Autowired
	private RegisterSvcDAOReq daoReq;

	@Autowired
	private RegisterSvcProcessReqBuilder procReqBuild;

	@Autowired
	private CreditCheckResponse credCheckResps;
	
	@Autowired
	private RegisterSvcProcessResBuilder procResBuilder;
	
	@Autowired
	private RegisterSvcProcessVBRes processVbResp;
	
	@Autowired
	private CreditCheckRequest credCheckReq ;

	public RegisterSvcProcessVBRes enrollment(RegisterSvcProcessVBReq vbreq)
			throws BussinessException, SystemException, UnknownException, SQLException, IOException {

		logger.debug("enter into process layer with vbReq:"+vbreq);
		System.out.println("Enter into process  layer");

		// build creditcheck req
		credCheckReq = procReqBuild.buildCreditCheckReq(vbreq);

		// call the creditcheck by passing creditcheck request
		credCheckResps = clientimpl.getCreditScore(credCheckReq);

		// if client credit score more than 60% then we call dao layer
		if (credCheckResps != null && credCheckResps.getScore() >= 60) {
			// prepare the dao Req
			daoReq = procReqBuild.buildDaoReq(vbreq);

			// call the dao layer by passing dao request
			daoResp = daoimpl.enrollment(daoReq);
			System.out.println("Dao Resp Code and Message in ProcessLayer::"+daoResp.getDaoRespCode()+daoResp.getDaoRespMsg());
			
		}

        //prepare processVbResp with creditcheckResp
		processVbResp = procResBuilder.buildSerLayResp(credCheckResps);
		
		//prepare procesVbResp with daoResp
		processVbResp=procResBuilder.buildSerLayRespWithDaoResp(daoResp);

		logger.debug("exit from process layer processVbResp=" + processVbResp);
		System.out.println("process RespCode and Message in ProcessLayer::"+processVbResp.getRespCode()+processVbResp.getRespMsg());
		return processVbResp;
	}

}
