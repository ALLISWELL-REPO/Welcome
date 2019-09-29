package org.o2.register.svc.client.impl;

import javax.ws.rs.core.MediaType;

import org.o2.register.svc.client.bean.RegisterSvcWebReq;
import org.o2.register.svc.client.bean.RegisterSvcWebRes;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class RegisterSvcClientImpl {

	
	
	public RegisterSvcWebRes enrollment(RegisterSvcWebReq wsReq){
		
		System.out.println("Client IMPL"+wsReq);
		
		//set uri 
		String url="http://localhost:8080/registersvc_resourceweb/rest/service/getEnrollment?"+"accNumb="+wsReq.getAccNumber()
		+"&"+"mobNumb="+wsReq.getMobileNum()+"&"+"cvv="+wsReq.getCvv()+"&"+"expDate="+wsReq.getExpDate()+
		"&"+"nameOnCard="+wsReq.getNameOnCard()+"&"+"cardNumb="+wsReq.getCardNum();
		
		// create the client object 
		Client client=Client.create();
	
		//using client object get the web resourse object 
		WebResource resource=client.resource(url);
		
		         
		//invoke the service using resource object
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).
				header("x-client-id", wsReq.getClientId()).
				header("x-channel-id", wsReq.getChannelId()).
				header("x-req-id", wsReq.getReqId()).
				get(ClientResponse.class);
		
		
		ClientResponse resp = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		
		//get response in string
		String Resp=response.getEntity(String.class);
		System.out.println(Resp);
		
		RegisterSvcWebRes respp=new RegisterSvcWebRes();
		respp.setCreditStatus("good");
		respp.setRateOfPer(63.0f);
		respp.setRespCode("0000");
		respp.setRespMsg("sucess");
		return respp;
		
		
	}
	
}
