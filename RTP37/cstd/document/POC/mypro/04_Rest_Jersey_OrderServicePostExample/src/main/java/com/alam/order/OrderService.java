package com.alam.order;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.alam.artifact.orderreq.OrderReqtype;
import com.alam.artifact.orderres.OrderRestype;

@Path("/a1")
public class OrderService {
	@Path("/b1")
	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public OrderRestype getOrder(OrderReqtype req){
		System.out.println("Order req="+req);
		
		OrderRestype res=new OrderRestype();
		res.setStatus("Delivered");
		
		return res;
		
	}

}
