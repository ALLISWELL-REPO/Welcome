package com.st.spring.mvc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ApplicationInitializer 
implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		// this is to load dispatcher servlet
		XmlWebApplicationContext webApplicationContext = 
				new XmlWebApplicationContext();
		webApplicationContext.setConfigLocation("/WEB-INF/dispatcher-servlet.xml");
		
		DispatcherServlet dispatcherServlet = 
				new DispatcherServlet(webApplicationContext);
		
		// add dispatcher servlet to the main servlet context
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", dispatcherServlet);
		dispatcher.addMapping("/");
		
		// this is to load root context
		XmlWebApplicationContext rootApplicationContext = 
				new XmlWebApplicationContext();
		rootApplicationContext.setConfigLocation("classpath:/applicationContext.xml");
		
		// add listener for root context
		ContextLoaderListener listener = 
				new ContextLoaderListener(rootApplicationContext);
		servletContext.addListener(listener);
	}
	
	
	
	
	
	
	
	
	
	
}
