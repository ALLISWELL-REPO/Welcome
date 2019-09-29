/*@NHS All rights are reserved.You should not disclose the
 * Information outside otherwise terms and conditions will apply
 * 
 */
package org.o2.register.svc.client.impl;

import org.o2.register.svc.client.RegisterServiceClient;
import org.o2.register.svc.client.beans.RegisterSvcWebReq;
import org.o2.register.svc.client.beans.RegisterSvcWebRes;
import org.o2.register.svc.exception.ApplicationExceptions;
import org.o2.registersvc.schema.req.AccountDetailsType;
import org.o2.registersvc.schema.req.CardDetailsType;
import org.o2.registersvc.schema.req.ClientDetailsType;
import org.o2.registersvc.schema.req.RegisterServiceReqType;
import org.o2.registersvc.schema.res.RegisterServiceResType;
import org.o2.registersvc.service.impl.RegisterService;
import org.o2.registersvc.service.impl.RegisterServiceImplService;
import org.omg.CORBA.portable.ApplicationException;

/**
 * @author stech
 * @Date 22-Apr-2018
   @Description : 
 * 
 */

public class RegisterServiceClientImpl implements RegisterServiceClient {

	
	public RegisterSvcWebRes enrollment(RegisterSvcWebReq req) throws ApplicationExceptions {
		
		System.out.println(req); 
		//create service object
		RegisterServiceImplService service=new RegisterServiceImplService();

		//2. call the port and returns interface
		RegisterService ref = service.getRegisterServiceImplPort();
		
		//3. prepare the wsreq with the help of artifacts
		RegisterServiceReqType wsReq = new RegisterServiceReqType();
		
		//create Account Object
		AccountDetailsType accDetType=new AccountDetailsType();
		accDetType.setAccNumber(req.getAccNumber());
		accDetType.setMobNumber(req.getMobileNum());
		
		//create clientDetails object
		ClientDetailsType clientDetailsType=new ClientDetailsType();
		clientDetailsType.setChannelId(req.getChannelId());
		clientDetailsType.setClientId(req.getClientId());
		clientDetailsType.setReqId(req.getReqId());
		
		//create cardDetails Object
		CardDetailsType cardDetailsType=new CardDetailsType();
		cardDetailsType.setCardNum(req.getCardNum());
		cardDetailsType.setCvv(req.getCvv());
		cardDetailsType.setExpDate(req.getExpDate());
		cardDetailsType.setNameOnCard(req.getNameOnCard());
		
		
		//prepare service details object
		wsReq.setAccountDetails(accDetType);
		wsReq.setCardDetails(cardDetailsType);
		wsReq.setClientDetails(clientDetailsType);
		
		//4. call the api by passing wsreq and get the wsresp
		 RegisterServiceResType wsResp = ref.enrollment(wsReq);
		 
		
		 //prepare client response
		 RegisterSvcWebRes webRes=new RegisterSvcWebRes();
		 
		 if("0000".equals(wsResp.getStatusBlock().getRespCode())){
			 webRes.setRespMsg(wsResp.getStatusBlock().getRespMsg()); 
			 webRes.setCreditStatus(wsResp.getCreditCheck().getCreditStatus());
			 webRes.setRateOfPer(wsResp.getCreditCheck().getRateOfPer());
			 webRes.setRespCode(wsResp.getStatusBlock().getRespCode());
		 }
		 else if("reg001".equals(wsResp.getStatusBlock().getRespCode())){
			throw new ApplicationExceptions("reg001", "req obj is invalide"); 
		 }
		 
        else if("reg002".equals(wsResp.getStatusBlock().getRespCode())){
        	throw new ApplicationExceptions("reg002", "client id is invalide"); 
		 }
		 
        else if("reg003".equals(wsResp.getStatusBlock().getRespCode())){
        	throw new ApplicationExceptions("reg003", "channel id is invalide"); 
		 }
		 
        else if("reg004".equals(wsResp.getStatusBlock().getRespCode())){
        	throw new ApplicationExceptions("reg004", "cardnumb is invalide"); 
		 }
		 
        else if("reg005".equals(wsResp.getStatusBlock().getRespCode())){
        	throw new ApplicationExceptions("reg005", "mobile number is invalide"); 
		 }
		 
        else if("reg006".equals(wsResp.getStatusBlock().getRespCode())){
        	throw new ApplicationExceptions("reg006", "invalide cvv"); 
		 }
		 
        else if("reg007".equals(wsResp.getStatusBlock().getRespCode())){
        	throw new ApplicationExceptions("reg007", "invalide expDate"); 
		 }
		 
        else if("reg008".equals(wsResp.getStatusBlock().getRespCode())){
        	throw new ApplicationExceptions("reg007", "invalide name on card");
        	
		 }
		
		return webRes;
	}
	

}
