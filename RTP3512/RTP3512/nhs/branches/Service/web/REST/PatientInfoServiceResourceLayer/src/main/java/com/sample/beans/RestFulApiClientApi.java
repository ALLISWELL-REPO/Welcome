package com.sample.beans;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.patientinfo.resources.PatientInfoReqType;

import javafx.beans.value.WritableObjectValue;
import javafx.beans.value.WritableStringValue;

public class RestFulApiClientApi {

	public static void main (String args[]) throws JsonGenerationException, JsonMappingException, IOException
	{
		 PatientInfoReqType request=new PatientInfoReqType();
		                    request.setNhsNumber("212122");
		                    request.setfName("deepak");
		                    request.setlName("rout");
		                    request.setDate(new Date());
		                    request.sethCode("11521562");
		                    request.sethNumber(21212);
		                    request.setPostalCode("y1b12");
		                    request.setSex("male");
		        ObjectMapper maper=new ObjectMapper();
		        String json = maper.defaultPrettyPrintingWriter().writeValueAsString(request);
		        System.out.println("this is json"+json);
		
	}
	

}
