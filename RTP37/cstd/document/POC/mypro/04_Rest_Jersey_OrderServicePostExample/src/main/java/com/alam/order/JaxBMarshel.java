package com.alam.order;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.alam.artifact.orderreq.OrderReqtype;

public class JaxBMarshel {

	public static void main(String[] args) throws JAXBException {
		
		JAXBContext context=JAXBContext.newInstance(OrderReqtype.class);
		
		 Marshaller marsh = context.createMarshaller();
		 
		 OrderReqtype req = new OrderReqtype();
		 req.setOid("12121");
		 req.setName("mobile");
		 
		 marsh.marshal(req, System.out);

	}

}
