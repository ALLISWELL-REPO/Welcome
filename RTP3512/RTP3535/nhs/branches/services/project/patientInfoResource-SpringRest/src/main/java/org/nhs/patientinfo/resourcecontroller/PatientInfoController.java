package org.nhs.patientinfo.resourcecontroller;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.nhs.patientdaodetails.beans.PatientDetailsDAOReq;
import org.nhs.patientdaodetails.beans.PatientDetailsDAORes;
import org.nhs.patientdaodetails.services.NHSPatientDetailsServiceImpl;
import org.nhs.patientinfo.controller.beans.PatientDetailsReq;
import org.nhs.patientinfo.controller.beans.PatientDetailsRes;
import org.nhs.patientinfo.controller.builders.PatientDetailsRsrcReqBuilder;
import org.nhs.patientinfo.controller.builders.PatientDetailsRsrcResBuilder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/patientInfo")
public class PatientInfoController {
	NHSPatientDetailsServiceImpl svcImpl = new NHSPatientDetailsServiceImpl();
	PatientDetailsRsrcResBuilder resourceResp = new PatientDetailsRsrcResBuilder();
	PatientDetailsRsrcReqBuilder reqBuilder = new PatientDetailsRsrcReqBuilder();

	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = "application/json")
	public List<PatientDetailsRes> searchPatient(@RequestParam(value = "nhsNumber", required = false) String nhsNum,
			@RequestParam(value = "firstName", required = false) String fName,
			@RequestParam(value = "lastName", required = false) String lName,
			@RequestParam(value = "dateofBirth", required = false) String dob,
			@RequestParam(value = "hnum", required = false) String hnum,
			@RequestParam(value = "gender", required = false) String gender,
			@RequestParam(value = "postalCode", required = false) String postalCode) {

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
			System.out.println(resrcResp);
			return resrcResp;
		} catch (Exception e) {
			System.out.println("Exception");
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value = "/createPatient", method = RequestMethod.POST, produces = ("application/json"), consumes = ("application/json"))
	public Integer createPatient(@RequestBody PatientDetailsReq request) {
		try {
            System.out.println("haiiii");
			PatientDetailsDAOReq daoReq = reqBuilder.buildDAOReq(request);
			Integer id = svcImpl.createPatient(daoReq);

			return id;
		} catch (ParseException e) {

			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value = "/getPatient/{patientId}", method = RequestMethod.GET, produces = "application/json")
	public List<PatientDetailsRes> getDetails(@PathVariable("patientId") String patientId) {
		List<PatientDetailsDAORes> daoRes = svcImpl.getPatient(Integer.parseInt(patientId));
		List<PatientDetailsRes> resourceRes = resourceResp.buildDAORes(daoRes);

		return resourceRes;

	}

	@RequestMapping(value = "/updatePatient", method = RequestMethod.POST, produces = ("application/json"), consumes = ("application/json"))
	public void updatePatient(PatientDetailsReq request) {
		try {

			PatientDetailsDAOReq daoReq = reqBuilder.buildDAOReq(request);
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
		PatientInfoController impl = new PatientInfoController();
		// int create = impl.createPatient(req);
		// System.out.println("Created sucessfully" + create);
		PatientDetailsDAOReq pdreq = new PatientDetailsDAOReq();
		pdreq.setFirstName("vineet");
		pdreq.setLastName("anand");
		List<PatientDetailsRes> list = impl.searchPatient(null, "srii", "anandii", "12-05-2010", "5", "female", null);
		String json = mapper.writeValueAsString(req);
		System.out.println(json);
		for (PatientDetailsRes res : list) {
			System.out.println("sad");
			System.out.println(res.getFname());
			System.out.println(res.getLname());
		}
		System.out.println(list.size());

	}
}