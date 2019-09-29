package org.o2.registersvc.service.impl;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.o2.registersvc.intg.util.BussinessException;
import org.o2.registersvc.intg.util.SystemException;
import org.o2.registersvc.intg.util.UnknownException;
import org.o2.registersvc.process.RegisterSvcProcess;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBReq;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBRes;
import org.o2.registersvc.schema.req.AccountDetailsType;
import org.o2.registersvc.schema.req.CardDetailsType;
import org.o2.registersvc.schema.req.ClientDetailsType;
import org.o2.registersvc.schema.req.RegisterServiceReqType;
import org.o2.registersvc.schema.res.RegisterServiceResType;
import org.o2.registersvc.schema.res.StatusBlockType;
import org.o2.registersvc.service.RegisterService;
import org.o2.registersvc.service.builder.RegisterSvcReqBuilder;
import org.o2.registersvc.service.builder.RegisterSvcResBuilder;
import org.o2.registersvc.service.springconfig.SpringConfig;
import org.o2.registersvc.service.util.RegisterSvcReqInvalid;
import org.o2.registersvc.service.validator.RegisterSvcValidator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@WebService(endpointInterface = "org.o2.registersvc.service.RegisterService")
public class RegisterServiceImpl implements RegisterService {
	
	//create logger object
	private Logger logger=Logger.getLogger(RegisterServiceImpl.class);
	
	
	private RegisterSvcValidator validator;
	private RegisterSvcReqBuilder svcReqBuilder;
	private RegisterSvcProcess process;
	private RegisterSvcResBuilder respBuilder;
	
	public RegisterServiceResType enrollment(RegisterServiceReqType wsReq) {

		
		ApplicationContext context=new AnnotationConfigApplicationContext(SpringConfig.class);
		
		validator=context.getBean(RegisterSvcValidator.class);
		svcReqBuilder=context.getBean(RegisterSvcReqBuilder.class);
		process=context.getBean(RegisterSvcProcess.class);
		respBuilder=context.getBean(RegisterSvcResBuilder.class);
		
		logger.debug("enter into service layer");
		logger.info("Ws Req"+wsReq);
		
		// get the request from client

		RegisterServiceResType wsresp = null;

		try {
			// validate the req
			
			//RegisterSvcValidator validator = new RegisterSvcValidator();
			validator.validatewsReq(wsReq);
		
			// prepare the process layer request
			//RegisterSvcReqBuilder svcReqBuilder = new RegisterSvcReqBuilder();
			RegisterSvcProcessVBReq vbReq = svcReqBuilder.buildProcessRequest(wsReq);

			// call the process layer by passing process request
			//RegisterSvcProcess process = new RegisterSvcProcessImpl();
			RegisterSvcProcessVBRes vbResp = process.enrollment(vbReq);

			// prepare service layer response
			//RegisterSvcResBuilder respBuilder = new RegisterSvcResBuilder();
			wsresp = respBuilder.buildWSResponse(vbResp);

		} catch (RegisterSvcReqInvalid exce) {
			logger.error("RegisterSvcReqInvalid",exce);
			wsresp = new RegisterServiceResType();
			StatusBlockType status = new StatusBlockType();
			status.setRespCode(exce.getRespCode());
			status.setRespMsg(exce.getRespMsg());
			wsresp.setStatusBlock(status);
          
			
		} catch (BussinessException e) {
			logger.error("BussinessException",e);
			wsresp = new RegisterServiceResType();
			StatusBlockType status = new StatusBlockType();
			status.setRespCode(e.getDbRespCode());
			status.setRespMsg(e.getDbRespMsg());
			wsresp.setStatusBlock(status);
		} catch (SystemException e) {
			logger.error("SystemException",e);
			wsresp = new RegisterServiceResType();
			StatusBlockType status = new StatusBlockType();
			status.setRespCode(e.getDbRespCode());
			status.setRespMsg(e.getDbRespMsg());
			wsresp.setStatusBlock(status);
		} catch (UnknownException e) {
			logger.error("UnknownException",e);
			wsresp = new RegisterServiceResType();
			StatusBlockType status = new StatusBlockType();
			status.setRespCode(e.getDbRespCode());
			status.setRespMsg(e.getDbRespMsg());
			wsresp.setStatusBlock(status);
			e.printStackTrace();
		} catch (Exception e) {
			logger.fatal("Exception",e);
			wsresp = new RegisterServiceResType();
			StatusBlockType status = new StatusBlockType();
			status.setRespCode("reg111");
			status.setRespMsg("Generic error message");
			wsresp.setStatusBlock(status);
		}
		
        logger.info("exit from serviceLayer  wsResp="+wsresp);
		return wsresp;

	}

	public static void main(String[] args) {
		
		RegisterServiceImpl svcImpl = new RegisterServiceImpl();
		RegisterServiceReqType wsReq = new RegisterServiceReqType();
		
		
		AccountDetailsType acctDetails = new AccountDetailsType();
		acctDetails.setAccNumber("123");
		acctDetails.setMobNumber(321);
		
		ClientDetailsType clientDtails = new ClientDetailsType();
		clientDtails.setChannelId("web");
		clientDtails.setClientId("101");
		//clientDtails.setReqId("523");
	
		CardDetailsType cardDtls = new CardDetailsType();
		cardDtls.setCardNum("1256565");
		cardDtls.setCvv("123");
		cardDtls.setExpDate("20/2563");
		cardDtls.setNameOnCard("chuoa");
		

		wsReq.setAccountDetails(acctDetails);
		wsReq.setClientDetails(clientDtails);
		wsReq.setCardDetails(cardDtls);
		//call svcImpl method
		RegisterServiceResType wsResp = svcImpl.enrollment(wsReq);
		
		System.out.println("wsresp is :" + wsResp.getStatusBlock().getRespCode());
		System.out.println(" "+wsResp.getStatusBlock().getRespMsg());
	}

}
