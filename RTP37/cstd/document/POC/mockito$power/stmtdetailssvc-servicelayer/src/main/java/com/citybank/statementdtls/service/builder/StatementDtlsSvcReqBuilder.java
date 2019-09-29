/* @CityBank 2018.All Rights are reserved.It is confidential
 * We should disclose this information outside.
 * Otherwise terms and conditions will apply.
 *  
 */
package com.citybank.statementdtls.service.builder;

import com.citybank.statementDtls.process.valuebeans.StatementDtlsProcessVbReq;
import com.citybank.statementdtls.schema.req.StatementDtlsReqType;

/**
 * @author stech1
 *
 *         Jun 22, 2018
 */

public class StatementDtlsSvcReqBuilder {

	/**
	 * @param wsReq
	 * @return vbReq
	 */
	public StatementDtlsProcessVbReq processReqBuilder(StatementDtlsReqType wsReq) {

		StatementDtlsProcessVbReq vbReq = new StatementDtlsProcessVbReq();
		vbReq.setClientId(wsReq.getClientDetails().getClientid());
		vbReq.setChannelId(wsReq.getClientDetails().getChannelid());
		vbReq.setCardNum(wsReq.getCustomerDetails().getCardnum());
		vbReq.setCvvnum(wsReq.getCustomerDetails().getCvvnum());
		vbReq.setNameOncard(wsReq.getCustomerDetails().getNameoncard());
		vbReq.setExpDate(wsReq.getCustomerDetails().getExpdate());
		if (wsReq.getTransCategory() != null || wsReq.getTransCategory().getDateRange() != null
				|| wsReq.getTransCategory().getDateRange().getStartdate() != null) {
			//vbReq.setStartDate(startDate);
		}
		// vbReq.setStartDate(wsReq.getTransCategory().getDateRange().getStartdate());
		// vbReq.setEndDate(wsReq.getTransCategory().getDateRange().getEnddate());
		vbReq.setTypeOfcateg(wsReq.getTransCategory().getTypeofcategory());
		return vbReq;
	}
}
