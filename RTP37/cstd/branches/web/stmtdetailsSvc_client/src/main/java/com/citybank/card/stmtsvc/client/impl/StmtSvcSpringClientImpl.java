package com.citybank.card.stmtsvc.client.impl;

import java.util.UUID;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.citybank.card.stmtsvc.client.beans.StatementWebReq;
import com.citybank.card.stmtsvc.client.beans.StatementWebResp;
import com.citybank.statementdtls.schema.req.ClientDetailsType;
import com.citybank.statementdtls.schema.req.StatementDtlsReqType;
import com.citybank.statementdtls.schema.res.StatementDtlsResType;

public class StmtSvcSpringClientImpl {
	public static StatementWebResp getTransaction(StatementWebReq webReq){
	String url="http://localhost:8080/stmtdetailsSvc_resource_war/rest/statement/getTransaction?cardNumber=98765&cvv=919&expDate=12-2021&nameOnCard=noor";
	//create the Rest client object
	
	RestTemplate restTemplate=new RestTemplate();
	StatementDtlsResType webResp=new StatementDtlsResType();
	//adding the headers
	HttpHeaders headers=new HttpHeaders();
	headers.set("clientId", "web");
	headers.set("channelId", "online");
	headers.set("reqId", UUID.randomUUID().toString());
	headers.set("Accept", "application/json");
	
	HttpEntity<String> entity = new HttpEntity<String>(headers);
	ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
	return null;
		
	}
	public static StatementWebResp postTransactions(StatementWebReq webReq) {
		String url="http://localhost:8080/stmtdetailsSvc_resource_war/rest/statement/postTransaction";
		StatementDtlsReqType wsReq = buildWsReq();	
		
		//Create the RestTemplate object
		RestTemplate template = new RestTemplate();
		
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("clientId","WEB");
		headers.add("channelId" , "ONLINE");
		headers.add("requestId" ,UUID.randomUUID().toString());
		headers.add("Accept","application/json");
		headers.add("Content-Type","application/xml");
			
		HttpEntity entity = new HttpEntity(wsReq,headers);		
		ResponseEntity<String> response = template.exchange(url, HttpMethod.POST, entity, String.class);		 
		System.out.println(response.getBody());
		return null;		
	}
	
	public static void main(String[] args){
		StatementWebReq webReq = null;
		//getTransactions(webReq);
		postTransactions(webReq);
	}
	
	private static StatementDtlsReqType buildWsReq() {
		StatementDtlsReqType wsReq = new StatementDtlsReqType();
		ClientDetailsType clientContext = new ClientDetailsType();
		clientContext.setClientid("web");
		clientContext.setChannelid("online");
		clientContext.setReqid(UUID.randomUUID().toString());
		wsReq.setClientDetails(clientContext);
		return wsReq;
	}
}	