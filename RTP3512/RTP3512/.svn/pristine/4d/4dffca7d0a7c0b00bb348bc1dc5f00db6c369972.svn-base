package org.nhs.patientinfosrv.service.builders;

import static org.junit.Assert.*;

import org.junit.Test;
import org.nhs.patientinfo.process.ValueBeans.PatientInfoProcessVbRes;
import org.nhs.patientinfo.v1.schemas.res.PatientInfoResType;

public class PatientInfoResBuilderTest {

	@Test
	public void testBuildProcessRes() {
		PatientInfoProcessVbRes vbResponse = buildresponse();

	}

	private PatientInfoProcessVbRes buildresponse() {
		PatientInfoProcessVbRes vbResponse = new PatientInfoProcessVbRes();
		PatientInfoResBuilder resBuilder = new PatientInfoResBuilder();
		PatientInfoResType res = resBuilder.buildProcessRes(vbResponse);
		assertEquals(res.getStatus().getResMsg(), vbResponse.getResMsg());

		return vbResponse;
	}

}
