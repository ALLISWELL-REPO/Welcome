/* @CityBank 2018.All Rights are reserved.It is confidential
 * We should disclose this information outside.
 * Otherwise terms and conditions will apply.
 *  
 */
package com.citybank.statementdtls.service.util;

import com.citybank.statementdtls.schema.req.ClientDetailsType;
import com.citybank.statementdtls.schema.req.CustomerDetailsType;
import com.citybank.statementdtls.schema.req.DateRangeType;
import com.citybank.statementdtls.schema.req.StatementDtlsReqType;
import com.citybank.statementdtls.schema.req.TransCategoryType;

/**
 * @author stech9 Jul 24, 2018
 * @Version
 */
public class StatementDtlsServiceUtilityTest {
	public static StatementDtlsReqType buildWSReq() {
		StatementDtlsReqType wsReq = new StatementDtlsReqType();
		ClientDetailsType clientDtls = new ClientDetailsType();
		clientDtls.setClientid("web");
		clientDtls.setChannelid("online ");
		clientDtls.setReqid("1212121 ");
		wsReq.setClientDetails(clientDtls);
		CustomerDetailsType custDetails = new CustomerDetailsType();
		custDetails.setCardnum("789456123789456");
		custDetails.setCvvnum("547");
		custDetails.setExpdate("08/2018");
		custDetails.setNameoncard("Abhinav");
		wsReq.setCustomerDetails(custDetails);

		TransCategoryType transCategory = new TransCategoryType();
		DateRangeType dateRange = new DateRangeType();
		// dateRange.setStartdate("");
		// dateRange.setEnddate("");
		transCategory.setDateRange(dateRange);
		transCategory.setTypeofcategory("ALL");
		wsReq.setTransCategory(transCategory);
		return wsReq;
	}

}
