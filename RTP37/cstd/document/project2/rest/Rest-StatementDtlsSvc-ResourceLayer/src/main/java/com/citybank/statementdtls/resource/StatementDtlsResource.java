package com.citybank.statementdtls.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.citybank.statementdtls.resource.util.XmlGregorianStringToGrego;
import com.citybank.statementdtls_schema.req.ClientDetailsType;
import com.citybank.statementdtls_schema.req.CustomerDetailsType;
import com.citybank.statementdtls_schema.req.DateRangeType;
import com.citybank.statementdtls_schema.req.StatementDtlsReqType;
import com.citybank.statementdtls_schema.req.TransCategoryType;
import com.citybank.statementdtls_schema.resp.StatementDtlsResType;
import com.citybank.statementdtls_schema.resp.StatusBlockType;
import com.citybank.statementdtls_schema.resp.TransDetailsType;
import com.citybank.statementdtls_schema.resp.TrasactionType;

@Path("/statement")
public class StatementDtlsResource {

	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Path("getTransaction")
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
		clientDetailsType.setChannelId(channelId);
		clientDetailsType.setClientId(clientId);
		clientDetailsType.setReqId(reqId);

		CustomerDetailsType customerDetailsType = new CustomerDetailsType();
		customerDetailsType.setCardnum(cardNumber);
		customerDetailsType.setCvvnum(cvv);
		customerDetailsType.setExpdate(expDate);
		customerDetailsType.setNameoncard(nameOnCard);

		TransCategoryType transCategoryType = new TransCategoryType();

		DateRangeType dateRangeType = new DateRangeType();
		if (startDate != null && !"".equals(startDate) && endDate != null && !"".equals(endDate)) {
			dateRangeType.setStartDate(XmlGregorianStringToGrego.getGregorianCalendar(startDate));
			dateRangeType.setEndDate(XmlGregorianStringToGrego.getGregorianCalendar(endDate));
			transCategoryType.setDateRange(dateRangeType);
			transCategoryType.setTypeOfCategory(typeOfCate);
		}

		reqType.setClientDetails(clientDetailsType);
		reqType.setCustomerDetails(customerDetailsType);
		reqType.setTransCategory(transCategoryType);

		StatementDtlsResType respType = new StatementDtlsResType();

		StatusBlockType blockType = new StatusBlockType();
		blockType.setRespCode("000");
		blockType.setRespMsg("success");

		TransDetailsType transDetailsType = new TransDetailsType();
		List<TrasactionType> trasactionTypeslist = transDetailsType.getTrasaction();
		System.out.println(reqType);
		for (int i = 1; i < 20; i++) {
			TrasactionType type = new TrasactionType();
			type.setAmout("1000" + i);
			type.setDesc("good" + i);
			type.setId("" + i);
			type.setMarchatName("zomoto" + i);
			type.setName("sunny" + i);
			type.setRemark("NA" + i);
			type.setStatus("status" + i);
			trasactionTypeslist.add(type);
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
		blockType.setRespCode("000");
		blockType.setRespMsg("success");

		TransDetailsType transDetailsType = new TransDetailsType();
		List<TrasactionType> trasactionTypeslist = transDetailsType.getTrasaction();

		for (int i = 1; i < 20; i++) {
			TrasactionType type = new TrasactionType();
			type.setAmout("1000" + i);
			type.setDesc("good" + i);
			type.setId("" + i);
			type.setMarchatName("zomoto" + i);
			type.setName("sunny" + i);
			type.setRemark("NA" + i);
			type.setStatus("status" + i);
			trasactionTypeslist.add(type);
		}
		respType.setStatusBlock(blockType);
		respType.setTransDetails(transDetailsType);

		return respType;
	}

}
