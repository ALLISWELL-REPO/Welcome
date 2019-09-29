/**
 * NHS.All Rights are reserved @Copy Rights are reserved.
You should not disclose the information outside otherwise
 terms and conditions will apply
 */
package org.nhs.patientinfo.service.client.impl;

import java.util.UUID;

import org.nhs.patientinfo.service.client.PatientInfoSvcClient;
import org.nhs.patientinfo.service.client.beans.PatientInfoWebReq;
import org.nhs.patientinfo.service.client.beans.PatientInfoWebResp;
import org.nhs.patientinfo.service.impl.PatientInfoSvc;
import org.nhs.patientinfo.service.impl.PatientInfoSvcImplService;
import org.nhs.patientinfo.v1.schemas.req.PatientContextType;
import org.nhs.patientinfo.v1.schemas.req.PatientDetailsType;
import org.nhs.patientinfo.v1.schemas.req.PatientInfoReqType;
import org.nhs.patientinfo.v1.schemas.resp.PatientInfoResType;

/**
 * @author: Stech
 * @Date     :  Mar 6, 2018
 * Description:  
 */
public class PatientInfoSvcClientImpl implements PatientInfoSvcClient {

	public PatientInfoWebResp createPatient(PatientInfoWebReq webReq) {
		// 1. Get the request from Controller
		// 2. Prepare the request for service 
		// 3. invoke/call the service and get the response
		PatientInfoWebResp webResp=new PatientInfoWebResp();
		//1) create service object
		PatientInfoSvcImplService service=new PatientInfoSvcImplService();
		
		//2) Call the port and it returns the interface
		PatientInfoSvc ref = service.getPatientInfoSvcImplPort();
		
		//3) Prepare WSreq using the Artifacts
		PatientInfoReqType req=new PatientInfoReqType();
		PatientContextType context=new PatientContextType();
		UUID uuid=UUID.randomUUID();
		System.out.println("request id="+uuid.toString());
		context.setRequestId(uuid.toString());
		context.setSourceName("web");
	    PatientDetailsType patientDetails=new PatientDetailsType();
	    patientDetails.setAddress("HYD");
	    patientDetails.setAge(25);
	    patientDetails.setDob(12-10-1990);
	    patientDetails.setFname("Ajay");
	    patientDetails.setLname("Kumar");
	    patientDetails.setGender("M");
	    patientDetails.setMobnum(1234);
	    patientDetails.setPatientId(111);
	    
		req.setPatientContext(context);
        req.setPatientDetails(patientDetails);
        
        PatientInfoResType wsResp=ref.createPatient(req);
        if(wsResp!=null && wsResp.getStatus()!=null)
        {
        	System.out.println(wsResp.getStatus().getResCode());
        }
        webResp.setRespCode(wsResp.getStatus().getResCode());
        webResp.setRespmsg(wsResp.getStatus().getRespMsg());
		return webResp;
	}

}
