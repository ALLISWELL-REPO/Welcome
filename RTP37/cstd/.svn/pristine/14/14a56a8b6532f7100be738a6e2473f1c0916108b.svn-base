package com.alam.matrix.test;




import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("/a1")
public class MatrixParam_Test {

	@GET
	@Path("/b1/{oid}")
	public Response getOrderDesc(@PathParam("oid") int oid,
			@MatrixParam("name") String  name,
			@MatrixParam("otype") String otype) {
 
		String status = " order id is : " + oid + " order name is :"+name + "order type is : "+otype;
		 
		return Response.status(200).entity(status).build();
 
	}

}
