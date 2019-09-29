package com.citybank.statementdtls.service.builder;

import java.util.ArrayList;
import java.util.List;

import com.citybank.statementdtls.process.valuebeans.StatementDtlsProcessVbRes;
import com.citybank.statementdtls.process.valuebeans.TransactionProcess;
import com.citybank.statementdtls_schema.resp.StatementDtlsResType;
import com.citybank.statementdtls_schema.resp.StatusBlockType;
import com.citybank.statementdtls_schema.resp.TransDetailsType;
import com.citybank.statementdtls_schema.resp.TrasactionType;

public class StatementDtlsSvcResBuilder {

	public StatementDtlsResType buildWsResponse(StatementDtlsProcessVbRes vbRes) {
		StatementDtlsResType wsRes = new StatementDtlsResType();
		StatusBlockType statusBlockType = new StatusBlockType();
		statusBlockType.setRespCode(vbRes.getRespCode());
		statusBlockType.setRespMsg(vbRes.getRespMsg());
		wsRes.setStatusBlock(statusBlockType);

		List<TransactionProcess> vbList = vbRes.getTransProcess();

		List<TrasactionType> wsList = new ArrayList<TrasactionType>();
		TransDetailsType transDetailsType = new TransDetailsType();
		if (vbList != null) {
			for (TransactionProcess transprocess : vbList) {
				TrasactionType transWs = new TrasactionType();
				transWs.setId(transprocess.getId());
				transWs.setName(transprocess.getName());
				transWs.setDesc(transprocess.getDesc());
				transWs.setMarchatName(transprocess.getMerchantName());
				transWs.setAmout(transprocess.getAmount());
				transWs.setStatus(transprocess.getStatus());
				transWs.setRemark(transprocess.getRemarks());
				// wsRes.getTransDetails().getTrasaction().add(transWs);
				transDetailsType.getTrasaction().add(transWs);
			}
		}

		// create TransDetailsType object and add into list object
		wsRes.setTransDetails(transDetailsType);

		return wsRes;
	}

}
