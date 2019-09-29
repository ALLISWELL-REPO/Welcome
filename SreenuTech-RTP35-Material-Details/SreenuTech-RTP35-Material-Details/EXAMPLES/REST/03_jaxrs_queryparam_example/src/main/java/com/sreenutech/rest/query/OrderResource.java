package com.sreenutech.rest.query;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

@Path("/ordersQuery")
public class OrderResource {

	@GET
	@Path("/v1")
	public Response getOrderDesc(@QueryParam("oid") String oid,
			                    @QueryParam("name") String name,
			                    @HeaderParam("user-agent") String useragent,
			                    @HeaderParam("client_ID") String clientId) {
		System.out.println("useragent is : " + useragent);
		System.out.println("clientId is : " + clientId);
		
		String status = " Delivered : " + oid + "name :" +name;
		
		return Response.status(200).entity(status).build();

	}
	
	@GET
	@Path("/v2")
	public Response getOrderDesc(@QueryParam("oid") String oid, @Context HttpHeaders headers) {
		//System.out.println("useragent is : " + useragent);
		//System.out.println("carNum is : " + cardNum);
		String status = " Delivered : " + oid;
		for(String header : headers.getRequestHeaders().keySet()){
			System.out.println(header+":"+headers.getRequestHeader(header));
		}

		return Response.status(200).entity(status).build();

	}

}