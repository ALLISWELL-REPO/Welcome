/**
 * NHS Technologies.All Rights are reserved @Copy Rights are reserved.
You should not disclose the information outside otherwise
 terms and conditions will apply
 */
package org.nhs.patientinfo.service.impl;

import javax.jws.WebService;

import org.apache.log4j.Logger;
import org.nhs.patientinfo.dao.util.BussinessException;
import org.nhs.patientinfo.dao.util.SystemException;
import org.nhs.patientinfo.dao.util.UnknownException;
import org.nhs.patientinfo.process.PatientInfoProcess;
import org.nhs.patientinfo.process.impl.PatientInfoProcessImpl;
import org.nhs.patientinfo.process.valuebeans.PatientInfoProcessVbReq;
import org.nhs.patientinfo.process.valuebeans.PatientInfoProcessVbRes;
import org.nhs.patientinfo.service.builders.PatientInfoSvcReqBuilder;
import org.nhs.patientinfo.service.builders.PatientInfoSvcResBuilder;
import org.nhs.patientinfo.service.util.PatientInfoReqValidException;
import org.nhs.patientinfo.service.validator.PatientInfoSvcValidator;
import org.nhs.patientinfo.v1.schemas.req.PatientContextType;
import org.nhs.patientinfo.v1.schemas.req.PatientDetailsType;
import org.nhs.patientinfo.v1.schemas.req.PatientInfoReqType;
import org.nhs.patientinfo.v1.schemas.resp.PatientInfoResType;
import org.nhs.patientinfo.v1.schemas.resp.StatusType;

@WebService(endpointInterface = "org.nhs.patientinfosvc.PatientInfoSvc")
public class PatientInfoSvcImpl  {

	private Logger logger=Logger.getLogger(PatientInfoSvcImpl.class);
	public PatientInfoResType createPatient(final PatientInfoReqType wsReq) {

		logger.info("Entered into Service Layer" + wsReq);
		// 1. Get the Request from Consumer
		// 2. Validate the Request
		PatientInfoResType wsResp = null;
		try {
			final PatientInfoSvcValidator validator = new PatientInfoSvcValidator();
			validator.validateWSReq(wsReq);
			// 3. Prepare the Process Request vbReq
			final PatientInfoSvcReqBuilder reqBuilder = new PatientInfoSvcReqBuilder();
			final PatientInfoProcessVbReq vbReq = reqBuilder.buildProcessRequest(wsReq);

			// 4. call Process Layer by passing Process request vbReq
			final PatientInfoProcess process = new PatientInfoProcessImpl();
			final PatientInfoProcessVbRes vbResp = process.createPatient(vbReq);

			// 5.Prepare the WsResp
			final PatientInfoSvcResBuilder respBuilder = new PatientInfoSvcResBuilder();
			wsResp = respBuilder.buildwsResp(vbResp);
			logger.info("Exited from Service Layer" + wsResp);
		} 
		catch (PatientInfoReqValidException e) {
			wsResp = buildStatus(e);
			logger.error("PatientInfoReqValidException",e);
           
		} catch (BussinessException e) {
			//wsResp = buildStatus(e);
			final String respCode = e.getRespCode();
			final String respMsg = e.getRespMsg();
			final StatusType status = new StatusType();
			status.setResCode(respCode);
			status.setRespMsg(respMsg);
			wsResp = new PatientInfoResType();
			wsResp.setStatus(status);
			logger.error("BussinessException",e);
		} catch (SystemException e) {
			final String respCode = e.getRespCode();
			final String respMsg = e.getRespMsg();
			final StatusType status = new StatusType();
			status.setResCode(respCode);
			status.setRespMsg(respMsg);
			wsResp = new PatientInfoResType();
			wsResp.setStatus(status);
			logger.error("SystemException",e);
	
		} catch (UnknownException e) {
			final String respCode = e.getRespCode();
			final String respMsg = e.getRespMsg();
			final StatusType status = new StatusType();
			status.setResCode(respCode);
			status.setRespMsg(respMsg);
			wsResp = new PatientInfoResType();
			wsResp.setStatus(status);
			logger.error("UnknownException",e);
		}
		catch(Exception e)
		{
		
			logger.fatal("Exception",e);
		}
		return wsResp;
	}

	private PatientInfoResType buildStatus(PatientInfoReqValidException e) {
		PatientInfoResType wsResp;
		String respCode = e.getRespCode();
		String respMsg = e.getRespMsg();
		logger.info("respCode"+respCode+"respMsg"+respMsg);
		StatusType status = new StatusType();
		status.setResCode(respCode);
		status.setRespMsg(respMsg);
		wsResp = new PatientInfoResType();
		wsResp.setStatus(status);
		return wsResp;
	}

	public static void main(String[] args) {
		PatientInfoSvcImpl svcImpl = new PatientInfoSvcImpl();
		PatientInfoReqType wsReq = new PatientInfoReqType();
		Logger logger=Logger.getLogger(PatientInfoSvcImpl.class);
		logger.info("Service Request is" + wsReq);
		PatientContextType context = new PatientContextType();
		context.setRequestId("2222");
		context.setSourceName("ABCD");

		PatientDetailsType patientDtls = new PatientDetailsType();
		patientDtls.setAddress("HYD");
		patientDtls.setAge(25);
		patientDtls.setDob(17 - 10 - 1990);
		patientDtls.setFname("venkat");
		patientDtls.setGender("M");
		patientDtls.setLname("sanikommu");
		patientDtls.setMobnum(9912345);
		patientDtls.setPatientId(12345);

		wsReq.setPatientContext(context);
		wsReq.setPatientDetails(patientDtls);
		PatientInfoResType resp = svcImpl.createPatient(wsReq);
		logger.info("Service Response is" + resp);
	}
}
