package com.st.rest.basic.auth.filter;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class CustomerServiceExceptionHandler implements ExceptionMapper<NotAuthorizedException> {

	@Override
	public Response toResponse(NotAuthorizedException exception) {
		
		//
		
		
		return Response.status(401).entity(exception).build();
	}

}
