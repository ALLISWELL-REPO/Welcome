package com.sreenutech.orders.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class OrderServiceExceptionHandler implements ExceptionMapper<OrderServiceException>{

	public Response toResponse(OrderServiceException exception) {
		ErrorBean error = null;
		if( exception != null ){
			System.out.println("Entered into Exception toResponse");
		 error = new ErrorBean();
		error.setRespCode(exception.getRespCode());
		error.setRespMsg(exception.getRespMSg());
		}
		
		
		
		 
		
		return Response.status(Status.BAD_REQUEST).entity(error).build();
	}

}
