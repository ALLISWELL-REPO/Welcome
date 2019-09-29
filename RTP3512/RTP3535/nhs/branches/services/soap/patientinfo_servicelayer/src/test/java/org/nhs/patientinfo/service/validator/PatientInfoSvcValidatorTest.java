/**
 * NHS.All Rights are reserved @Copy Rights are reserved.
You should not disclose the information outside otherwise
 terms and conditions will apply
 */
package org.nhs.patientinfo.service.validator;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.nhs.patientinfo.service.util.PatientInfoReqValidException;
import org.nhs.patientinfo.v1.schemas.req.PatientContextType;
import org.nhs.patientinfo.v1.schemas.req.PatientDetailsType;
import org.nhs.patientinfo.v1.schemas.req.PatientInfoReqType;

/**
 * @author: Stech
 * @Date : Mar 10, 2018 Description:
 */
public class PatientInfoSvcValidatorTest {

	PatientInfoSvcValidator validator;
	PatientInfoReqType wsreq = null;

	@Before
	public void setUp() throws Exception {
		validator = new PatientInfoSvcValidator();
		wsreq = buildWSReq();
	}

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

	@Test
	public void testWSReqObj_Null_Scenario() {
		wsreq = null;
		try {
			validator.validateWSReq(wsreq);
		} catch (PatientInfoReqValidException e) {
			assertEquals("pt001", e.getRespCode());
		}
	}

	@Test
	public void testPatientContextObj_Null_Scenario() {
		wsreq.setPatientContext(null);
		try {
			PatientInfoReqType wsreq = new PatientInfoReqType();
			validator.validateWSReq(wsreq);
		} catch (PatientInfoReqValidException e) {
			assertEquals("pt001", e.getRespCode());
		}
	}

	@Test
	public void testRequestId_Null_Scenario() {
		wsreq.getPatientContext().setRequestId(null);
		try {
			validator.validateWSReq(wsreq);
		} catch (PatientInfoReqValidException e) {
			assertEquals("pt002", e.getRespCode());
		
		}
	}

	@Test
	public void testRequestId_isempty_scenario() {
		wsreq.getPatientContext().setRequestId("");
		try {
			validator.validateWSReq(wsreq);
		} catch (PatientInfoReqValidException e) {
			assertEquals("pt002", e.getRespCode());
		}
	}

	@Test
	public void testSourceName_isempty_scenario() {
		wsreq.getPatientContext().setSourceName("");
		try {
			validator.validateWSReq(wsreq);
		} catch (PatientInfoReqValidException e) {
			assertEquals("pt003", e.getRespCode());
		}
	}

	@Test
	public void testSourceName_Null_Scenario() {
		wsreq.getPatientContext().setSourceName(null);
		try {
			validator.validateWSReq(wsreq);
		} catch (PatientInfoReqValidException e) {
			assertEquals("pt003", e.getRespCode());
		}
	}

	@Test
	public void testPatientDetailsTypeObj_Null_Scenario() {
		wsreq.setPatientDetails(null);
		try {
			PatientInfoReqType wsreq = new PatientInfoReqType();
			validator.validateWSReq(wsreq);
		} catch (PatientInfoReqValidException e) {
			assertEquals("pt001", e.getRespCode());
		}
	}

	@Test
	public void testFname_isempty_scenario() {
		wsreq.getPatientDetails().setFname(null);
		try {
			validator.validateWSReq(wsreq);
		} catch (PatientInfoReqValidException e) {
			assertEquals("pt004", e.getRespCode());
		}
	}

	@Test
	public void testFname_Null_Scenario() {
		wsreq.getPatientDetails().setFname("");
		try {
			validator.validateWSReq(wsreq);
		} catch (PatientInfoReqValidException e) {
			assertEquals("pt004", e.getRespCode());
		}
	}

	@Test
	public void testLname_isempty_scenario() {
		wsreq.getPatientDetails().setLname(null);
		try {
			validator.validateWSReq(wsreq);
		} catch (PatientInfoReqValidException e) {
			assertEquals("pt005", e.getRespCode());
		}
	}

	@Test
	public void testLname_Null_Scenario() {
		wsreq.getPatientDetails().setLname("");
		try {
			validator.validateWSReq(wsreq);
		} catch (PatientInfoReqValidException e) {
			assertEquals("pt005", e.getRespCode());
		}
	}


	@Test
	public void testGender_isempty_scenario() {
		wsreq.getPatientDetails().setGender(null);
		try {
			validator.validateWSReq(wsreq);
		} catch (PatientInfoReqValidException e) {
			assertEquals("pt007", e.getRespCode());
		}
	}

	@Test
	public void testGender_Null_Scenario() {
		wsreq.getPatientDetails().setGender("");
		try {
			validator.validateWSReq(wsreq);
		} catch (PatientInfoReqValidException e) {
			assertEquals("pt007", e.getRespCode());
		}
	}

	@Test
	public void testDob_Null_Scenario() {
		wsreq.getPatientDetails().setPatientId(0);
		try {
			validator.validateWSReq(wsreq);
		} catch (PatientInfoReqValidException e) {
			assertEquals("pt008", e.getRespCode());
		}
	}

	@Test
	public void testAge_Null_Scenario() {
		wsreq.getPatientDetails().setAge(0);
		try {
			validator.validateWSReq(wsreq);
		} catch (PatientInfoReqValidException e) {
			assertEquals("pt009", e.getRespCode());
		}
	}

	@Test
	public void testMobile_Null_Scenario() {
		wsreq.getPatientDetails().setMobnum(0);
		try {
			validator.validateWSReq(wsreq);
		} catch (PatientInfoReqValidException e) {
			assertEquals("pt010", e.getRespCode());
		}
	}

	@Test
	public void testAddress_Null_Scenario() {
		wsreq.getPatientDetails().setAddress(null);
		try {
			validator.validateWSReq(wsreq);
		} catch (PatientInfoReqValidException e) {
			assertEquals("pt011", e.getRespCode());
		}
	}

	@Test
	public void testAddress_isEmpty_Scenario() {
		wsreq.getPatientDetails().setAddress("");
		try {
			validator.validateWSReq(wsreq);
		} catch (PatientInfoReqValidException e) {
			assertEquals("pt011", e.getRespCode());
		}
	}

	@After
	public void tearDown() throws Exception {
		validator = null;
	}

}
