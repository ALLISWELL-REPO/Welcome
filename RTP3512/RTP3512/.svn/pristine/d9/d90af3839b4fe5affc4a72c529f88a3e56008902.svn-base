package org.nhs.patientinfo.service.client.impl;

import org.nhs.patientinfo.service.client.PatientInfoService;
import org.nhs.patientinfo.service.client.beans.PatientInfoWebReq;
import org.nhs.patientinfo.service.client.beans.PatientInfoWebRes;
import org.nhs.patientinfo.v1.schemas.req.PatientContextType;
import org.nhs.patientinfo.v1.schemas.req.PatientDetailsTYpe;
import org.nhs.patientinfo.v1.schemas.req.PatientInfoReqType;
import org.nhs.patientinfo.v1.schemas.res.PatientInfoResType;
import org.nhs.patientinfosrv.patientinfosrv.impl.PatientInfoSrv;
import org.nhs.patientinfosrv.patientinfosrv.impl.PatientInfoSvcImplService;

public class PatientInfoServiceImpl implements PatientInfoService{

	public PatientInfoWebRes createPatient(PatientInfoWebReq wReq) {
		return null;
	}
	
	
	
	
	public static void main(String args[])
	{
		PatientInfoSvcImplService srvImpl=new PatientInfoSvcImplService();
		                          PatientInfoSrv ref = srvImpl.getPatientInfoSvcImplPort();
		            
		              PatientInfoReqType req=new   PatientInfoReqType();
		                   PatientContextType contextType=new PatientContextType();
		                                      contextType.setRequestId("10");
		                                      contextType.setSourceName("hyderabad");
		                   PatientDetailsTYpe detail=new PatientDetailsTYpe();
		                                      detail.setPatientId(1);
		                                      detail.setFname("deepak");
		                                      detail.setLname("rout");
		                                      detail.setAddress("ameerpet");
		                                    //detail.setDob(19-5-1992);
		                                      detail.setMobnum("19987923890");
		                                      detail.setGender("male");
		                                       
		                                      req.setPatientContext(contextType);
		                                      req.setPatientDetails(detail);
		                            PatientInfoResType res = ref.createPatient(req); 
                                 System.out.println("THIS IS RESPONSE:"+res.getStatus().getRespCode()); 
                                 System.out.println("THIS IS RESPONSE:"+res.getStatus().getResMsg());
	}

}
