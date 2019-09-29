package com.resourse.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class MyFirstJerseExample {
	  //.this is my first get uri "http://localhost:3535/FirstJerseApplication/rest/hello";
    @GET
    @Produces(value=MediaType.TEXT_PLAIN)
   //1This is My first get Method Plain Text Example;
	public String getAcountDetails()
	{
		return "THis is my first JerseImplementation example";
	}
    //.this is my first get uri "http://localhost:3535/FirstJerseApplication/rest/hello/xml";
     @GET
     @Produces(MediaType.APPLICATION_XML)
     @Path("/xml")
     public String xmlHello()
     {
    	 return "<?xml version=\"1.0\"?>"+"<hello>"+"<current>"+"Hello Xml"+"</current>"+"</hello>";
     }
     //.this is my first get uri "http://localhost:3535/FirstJerseApplication/rest/hello/html
      @GET
      @Produces(MediaType.TEXT_HTML)
      @Path("/html")
     public String HtmlHello()
     {
    	 return "<html>"+"<titel>"+"this is Html"+"</titel>"+"<body>"+"this is order Details"+"</body>"+"</html>";
     }

}
