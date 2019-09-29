package com.st.rest.basic.auth.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/customers")
public class CustomerResource {

	@GET
	public Response getCustomer() {
		return Response.status(200).entity("getUser is called").build();	
	}

	@GET
	@Path("/cid")
	public Response getCustomerID() {

		return Response.status(200).entity("getCustomerID is called").build();

	}

}
