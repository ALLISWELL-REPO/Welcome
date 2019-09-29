package com.citybank.card.stmtsvc.client.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.UUID;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.citybank.card.stmtsvc.client.beans.StatementWebReq;
import com.citybank.card.stmtsvc.client.beans.StatementWebResp;
import com.citybank.card.stmtsvc.client.builder.StmtDtlsSvcClientReqBuilder;
import com.citybank.card.stmtsvc.client.util.StatementDtlConstant;
import com.citybank.statementdtls.schema.res.StatementDtlsResType;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

public class StatementSvcClientImpl {
	public StatementWebResp getTransactions(StatementWebReq webReq)
			throws JsonParseException, JsonMappingException, IOException {
		System.out.println("enter into rest client");
		Client client = Client.create();
		String uri = getUri();
		WebResource resource = client.resource(uri);

		MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
		queryParams.add("cardNumber", webReq.getCardNumber());
		queryParams.add("cvv", String.valueOf(webReq.getCvvNumber()));
		queryParams.add("expDate", webReq.getExpDate());
		queryParams.add("startDate", webReq.getStartDate());
		queryParams.add("endDate", webReq.getEndDate());
		queryParams.add("typeOfCate", webReq.getTypeOfCat());

		resource.setProperty("client-id", StatementDtlConstant.CLIENT_ID);
		resource.setProperty("channel-id", StatementDtlConstant.CHANNEL_ID);
		resource.setProperty("req-id", UUID.randomUUID().toString());
		resource.setProperty("patner-key", "9876");

		ClientResponse clientResponse = resource.queryParams(queryParams).accept(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		String jsonResp = clientResponse.getEntity(String.class);
		System.out.println(jsonResp);

		ObjectMapper mapper = new ObjectMapper();
		StatementDtlsResType resType = mapper.readValue(jsonResp, StatementDtlsResType.class);
		System.out.println(resType);

		StmtDtlsSvcClientReqBuilder builder = new StmtDtlsSvcClientReqBuilder();
		StatementWebResp webRes =builder.buildWebResponse(resType);
		System.out.println("from client WebRes " + webRes);
		System.out.println("exit from rest client");
		return webRes;
	}

	

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException {
		StatementSvcClientImpl clientImpl = new StatementSvcClientImpl();
		StatementWebReq req = new StatementWebReq();
		req.setCardNumber("57448847383848334");
		req.setCvvNumber("784");
		// req.setEndDate("15-08-2015");
		req.setNameOnCard("AAA");
		// req.setStartDate("10-02-2014");
		// req.setTypeOfCate("ALL");
		req.setExpDate("2017-11-04");
		//StatementDtlsWebRes res = clientImpl.getTransactions(req);
		String uri=getUri();
		System.out.println("uri "+uri);
	}
	public static String getUri(){
		String uri="";
		Properties properties=new Properties();
		InputStream is = StatementSvcClientImpl.class.getClassLoader().getSystemResourceAsStream("restclient.properties");
		try {
			properties.load(is);
			uri=properties.getProperty("get_Uri_endpoint");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uri;
	}
}


