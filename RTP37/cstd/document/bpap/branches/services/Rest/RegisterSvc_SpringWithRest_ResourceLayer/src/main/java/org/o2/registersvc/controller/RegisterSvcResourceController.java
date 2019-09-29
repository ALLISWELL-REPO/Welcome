package org.o2.registersvc.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import org.apache.log4j.Logger;
import org.o2.registersvc.exception.RegisterSvcReqInvalid;
import org.o2.registersvc.intg.util.BussinessException;
import org.o2.registersvc.process.RegisterSvcProcess;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBReq;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBRes;
import org.o2.registersvc.req.AccountDetailsType;
import org.o2.registersvc.req.CardDetailsType;
import org.o2.registersvc.req.ClientDetailsType;
import org.o2.registersvc.req.RegisterServiceReqType;
import org.o2.registersvc.res.RegisterServiceResType;
import org.o2.registersvc.res.StatusBlockType;
import org.o2.registersvc.service.builder.RegisterSvcReqBuilder;
import org.o2.registersvc.service.builder.RegisterSvcResBuilder;
import org.o2.registersvc.validator.RegisterSvcValidator;
import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.UnknownException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/service")
@RestController
public class RegisterSvcResourceController {

	// injecting bean class object using auto wiring
	@Autowired
	private AccountDetailsType accountDetailsType;

	@Autowired
	private CardDetailsType cardDetailsType;

	@Autowired
	private ClientDetailsType clientDetailsType;

	@Autowired
	private RegisterServiceReqType wsReq;

	@Autowired
	private RegisterServiceResType wsResp;

	@Autowired
	private RegisterSvcValidator validator;

	@Autowired
	private StatusBlockType statusBlockType;

	@Autowired
	private RegisterSvcReqBuilder SvcReqBuilder;

	@Autowired
	private RegisterSvcResBuilder svcResBuilder;

	@Autowired
	private RegisterSvcProcess process;

	String respCode = "0000";
	String respMsg = "sucess";
	String typeOfError = "s";
	long t1 = System.currentTimeMillis();
	long t2;

	// create Logger Object
	Logger logger = Logger.getLogger(RegisterSvcResourceController.class);

	@RequestMapping(value = "/postenrollment",method=RequestMethod.POST)
	public RegisterServiceResType postEnrollment(@RequestBody RegisterServiceReqType wsReq,
			@RequestHeader("x-client-id") String clientId, @RequestHeader("x-channel-id") String channelId,
			@RequestHeader("x-req-id") String reqId) {

		try {

			t2 = System.currentTimeMillis();

			// setting clientDetails
			clientDetailsType.setChannelId(channelId);
			clientDetailsType.setClientId(clientId);
			clientDetailsType.setReqId(reqId);
			wsReq.setClientDetails(clientDetailsType);

			logger.info("Enter into Resource Layer with::" + wsReq);

			// calling validator to valid the consumer input
			validator.validatewsReq(wsReq);

			// prepare process layer req i.e vbReq
			RegisterSvcProcessVBReq vbReq = SvcReqBuilder.buildProcessRequest(wsReq);

			// calling process layer
			RegisterSvcProcessVBRes vbResp = process.enrollment(vbReq);

			// prapare wsResp to vbResp
			wsResp = svcResBuilder.buildWSResponse(vbResp);

		} catch (RegisterSvcReqInvalid e) {
			long t2 = System.currentTimeMillis();
			statusBlockType.setRespCode(e.getRespCode());
			statusBlockType.setRespMsg(e.getRespMsg());
			wsResp.setStatusBlock(statusBlockType);
			typeOfError = "BE";
		}

		catch (BussinessException e) {
			long t2 = System.currentTimeMillis();
			statusBlockType.setRespCode(e.getDbRespCode());
			statusBlockType.setRespMsg(e.getDbRespMsg());
			wsResp.setStatusBlock(statusBlockType);
			typeOfError = "BE";
		}

		catch (SystemException e) {
			long t2 = System.currentTimeMillis();
			statusBlockType.setRespCode("");
			statusBlockType.setRespMsg("");
			wsResp.setStatusBlock(statusBlockType);
			typeOfError = "SE";
		}

		/*catch (UnknownException e) {
			long t2 = System.currentTimeMillis();
			statusBlockType.setRespCode("");
			statusBlockType.setRespMsg("");
			wsResp.setStatusBlock(statusBlockType);
			typeOfError = "UE";
		}*/

		catch (Exception e) {
			typeOfError = "E";
			long t2 = System.currentTimeMillis();
			statusBlockType.setRespCode("");
			statusBlockType.setRespMsg("");
		}

		finally {

			long timeTaken = t2 - t1;
			InetAddress ipAddress = null;
			try {
				ipAddress = InetAddress.getLocalHost();

				StringBuilder builder = new StringBuilder();

				builder.append(new Date()).append("/").append("RegisterSvcResourceImpl").append("/")
						.append("getEnrollment").append("/").append("/enroll").append(clientDetailsType.getClientId())
						.append("/").append(clientDetailsType.getChannelId()).append("/")
						.append(clientDetailsType.getReqId()).append("/").append(respCode).append("/").append(respMsg)
						.append(timeTaken).append(typeOfError).append(ipAddress);

				logger.warn(builder);
			} catch (UnknownHostException e) {

			}
		}

		return wsResp;

	}

