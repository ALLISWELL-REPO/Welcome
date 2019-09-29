package com.alam.test.query;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/a1")
public class QueryParamResource2_Example {
	@Path("/b1")
	@GET
	public Response getOrderDesc(@QueryParam("oid") int oid,
			@QueryParam("name") String  name,
			@QueryParam("otype") String otype) {
 
		String status = " order id is : " + oid + " order name is :"+name + "order type is : "+otype;
 
		return Response.status(200).entity(status).build();
		
	}
	@Path("/c1")
	@GET
	public Response getOrderPrice(@Context UriInfo info){
		
		String oid=info.getQueryParameters().getFirst("oid");
		System.out.println("order1 id is="+oid);
		
		String name=info.getQueryParameters().getFirst("oname");
		System.out.println("Order name is="+name);
		
		MultivaluedMap<String , String> customerMap=info.getQueryParameters();
		String oid1=customerMap.get("oid").toString(); 
		
		
		String name1=customerMap.get("oname").toString();
		
		String status="order2 id is="+oid1+",order name="+name1;
		
		return Response.status(200).entity(status).build();
		
	}

}
