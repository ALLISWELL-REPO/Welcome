/**
 * NHS.All Rights are reserved @Copy Rights are reserved.
You should not disclose the information outside otherwise
 terms and conditions will apply
 */
package org.nhs.patientinfo.service.builders;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.nhs.patientinfo.process.valuebeans.PatientInfoProcessVbReq;
import org.nhs.patientinfo.v1.schemas.req.PatientContextType;
import org.nhs.patientinfo.v1.schemas.req.PatientDetailsType;
import org.nhs.patientinfo.v1.schemas.req.PatientInfoReqType;

/**
 * @author: Stech
 * @Date     :  Mar 11, 2018
 * Description:  
 */
public class PatientInfoSvcReqBuilderTest {

	
	
	@Test
	public void testBuildProcessRequest() {
		PatientInfoSvcReqBuilder reqBuilder=new PatientInfoSvcReqBuilder();
		PatientInfoReqType wsReq=buildWSReq();
		PatientInfoProcessVbReq vbReq = reqBuilder.buildProcessRequest(wsReq);
		assertNotNull(vbReq);
        assertEquals(wsReq.getPatientDetails().getAddress(),vbReq.getAddress());
	    assertEquals(wsReq.getPatientDetails().getAge(), vbReq.getAge());
	    assertEquals(wsReq.getPatientDetails().getDob(), vbReq.getDob());
	    assertEquals(wsReq.getPatientDetails().getFname(), vbReq.getFname());
	    assertEquals(wsReq.getPatientDetails().getGender(),vbReq.getGender());
	    assertEquals(wsReq.getPatientDetails().getLname(), vbReq.getLname());
	    assertEquals(wsReq.getPatientDetails().getMobnum(), vbReq.getMobnum());
	    assertEquals(wsReq.getPatientDetails().getPatientId(), vbReq.getPatientId());
	}
	
	/**
	 * @return
	 */
	
		private PatientInfoReqType buildWSReq() {
			PatientInfoReqType wsreq = new PatientInfoReqType();
			PatientContextType context = new PatientContextType();
			UUID uuid = UUID.randomUUID();
			System.out.println("request id=" + uuid.toString());
			context.setRequestId(uuid.toString());
			context.setSourceName("web");
			PatientDetailsType patientDetails = new PatientDetailsType();
			patientDetails.setAddress("HYD");
			patientDetails.setAge(25);
			patientDetails.setDob(12 - 10 - 1990);
			patientDetails.setFname("Ajay");
			patientDetails.setLname("Kumar");
			patientDetails.setGender("M");
			patientDetails.setMobnum(1234);
			patientDetails.setPatientId(111);

			wsreq.setPatientContext(context);
			wsreq.setPatientDetails(patientDetails);
			return wsreq;
		}

	}