	@RequestMapping(value = "/getenrollment/{accNumb}/{mobNumb}/{cvv}/{expDate}/{nameOnCard}/{cardNumb}",method=RequestMethod.GET)
	public RegisterServiceResType getEnrollment(

			@PathVariable("accNumb") String accNumb, @PathVariable("mobNumb") String mobNumb,
			@PathVariable("cvv") String cvv, @PathVariable("expDate") String expDate,
			@PathVariable("nameOnCard") String nameOnCard, @PathVariable("cardNumb") String cardNumb,
			@RequestHeader("x-client-id") String clientId, @RequestHeader("x-channel-id") String channelId,
			@RequestHeader("x-req-id") String reqId) {

		try {

			t2 = System.currentTimeMillis();

			// setting accountDetails
			accountDetailsType.setAccNumber(accNumb);
			accountDetailsType.setMobNumber(Long.parseLong(mobNumb));

			// setting clientDetails
			clientDetailsType.setChannelId(channelId);
			clientDetailsType.setClientId(clientId);
			clientDetailsType.setReqId(reqId);

			// setting cardDetails
			cardDetailsType.setCardNum(cardNumb);
			cardDetailsType.setCvv(cvv);
			cardDetailsType.setExpDate(expDate);
			cardDetailsType.setNameOnCard(nameOnCard);

			// setting accountDetails clientDetails and cardDetails in
			// RegisterServiceReqType object
			wsReq.setAccountDetails(accountDetailsType);
			wsReq.setCardDetails(cardDetailsType);
			wsReq.setClientDetails(clientDetailsType);

			logger.info("Enter into Resource Layer with::" + wsReq);

			// calling validator to valide the consumer input
			validator.validatewsReq(wsReq);

			// prepare process layer req i.e vbReq
			RegisterSvcProcessVBReq vbReq = SvcReqBuilder.buildProcessRequest(wsReq);

			// call process layer
			RegisterSvcProcessVBRes vbResp = process.enrollment(vbReq);

			// prapare wsResp to vbResp
			wsResp = svcResBuilder.buildWSResponse(vbResp);

		} catch (RegisterSvcReqInvalid e) {
			long t2 = System.currentTimeMillis();
			statusBlockType.setRespCode(e.getRespCode());
			statusBlockType.setRespMsg(e.getRespMsg());
			wsResp.setStatusBlock(statusBlockType);
			typeOfError = "BE";
		}

		catch (BussinessException e) {
			long t2 = System.currentTimeMillis();
			statusBlockType.setRespCode(e.getDbRespCode());
			statusBlockType.setRespMsg(e.getDbRespMsg());
			wsResp.setStatusBlock(statusBlockType);
			typeOfError = "BE";
		}

		catch (SystemException e) {
			long t2 = System.currentTimeMillis();
			statusBlockType.setRespCode("");
			statusBlockType.setRespMsg("");
			wsResp.setStatusBlock(statusBlockType);
			typeOfError = "SE";
		}

		/*catch (UnknownException e) {
			long t2 = System.currentTimeMillis();
			statusBlockType.setRespCode(e.getDbRespCode());
			statusBlockType.setRespMsg(e.getDbRespMsg());
			wsResp.setStatusBlock(statusBlockType);
			typeOfError = "UE";
		}
*/
		catch (Exception e) {
			long t2 = System.currentTimeMillis();
			typeOfError = "E";
		}

		finally {

			long timeTaken = t2 - t1;
			InetAddress ipAddress = null;
			try {
				ipAddress = InetAddress.getLocalHost();

				StringBuilder builder = new StringBuilder();

				builder.append(new Date()).append("/").append("RegisterSvcResourceImpl").append("/")
						.append("getEnrollment").append("/").append("/enroll").append(clientDetailsType.getClientId())
						.append("/").append(clientDetailsType.getChannelId()).append("/")
						.append(clientDetailsType.getReqId()).append("/").append(respCode).append("/").append(respMsg)
						.append(timeTaken).append(typeOfError).append(ipAddress);

				logger.warn(builder);
			} catch (UnknownHostException e) {

			}
		}

		return wsResp;
	}

}
