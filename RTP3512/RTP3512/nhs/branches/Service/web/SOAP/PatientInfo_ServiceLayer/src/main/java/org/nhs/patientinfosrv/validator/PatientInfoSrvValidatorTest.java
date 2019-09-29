package org.nhs.patientinfosrv.validator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.nhs.patientinfo.v1.schemas.req.PatientContextType;
import org.nhs.patientinfo.v1.schemas.req.PatientDetailsTYpe;
import org.nhs.patientinfo.v1.schemas.req.PatientInfoReqType;
import org.nhs.patientinfosrv.service.Util.PatientSrvReqValidException;

public class PatientInfoSrvValidatorTest {

	PatientInfoSrvValidator validater = null;
	PatientInfoReqType wsRequest = null;

	@Before
	public void setUp() throws Exception {
		validater = new PatientInfoSrvValidator();
		wsRequest = new PatientInfoReqType();
		validater.validateWsReq(wsRequest);
		wsRequest = buildWsRequest();
	}

	private PatientInfoReqType buildWsRequest() {
		PatientContextType context = new PatientContextType();
		context.setRequestId("1");
		context.setSourceName("hyderabad");
		PatientDetailsTYpe detail = new PatientDetailsTYpe();
		detail.setPatientId(1);
		detail.setFname("deepak");
		detail.setLname("rout");
		detail.setAddress("ameerpet");
		 //detail.setDob(12-18);
		detail.setMobnum("9853293167");
		detail.setGender("male");
		wsRequest.setPatientDetails(detail);
		wsRequest.setPatientContext(context);
		return wsRequest;
	}
	@After
	public void tearDown() throws Exception {
		validater = null;
	}

	@Test
	public void testWsRequestNull_Senarious() {
		
		 wsRequest=null;
		  try {
			validater.validateWsReq(wsRequest);
		} catch (PatientSrvReqValidException e) {
			assertEquals("P001", e.getRespCode());
			e.printStackTrace();
	 
		}
		  
		
	


}
}
