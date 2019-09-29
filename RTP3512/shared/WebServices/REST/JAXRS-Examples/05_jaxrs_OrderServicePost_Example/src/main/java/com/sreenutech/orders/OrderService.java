package com.sreenutech.orders;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.sreenutech.ordersreq.OrderReqtype;
import org.sreenutech.ordersres.OrderRestype;
@Path("/postOrders")
public class OrderService {
	
	@Path("/info")
	@POST
	@Produces("application/xml")
	@Consumes("application/xml")
	public OrderRestype getOrders(OrderReqtype req){
		
		System.out.println("entered into getOrders : "+req);
		OrderRestype resp = new OrderRestype();
		resp.setStatus("Delivered");
		
		
		
		return resp;
		
	}

}
