package com.citybank.statementdtls.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.citybank.statementdtls.dao.util.BusinessException;
import com.citybank.statementdtls.dao.util.SystemException;
import com.citybank.statementdtls.process.StatementDtlsProcess;
import com.citybank.statementdtls.process.valuebeans.StatementDtlsProcessVbReq;
import com.citybank.statementdtls.process.valuebeans.StatementDtlsProcessVbRes;
import com.citybank.statementdtls.schema.req.ClientDetailsType;
import com.citybank.statementdtls.schema.req.CustomerDetailsType;
import com.citybank.statementdtls.schema.req.DataRangeType;
import com.citybank.statementdtls.schema.req.StatementDtlsReqType;
import com.citybank.statementdtls.schema.req.TransCategoryType;
import com.citybank.statementdtls.schema.res.StatementDtlsResType;
import com.citybank.statementdtls.schema.res.StatusBlockType;
import com.citybank.statementdtls.schema.res.TransDetailsType;
import com.citybank.statementdtls.schema.res.TransactionType;
import com.citybank.statementdtls.service.builder.StatementDtlsSvcReqBuilder;
import com.citybank.statementdtls.service.builder.StatementDtlsSvcResBuilder;
import com.citybank.statementdtls.service.util.StatementReqInvalidException;
import com.citybank.statementdtls.service.validator.StatementDtlsSvcReqValidator;

@RestController
@RequestMapping("/statement")
public class SpringDtlBoot_RestController {

	@Autowired
	StatementDtlsSvcReqBuilder reqBuilder;
	@Autowired
	StatementDtlsSvcResBuilder respBuilder;
	@Autowired
	StatementDtlsSvcReqValidator validator=null;
	
	@Autowired
	StatementDtlsProcess process = null;

	@RequestMapping(value = "/getTransaction", method = RequestMethod.GET, produces = { "application/xml",
			"application/json" })
	public StatementDtlsResType getTransactions(@RequestParam(required = false, value = "cardNumber") String cardNumber,
			@RequestParam(required = false, value = "cvv") String cvv,
			@RequestParam(required = false, value = "expDate") String expDate,
			@RequestParam(required = false, value = "nameOnCard") String nameOnCard,
			@RequestParam(required = false, value = "startDate") String startDate,
			@RequestParam(required = false, value = "endDate") String endDate,
			@RequestParam(required = false, value = "typeOfCate") String typeOfCate,
			@RequestParam(required = false, value = "sortType") String sortType,
			@RequestHeader(required = false, value = "client-id") String clientId,
			@RequestHeader(required = false, value = "channel-id") String channelId,
			@RequestHeader(required = false, value = "req-id") String reqId,
			@RequestHeader(required = false, value = "patner-key") String patnerKey) {
		System.out.println("enter into getTransactions");
		System.out.println("cardNumber " + cardNumber);
		System.out.println("clientId " + clientId);
		System.out.println("Cvv " + cvv);
		StatementDtlsResType wsResp = null;
		try {
			StatementDtlsReqType reqType = new StatementDtlsReqType();
			ClientDetailsType clientDetailsType = new ClientDetailsType();
			clientDetailsType.setChannelid(channelId);
			clientDetailsType.setClientid(clientId);
			clientDetailsType.setReqid(reqId);

			CustomerDetailsType detailsType = new CustomerDetailsType();
			detailsType.setCardnum(cardNumber);
			detailsType.setCvvnum(cvv);
			detailsType.setExpdate(expDate);
			detailsType.setNameoncard(nameOnCard);

			TransCategoryType categoryType = new TransCategoryType();
			DataRangeType dateRangeType = new DataRangeType();
			//dateRangeType.setStartDate(XmlGregorianStringToGrego.getGregorianCalendar(startDate));
			//dateRangeType.setEndDate(XmlGregorianStringToGrego.getGregorianCalendar(endDate));
			categoryType.setDataRange(dateRangeType);
			categoryType.setTypeofcategory(typeOfCate);

			reqType.setClientDetails(clientDetailsType);
			reqType.setCustomerDetails(detailsType);
			reqType.setTransCategory(categoryType);
			//validating ws req
			validator.validate(reqType);

			StatementDtlsProcessVbReq vbReq = reqBuilder.processReqBuilder(reqType);
			StatementDtlsProcessVbRes vbResp = process.getTransactions(vbReq);
			wsResp = respBuilder.resClientBuilder(vbResp);

		}catch (StatementReqInvalidException sre) {
			StatusBlockType statusBlockType = new StatusBlockType();
			statusBlockType.setReapcode(sre.getErrorCode());
			statusBlockType.setRespmsg(sre.getErrorMsg());
			wsResp.setStatusBlock(statusBlockType);
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BusinessException be) {
			StatusBlockType blockType = new StatusBlockType();
			blockType.setReapcode(be.getDbErrorCode());
			blockType.setRespmsg(be.getDbErrorMsg());
			wsResp.setStatusBlock(blockType);
			be.printStackTrace();
		} catch (SystemException se) {
			StatusBlockType blockType = new StatusBlockType();
			blockType.setReapcode(se.getSysErrorCode());
			blockType.setRespmsg(se.getSysErrorMsg());
			wsResp.setStatusBlock(blockType);
			se.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("exit from getTransactions");
		return wsResp;
	}

	@RequestMapping(value = "/postTransaction", method = RequestMethod.POST, produces = { "application/xml",
			"application/json" })

	public StatementDtlsResType postTransaction(@RequestHeader(required = false, value = "client-id") String clientId,
			@RequestHeader(required = false, value = "channel-id") String channelId,
			@RequestHeader(required = false, value = "req-id") String reqId,
			@RequestHeader(required = false, value = "patner-key") String patnerkey,
			@RequestBody StatementDtlsReqType req) {
		System.out.println("enter into post");
		System.out.println(req.getClientDetails().getChannelid());
		System.out.println(req.getCustomerDetails().getCardnum());
		System.out.println(req);

		StatementDtlsResType respType = new StatementDtlsResType();

		StatusBlockType blockType = new StatusBlockType();
		blockType.setReapcode("000");
		blockType.setRespmsg("success");

		TransDetailsType transDetailsType = new TransDetailsType();
		List<TransactionType> trasactionTypeslist = transDetailsType.getTransaction();

		for (int i = 1; i < 20; i++) {
			TransactionType type = new TransactionType();
			type.setAmount("1000" + i);
			type.setDesc("good" + i);
			type.setId("" + i);
			type.setMerchantname("zomoto" + i);
			type.setName("ABS" + i);
			type.setRemark("NA" + i);
			type.setStatus("status" + i);
			trasactionTypeslist.add(type);
		}
		respType.setStatusBlock(blockType);
		respType.setTransDetails(transDetailsType);

		return respType;
	}

	private StatementDtlsResType buildWsResponse() {

		StatementDtlsResType respType = new StatementDtlsResType();

		StatusBlockType blockType = new StatusBlockType();
		blockType.setReapcode("000");
		blockType.setRespmsg("success");

		TransDetailsType transDetailsType = new TransDetailsType();
		List<TransactionType> trasactionTypeslist = transDetailsType.getTransaction();

		for (int i = 1; i < 20; i++) {
			TransactionType type = new TransactionType();
			type.setAmount("1000" + i);
			type.setDesc("good" + i);
			type.setId("" + i);
			type.setMerchantname("zomoto" + i);
			type.setName("ABS" + i);
			type.setRemark("NA" + i);
			type.setStatus("status" + i);
			trasactionTypeslist.add(type);
		}
		respType.setStatusBlock(blockType);
		respType.setTransDetails(transDetailsType);

		return respType;
	}

}