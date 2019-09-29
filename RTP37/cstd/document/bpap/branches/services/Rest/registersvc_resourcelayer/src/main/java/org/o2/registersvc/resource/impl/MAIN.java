package org.o2.registersvc.resource.impl;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.o2.registersvc.schema.req.AccountDetailsType;
import org.o2.registersvc.schema.req.CardDetailsType;
import org.o2.registersvc.schema.req.RegisterServiceReqType;

public class MAIN {

	
public static void main(String[] args) throws JAXBException, JsonGenerationException, JsonMappingException, IOException {
		
		/*JAXBContext ctxt = JAXBContext.newInstance(RegisterServiceReqType.class);
		
		 Marshaller marsh = ctxt.createMarshaller();*/
		
		 RegisterServiceReqType req = new RegisterServiceReqType();
		 
		 //set card Details
		 CardDetailsType cardD=new CardDetailsType();
		 cardD.setCardNum("1234505");
		 cardD.setCvv("123");
		 cardD.setExpDate("20/01/2023");
		 cardD.setNameOnCard("Abhay");
		 req.setCardDetails(cardD);
		
		 //set account details
		 AccountDetailsType accntDet=new AccountDetailsType();
		 accntDet.setAccNumber("111");
		 accntDet.setMobNumber(222);
		
		 
		
		 req.setAccountDetails(accntDet);
		 req.setCardDetails(cardD);
		
		 
		 ObjectMapper mapper=new ObjectMapper();
		 String jsonString;
		jsonString= mapper.defaultPrettyPrintingWriter().writeValueAsString(req);
		 System.out.println(jsonString);
		// marsh.marshal(req, System.out);

	 
	}
	
}
