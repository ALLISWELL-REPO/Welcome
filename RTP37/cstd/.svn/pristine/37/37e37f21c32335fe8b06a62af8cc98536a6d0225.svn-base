package org.o2.registersvc.service.builder;

import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.o2.registersvc.process.beans.RegisterSvcProcessVBRes;
import org.o2.registersvc.schema.res.RegisterServiceResType;

public class RegisterSvcResBuilderTest {

	RegisterSvcResBuilder respBuilder = null;
	RegisterSvcProcessVBRes vbResp= null;
	RegisterServiceResType wsResp=null;
	
	@Before
	public void setUp() throws Exception {
		respBuilder=new RegisterSvcResBuilder();
		vbResp=buildResp();
		wsResp = respBuilder.buildWSResponse(vbResp);
	}

	@Test
	public void testBuildWSResponse() {
		Assert.assertNotNull(vbResp);
		Assert.assertEquals(vbResp.getRespCode(), wsResp.getStatusBlock().getRespCode());
		Assert.assertEquals(vbResp.getRespMsg(), wsResp.getStatusBlock().getRespMsg());
		Assert.assertEquals(vbResp.getScore(), wsResp.getCreditCheck().getRateOfPer(), 00);
		Assert.assertEquals(vbResp.getStatus(), wsResp.getCreditCheck().getCreditStatus());
	}


	
	
	public RegisterSvcProcessVBRes buildResp(){
		RegisterSvcProcessVBRes vbResp=new RegisterSvcProcessVBRes();
		vbResp.setRespCode("102");
		vbResp.setRespMsg("nice");
		vbResp.setScore(86.02f);
		vbResp.setStatus("very good");
		return vbResp;
	}
	
}
