package com.citybank.statementdtls.service.builder;

import org.springframework.stereotype.Component;

import com.citybank.statementdtls.process.valuebeans.StatementDtlsProcessVbReq;
import com.citybank.statementdtls.schema.req.StatementDtlsReqType;
import com.citybank.statementdtls.service.util.XmlGregorianDataToString;
@Component
public class StatementDtlsSvcReqBuilder {

	public StatementDtlsProcessVbReq processReqBuilder(StatementDtlsReqType wsReq) {
		// TODO Auto-generated method stub

		StatementDtlsProcessVbReq vbreq = new StatementDtlsProcessVbReq();
		vbreq.setClientId(wsReq.getClientDetails().getClientid());
		vbreq.setChannelId(wsReq.getClientDetails().getChannelid());
		vbreq.setCardNum(wsReq.getCustomerDetails().getCardnum());
		//vbreq.setCvvNum(String.valueOf(wsReq.getCustomerDetails().getCvvnum()));
		vbreq.setCvvNum(wsReq.getCustomerDetails().getCvvnum());
		vbreq.setNameOnCard(wsReq.getCustomerDetails().getNameoncard());
		vbreq.setExpDate(wsReq.getCustomerDetails().getExpdate());
		/*if (wsReq.getTransCategory() != null || wsReq.getTransCategory().getDataRange() != null
				|| wsReq.getTransCategory().getDataRange().getStartdate() != null) {

			vbreq.setStartDate(XmlGregorianDataToString
					.convertXmlGregorianToString(wsReq.getTransCategory().getDataRange().getStartdate()));
		}
		if (wsReq.getTransCategory() != null || wsReq.getTransCategory().getDataRange() != null
				|| wsReq.getTransCategory().getDataRange().getEnddate() != null) {

			vbreq.setEndDate(XmlGregorianDataToString
					.convertXmlGregorianToString(wsReq.getTransCategory().getDataRange().getEnddate()));

		}*/
		if (wsReq.getTransCategory() != null) {
			vbreq.setTypeOfCate(wsReq.getTransCategory().getTypeofcategory());
		}
		return vbreq;
	}

	
	

}
