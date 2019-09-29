package org.nhs.patientinfosrv.patientinfosrv.Impl;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.nhs.patientinfo.dao.Util.BeginessException;
import org.nhs.patientinfo.dao.Util.SystemException;
import org.nhs.patientinfo.dao.Util.UnKnownException;
import org.nhs.patientinfo.process.PatientInfoProcess;
import org.nhs.patientinfo.process.Impl.PatientInfoProcessImpl;
import org.nhs.patientinfo.process.ValueBeans.PatientInfoProcessVbReq;
import org.nhs.patientinfo.process.ValueBeans.PatientInfoProcessVbRes;
import org.nhs.patientinfo.v1.schemas.req.PatientContextType;
import org.nhs.patientinfo.v1.schemas.req.PatientDetailsTYpe;
import org.nhs.patientinfo.v1.schemas.req.PatientInfoReqType;
import org.nhs.patientinfo.v1.schemas.res.PatientInfoResType;
import org.nhs.patientinfo.v1.schemas.res.StatusType;
import org.nhs.patientinfo_srv.PatientInfoSrv;
import org.nhs.patientinfosrv.service.Util.PatientSrvReqValidException;
import org.nhs.patientinfosrv.service.builders.PatientInfoReqBuilder;
import org.nhs.patientinfosrv.service.builders.PatientInfoResBuilder;
import org.nhs.patientinfosrv.validator.PatientInfoSrvValidator;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@WebService(endpointInterface = "org.nhs.patientinfo_srv.PatientInfoSrv")
public class PatientInfoSvcImpl implements PatientInfoSrv {
	private PatientInfoSrvValidator validate;
	private PatientInfoReqBuilder reqBuilder;
	private PatientInfoResBuilder pResBuilder;
	// 3406
	private static Logger logger = Logger.getLogger(PatientInfoSvcImpl.class);
	

	public PatientInfoResType createPatient(PatientInfoReqType wsReq) {
		
		

		String respCode = null;
		String respMsg = null;
		logger.info("enter in service layer:" + wsReq);
		// 1.Get the Request from Consumer.
		// 2.validate the Request

		// PatientInfoSrvValidator validate=new PatientInfoSrvValidator();

		try {
			validate.validateWsReq(wsReq);

			PatientInfoProcessVbReq req = reqBuilder.buildProcessReq(wsReq);
			PatientInfoProcess process = new PatientInfoProcessImpl();

			PatientInfoProcessVbRes vRes = null;
			try {
				vRes = process.createPatient(req);
				PatientInfoResType pResType = pResBuilder.buildProcessRes(vRes);
				return pResType;
			} catch (BeginessException e) {
				// e.printStackTrace();
				logger.error("biginess Exception are comming", e);
				respCode = e.getRespCode();
				respMsg = e.getRespMsg();
				PatientInfoResType pResType = new PatientInfoResType();
				StatusType type = new StatusType();
				type.setResMsg(respMsg);
				type.setRespCode(respCode);
				pResType.setStatus(type);

				return pResType;
			} catch (SystemException e) {
				// e.printStackTrace();
				logger.error("System Exceptio are  comming ", e);
				respCode = e.getRespCode();
				respMsg = e.getRespMsg();
				PatientInfoResType pResType = new PatientInfoResType();
				StatusType type = new StatusType();
				type.setResMsg(respMsg);
				type.setRespCode(respCode);
				pResType.setStatus(type);

				return pResType;
			} catch (UnKnownException e) {
				// e.printStackTrace();
				logger.error("this  ia unnone Exception are comming", e);
				respCode = e.getRespCode();
				respMsg = e.getRespMsg();
				PatientInfoResType pResType = new PatientInfoResType();
				StatusType type = new StatusType();
				type.setResMsg(respMsg);
				type.setRespCode(respCode);
				pResType.setStatus(type);

				return pResType;
			}

		} catch (PatientSrvReqValidException e) {
			respCode = e.getRespCode();
			respMsg = e.getRespMsg();

			// 4. We convert ProcessLayer to Service Layer Response.
			PatientInfoResType pResType = new PatientInfoResType();
			StatusType type = new StatusType();
			type.setResMsg(respMsg);
			logger.info("this is response messsage:" + respMsg);
			logger.info("this is respopnse code:" + respCode);
			type.setRespCode(respCode);
			pResType.setStatus(type);

			return pResType;
		}
	}

	// return pResType;
	// return pResType;
	// return pResType;
	public static void main(String args[]) {
		ApplicationContext acontext = new AnnotationConfigApplicationContext("SpringConfig");
		PatientInfoSrvValidator validate = (PatientInfoSrvValidator) acontext.getBean("PatientInfoSrvValidator.class");
		PatientInfoReqBuilder reqBuilder = (PatientInfoReqBuilder) acontext.getBean("PatientInfoReqBuilder.class");
		PatientInfoResBuilder pResBuilder = (PatientInfoResBuilder) acontext.getBean("PatientInfoResBuilder.class");

	
		PatientContextType context = new PatientContextType();
		context.setRequestId("12");
		context.setSourceName("hyd");
		PatientDetailsTYpe detail = new PatientDetailsTYpe();
		detail.setAddress("mumtaz mahal");
		// detail.setDob(new Date());
		detail.setFname("deepak");
		detail.setLname("rout");
		detail.setMobnum("12454r565234");
		detail.setPatientId(1);
		detail.setGender("male");
		PatientInfoReqType pReq1 = new PatientInfoReqType();
		pReq1.setPatientContext(context);
		pReq1.setPatientDetails(detail);
		PatientInfoSvcImpl srv = new PatientInfoSvcImpl();
		PatientInfoResType res = srv.createPatient(pReq1);
		logger.info("entered into service layer");
		logger.info("print response:" + res.getStatus());

	}
}
