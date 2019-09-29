package com.resourse.rest;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/header")
public class MyFirstJerseExampleQuaryparameter {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/heder")
	public Response createAcount(@QueryParam("acountNumber") int acountNumber,
			@HeaderParam("user_name") String user_name, @HeaderParam("user_pswd") String user_pswd) {
		String status = "created Acount number:" + acountNumber;
		  System.out.println(status);
		  System.out.println("username +  :"+user_name);
		  System.out.println("userpswd  + : "+user_pswd);
		return Response.status(200).entity(status).build();

	}

}
