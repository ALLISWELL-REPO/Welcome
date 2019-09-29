/* @CityBank 2018.All Rights are reserved.It is confidential
 * We should disclose this information outside.
 * Otherwise terms and conditions will apply.
 *  
 */
package com.citybank.statementdtls.service.builder;

import java.util.List;

import com.citybank.statementDtls.process.valuebeans.StatementDtlsProcessVbResp;
import com.citybank.statementDtls.process.valuebeans.TransactionsProcess;
import com.citybank.statementdtls.schema.resp.StatementDtlsRespType;
import com.citybank.statementdtls.schema.resp.StatusBlockType;
import com.citybank.statementdtls.schema.resp.TransDetailsType;
import com.citybank.statementdtls.schema.resp.TransactionType;

/**
 * @author stech1
 *
 *         Jun 22, 2018
 */
public class StatementDtlsSvcRespBuilder {

	/**
	 * @param vbResp
	 * @return wsResp
	 */
	public StatementDtlsRespType buildServiceResp(StatementDtlsProcessVbResp vbResp) {

		StatementDtlsRespType wsResp = new StatementDtlsRespType();
		StatusBlockType statusBlockType = new StatusBlockType();
		statusBlockType.setRespCode(vbResp.getRespCode());
		statusBlockType.setRespMsg(vbResp.getRespMsg());
		// get Process Transaction List
		List<TransactionsProcess> transProcessList = vbResp.getTransProcess();

		// prepare wsResp Transaction List
		TransDetailsType svctransList = new TransDetailsType();
		for (TransactionsProcess transProcess : transProcessList) {
			TransactionType transType = new TransactionType();
			transType.setId(transProcess.getId());
			transType.setDate(transProcess.getDate());
			transType.setAmount(transProcess.getAmount());
			transType.setDesc(transProcess.getDesc());
			transType.setMerchantname(transProcess.getMerchantname());
			transType.setStautus(transProcess.getStatus());
			transType.setRemarks(transProcess.getRemarks());
			svctransList.getTransaction().add(transType);
		}

		wsResp.setStatusBlock(statusBlockType);
		wsResp.setTransDetails(svctransList);

		return wsResp;
	}
}
