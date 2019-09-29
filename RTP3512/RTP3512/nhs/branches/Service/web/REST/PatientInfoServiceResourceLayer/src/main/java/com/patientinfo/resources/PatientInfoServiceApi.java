package com.patientinfo.resources;

import java.io.OutputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/patientinfo")
public class PatientInfoServiceApi {
	@GET()
	@Path("/searchPatient")
	@Produces(MediaType.APPLICATION_JSON)
	public PatientInfoResType searchPatient(
			@QueryParam("nhsNumber") String nhsNumber) {
		PatientInfoResType responce = new PatientInfoResType();
		responce.setRespCode("0");
		responce.setRespMsg("sucsess");
		return responce;

	}

	@POST()
	@Path("/createpatient")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public PatientInfoResType createPatient(PatientInfoReqType req) {
		PatientInfoResType responce = new PatientInfoResType();
		responce.setRespCode("0");
		responce.setRespMsg("sucsess");
		return responce;

	}

	@GET()
	@Path("/getpatient/{patientid}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public PatientInfoResType getPatient(
			@PathParam("patientId") String patientId) {
		PatientInfoResType responce = new PatientInfoResType();
		responce.setRespCode("0");
		responce.setRespMsg("sucsess");
		return responce;

	}

	@PUT()
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("updatePatient")
	public PatientInfoResType updatePatient(PatientInfoReqType req) {
		PatientInfoResType responce = new PatientInfoResType();
		responce.setRespCode("0");
		responce.setRespMsg("sucsess");
		return responce;

	}

}
