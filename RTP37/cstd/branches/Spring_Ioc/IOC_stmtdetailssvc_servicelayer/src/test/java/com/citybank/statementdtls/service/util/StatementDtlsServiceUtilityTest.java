/* @CityBank 2018.All Rights are reserved.It is confidential
 * We should disclose this information outside.
 * Otherwise terms and conditions will apply.
 *  
 */
package com.citybank.statementdtls.service.util;

import com.citybank.statementdtls.schema.req.ClientDetailsType;
import com.citybank.statementdtls.schema.req.CustomerDetailsType;
import com.citybank.statementdtls.schema.req.DataRangeType;
import com.citybank.statementdtls.schema.req.StatementDtlsReqType;
import com.citybank.statementdtls.schema.req.TransCategoryType;


public class StatementDtlsServiceUtilityTest {
	public static StatementDtlsReqType buildWSReq() {
		StatementDtlsReqType wsReq = new StatementDtlsReqType();
		ClientDetailsType clientDtls = new ClientDetailsType();
		clientDtls.setClientid("web");
		clientDtls.setChannelid("online ");
		clientDtls.setReqid("1212121 ");
		wsReq.setClientDetails(clientDtls);
		CustomerDetailsType custDetails = new CustomerDetailsType();
		custDetails.setCardnum("9459375338409");
		custDetails.setCvvnum("547");
		custDetails.setExpdate("08/09/2018");
		custDetails.setNameoncard("ABCD");
		wsReq.setCustomerDetails(custDetails);

		TransCategoryType transCategory = new TransCategoryType();
		DataRangeType dateRange = new DataRangeType();
		// dateRange.setStartdate("");
		// dateRange.setEnddate("");
		transCategory.setDataRange(dateRange);
		transCategory.setTypeofcategory("ALL");
		wsReq.setTransCategory(transCategory);
		return wsReq;
	}

}
