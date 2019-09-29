package com.citybank.cards.statement.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.citybank.cards.statement.bootservice.builder.StatementDtlsSvcReqBuilder;
import com.citybank.cards.statement.bootservice.builder.StatementDtlsSvcResBuilder;
import com.citybank.cards.statement.bootservice.util.StmtSvcReqInvalidException;
import com.citybank.cards.statement.bootservice.util.XmlGregorianStringToGrego;
import com.citybank.cards.statement.bootservice.validator.StatementDtlsSvcValidator;
import com.citybank.cards.statement.req.ClientDetailsType;
import com.citybank.cards.statement.req.CustomerDetailsType;
import com.citybank.cards.statement.req.DateRangeType;
import com.citybank.cards.statement.req.StatementDtlsReqType;
import com.citybank.cards.statement.req.TransCategoryType;
import com.citybank.cards.statement.resp.StatementDtlsResType;
import com.citybank.cards.statement.resp.StatusBlockType;
import com.citybank.cards.statement.resp.TransDetailsType;
import com.citybank.cards.statement.resp.TrasactionType;
import com.citybank.statementdtls.dao.util.BusinessException;
import com.citybank.statementdtls.dao.util.SystemException;
import com.citybank.statementdtls.process.StatementDtlsProcess;
import com.citybank.statementdtls.process.valuebeans.StatementDtlsProcessVbReq;
import com.citybank.statementdtls.process.valuebeans.StatementDtlsProcessVbRes;

@RestController
@RequestMapping("/statement")
public class StatementDtlsBootRestController {

	@Autowired
	StatementDtlsSvcReqBuilder reqBuilder;
	@Autowired
	StatementDtlsSvcResBuilder respBuilder;
	@Autowired
	StatementDtlsSvcValidator validator=null;
	
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
			clientDetailsType.setChannelId(channelId);
			clientDetailsType.setClientId(clientId);
			clientDetailsType.setReqId(reqId);

			CustomerDetailsType detailsType = new CustomerDetailsType();
			detailsType.setCardnum(cardNumber);
			detailsType.setCvvnum(cvv);
			detailsType.setExpdate(expDate);
			detailsType.setNameoncard(nameOnCard);

			TransCategoryType categoryType = new TransCategoryType();
			DateRangeType dateRangeType = new DateRangeType();
			dateRangeType.setStartDate(XmlGregorianStringToGrego.getGregorianCalendar(startDate));
			dateRangeType.setEndDate(XmlGregorianStringToGrego.getGregorianCalendar(endDate));
			categoryType.setDateRange(dateRangeType);
			categoryType.setTypeOfCategory(typeOfCate);

			reqType.setClientDetails(clientDetailsType);
			reqType.setCustomerDetails(detailsType);
			reqType.setTransCategory(categoryType);
			//validating ws req
			validator.validateWsRequest(reqType);

			StatementDtlsProcessVbReq vbReq = reqBuilder.buildProcessVbRequest(reqType);
			StatementDtlsProcessVbRes vbResp = process.getTrasactions(vbReq);
			wsResp = respBuilder.buildWsResponse(vbResp);

		}catch (StmtSvcReqInvalidException sre) {
			StatusBlockType statusBlockType = new StatusBlockType();
			statusBlockType.setRespCode(sre.getErrorCode());
			statusBlockType.setRespMsg(sre.getErrorMsg());
			wsResp.setStatusBlock(statusBlockType);
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BusinessException be) {
			StatusBlockType blockType = new StatusBlockType();
			blockType.setRespCode(be.getErrorCode());
			blockType.setRespMsg(be.getErrorMsg());
			wsResp.setStatusBlock(blockType);
			be.printStackTrace();
		} catch (SystemException se) {
			StatusBlockType blockType = new StatusBlockType();
			blockType.setRespCode(se.getErrorCode());
			blockType.setRespMsg(se.getErrorMsg());
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
		System.out.println(req.getClientDetails().getChannelId());
		System.out.println(req.getCustomerDetails().getCardnum());
		System.out.println(req);

		StatementDtlsResType respType = new StatementDtlsResType();

		StatusBlockType blockType = new StatusBlockType();
		blockType.setRespCode("000");
		blockType.setRespMsg("success");

		TransDetailsType transDetailsType = new TransDetailsType();
		List<TrasactionType> trasactionTypeslist = transDetailsType.getTrasaction();

		for (int i = 1; i < 20; i++) {
			TrasactionType type = new TrasactionType();
			type.setAmout("1000" + i);
			type.setDesc("good" + i);
			type.setId("" + i);
			type.setMarchatName("zomoto" + i);
			type.setName("sunny" + i);
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
		blockType.setRespCode("000");
		blockType.setRespMsg("success");

		TransDetailsType transDetailsType = new TransDetailsType();
		List<TrasactionType> trasactionTypeslist = transDetailsType.getTrasaction();

		for (int i = 1; i < 20; i++) {
			TrasactionType type = new TrasactionType();
			type.setAmout("1000" + i);
			type.setDesc("good" + i);
			type.setId("" + i);
			type.setMarchatName("zomoto" + i);
			type.setName("sunny" + i);
			type.setRemark("NA" + i);
			type.setStatus("status" + i);
			trasactionTypeslist.add(type);
		}
		respType.setStatusBlock(blockType);
		respType.setTransDetails(transDetailsType);

		return respType;
	}

}
