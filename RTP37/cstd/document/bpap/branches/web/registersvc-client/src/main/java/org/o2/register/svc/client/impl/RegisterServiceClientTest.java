/*@NHS All rights are reserved.You should not disclose the
 * Information outside otherwise terms and conditions will apply
 * 
 */
package org.o2.register.svc.client.impl;

import org.o2.registersvc.schema.req.AccountDetailsType;
import org.o2.registersvc.schema.req.CardDetailsType;
import org.o2.registersvc.schema.req.ClientDetailsType;
import org.o2.registersvc.schema.req.RegisterServiceReqType;
import org.o2.registersvc.schema.req.ServiceDetailsType;
import org.o2.registersvc.schema.res.RegisterServiceResType;
import org.o2.registersvc.service.impl.RegisterService;
import org.o2.registersvc.service.impl.RegisterServiceImplService;

public class RegisterServiceClientTest {

	public static void main(String[] args) {
		//1. create the service object
		RegisterServiceImplService service = new RegisterServiceImplService();
		
		//2. call the port and returns interface
		RegisterService ref = service.getRegisterServiceImplPort();
		
		//3. prepare the wsreq with the help of artifacts
		RegisterServiceReqType wsReq = new RegisterServiceReqType();
		
		//prepare the accountdetails obj
		AccountDetailsType acctDtls = new AccountDetailsType();
		acctDtls.setAccNumber("256554");
		acctDtls.setMobNumber(4568);
		
		//prepare the carddetails obj
		CardDetailsType cardDtls = new CardDetailsType();
		cardDtls.setCardNum("12154578787");
		cardDtls.setCvv("121");
		
		//preapre the clientdetails object
		ClientDetailsType clientDtls = new ClientDetailsType();
		clientDtls.setClientId("web");
		clientDtls.setChannelId("");
		clientDtls.setReqId("12121");
		
		//prepare the servicedetails obj
		ServiceDetailsType svcDtls = new ServiceDetailsType();
		wsReq.setAccountDetails(acctDtls);
		wsReq.setCardDetails(cardDtls);
		wsReq.setClientDetails(clientDtls);
		wsReq.setServiceDetails(svcDtls);
		
	//4. call the api by passing wsreq and get the wsresp
	 RegisterServiceResType wsResp = ref.enrollment(wsReq);
	 
	 
	 if( wsResp != null && wsResp.getStatusBlock() != null && "000".equals(wsResp.getStatusBlock().getRespCode())){
		 //System.out.println("wsresp :"+wsResp);
		 //System.out.println("statublock is :"+wsResp.getStatusBlock());
		// System.out.println("statublock - RespCode :"+wsResp.getStatusBlock().getRespCode());
		 
	 }
	
	}

}
