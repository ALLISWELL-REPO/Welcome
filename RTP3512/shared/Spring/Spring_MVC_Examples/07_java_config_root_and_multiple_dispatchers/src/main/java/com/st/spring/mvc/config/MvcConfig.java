package com.st.spring.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.st.spring.mvc.controller")
public class MvcConfig extends WebMvcConfigurerAdapter {

	/**
	 * this is similar to <mvc:view-controller>
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// this is relative to the path mapping given to dispatcher servlet
		// in this example it will be  <context_root>/mvc/
		registry.addViewController("/").setViewName("helloWorldStatic");
	}
	
	/**
	 * this is similar to <mvc:resources>
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/img/*").addResourceLocations("/img/");
	}
	
	/**
	 * similar to <mvc:default-servlet-handler>
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Bean
    public InternalResourceViewResolver getViewResolver(){
       InternalResourceViewResolver resolver = new InternalResourceViewResolver();
       resolver.setPrefix("/WEB-INF/jsp/");
       resolver.setSuffix(".jsp" );
       return resolver;
   }
	
	
	
	
	
	
	
	
	
	
	
	
}
