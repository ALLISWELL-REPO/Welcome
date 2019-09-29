package com.sreenutech.orders;

import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.sreenutech.ordersreq.OrderReqtype;
import org.sreenutech.ordersres.OrderRestype;

import com.sreenutech.orders.exception.OrderServiceException;
@Path("/postOrders")
public class OrderService {
	
	@Path("/info")
	@POST
	@Produces({"application/json","application/xml"})
	@Consumes({"application/xml","application/json"})
	public OrderRestype getOrders(OrderReqtype req,
			@HeaderParam("cardnum") String cardNum) throws OrderServiceException{
		
		System.out.println("order object :"+req);
		System.out.println("req.getOid() is  :"+req.getOid());
		if( req.getOid() == null ){
			
			throw new OrderServiceException("100", "invalid order id");
		}
		
		System.out.println("entered into getOrders : "+req);
		System.out.println("cardNumber  is :"+cardNum);
		OrderRestype resp = new OrderRestype();
		resp.setStatus("Delivered");
		
		
		
		return resp;
		
	}

}
