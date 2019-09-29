package org.nhs.patientinfo.resource;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.nhs.patientinfo.dao.beans.PatientInfoReqIntg;
import org.nhs.patientinfo.dao.impl.PatientDaoOperations;
import org.nhs.patientinfo.details.PatientInfoReq;
import org.nhs.patientinfo.details.PatientInfoResp;
import org.nhs.patientinfo.v1.schemas.req.PatientInfoReqType;
import org.nhs.patientinfo.v1.schemas.resp.PatientInfoResType;
import org.nhs.patientinfo.v1.schemas.resp.StatusType;

@Path("/patient/info/v1")
public class PatientInfoApiImpl {

	PatientDaoOperations dao=new PatientDaoOperations();
	PatientInfoReqIntg reqIntg=new PatientInfoReqIntg();
	@Path("/search")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public PatientInfoResp 
	searchPatient(@QueryParam("nhsnum") String nhsNum,
			@QueryParam("hcode") String hcode,
			@QueryParam("fname") String fname,
			@QueryParam("lname") String lname,
			@QueryParam("dob") String dob,
			@QueryParam("sex") String sex,
			@QueryParam("postalcode") String postalcode){
		System.out.println("Eneterd into search api");
		PatientInfoResp response = new PatientInfoResp();
	      response.setFname("sindhu");
          response.setLname("guduru");
          response.setSex("F");
          response.sethCode(123);
          response.sethNum(2424);
          response.setDob("20/02/2018");
          response.setPostalCode(2143);
		return response;
	}

	@Path("/createPatient")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String createPatient(PatientInfoReq req) throws SQLException {
		reqIntg.setFname(req.getFname());
		reqIntg.setLname(req.getLname());
		reqIntg.setSex(req.getSex());
		reqIntg.setDob(req.getDob());
		reqIntg.sethCode(req.gethCode());
		reqIntg.sethNum(req.gethNum());
		reqIntg.setPostalCode(req.getPostalCode());
		dao.createPatient(reqIntg);
		return "Created Patient Sucessfully";
	}

	@Path("/getPatient/{patientId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public PatientInfoResp getPatient(@PathParam("patientId") String PatientId) {
		PatientInfoResp response = new PatientInfoResp();
	      response.setFname("sindhu");
        response.setLname("guduru");
        response.setSex("F");
        response.sethCode(123);
        response.sethNum(2424);
        response.setDob("20/02/2018");
        response.setPostalCode(2143);
		return response;
	
	}
	

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/update")
	public PatientInfoResp updatePatient(PatientInfoReqType req) {
		PatientInfoResp response = new PatientInfoResp();
	      response.setFname("sindhu");
        response.setLname("guduru");
        response.setSex("F");
        response.sethCode(123);
        response.sethNum(2424);
        response.setDob("20/02/2018");
        response.setPostalCode(2143);
		return response;
	
	}
	
	public static void main(String[] args) throws SQLException {
		PatientInfoApiImpl impl=new PatientInfoApiImpl();
		PatientInfoReq req=new PatientInfoReq();
		req.setFname("sindhu");
		req.setLname("guduru");
		req.setSex("f");
		req.setDob("02-10-2018");
		req.sethCode(1234);
		req.sethNum(1234354);
		req.setPostalCode(57687);
		String status=impl.createPatient(req);
	}
}
