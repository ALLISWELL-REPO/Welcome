package com.citybank.stmtdtls.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.citybank.statementdtls.schema.req.StatementDtlsReqType;
import com.citybank.statementdtls.schema.res.StatementDtlsResType;
import com.citybank.statementdtls.schema.res.StatusBlockType;
import com.citybank.statementdtls.schema.res.TransDetailsType;
import com.citybank.statementdtls.schema.res.TransactionType;

@RestController
@RequestMapping(value = "/statement")
public class StmtDtlsSvcController {
	// get transaction
	@RequestMapping(value = "/getTransactions", method = RequestMethod.GET, produces = { "application/xml",
			"application/json" })
	public StatementDtlsResType getTransactions(@RequestParam(required = false, value = "cardnum") String cardnum,
			@RequestParam(required = false, value = "cvvnum") String cvvnum,
			@RequestParam(required = false, value = "expdate") String expdate,
			@RequestParam(required = false, value = "nameoncard") String nameoncard,
			@RequestHeader(required = false, value = "clientid") String clientid,
			@RequestHeader(required = false, value = "channelid") String channelid,
			@RequestHeader(required = false, value = "reqid") String reqid) {

		StatementDtlsResType wsResp = buildWSResp();
		return wsResp;

	}

	// post transaction
	@RequestMapping(value = "/postTrasactions", method = RequestMethod.POST, produces = { "application/xml",
			"application/json" }, consumes = { "application/xml", "application/json" })
	public StatementDtlsResType postTransactions(@RequestBody StatementDtlsReqType wsReq,
			@RequestHeader(required = false, value = "clientid") String clientid,
			@RequestHeader(required = false, value = "channelid") String channelid) {

		StatementDtlsResType wsResp = buildWSResp();
		return wsResp;

	}

	private StatementDtlsResType buildWSResp() {
		StatementDtlsResType wsResp = new StatementDtlsResType();
		StatusBlockType statusBlock = new StatusBlockType();
		statusBlock.setReapcode("0000");
		statusBlock.setRespmsg("SUCCESS");

		TransDetailsType transDetailsType = new TransDetailsType();
		List<TransactionType> trasactionTypeslist = transDetailsType.getTransaction();

		for (int i = 1; i < 5; i++) {
			TransactionType transType = new TransactionType();
			transType.setId("Trans-" + i);
			transType.setDesc("good");
			transType.setDate("21-02-1998");
			transType.setAmount("2000");
			transType.setMerchantname("AAA");
			transType.setStatus("success");
			transType.setRemark("NA");
			trasactionTypeslist.add(transType);
		}
		wsResp.setStatusBlock(statusBlock);
		wsResp.setTransDetails(transDetailsType);

		return wsResp;
	}
}
