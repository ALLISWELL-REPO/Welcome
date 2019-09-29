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
@Priority(1)
public class LoggingFilter implements ContainerRequestFilter,ContainerResponseFilter {

	public void filter(ContainerRequestContext requestContext) throws IOException {
		System.out.println("Logging Filter--Req");
		long t1 = System.currentTimeMillis();
		requestContext.setProperty("stattime", t1);
		
	}

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		System.out.println("Logging Filter--Res ponse");
		
		long t1 = (long) requestContext.getProperty("stattime");
		
		long t2 = System.currentTimeMillis();
		
		long timetaken = t2-t1;
		
		System.out.println("timetaken : "+timetaken);
		
	}

}
