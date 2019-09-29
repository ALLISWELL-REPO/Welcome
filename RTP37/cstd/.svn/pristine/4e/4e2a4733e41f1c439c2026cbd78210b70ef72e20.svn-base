package com.citybank.statement.resource.impl;

import java.util.List;


import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.citybank.statementdtls.schema.req.ClientDetailsType;
import com.citybank.statementdtls.schema.req.CustomerDetailsType;
import com.citybank.statementdtls.schema.req.DataRangeType;
import com.citybank.statementdtls.schema.req.StatementDtlsReqType;
import com.citybank.statementdtls.schema.req.TransCategoryType;
import com.citybank.statementdtls.schema.res.StatementDtlsResType;
import com.citybank.statementdtls.schema.res.StatusBlockType;
import com.citybank.statementdtls.schema.res.TransDetailsType;
import com.citybank.statementdtls.schema.res.TransactionType;

@Path("/statement")
public class StatementDetailsResource {

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("/getTransaction")
	public StatementDtlsResType getTransaction(@HeaderParam("client-id") String clientId,
			@HeaderParam("channel-id") String channelId, @HeaderParam("req-id") String reqId,
			@HeaderParam("patner-key") String patnerkey, @QueryParam("cardNumber") String cardNumber,
			@QueryParam("cvv") String cvv, @QueryParam("expDate") String expDate,
			@QueryParam("nameOnCard") String nameOnCard, @QueryParam("startDate") String startDate,
			@QueryParam("endDate") String endDate, @QueryParam("typeOfCate") String typeOfCate,
			@QueryParam("sortType") String sortType) {
		
		StatementDtlsReqType reqType = new StatementDtlsReqType();
		System.out.println("cvv  "+cvv);
		System.out.println("header "+channelId);
		ClientDetailsType clientDetailsType = new ClientDetailsType();
		clientDetailsType.setClientid(channelId);
		clientDetailsType.setChannelid(clientId);
		clientDetailsType.setReqid(reqId);

		CustomerDetailsType customerDetailsType = new CustomerDetailsType();
		customerDetailsType.setCardnum(cardNumber);
		customerDetailsType.setCvvnum(cvv);
		customerDetailsType.setExpdate(expDate);
		customerDetailsType.setNameoncard(nameOnCard);

		TransCategoryType transCategoryType = new TransCategoryType();

		DataRangeType dateRangeType = new DataRangeType();
		/*if (startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) {
			dateRangeType.setStartDate(XmlGregorianStringToGrego.getGregorianCalendar(startDate));
			dateRangeType.setEndDate(XmlGregorianStringToGrego.getGregorianCalendar(endDate));
			transCategoryType.setDateRange(dateRangeType);
			transCategoryType.setTypeOfCategory(typeOfCate);
		}*/

		reqType.setClientDetails(clientDetailsType);
		reqType.setCustomerDetails(customerDetailsType);
		reqType.setTransCategory(transCategoryType);

		StatementDtlsResType respType = new StatementDtlsResType();

		StatusBlockType blockType = new StatusBlockType();
		blockType.setReapcode("000");
		blockType.setRespmsg("success");

		TransDetailsType transDetailsType = new TransDetailsType();
		List<TransactionType> trasactionTypeslist = transDetailsType.getTransaction();
		
		System.out.println(reqType);
		for (int i = 1; i < 5; i++) {
			TransactionType transType = new TransactionType();
			transType.setId("12121");
			transType.setDesc("good");
			transType.setDate("21-02-1998");
			transType.setAmount("2000");
			transType.setMerchantname("AAA");
			transType.setStatus("success");
			transType.setRemark("NA");
			trasactionTypeslist.add(transType);
		}
		respType.setStatusBlock(blockType);
		respType.setTransDetails(transDetailsType);

		return respType;
	}

	@POST
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("postTransaction")
	public StatementDtlsResType postTransaction(@HeaderParam("client-id") String clientId,
			@HeaderParam("channel-id") String channelId, @HeaderParam("req-id") String reqId,
			@HeaderParam("patner-key") String patnerkey, StatementDtlsReqType req) {
		System.out.println("enter into post");
		System.out.println(req);

		StatementDtlsResType respType = new StatementDtlsResType();

		StatusBlockType blockType = new StatusBlockType();
		blockType.setReapcode("000");
		blockType.setRespmsg("success");


		TransDetailsType transDetailsType = new TransDetailsType();
		List<TransactionType> trasactionTypeslist = transDetailsType.getTransaction();

		for (int i = 1; i < 5; i++) {
			TransactionType transType = new TransactionType();
			transType.setId("12121");
			transType.setDesc("good");
			transType.setDate("21-02-1998");
			transType.setAmount("2000");
			transType.setMerchantname("AAA");
			transType.setStatus("success");
			transType.setRemark("NA");
			trasactionTypeslist.add(transType);
		}
		respType.setStatusBlock(blockType);
		respType.setTransDetails(transDetailsType);

		return respType;
	}

}
/*@Path("/statements")
public class StatementDetailsResource {
	@Path("/getTransaction")
	@GET
	@Produces({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON })
	public StatementDtlsResType getTransactions(@QueryParam("cardNum") String cardNum,
			                                    @QueryParam("cvvNum") String cvvNum,
			                                    @QueryParam("nameOncard") String nameOncard,
			                                    @QueryParam("expDate") String expDate)
												//@HeaderParam("client_id") String client_id,
											   // @HeaderParam("channel_id") String channel_id, 
											    //@HeaderParam("req_id") String req_id) 
			                                    {

		System.out.println("CardNum: " + cardNum + "\n" + "CvvNum: " + cvvNum + "\n" + "ExpiryDate: " + expDate + "\n"
				+ "NameOnCard: " + nameOncard + "\n");

		StatementDtlsResType wsResp = buildWSResp();
		return wsResp;

	}
	@Path("/postTransaction")
	@POST
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public StatementDtlsResType getTransactions(StatementDtlsReqType wsReq){
		System.out.println("Plain Rest Calling");
		StatementDtlsResType wsResp=new StatementDtlsResType();
		return wsResp;
		
	}

	private StatementDtlsResType buildWSResp() {
		StatementDtlsResType wsResp = new StatementDtlsResType();
		StatusBlockType statusblock = new StatusBlockType();
		statusblock.setReapcode("0000");
		statusblock.setRespmsg("success");
		wsResp.setStatusBlock(statusblock);

		TransDetailsType transactions = new TransDetailsType();
		List<TransactionType> transList = transactions.getTransaction();
		for (int i = 0; i < 3; i++) {
			TransactionType transType = new TransactionType();
			transType.setId("12121");
			transType.setDesc("good");
			transType.setDate("21-02-1998");
			transType.setAmount("2000");
			transType.setMerchantname("AAA");
			transType.setStatus("success");
			transType.setRemark("NA");
			
			transList.add(transType);
		}
		wsResp.setTransDetails(transactions);
		return wsResp;
	}

}
*/