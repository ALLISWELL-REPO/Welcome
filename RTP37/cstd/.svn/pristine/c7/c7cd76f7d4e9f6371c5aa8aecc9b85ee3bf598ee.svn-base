package org.o2.register.svc.client.impl;

import java.util.HashMap;
import java.util.Map;

import org.o2.register.svc.client.bean.RegisterSvcWebReq;
import org.o2.register.svc.client.bean.RegisterSvcWebRes;
import org.o2.registersvc.schema.res.RegisterServiceResType;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RegisterSvcClientImpl {

	public RegisterSvcWebRes enrollment(RegisterSvcWebReq wsReq){
		
		
		//set uri 
		String url="http://localhost:8080/registersvc_resourceweb/rest/service/getEnrollment";
		
		

		
		//set headers
		HttpHeaders headers=new HttpHeaders();
		headers.set("content-type", "application/xml");
		headers.set("Accept", "application/xml");
	    headers.add("x-client-id", wsReq.getClientId());
	    headers.add("x-channel-id", wsReq.getChannelId());
	    headers.add("x-req-id", wsReq.getReqId());
	    
	    //set params 
	    Map<String, String> params=new HashMap<String, String>();
	    params.put("accNumb", wsReq.getAccNumber());
	    params.put("mobNumb", Long.toString(wsReq.getMobileNum()));
	    params.put("cvv", wsReq.getCvv());
	    params.put("expDate", wsReq.getExpDate());
	    params.put("nameOnCard", wsReq.getNameOnCard());
	    params.put("cardNumb", wsReq.getCardNum());
	    
	    //create http entity object
	    HttpEntity httpEntity=new HttpEntity(headers);
	    
	    RestTemplate template=new RestTemplate();
	    
	    ResponseEntity<String> response=template.exchange(url, HttpMethod.GET,httpEntity,String.class,params);
	    
	    System.out.println("HttpResponse"+response);
	    
	   // RegisterServiceResType resp=response.getBody();
	    System.out.println("WsResp"+response);
		return null;
		
	}
	
}
