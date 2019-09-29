package com.citybank.card.stmtsvc.client.impl;

import java.io.IOException;
import java.util.UUID;

import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.citybank.card.stmtsvc.client.beans.StatementWebReq;
import com.citybank.card.stmtsvc.client.beans.StatementWebResp;
import com.citybank.statementdtls.schema.req.ClientDetailsType;
import com.citybank.statementdtls.schema.req.StatementDtlsReqType;
import com.citybank.statementdtls.schema.res.StatementDtlsResType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class StmtSvcClientGETImpl {
	//get transaction
	public static StatementWebResp getTransactions(StatementWebReq webReq) {
		StatementWebResp webResp = null;
		StatementDtlsResType wsResp = null;

		String getsql = "http://localhost:8080/stmtdetailsSvc_resource_war/rest/statement/getTransaction";
		Client client = Client.create();
		WebResource webResource = client.resource(getsql);
		ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_XML)
				.get(ClientResponse.class);
		String resp = response.getEntity(String.class);
		System.out.println("Response :" + resp);
		return webResp;

	}
//post transaction
	public static StatementWebResp postTransactions(StatementWebReq webReq) throws JsonGenerationException, JsonMappingException, IOException {
		StatementWebResp webResp = null;
		StatementDtlsResType wsResp = null;
		String postsql = "http://localhost:8080/stmtdetailsSvc_resource_war/rest/statement/postTransaction";
		Client client = Client.create();

		StatementDtlsReqType wsReq = buildRequest();
		
		ObjectMapper mapper = new ObjectMapper();	
		String writeValueAsString = mapper.defaultPrettyPrintingWriter().writeValueAsString(wsReq);
		System.out.println("StatementDtlsResType obj: "+writeValueAsString);
		
		WebResource webResource = client.resource(postsql);
		ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON).type(MediaType.APPLICATION_XML).post(ClientResponse.class);
		String resp = response.getEntity(String.class);
		//System.out.println("Response:" + resp);
		return webResp;

	}

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		StatementWebReq webReq = null;
		//getTransactions(webReq);
		postTransactions(webReq);
	}

	private static StatementDtlsReqType buildRequest() {
		StatementDtlsReqType wsReq = new StatementDtlsReqType();
		ClientDetailsType clientReq = new ClientDetailsType();
		clientReq.setClientid("1245");
		clientReq.setChannelid("web");
		clientReq.setReqid(UUID.randomUUID().toString());
		wsReq.setClientDetails(clientReq);
		return wsReq;
	}

}
