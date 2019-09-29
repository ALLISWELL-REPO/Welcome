package com.citybank.statementdtls.service.builder;

import org.springframework.stereotype.Component;

import com.citybank.statementdtls.process.valuebeans.StatementDtlsProcessVbReq;
import com.citybank.statementdtls.schema.req.StatementDtlsReqType;
import com.citybank.statementdtls.service.util.XmlGregorianDateToString;

@Component
public class StatementDtlsSvcReqBuilder {

	public StatementDtlsProcessVbReq processReqBuilder(
			StatementDtlsReqType wsReq) {

		StatementDtlsProcessVbReq vbReq = new StatementDtlsProcessVbReq();

		vbReq.setClientid(wsReq.getClientDetails().getClientid());
		vbReq.setChannelid(wsReq.getClientDetails().getChannelid());
		vbReq.setCardnum(wsReq.getCustomerDetails().getCardnum());

		vbReq.setCvvnum(wsReq.getCustomerDetails().getCvvnum());
		vbReq.setNameoncard(wsReq.getCustomerDetails().getNameoncard());
		vbReq.setExpdate(wsReq.getCustomerDetails().getExpdate());

		if (wsReq.getTransCategory() != null) {
			if (wsReq.getTransCategory().getDateRange().getStartdate() != null) {

				if (wsReq.getTransCategory().getDateRange().getStartdate() != null) {

					vbReq.setStartdate(XmlGregorianDateToString
							.convertXmlGregorianToString(wsReq
									.getTransCategory().getDateRange()
									.getStartdate()));

				}

				if (wsReq.getTransCategory().getDateRange().getEnddate() != null) {

					vbReq.setEnddate(XmlGregorianDateToString
							.convertXmlGregorianToString(wsReq
									.getTransCategory().getDateRange()
									.getEnddate()));

				}

			}

			if(wsReq.getTransCategory().getTypeOfCategory() != null
					
					&& !"".equalsIgnoreCase(wsReq.getTransCategory().getTypeOfCategory().trim())){
			
				vbReq.setTypeOfCate(wsReq.getTransCategory().getTypeOfCategory());
				
			}
			
			
		}

		return vbReq;

	}

}
