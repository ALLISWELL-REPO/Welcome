package org.o2.registersvc.process.impl;

import java.io.IOException;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.o2.registersvc.creditcheck.CreditCheckSvcClient;
import org.o2.registersvc.creditcheck.beans.CreditCheckRequest;
import org.o2.registersvc.creditcheck.beans.CreditCheckResponse;
import org.o2.registersvc.intg.RegisterSvcDAO;
import org.o2.registersvc.intg.beans.RegisterSvcDAOReq;
import org.o2.registersvc.intg.beans.RegisterSvcDAORes;
import org.o2.registersvc.intg.impl.RegisterSvcDAOImpl_Springjdbc;
import org.o2.registersvc.intg.util.BussinessException;
import org.o2.registersvc.intg.util.SystemException;
import org.o2.registersvc.intg.util.UnknownException;
import org.o2.registersvc.process.RegisterSvcProcess;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBReq;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBRes;
import org.o2.registersvc.process.builder.RegisterSvcProcessReqBuilder;
import org.o2.registersvc.process.builder.RegisterSvcProcessResBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class RegisterSvcProcessImpl implements RegisterSvcProcess {

	    //create logger object
		private Logger logger=Logger.getLogger(RegisterSvcProcessImpl.class);
		
		@Autowired
	    private CreditCheckSvcClient client;
		
		@Autowired
		private JdbcTemplate jt;
		
		@Autowired
		private RegisterSvcProcessReqBuilder procReqBuild;
		
	    @Autowired
		private RegisterSvcDAO dao;
		
	    @Autowired
	    private RegisterSvcProcessResBuilder procResBuilder;

	public RegisterSvcProcessVBRes enrollment(RegisterSvcProcessVBReq vbreq) throws BussinessException, SystemException, UnknownException, SQLException, IOException {
     
		
		logger.debug("enter into process layer");
		
		RegisterSvcDAORes daoResp = null;
		
		// create request for creditcheck
		CreditCheckResponse credCheckResps = null;
		//RegisterSvcProcessReqBuilder procReqBuild = new RegisterSvcProcessReqBuilder();
		CreditCheckRequest credCheckReq = procReqBuild.buildCreditCheckReq(vbreq);

		// call the creditcheck by passing creditcheck request
		//CreditCheckSvcClient client = new CreditCheckSvcClientImpl();
		
		credCheckResps = client.getCreditScore(credCheckReq);

		// if client credit score more than 60% then we call dao layer
		if (credCheckResps != null && credCheckResps.getScore() >= 60) {

			// prepare the request for dao layer
			RegisterSvcDAOReq daoReq = procReqBuild.buildDaoReq(vbreq);

			// call the dao layer by passing dao request
			//RegisterSvcDAO dao = new RegisterSvcDAOImpl_Springjdbc(jt);
			daoResp = dao.enrollment(daoReq);
		}

		// return process layer response to service layer
		//RegisterSvcProcessResBuilder procResBuilder = new RegisterSvcProcessResBuilder();
		
		RegisterSvcProcessVBRes processVbResp = procResBuilder.buildSerLayResp(credCheckResps);
		
		logger.debug("exit from process layer processVbResp="+processVbResp);
		
		return processVbResp;
	}

}
