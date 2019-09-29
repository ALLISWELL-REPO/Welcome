package com.citybank.statementdtls.service.builder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.citybank.statementdtls.process.valuebeans.StatementDtlsProcessVbRes;
import com.citybank.statementdtls.process.valuebeans.TransactionProcess;
import com.citybank.statementdtls.schema.res.StatementDtlsRespType;
import com.citybank.statementdtls.schema.res.StatusBlockType;
import com.citybank.statementdtls.schema.res.TransactionDetailsType;
import com.citybank.statementdtls.schema.res.TransactionType;

@Component
public class StatementDtlsSvcResBuilder {

	public StatementDtlsRespType buildWsResponse(StatementDtlsProcessVbRes vbRes){
		
		StatementDtlsRespType wsRes = new StatementDtlsRespType();
		
		StatusBlockType statusBlockType = new StatusBlockType();
		
		statusBlockType.setExpncode(vbRes.getExpncode());
		statusBlockType.setExpmsg(vbRes.getExpmsg());
		
		wsRes.setStatusBlock(statusBlockType);
		
		
		
		List<TransactionProcess> vbList = vbRes.getTransProcess();
		List<TransactionType> wsList  = new ArrayList<TransactionType>();
		
		TransactionDetailsType transDetailsType = new TransactionDetailsType();
		
		if(vbList != null){
			
			for(TransactionProcess transprocess : vbList){
				
				TransactionType  transWs = new TransactionType();
				transWs.setTransid(transprocess.getTransid());
				transWs.setName(transprocess.getName());
				transWs.setDesc(transprocess.getDesc());
				transWs.setAmount(transprocess.getAmount());
				transWs.setMerchantname(transprocess.getMerchantname());
				transWs.setStatus(transprocess.getStatus());
				transWs.setRemarks(transprocess.getRemarks());
				
				transDetailsType.getTransaction().add(transWs);
				
			}
			
			
		}
		
		
		wsRes.setTransactionDetails(transDetailsType);
		
		
		return wsRes;
		
	}
	
	
}
