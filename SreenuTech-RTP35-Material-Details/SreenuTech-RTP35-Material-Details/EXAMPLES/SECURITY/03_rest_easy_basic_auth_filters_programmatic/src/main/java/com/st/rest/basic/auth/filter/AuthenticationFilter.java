package com.st.rest.basic.auth.filter;

import java.io.IOException;

import javax.annotation.Priority;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import com.st.rest.basic.auth.util.AuthenticateUser;
import com.st.rest.basic.auth.util.SpringContext;

@Provider
@PreMatching
@Priority(2)
public class AuthenticationFilter implements ContainerRequestFilter,ContainerResponseFilter {

	public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.println("AuthenticationFilter--Req");
		String authHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
		System.out.println("context object is :"+SpringContext.class);
		AuthenticateUser authenticateUser = SpringContext.getBean(AuthenticateUser.class);
		boolean validUser = authenticateUser.authenticate(authHeader);
		if (validUser) {
			System.out.println("**** Valid User ****");
		} else {
			System.out.println("#### Invalid User ####");
			throw new NotAuthorizedException(Response.status(401).entity("Unauthorized user. Please provide valid user name and password").build());
		}
		long t1 = System.currentTimeMillis();
		requestContext.setProperty("stattime", t1);
		
	}

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		System.out.println("AuthenticationFilter--Response");
		long t1 = (long) requestContext.getProperty("stattime");
		
		long t2 = System.currentTimeMillis();
		
		long timetaken = t2-t1;
		
		System.out.println("timetaken : "+timetaken);
		
	}

}
