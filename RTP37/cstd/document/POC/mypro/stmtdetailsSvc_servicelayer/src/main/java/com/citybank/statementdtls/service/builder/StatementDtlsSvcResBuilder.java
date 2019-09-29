package com.citybank.statementdtls.service.builder;

import java.util.List;

import com.citybank.statementdtls.process.valuebeans.StatementDtlsProcessVbRes;
import com.citybank.statementdtls.process.valuebeans.TransactionsProcess;
import com.citybank.statementdtls.schema.res.StatementDtlsResType;
import com.citybank.statementdtls.schema.res.StatusBlockType;
import com.citybank.statementdtls.schema.res.TransDetailsType;
import com.citybank.statementdtls.schema.res.TransactionType;

public class StatementDtlsSvcResBuilder {

	public StatementDtlsResType resClientBuilder(StatementDtlsProcessVbRes vbResp) {
		// TODO Auto-generated method stub

		StatementDtlsResType wsRes = new StatementDtlsResType();
		StatusBlockType blockType = new StatusBlockType();
		blockType.setReapcode(vbResp.getRespCode());
		blockType.setRespmsg(vbResp.getRespMsg());
		wsRes.setStatusBlock(blockType);

		List<TransactionsProcess> transProcess = vbResp.getTransProcess();
		TransDetailsType transDetailsType = new TransDetailsType();

		for (TransactionsProcess transpro : transProcess) {
			TransactionType transType = new TransactionType();
			transType.setId(transpro.getId());
			transType.setName(transpro.getName());
			transType.setDate(transpro.getDate());
			transType.setDesc(transpro.getDesc());
			transType.setAmount(transpro.getAmount());
			transType.setMerchantname(transpro.getMerchantname());
			transType.setStatus(transpro.getStatus());
			transType.setRemark(transpro.getRemarks());
			
			transDetailsType.getTransaction().add(transType);
		}
		wsRes.setTransDetails(transDetailsType);
		System.out.println("Exit from service layer");
		return wsRes;
	}

}
