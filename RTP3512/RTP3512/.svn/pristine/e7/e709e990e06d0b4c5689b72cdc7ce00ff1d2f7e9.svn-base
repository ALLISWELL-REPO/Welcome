package org.nhs.patientinfosrv.validator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.nhs.patientinfo.v1.schemas.req.PatientContextType;
import org.nhs.patientinfo.v1.schemas.req.PatientDetailsTYpe;
import org.nhs.patientinfo.v1.schemas.req.PatientInfoReqType;
import org.nhs.patientinfosrv.service.Util.PatientSrvReqValidException;

public class PatientInfoSrvValidatorTest1 {

	PatientInfoSrvValidator validater = null;
	PatientInfoReqType wsRequest = null;
	PatientContextType context = new PatientContextType();
	PatientDetailsTYpe detail = new PatientDetailsTYpe();

	@Before
	public void setUp() throws Exception {
		validater = new PatientInfoSrvValidator();
		wsRequest = new PatientInfoReqType();

		// validater.validateWsReq(wsRequest);
		wsRequest = buildWsRequest();

	}

	private PatientInfoReqType buildWsRequest() {
		context.setRequestId("1");
		context.setSourceName("hyderabad");
		detail.setPatientId(1);
		detail.setFname("deepak");
		detail.setLname("rout");
		detail.setMobnum("987656441");
		detail.setGender("male");
		detail.setAddress("ameerpet");
		wsRequest.setPatientContext(context);
		wsRequest.setPatientDetails(detail);

		return wsRequest;
	}

	@After
	public void tearDown() throws Exception {
		validater = null;
	}

	@Test
	public void testValidateWsReq() {
		wsRequest = null;
		try {
			validater.validateWsReq(wsRequest);
		} catch (PatientSrvReqValidException e) {
			assertEquals("P001", e.getRespCode());

		}

	}

	@Test
	public void testPatientContextTypeNull_Senario() {
		wsRequest.setPatientContext(null);

		try {
			validater.validateWsReq(wsRequest);
		} catch (PatientSrvReqValidException e) {
			assertEquals("P001", e.getRespCode());

		}

	}

	@Test
	public void testPatientDetailsNull_Senario() {
		wsRequest.setPatientDetails(null);
		try {
			validater.validateWsReq(wsRequest);
		} catch (PatientSrvReqValidException e) {
			assertEquals("P001", e.getRespCode());

		}

	}

	@Test
	public void testPatientContextRequestIdIs_Empty_Senario() {
		
		wsRequest.getPatientContext().setRequestId(" ");

		try {
			validater.validateWsReq(wsRequest);
		} catch (PatientSrvReqValidException e) {
			assertEquals("p002", e.getRespCode());

		}

	}

	@Test
	public void testPatientContextSourseNameIs_Empty_Senario() {
		wsRequest.getPatientContext().setSourceName(" ");;
		try {
			validater.validateWsReq(wsRequest);
		} catch (PatientSrvReqValidException e) {
			assertEquals("p003", e.getRespCode());

		}

	}

	@Test
	public void testPatientDetailsPatientIdIsNull_Senario() {
	
		wsRequest.getPatientDetails().setPatientId(0);;
		try {
			validater.validateWsReq(wsRequest);
		} catch (PatientSrvReqValidException e) {
			assertEquals("p004", e.getRespCode());

		}

	}

	@Test
	public void testPatientDetailsFirstNameIsNull_Senario() {
	
		wsRequest.getPatientDetails().setFname(null);;
		try {
			validater.validateWsReq(wsRequest);
		} catch (PatientSrvReqValidException e) {
			assertEquals("p005", e.getRespCode());
		}
	}

	@Test
	public void testPatientDetailsLastNameIsEmpty_Senario() {
		
		wsRequest.getPatientDetails().setLname(" ");
		try {
			validater.validateWsReq(wsRequest);
		} catch (PatientSrvReqValidException e) {
			assertEquals("p006", e.getRespCode());

		}

	}

	@Test
	public void testPatientDetailsMobileNumberIsEmpty_Senario() {
		wsRequest.getPatientDetails().setMobnum(" ");
		try {
			validater.validateWsReq(wsRequest);
		} catch (PatientSrvReqValidException e) {
			assertEquals("p008", e.getRespCode());

		}
	}
	@Test
	public void testPatientDetailsGenderIsEmpty_Senario()
	{
		
		wsRequest.getPatientDetails().setGender(" ");;
		try {
			validater.validateWsReq(wsRequest);
		} catch (PatientSrvReqValidException e) {
			assertEquals("p007", e.getRespCode());
		}
	}
}
