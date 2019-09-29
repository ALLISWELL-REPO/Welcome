package com.st.spring.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.ResourceBundleViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.st.spring.mvc")
public class MvcConfig extends WebMvcConfigurerAdapter {

	/**
	 * this is similar to <mvc:view-controller>
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
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
	@Order(0)
	public ResourceBundleViewResolver getResourceViewResolver() {
		ResourceBundleViewResolver viewResolver = 
				new ResourceBundleViewResolver();
		viewResolver.setBasename("views");
		return viewResolver;
	}
	
	@Bean
	@Order(1)
    public InternalResourceViewResolver getViewResolver(){
       InternalResourceViewResolver resolver = 
    		   new InternalResourceViewResolver();
       resolver.setPrefix("/WEB-INF/jsp/");
       resolver.setSuffix(".jsp" );
       return resolver;
   }
	
	
	
	
	
	
	
	
	
	
	
	
}
