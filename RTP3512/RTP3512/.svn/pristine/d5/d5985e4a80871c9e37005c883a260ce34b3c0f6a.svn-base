package org.nhs.patientinfo.controller.resources;

import org.nhs.patientinfo.controller.bean.PatientInfoReqType;
import org.nhs.patientinfo.controller.bean.PatientInfoResType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/patientinfoServiceController")
public class PatientInfoServiceController {
	 @RequestMapping(value="/createPatient",method=RequestMethod.POST, produces={"application/xml","application/json"},consumes={"application/xml","application/json"})
	public PatientInfoResType  createPatient(@RequestBody PatientInfoReqType req)
	{
		    //prepare process Request and get the daoResponse
		 PatientInfoResType response=new PatientInfoResType();
		return response;
		
	}
	  @RequestMapping(value="/searchPatient",method=RequestMethod.GET,produces={"application/xml","application/json"},consumes={"application/xml","application/json"})
	 public PatientInfoResType  searchpatient(@RequestParam("first_name")String firstName,@RequestParam("last_name")String lastName,@RequestParam("nhs_number") int nhs_number)
	   
	 {
		  //prepare process Request and get the List of patientDaoRessponse
		  PatientInfoResType response=new PatientInfoResType();
		return response;
		 
	 }
}
