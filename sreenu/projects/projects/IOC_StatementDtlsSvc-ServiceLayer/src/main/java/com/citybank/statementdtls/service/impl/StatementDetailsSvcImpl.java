package com.citybank.statementdtls.service.impl;

import java.sql.SQLException;

import javax.jws.WebService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.citybank.statementdtls.dao.impl.StatementDtlsDAOImpl;
import com.citybank.statementdtls.dao.util.BusinessException;
import com.citybank.statementdtls.dao.util.SystemException;
import com.citybank.statementdtls.process.impl.StatementDtlsProcess;
import com.citybank.statementdtls.process.valuebeans.StatementDtlsProcessVbReq;
import com.citybank.statementdtls.process.valuebeans.StatementDtlsProcessVbRes;
import com.citybank.statementdtls.schema.req.ClientDetailsType;
import com.citybank.statementdtls.schema.req.CustomerDetailsType;
import com.citybank.statementdtls.schema.req.StatementDtlsReqType;
import com.citybank.statementdtls.schema.res.StatementDtlsRespType;
import com.citybank.statementdtls.schema.res.StatusBlockType;
import com.citybank.statementdtls.service.StatementDetailsService;
import com.citybank.statementdtls.service.builder.StatementDtlsSvcReqBuilder;
import com.citybank.statementdtls.service.builder.StatementDtlsSvcResBuilder;
import com.citybank.statementdtls.service.config.ServiceJavaConfig;
import com.citybank.statementdtls.service.util.StatementDetailsRequestInvalidException;
import com.citybank.statementdtls.service.validator.StatementDtlsSvcReqValidator;

@WebService(endpointInterface = "com.citybank.statementdtls.service.StatementDetailsService")
public class StatementDetailsSvcImpl implements StatementDetailsService {

	StatementDtlsSvcReqBuilder processVbBuilder = null;
	StatementDtlsSvcResBuilder wsResBuilder = null;
	StatementDtlsSvcReqValidator serviceValidator = null;
	StatementDtlsProcess process = null;

	public StatementDtlsRespType getTransactions(StatementDtlsReqType wsReq) {

		System.out
				.println("---------------------------------------------------");

		ApplicationContext context = new AnnotationConfigApplicationContext(
				ServiceJavaConfig.class);

		System.out.println("CONTEXT Container" + context);

		processVbBuilder = context.getBean(StatementDtlsSvcReqBuilder.class);

		wsResBuilder = context.getBean(StatementDtlsSvcResBuilder.class);
		serviceValidator = context.getBean(StatementDtlsSvcReqValidator.class);
		process = context.getBean(StatementDtlsProcess.class);

		System.out.println("-->" + context.getBean(StatementDtlsDAOImpl.class));
		System.out.println("Enter into service layer");

		StatementDtlsRespType wsRes = new StatementDtlsRespType();
		try {

			// get the request from client

			serviceValidator = new StatementDtlsSvcReqValidator();
			serviceValidator.validate(wsReq);

			// preapre the request for process layer
			processVbBuilder = new StatementDtlsSvcReqBuilder();
			// StatementDtlsProcessVbReq vbReq = processVbBuilder.

			StatementDtlsProcessVbReq vbReq = processVbBuilder
					.processReqBuilder(wsReq);
			// call the process
			StatementDtlsProcessVbRes vbRes;

			vbRes = process.getTransactions(vbReq);

			wsResBuilder = new StatementDtlsSvcResBuilder();

			wsRes = wsResBuilder.buildWsResponse(vbRes);

		} catch (BusinessException be) {

			System.out.println("Entered into business exception");
			StatusBlockType blockType = new StatusBlockType();

			blockType.setErrorcode(be.getErrorcode());
			blockType.setErrormsg(be.getErrormsg());

			wsRes.setStatusBlock(blockType);
			be.printStackTrace();
		}

		catch (SystemException se) {
			System.out.println("in system exception");
			StatusBlockType blockType = new StatusBlockType();
			blockType.setErrorcode(se.getErrorcode());
			blockType.setErrormsg(se.getErrormsg());

			wsRes.setStatusBlock(blockType);
			se.printStackTrace();
		}

		catch (StatementDetailsRequestInvalidException sre) {

			StatusBlockType blockType = new StatusBlockType();
			blockType.setErrorcode(sre.getErrorcode());
			blockType.setErrormsg(sre.getErrormsg());

			wsRes.setStatusBlock(blockType);
			sre.printStackTrace();

		}

		catch (ClassNotFoundException e) {

			System.out.println("in class not found excedption");

			StatusBlockType blockType = new StatusBlockType();
			blockType.setErrorcode("2000");
			blockType.setErrormsg("class not found exception");

			wsRes.setStatusBlock(blockType);
			e.printStackTrace();

		}

		catch (SQLException e) {

			System.out.println("sql exception in service layer ");

			StatusBlockType blockType = new StatusBlockType();
			blockType.setErrorcode("2001");
			blockType.setErrormsg("sql exception");

			wsRes.setStatusBlock(blockType);
			e.printStackTrace();

		}

		catch (Exception e) {

			System.out.println("entered into exception catch block in service");

			StatusBlockType blockType = new StatusBlockType();
			blockType.setErrorcode("2002");
			blockType.setErrormsg("unknown exception");

			wsRes.setStatusBlock(blockType);
			e.printStackTrace();
		}

		System.out.println("Exit from service layer");
		return wsRes;
	}

	public static void main(String[] args) {

		System.setProperty("spring.profiles.active", "dev");

		StatementDetailsSvcImpl svcImpl = new StatementDetailsSvcImpl();
		StatementDtlsReqType reqType = new StatementDtlsReqType();

		ClientDetailsType clientDetails = new ClientDetailsType();

		clientDetails.setClientid("web");
		clientDetails.setChannelid("online");
		clientDetails.setReqid("123");

		CustomerDetailsType custDetails = new CustomerDetailsType();

		custDetails.setCardnum("45900500000321478");
		custDetails.setCvvnum("514");
		custDetails.setExpdate("2018-04-03");
		custDetails.setNameoncard("arun");

		reqType.setClientDetails(clientDetails);
		reqType.setCustomerDetails(custDetails);

		// call service method
		System.out.println("hi");
		StatementDtlsRespType wsResp = svcImpl.getTransactions(reqType);
		System.out.println("bye");

		System.out.println(wsResp.getStatusBlock().getExpncode());
		System.out.println(wsResp.getStatusBlock().getExpmsg());
		System.out.println(wsResp.getTransactionDetails().getTransaction()
				.size());

	}

}
