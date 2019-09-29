package com.sreenutech.orders;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.sreenutech.ordersreq.OrderReqtype;

public class JAXBMarshaller {

	public static void main(String[] args) throws JAXBException {
		
		JAXBContext ctxt = JAXBContext.newInstance(OrderReqtype.class);
		
		 Marshaller marsh = ctxt.createMarshaller();
		 
		 OrderReqtype req = new OrderReqtype();
		 req.setOid("12121");
		 req.setName("mobile");
		 
		 marsh.marshal(req, System.out);

	}

}
