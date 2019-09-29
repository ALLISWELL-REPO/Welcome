package com.alam.test;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/abc")
public class QueryParamResource_Example {

	@Path("/order")
	@GET
	public Response getOrderSetup(@QueryParam("oid") int oid, 
			@QueryParam("name") String oname,
			@QueryParam("otype") String otype,@HeaderParam("user-agent")String useragent,
			@HeaderParam("cardNum")String cardNum){
		
		System.out.println("UserAgent ="+useragent);
		System.out.println("Header cardNum="+cardNum);

		String status = "order id is=" + oid + ",Order name=" + oname + ",Order type=" + otype;
		return Response.status(200).entity(status).build();
	}

	@Path("/desc")
	@GET
	public Response getOrderDesc(@QueryParam("oid12") int oid, @Context HttpHeaders headers) {
		String status = "oid =" + oid + " deliverd";

		for (String header : headers.getRequestHeaders().keySet()) {
			System.out.println(header + ";" + headers.getRequestHeader(header));
		}
		return Response.status(Status.OK).entity(status).build();

	}
}
