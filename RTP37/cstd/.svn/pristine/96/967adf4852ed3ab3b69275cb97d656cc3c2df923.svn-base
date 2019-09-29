package com.alam.test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/abc")
public class Hello_World_Example {
	
	@Path("/hellotext")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainText(){
		return "Hello Jersy First Url";
	}
	@Path("/helloxml")
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayPlainXMl(){
		return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey Second Url" + "</hello>";
	}
	@Path("/hellohtml")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayPlainHtml(){
		return "<html> " + "<title>" + "Hello Jersey third Url" + "</title>"
        + "<body><h1>" + "Hello Jersey third Url" + "</body></h1>" + "</html> ";
		
	}

}
