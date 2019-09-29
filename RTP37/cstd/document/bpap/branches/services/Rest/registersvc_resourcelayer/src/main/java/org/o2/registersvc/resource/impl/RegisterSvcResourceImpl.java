package org.o2.registersvc.resource.impl;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.Date;

/*
 * 
 *Author : vipin
 *Date : 21-july-2018
 *
 */

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.o2.registersvc.exception.RegisterSvcReqInvalid;
import org.o2.registersvc.intg.util.BussinessException;
import org.o2.registersvc.intg.util.SystemException;
import org.o2.registersvc.intg.util.UnknownException;
import org.o2.registersvc.process.RegisterSvcProcess;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBReq;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBRes;
import org.o2.registersvc.process.impl.RegisterSvcProcessImpl;
import org.o2.registersvc.resource.springconfig.ResourceSpringConfig;
import org.o2.registersvc.schema.req.AccountDetailsType;
import org.o2.registersvc.schema.req.CardDetailsType;
import org.o2.registersvc.schema.req.ClientDetailsType;
import org.o2.registersvc.schema.req.RegisterServiceReqType;
import org.o2.registersvc.schema.res.RegisterServiceResType;
import org.o2.registersvc.schema.res.StatusBlockType;
import org.o2.registersvc.service.builder.RegisterSvcReqBuilder;
import org.o2.registersvc.service.builder.RegisterSvcResBuilder;
import org.o2.registersvc.validator.RegisterSvcValidator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Path("/service")
public class RegisterSvcResourceImpl {

	String respCode = "0000";
	String respMsg = "sucess";
	String typeOfError = "s";
	long t1 = System.currentTimeMillis();
	long t2;

	// create Logger Object
	Logger logger = Logger.getLogger(RegisterSvcResourceImpl.class);

	// Create ApplicationContext and active ResourceSpringConfig.java
	ApplicationContext context = new AnnotationConfigApplicationContext(ResourceSpringConfig.class);

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getEnrollment")
	public RegisterServiceResType getEnrollment(

			@QueryParam("accNumb") String accNumb, @QueryParam("mobNumb") String mobNumb, @QueryParam("cvv") String cvv,
			@QueryParam("expDate") String expDate, @QueryParam("nameOnCard") String nameOnCard,
			@QueryParam("cardNumb") String cardNumb, @HeaderParam("x-client-id") String clientId,
			@HeaderParam("x-channel-id") String channelId, @HeaderParam("x-req-id") String reqId)

