package com.sreenutech.rest.query;
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
 
@Path("/order/queryparams")
public class OrderMoreQueryParamResource {
 
	@GET
	@Path("/v1")
	public Response getOrderPrice(@QueryParam("oid") int oid,
			@QueryParam("name") String  name,
			@QueryParam("otype") String otype) {
 
		String status = " order id is : " + oid + " order name is :"+name + "order type is : "+otype;
 
		return Response.status(200).entity(status).build();
 
	}
	
	
	@GET
	@Path("/v2")
	public Response getOrderPrice(@Context UriInfo info) {
		
		
       String oid = info.getQueryParameters().getFirst("oid");
		
		System.out.println("oid is :" + oid);
		String name = info.getQueryParameters().getFirst("name");
		System.out.println("name is : " + name);
		String otype = info.getQueryParameters().getFirst("otype");
		System.out.println("otype is : " + otype);

		MultivaluedMap<String, String> customerMap = info.getQueryParameters();

		String oid1 = customerMap.get("oid").toString();
		String name1 = customerMap.get("name").toString();
		String otype1 = customerMap.get("otype").toString();
		
 
		String status = " order id is : " + oid1 + " order name is :"+name1 + "order type is : "+otype1;
      
		return Response.status(200).entity(status).build();
 
	}
 
}