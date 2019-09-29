package com.citybank.cards.statement.bootservice.builder;

import org.springframework.stereotype.Component;

import com.citybank.cards.statement.bootservice.util.XmlGregorianDateToString;
import com.citybank.cards.statement.req.StatementDtlsReqType;
import com.citybank.statementdtls.process.valuebeans.StatementDtlsProcessVbReq;

@Component
public class StatementDtlsSvcReqBuilder {
	public StatementDtlsProcessVbReq buildProcessVbRequest(StatementDtlsReqType wsReq) {
		StatementDtlsProcessVbReq vbReq = new StatementDtlsProcessVbReq();
		vbReq.setClientId(wsReq.getClientDetails().getClientId());
		vbReq.setChannelId(wsReq.getClientDetails().getChannelId());
		vbReq.setCardNum(wsReq.getCustomerDetails().getCardnum());
		vbReq.setCvvNum(Integer.valueOf(wsReq.getCustomerDetails().getCvvnum()));
		vbReq.setNameOnCard(wsReq.getCustomerDetails().getNameoncard());
		vbReq.setExpDate(wsReq.getCustomerDetails().getExpdate());
		if (wsReq.getTransCategory() != null) {
			if (wsReq.getTransCategory().getDateRange() != null) {
				if (wsReq.getTransCategory().getDateRange().getStartDate() != null) {
					vbReq.setStartDate(XmlGregorianDateToString
							.convertXmlGregorianToString(wsReq.getTransCategory().getDateRange().getStartDate()));
				}
				if (wsReq.getTransCategory().getDateRange().getEndDate() != null) {
					vbReq.setEndDate(XmlGregorianDateToString
							.convertXmlGregorianToString(wsReq.getTransCategory().getDateRange().getEndDate()));
				}
			}
			
			
			if (wsReq.getTransCategory().getTypeOfCategory() != null
					&& !"".equalsIgnoreCase(wsReq.getTransCategory().getTypeOfCategory().trim())) {
				
				vbReq.setTypeOfCate(wsReq.getTransCategory().getTypeOfCategory());
			}
		}
		return vbReq;
	}

}
