package com.sreenutech.matrix;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/ordersMatrix")
public class OrdermatrixResource {

	@GET
	@Path("/v1/{oid}")
	public Response getOrderDesc(@PathParam("oid") int oid,
			@MatrixParam("name") String  name,
			@MatrixParam("otype") String otype) {
 
		String status = " order id is : " + oid + " order name is :"+name + "order type is : "+otype;
		 
		return Response.status(200).entity(status).build();
 
	}
	
	//Case 1 : /ordersMarix/v1/111
	// Case 2 : “/ordersMarix/v1/111;name=mobil”
	// Case 3 : “/ordersMarix/v1/111;name=mobil;otype=eles
	
}
