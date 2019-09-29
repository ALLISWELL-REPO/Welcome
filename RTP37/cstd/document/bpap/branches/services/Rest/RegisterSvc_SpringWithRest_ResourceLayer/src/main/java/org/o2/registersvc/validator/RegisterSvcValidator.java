package org.o2.registersvc.validator;

import org.o2.registersvc.exception.RegisterSvcReqInvalid;
import org.o2.registersvc.req.AccountDetailsType;
import org.o2.registersvc.req.CardDetailsType;
import org.o2.registersvc.req.ClientDetailsType;
import org.o2.registersvc.req.RegisterServiceReqType;
import org.springframework.stereotype.Component;


@Component
public class RegisterSvcValidator {
	
	//create logger object
	//private Logger logger=Logger.getLogger(RegisterSvcValidator.class);
	//private Logger logger=Logger.getLogger(RegisterSvcValidator.class);
	public void validatewsReq(RegisterServiceReqType wsReq) throws RegisterSvcReqInvalid {
		
		//logger.debug("enter into validator class");
		
		if ( wsReq == null || wsReq.getClientDetails() == null || wsReq.getAccountDetails() == null 
				|| wsReq.getCardDetails() == null ){
			throw new RegisterSvcReqInvalid("02001", "req obj is null");
		}
		
		ClientDetailsType cdt=wsReq.getClientDetails();
		System.out.println(cdt);
		if( cdt.getClientId() == null || " " .equals( cdt.getClientId() ) ){
			throw new RegisterSvcReqInvalid("02002", "clientId is invalid");
		}
		
		if(cdt.getChannelId() == null || " ".equals(cdt.getChannelId())){
			throw new RegisterSvcReqInvalid("02003", "channelId is invalid");
		}
		
		
		AccountDetailsType adt = wsReq.getAccountDetails();
		
		if ( adt.getAccNumber() == null || " ".equals( adt.getAccNumber()) ){
			throw new RegisterSvcReqInvalid("02004", "invalid account number");
		}
		

		if ( adt.getMobNumber()==0 || " ".equals( adt.getMobNumber()) ){
			throw new RegisterSvcReqInvalid("02005", "invalid mobile number");
		}
		
		CardDetailsType cdtt = wsReq.getCardDetails();
		
		if( cdtt.getCardNum() == null || " " . equals( cdtt.getCardNum () ) ){
			throw new RegisterSvcReqInvalid("02006", "invalid card number");
		}
		
		if( cdtt.getCvv() == null || " " . equals( cdtt.getCvv() ) ){
			throw new RegisterSvcReqInvalid("02007", "invalid cvv number");
		}
		
		if( cdtt.getExpDate() == null || " " . equals( cdtt.getExpDate() ) ){
			throw new RegisterSvcReqInvalid("02008", "invalid card ExpDate");
		}
		
		if( cdtt.getNameOnCard() == null || " " . equals( cdtt.getNameOnCard() ) ){
			throw new RegisterSvcReqInvalid("02009", "name on card is required ");
		}
		
		//logger.debug("exit from validator class" );
	}

}