	{

		// get all object through spring container
		AccountDetailsType accountDetailsType = context.getBean(AccountDetailsType.class);
		CardDetailsType cardDetailsType = context.getBean(CardDetailsType.class);
		ClientDetailsType clientDetailsType = context.getBean(ClientDetailsType.class);
		RegisterServiceReqType wsReq = context.getBean(RegisterServiceReqType.class);
		RegisterServiceResType wsResp = context.getBean(RegisterServiceResType.class);
		RegisterSvcValidator validator = context.getBean(RegisterSvcValidator.class);
		StatusBlockType statusBlockType = context.getBean(StatusBlockType.class);
		RegisterSvcReqBuilder SvcReqBuilder = context.getBean(RegisterSvcReqBuilder.class);
		RegisterSvcResBuilder svcResBuilder = context.getBean(RegisterSvcResBuilder.class);
		RegisterSvcProcess process = context.getBean(RegisterSvcProcessImpl.class);

		try {
			//System.out.println("Enter into resource layer");
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

			wsReq.setAccountDetails(accountDetailsType);
			wsReq.setCardDetails(cardDetailsType);
			wsReq.setClientDetails(clientDetailsType);

			System.out.println("Enter into Resource Layer with::" + wsReq);
			logger.info("Enter into Resource Layer with::" + wsReq);
			// calling validator to valide the consumer input
			validator.validatewsReq(wsReq);

			// prepare process layer req i.e vbReq
			RegisterSvcProcessVBReq vbReq = SvcReqBuilder.buildProcessRequest(wsReq);

			// call process layer
			RegisterSvcProcessVBRes vbResp = process.enrollment(vbReq);
			System.out.println("VBResp code and Resp Message in Resource layer::" + vbResp.getRespCode() + "::: "
					+ vbResp.getRespMsg());

			// prapare wsResp to vbResp
			wsResp = svcResBuilder.buildWSResponse(vbResp);

		} catch (RegisterSvcReqInvalid e) {
			statusBlockType.setRespCode(e.getRespCode());
			statusBlockType.setRespMsg(e.getRespMsg());
			wsResp.setStatusBlock(statusBlockType);
			typeOfError = "BE";
			long t2 = System.currentTimeMillis();

		}

		catch (BussinessException e) {
			statusBlockType.setRespCode(e.getDbRespCode());
			statusBlockType.setRespMsg(e.getDbRespMsg());
			wsResp.setStatusBlock(statusBlockType);
			typeOfError = "BE";
			long t2 = System.currentTimeMillis();
		}

		catch (SystemException e) {
			statusBlockType.setRespCode(e.getDbRespCode());
			statusBlockType.setRespMsg(e.getDbRespMsg());
			wsResp.setStatusBlock(statusBlockType);
			typeOfError = "SE";
			long t2 = System.currentTimeMillis();
		}

		catch (UnknownException e) {
			statusBlockType.setRespCode(e.getDbRespCode());
			statusBlockType.setRespMsg(e.getDbRespMsg());
			wsResp.setStatusBlock(statusBlockType);
			typeOfError = "UE";
			long t2 = System.currentTimeMillis();
		}

		catch (SQLException e) {
			typeOfError = "SE";
			long t2 = System.currentTimeMillis();

		}

		catch (IOException e) {
			typeOfError = "IOE";
			long t2 = System.currentTimeMillis();
		}

		catch (Exception e) {
			typeOfError = "E";
			long t2 = System.currentTimeMillis();
		}

		finally {

			long timeTaken = t2 - t1;
			InetAddress ipAddress = null;
			try {
				ipAddress = InetAddress.getLocalHost();

				System.out.println(ipAddress.getHostAddress().trim());

				StringBuilder builder = new StringBuilder();

				builder.append(new Date()).append("/").append("RegisterSvcResourceImpl").append("/")
						.append("getEnrollment").append("/").append("/enroll").append(clientDetailsType.getClientId())
						.append("/").append(clientDetailsType.getChannelId()).append("/")
						.append(clientDetailsType.getReqId()).append("/").append(respCode).append("/").append(respMsg)
						.append(timeTaken).append(typeOfError).append(ipAddress);

				// logger.warn(builder);
			} catch (UnknownHostException e) {

			}
		}

		return wsResp;
	}

	
	
	
	@POST
	@Produces({ "application/xml", "application/json" })
	@Consumes({ "application/xml", "application/json" })
	@Path("/postEnrollment")
	public RegisterServiceResType postEnrollment(RegisterServiceReqType wsReq,

			@HeaderParam("x-client-id") String clientId, @HeaderParam("x-channel-id") String channelId,
			@HeaderParam("x-req-id") String reqId) {

	
		
		// get all object through spring container
		AccountDetailsType accountDetailsType = context.getBean(AccountDetailsType.class);
		CardDetailsType cardDetailsType = context.getBean(CardDetailsType.class);
		ClientDetailsType clientDetailsType = context.getBean(ClientDetailsType.class);
		//RegisterServiceReqType wsReq = context.getBean(RegisterServiceReqType.class);
		RegisterServiceResType wsResp = context.getBean(RegisterServiceResType.class);
		RegisterSvcValidator validator = context.getBean(RegisterSvcValidator.class);
		StatusBlockType statusBlockType = context.getBean(StatusBlockType.class);
		RegisterSvcReqBuilder SvcReqBuilder = context.getBean(RegisterSvcReqBuilder.class);
		RegisterSvcResBuilder svcResBuilder = context.getBean(RegisterSvcResBuilder.class);
		RegisterSvcProcess process = context.getBean(RegisterSvcProcessImpl.class);

		try {
			
			clientDetailsType.setChannelId(channelId);
			clientDetailsType.setClientId(clientId);
			clientDetailsType.setReqId(reqId);
			wsReq.setClientDetails(clientDetailsType);
			
			System.out.println("Enter into resource layer with webReq"+wsReq);
			t2 = System.currentTimeMillis();

			
			logger.info("Enter into Resource Layer with::" + wsReq);
			// calling validator to valide the consumer input
			validator.validatewsReq(wsReq);

			// prepare process layer req i.e vbReq
			RegisterSvcProcessVBReq vbReq = SvcReqBuilder.buildProcessRequest(wsReq);

			// call process layer
			RegisterSvcProcessVBRes vbResp = process.enrollment(vbReq);
			System.out.println("VBResp code and Resp Message in Resource layer::" + vbResp.getRespCode() + "::: "
					+ vbResp.getRespMsg());

			// prapare wsResp to vbResp
			wsResp = svcResBuilder.buildWSResponse(vbResp);

		} catch (RegisterSvcReqInvalid e) {
			statusBlockType.setRespCode(e.getRespCode());
			statusBlockType.setRespMsg(e.getRespMsg());
			wsResp.setStatusBlock(statusBlockType);
			typeOfError = "BE";
			long t2 = System.currentTimeMillis();

		}

		catch (BussinessException e) {
			statusBlockType.setRespCode(e.getDbRespCode());
			statusBlockType.setRespMsg(e.getDbRespMsg());
			wsResp.setStatusBlock(statusBlockType);
			typeOfError = "BE";
			long t2 = System.currentTimeMillis();
		}

		catch (SystemException e) {
			statusBlockType.setRespCode(e.getDbRespCode());
			statusBlockType.setRespMsg(e.getDbRespMsg());
			wsResp.setStatusBlock(statusBlockType);
			typeOfError = "SE";
			long t2 = System.currentTimeMillis();
		}

		catch (UnknownException e) {
			statusBlockType.setRespCode(e.getDbRespCode());
			statusBlockType.setRespMsg(e.getDbRespMsg());
			wsResp.setStatusBlock(statusBlockType);
			typeOfError = "UE";
			long t2 = System.currentTimeMillis();
		}

		catch (SQLException e) {
			typeOfError = "SE";
			long t2 = System.currentTimeMillis();

		}

		catch (IOException e) {
			typeOfError = "IOE";
			long t2 = System.currentTimeMillis();
		}

		catch (Exception e) {
			typeOfError = "E";
			long t2 = System.currentTimeMillis();
		}

		finally {

			long timeTaken = t2 - t1;
			InetAddress ipAddress = null;
			try {
				ipAddress = InetAddress.getLocalHost();

				System.out.println(ipAddress.getHostAddress().trim());

				StringBuilder builder = new StringBuilder();

				builder.append(new Date()).append("/").append("RegisterSvcResourceImpl").append("/")
						.append("getEnrollment").append("/").append("/enroll").append(clientDetailsType.getClientId())
						.append("/").append(clientDetailsType.getChannelId()).append("/")
						.append(clientDetailsType.getReqId()).append("/").append(respCode).append("/").append(respMsg)
						.append(timeTaken).append(typeOfError).append(ipAddress);

				// logger.warn(builder);
			} catch (UnknownHostException e) {

			}
		}

		System.out.println("wsResp in resource layer::"+wsResp);
		return wsResp;
		


	}

}
