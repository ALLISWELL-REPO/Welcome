package com.resourse.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/path")
public class MyApplicationMatrixParam {
	@POST()
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/city/{cityname}")
	public Response getCityList(@PathParam("cityname")String cityname,@MatrixParam("price")int price,@MatrixParam("location")String location)
	{     
		  String city = null;
		  System.out.println("city:"+city);
		  String status="city name:"+cityname+"hostel price is :"+price+"near location is:"+location+city+"this is city";
		  return Response.status(200).entity(status).build();
	}
	
	  
	
}
