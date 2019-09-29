/**
 * NHS.All Rights are reserved @Copy Rights are reserved.
You should not disclose the information outside otherwise
 terms and conditions will apply
 */
package org.nhs.patientinfo.service.builders;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.nhs.patientinfo.process.builders.PatientInfoProcessResBuilder;
import org.nhs.patientinfo.process.valuebeans.PatientInfoProcessVbRes;
import org.nhs.patientinfo.v1.schemas.resp.PatientInfoResType;

/**
 * @author: Stech
 * @Date     :  Mar 11, 2018
 * Description:  
 */
public class PatientInfoSvcResBuilderTest {

	
	
	@Test
	public void testBuildwsResp() {
		PatientInfoSvcResBuilder respBuilder=new PatientInfoSvcResBuilder();
		PatientInfoProcessVbRes vbResp=new PatientInfoProcessVbRes();
		vbResp.setRespCode("000");
		vbResp.setRespMsg("success");
		PatientInfoResType wsResp = respBuilder.buildwsResp(vbResp);
		assertNotNull(wsResp);
		assertNotNull(wsResp.getStatus());
		assertEquals(vbResp.getRespCode(), wsResp.getStatus().getResCode());
		assertEquals(vbResp.getRespMsg(), wsResp.getStatus().getRespMsg());
		
	}

}
