package com.st.spring.mvc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class ApplicationInitializer 
implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		// this is to load regular dispatcher servlet related to web MVC for web application
		AnnotationConfigWebApplicationContext webMVCAppContext = 
				new AnnotationConfigWebApplicationContext();
		webMVCAppContext.register(MvcConfig.class); // config class to be loaded
		
		DispatcherServlet webMVCDispatcherServlet = 
				new DispatcherServlet(webMVCAppContext);
		
		// this is dispatcher for REST services
		AnnotationConfigWebApplicationContext restServicesAppContext = 
				new AnnotationConfigWebApplicationContext();
		restServicesAppContext.register(RestConfig.class); // config class to be loaded
		
		DispatcherServlet restServicesDispatcherServlet = 
				new DispatcherServlet(restServicesAppContext);
		
		// add mvc dispatcher to main servlet context and add servlet mapping
		ServletRegistration.Dynamic mvcDispatcher = 
				servletContext.addServlet("dispatcher-mvc", webMVCDispatcherServlet);
		mvcDispatcher.setLoadOnStartup(1);
		mvcDispatcher.addMapping("/mvc/*");
		
		// add rest dispatcher to main servlet context and add servlet mapping
		ServletRegistration.Dynamic restDispatcher = 
				servletContext.addServlet("dispatcher-rest", restServicesDispatcherServlet);
		restDispatcher.setLoadOnStartup(1);
		restDispatcher.addMapping("/rest/*");
		
		// load root config in root context by using ContextLoaderListener
		AnnotationConfigWebApplicationContext rootAppContext = 
				new AnnotationConfigWebApplicationContext();
		rootAppContext.register(RootConfig.class);
		
		ContextLoaderListener rootContextListener = 
				new ContextLoaderListener(rootAppContext);
		servletContext.addListener(rootContextListener);
	}
	
	
	
	
	
	
	
	
}
