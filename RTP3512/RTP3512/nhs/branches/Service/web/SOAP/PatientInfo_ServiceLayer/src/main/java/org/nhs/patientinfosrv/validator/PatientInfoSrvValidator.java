package org.nhs.patientinfosrv.validator;

import org.nhs.patientinfo.v1.schemas.req.PatientContextType;
import org.nhs.patientinfo.v1.schemas.req.PatientDetailsTYpe;
import org.nhs.patientinfo.v1.schemas.req.PatientInfoReqType;
import org.nhs.patientinfosrv.service.Util.PatientSrvReqValidException;

public class PatientInfoSrvValidator {

	public void validateWsReq(PatientInfoReqType wsReq) throws PatientSrvReqValidException {
		 
		 if(wsReq==null||wsReq.getPatientContext()==null||wsReq.getPatientDetails()==null)
		 {
			 throw new PatientSrvReqValidException("P001","this request is invalid");
		 } 
		              PatientContextType context = wsReq.getPatientContext();
		  if(context.getRequestId()==null||"".equals(context.getRequestId()))
		  {
			  throw new PatientSrvReqValidException("p002","request id is invalide");
		  }
           if(context.getSourceName()==null||"".equals(context.getSourceName()))
        	   {
        	     throw new PatientSrvReqValidException("p003","Source name is in valid");
        	   
           }
             
                              PatientDetailsTYpe details = wsReq.getPatientDetails();
                              
                              if(details.getPatientId()==0||"".equals(details.getPatientId()))
                              {
                            	  throw new PatientSrvReqValidException("p004","patient id is invalid") ;                       
            
	                           }
                               if(details.getFname()==null||"".equals(details.getFname()))
                               {
                            	   throw new PatientSrvReqValidException("p005","patient first name is invalide");
                            	   
                               }
                                if(details.getLname()==null||"".equals(details.getLname()))
                                	{
                                	   throw new PatientSrvReqValidException("p006","patient last name is in valide");
                                	   
                                      }
                                     if(details.getGender()==null||"".equals(details.getGender()))
                                     {
                                    	 throw new PatientSrvReqValidException("p007","patient is invalide ");
                                     }
                                      if(details.getMobnum()==null||"".equals(details.getMobnum()))
                                      {
                                    	  throw new PatientSrvReqValidException("p008", "patient mobile number is invaide");
                                      }
                                       
                                
                                
                                
}                   
}
	
	

