package com.resourse.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/quary")
public class MyFirstJerseExampleQuaryparameter {
	// . THIS IS MY QUARY PARAM
	// http://localhost:3535/FirstJerseApplication/rest/quary/hello?oid=1312312&oname=deepak&Otype=tv
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/hello")
	public String orderDetails(@QueryParam("oid") int oid, @QueryParam("oname") String oname,
			@QueryParam("Otype") String Otype) {
		return "this is oid:" + oid + "this is oname" + oname + "this is type" + Otype + "sucsesful";

	}
	 @GET
	 @Path("/context")
	 public Response orderDetails(@Context UriInfo uinfo)
	  
	 {
		  String oid=uinfo.getQueryParameters().getFirst("oid");
		  String oname=uinfo.getQueryParameters().getFirst("oname");
		  String otype=uinfo.getQueryParameters().getFirst("Otype");
		  System.out.println(oid);
		  System.out.println(oname);
		  System.out.println(otype);
		  String status="odername:"+oid+"oname"+oname+"otype is"+otype+"this is odertype";
	
		return  Response.status(200).entity(status).build();	 
	 }
}