package com.st.rest.basic.auth.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.st.rest.basic.auth.filter.AuthenticationFilter;
import com.st.rest.basic.auth.service.CustomerResource;

@ApplicationPath("/services")
public class ApplicationConfig extends Application {

	private Set<Object> singletons = new HashSet<Object>();
	
	public ApplicationConfig() {
		singletons.add(new CustomerResource());
		singletons.add(new AuthenticationFilter());
	}
	
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
