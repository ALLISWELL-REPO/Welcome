package org.nhs.patientdetails;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.nhs.patientdaodetails.beans.PatientDetailsDAOReq;
import org.nhs.patientdaodetails.beans.PatientDetailsDAORes;
import org.nhs.patientdaodetails.builders.PatientDetailsDAOReqBuilder;
import org.nhs.patientdaodetails.entities.PatientDetails;
import org.nhs.patientdaodetails.services.NHSPatientDetailsServiceImpl;
import org.nhs.patientdetails.beans.PatientDetailsReq;
import org.nhs.patientdetails.beans.PatientDetailsRes;
import org.nhs.patientdetails.beans.PatientInfo;
import org.nhs.patientdetails.resource.builders.PatientDetailsRsrcReqBuilder;
import org.nhs.patientdetails.resource.builders.PatientDetailsRsrcResBuilder;

@Path("/patientinfo")
public class PatientDetailsApiImpl {
	NHSPatientDetailsServiceImpl svcImpl = new NHSPatientDetailsServiceImpl();
	PatientDetailsRsrcResBuilder resourceResp = new PatientDetailsRsrcResBuilder();
	PatientDetailsRsrcReqBuilder reqBuild = new PatientDetailsRsrcReqBuilder();
	PatientDetailsRes res = new PatientDetailsRes();

	@Path("/search")
	@GET
	@Produces("application/json")

	List<PatientDetailsRes> searchPatient(@QueryParam("nhsNumber") String nhsNum, @QueryParam("firstName") String fName,
			@QueryParam("lastName") String lName, @QueryParam("dateofBirth") String dob,
			@QueryParam("hnum") String hnum, @QueryParam("gender") String gender,
			@QueryParam("postalCode") String postalCode) {
		try {

			// Date dob1 = new SimpleDateFormat("dd-MM-yyyy").parse(dob);
			PatientDetailsDAOReq searchReq = new PatientDetailsDAOReq();
			searchReq.setNhsNumber(nhsNum);
			searchReq.setFirstName(fName);
			searchReq.setLastName(lName);
			searchReq.setDateofBirth(dob);
			searchReq.setHnum(hnum);
			searchReq.setGender(gender);
			searchReq.setPostalCode(postalCode);
			List<PatientDetailsDAORes> resp = svcImpl.searchPatient(searchReq);
			List<PatientDetailsRes> resrcResp = resourceResp.buildDAORes(resp);
			return resrcResp;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	@Path("/getpatient/{patientId}")
	@Produces("application/json")
	public List<PatientDetailsRes> getDetails(@PathParam("patientId") String patientId) {
		List<PatientDetailsDAORes> daoRes = svcImpl.getPatient(Integer.parseInt(patientId));
		List<PatientDetailsRes> resourceRes = resourceResp.buildDAORes(daoRes);

		return resourceRes;

	}

	@Path("/create")
	@Produces("application/json")
	@Consumes("application/json")
	public Integer createPatient(PatientDetailsReq request) {
		try {

			PatientDetailsDAOReq daoReq = reqBuild.buildDAOReq(request);
			Integer i = svcImpl.createPatient(daoReq);

			return i;
		} catch (ParseException e) {

			e.printStackTrace();
			return 0;
		}
	}

	@Path("/update")
	@Produces("application/json")
	@Consumes("application/json")
	public void updatePatient(PatientDetailsReq request) {
		try {

			PatientDetailsDAOReq daoReq = reqBuild.buildDAOReq(request);
			svcImpl.updatePatient(daoReq);

		} catch (ParseException e) {

			e.printStackTrace();

		}
	}

	public static void main(String args[]) throws JsonGenerationException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		PatientDetailsReq req = new PatientDetailsReq();
		req.setCreatedBy("s2");
		req.setCreatedDate("12-05-2010");
		req.setDOB("12-05-2010");
		req.setFname("srii");
		req.setGender("female");
		req.setId("18");
		req.setLname("anandii");
		req.setNhsNumber("nhs123456");
		req.setPostalCode("postal2343");
		req.setUpdatedBy("ytor");
		req.setUpdatedDate("12-05-2010");
		req.setNationalIdentifierType("462435");
		req.setNationalPatientId("4645");
		PatientDetailsApiImpl impl = new PatientDetailsApiImpl();
		// int create = impl.createPatient(req);
		// System.out.println("Created sucessfully" + create);
		PatientDetailsDAOReq pdreq = new PatientDetailsDAOReq();
		pdreq.setFirstName("vineet");
		pdreq.setLastName("anand");
		List<PatientDetailsRes> list = impl.searchPatient(null, "srii", "anandii", "12-05-2010", "5", 
				"female", null);
		String json = mapper.defaultPrettyPrintingWriter().writeValueAsString(req);
		System.out.println(json);
		for (PatientDetailsRes res : list) {
			System.out.println("sad");
			System.out.println(res.getFname());
			System.out.println(res.getLname());
		}
		System.out.println(list.size());

		/*
		 * List<PatientDetailsRes> res = impl.getDetails("9");
		 * System.out.println(res);
		 */

	}

}
