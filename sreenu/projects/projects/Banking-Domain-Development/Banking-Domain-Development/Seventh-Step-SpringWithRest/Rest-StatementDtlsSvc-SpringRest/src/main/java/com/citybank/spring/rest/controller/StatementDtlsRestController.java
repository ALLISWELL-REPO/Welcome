package com.citybank.spring.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.citybank.statementdtls.schema.res.StatementDtlsRespType;
import com.citybank.statementdtls.schema.res.StatusBlockType;
import com.citybank.statementdtls.schema.res.TransactionDetailsType;
import com.citybank.statementdtls.schema.res.TransactionType;

@RestController
@RequestMapping("/statement")
public class StatementDtlsRestController {

	@RequestMapping(value = "/getTransactions", method = RequestMethod.GET, produces = {

	"application/xml", "application/json" })
	public StatementDtlsRespType getTransactions(

			@RequestParam(required = false, value = "cardnum") String cardnum,
			@RequestParam(required = false, value = "cvvnum") String cvvnum,
			@RequestParam(required = false, value = "expdate") String expdate,
			@RequestParam(required = false, value = "nameoncard") String nameoncard,
			@RequestParam(required = false, value = "startdate") String startdate,
			@RequestParam(required = false, value = "enddate") String enddate,
			@RequestParam(required = false, value = "typeOfCategory") String typeOfCategory,
			@RequestParam(required = false, value = "sortType") String sortType,
			@RequestParam(required = false, value = "clientid") String clientid,

			@RequestParam(required = false, value = "channelid") String channelid,

			@RequestParam(required = false, value = "reqid") String reqid,
			@RequestParam(required = false, value = "patner-key") String patnerKey) {

		System.out.println("entered into getTransactions");
		System.out.println("cardnum" + cardnum);
		System.out.println("clientid" + clientid);

		StatementDtlsRespType resType = new StatementDtlsRespType();
		resType = buildWsResonse();

		System.out.println("exit from getTransactions");
		return resType;
	}

	private StatementDtlsRespType buildWsResonse() {

		StatementDtlsRespType resType = new StatementDtlsRespType();

		StatusBlockType blockType = new StatusBlockType();

		blockType.setExpncode("000");
		blockType.setExpmsg("success");

		TransactionDetailsType transDetailsType = new TransactionDetailsType();

		List<TransactionType> transactionTypelist = transDetailsType
				.getTransaction();

		for (int i = 1; i < 20; i++) {

			TransactionType type = new TransactionType();

			type.setAmount("1000" + i);
			type.setDesc("good" + i);
			type.setTransid("" + i);
			type.setMerchantname("flipkart" + i);
			type.setName("Banana" + i);
			type.setRemarks("NA" + i);
			type.setStatus("status" + i);
			transactionTypelist.add(type);

		}

		resType.setStatusBlock(blockType);
		resType.setTransactionDetails(transDetailsType);

		return resType;

	}

}
