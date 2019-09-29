package org.nhs.patientinfosrv.service.builders;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.nhs.patientinfo.process.ValueBeans.PatientInfoProcessVbReq;
import org.nhs.patientinfo.v1.schemas.req.PatientContextType;
import org.nhs.patientinfo.v1.schemas.req.PatientDetailsTYpe;
import org.nhs.patientinfo.v1.schemas.req.PatientInfoReqType;

public class PatientInfoReqBuilderTest extends PatientInfoReqBuilder {

	private PatientInfoReqType buildWsRequest() {
		PatientDetailsTYpe detail = new PatientDetailsTYpe();
		PatientContextType type = new PatientContextType();
		PatientInfoReqType WsRequest1 = new PatientInfoReqType();
		type.setRequestId("1");
		type.setSourceName("hyderabad");
		detail.setPatientId(1);
		detail.setFname("deepak");
		detail.setLname("rout");
		detail.setMobnum("987656441");
		detail.setGender("male");
		detail.setAddress("ameerpet");
		WsRequest1.setPatientContext(type);
		WsRequest1.setPatientDetails(detail);

		return WsRequest1;
	}

	@Test
	public void testBuildProcessReq() {
		PatientInfoReqType req = buildWsRequest();

		PatientInfoReqBuilder bulder = new PatientInfoReqBuilder();
		PatientInfoProcessVbReq bvreq = bulder.buildProcessReq(req);

		assertEquals(req.getPatientContext().getSourceName(),
				bvreq.getSourceName());

	}
	@Test
	public void testBuildProcessRequsetId()
	{
		PatientInfoReqType req = buildWsRequest();

		PatientInfoReqBuilder bulder = new PatientInfoReqBuilder();
		PatientInfoProcessVbReq bvreq = bulder.buildProcessReq(req);

		assertEquals(req.getPatientContext().getRequestId(),bvreq.getRequestId());
		
	}
	@Test
	public void testBuildProcessReqestDetailsFirstName()
	{
		PatientInfoReqType req = buildWsRequest();

		PatientInfoReqBuilder bulder = new PatientInfoReqBuilder();
		PatientInfoProcessVbReq bvreq = bulder.buildProcessReq(req);

		assertEquals(req.getPatientDetails().getFname(),bvreq.getFname());
	}
	@Test
	public void testBuildProcessRequestDetailsLastName()
	{
		PatientInfoReqType req = buildWsRequest();

		PatientInfoReqBuilder bulder = new PatientInfoReqBuilder();
		PatientInfoProcessVbReq bvreq = bulder.buildProcessReq(req);

		assertEquals(req.getPatientDetails().getLname(),bvreq.getLname());
	}
		
	
	@Test
	public void testBuildProcessRequestDetailsGender()
	{
		PatientInfoReqType req = buildWsRequest();

		PatientInfoReqBuilder bulder = new PatientInfoReqBuilder();
		PatientInfoProcessVbReq bvreq = bulder.buildProcessReq(req);

		assertEquals(req.getPatientDetails().getGender(),bvreq.getGender());
	}
	@Test
	public void testBuildProcessRequestDetailsAddress()
	{
		PatientInfoReqType req = buildWsRequest();

		PatientInfoReqBuilder bulder = new PatientInfoReqBuilder();
		PatientInfoProcessVbReq bvreq = bulder.buildProcessReq(req);

		assertEquals(req.getPatientDetails().getAddress(),bvreq.getAddress());
	}
	@Test
	public void testBuildProcessRequestDetailsMobile()
	{
		PatientInfoReqType req = buildWsRequest();

		PatientInfoReqBuilder bulder = new PatientInfoReqBuilder();
		PatientInfoProcessVbReq bvreq = bulder.buildProcessReq(req);

		assertEquals(req.getPatientDetails().getMobnum(),bvreq.getMobnum());
	}
	@Test
	public void testBuildProcessRequestDetailsPatientId()
	{
		PatientInfoReqType req = buildWsRequest();

		PatientInfoReqBuilder bulder = new PatientInfoReqBuilder();
		PatientInfoProcessVbReq bvreq = bulder.buildProcessReq(req);
		assertEquals(req.getPatientDetails().getPatientId(),bvreq.getPatientId());

	}
}
