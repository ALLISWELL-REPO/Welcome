package org.patientdetails.controller;

import java.util.List;

import org.nhs.patient.resource.beans.PatientDetailsMainRes;
import org.nhs.patient.resource.beans.PatientDetailsReq;
import org.nhs.patient.resource.beans.PatientDetailsRes;
import org.nhs.patient.resource.client.PatientDetailsResourceClient;
import org.patientdetails.controller.bean.RequestBean;
import org.patientdetails.controller.bean.ResponseBean;
import org.patientdetails.controller.builder.ReqBuilder;
import org.patientdetails.controller.builder.ResBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/controller")
public class PatientController {
	PatientController()
	{
		System.out.println("controller");
	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() {
		return "Home";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String searchPatient(@RequestParam(value = "fname", required = false) String fname,
			@RequestParam(value = "lname", required = false) String lname,
			@RequestParam(value = "dob", required = false) String dob,
			@RequestParam(value = "gender", required = false) String gender,
			@RequestParam(value = "postalCode", required = false) String postalCode, Model model) {
		System.out.println("hi" + fname);

		RequestBean req = new RequestBean();
		req.setFirstName(fname);
		req.setLastName(lname);
		req.setDateofBirth(dob);
		req.setGender(gender);
		req.setPostalCode(postalCode);

		PatientDetailsResourceClient client = new PatientDetailsResourceClient();
		PatientDetailsReq clientReq = new PatientDetailsReq();
		clientReq.setFname(req.getFirstName());
		clientReq.setLname(req.getLastName());
		clientReq.setDOB(req.getDateofBirth());
		clientReq.setGender(req.getGender());
		clientReq.setPostalCode(req.getPostalCode());
		PatientDetailsMainRes res = client.searchPatient(clientReq);
		List<PatientDetailsRes> list = res.getPatientDetailsRes1();
		
		ResBuilder builder = new ResBuilder();
		List<ResponseBean> res1 = builder.getResp(list);
		model.addAttribute("searchList",res1);
		
		System.out.println("success");

		return "GetAll";
	}

	@RequestMapping(value = "/exresult", method = RequestMethod.GET)
	public String exSearchResult() {
		return "EXSearchResult";
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create() {
		return "Create";
	}

	@RequestMapping(value = "/createpatient", method = RequestMethod.POST)
	public String createPatient(@RequestParam(value = "fname", required = false) String fname,
			@RequestParam(value = "lname", required = false) String lname,
			@RequestParam(value = "dob", required = false) String dob,
			@RequestParam(value = "gender", required = false) String gender,
			@RequestParam(value = "createdDate", required = false) String createdDate,
			@RequestParam(value = "postalCode", required = false) String postalCode,
			@RequestParam(value = "nationalIdentifierType", required = false) String nationalIdentifierType,
			@RequestParam(value = "nationalPatientId", required = false) String nationalPatientId,
			@RequestParam(value = "updatedDate", required = false) String updatedDate,
			@RequestParam(value = "createdBy", required = false) String createdBy,
			@RequestParam(value = "updatedBy", required = false) String updatedBy,
			@RequestParam(value = "nhsNumber", required = false) String nhsNumber,
			@RequestParam(value = "hnum", required = false) String hnum) {
		System.out.println("Fname" + fname);
		RequestBean req = new RequestBean();
		req.setFirstName(fname);
		req.setLastName(lname);
		req.getDateofBirth();
		req.setGender(gender);
		req.setCreatedDate(createdDate);
		req.setPostalCode(postalCode);
		req.setNationalIdentifierType(nationalIdentifierType);
		req.setNationalPatientId(nationalPatientId);
		req.setNationalPatientId(nationalPatientId);
		req.setNationalPatientId(nationalPatientId);
		req.setUpdatedDate(updatedDate);
		req.setCreatedBy(createdBy);
		req.setUpdatedBy(updatedBy);
		req.setNhsNumber(nhsNumber);
		PatientDetailsResourceClient client = new PatientDetailsResourceClient();
		ReqBuilder reqBuild = new ReqBuilder();
		PatientDetailsReq reqType = reqBuild.buildPatientDetailsReq(req);
		Integer i = client.createPatient(reqType);
		System.out.println("craeted Patient Sucessfylly");
		return "CreatePatient";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit() {
		return "EditCurrentEntry";
	}
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update() {
		return "Update";
	}

	@RequestMapping(value = "/updatepatient", method = RequestMethod.POST)
	public String updatePatient(@RequestParam(value = "fname", required = false) String fname,
			@RequestParam(value = "lname", required = false) String lname,
			@RequestParam(value = "dob", required = false) String dob,
			@RequestParam(value = "gender", required = false) String gender,
			@RequestParam(value = "createdDate", required = false) String createdDate,
			@RequestParam(value = "postalCode", required = false) String postalCode,
			@RequestParam(value = "nationalIdentifierType", required = false) String nationalIdentifierType,
			@RequestParam(value = "nationalPatientId", required = false) String nationalPatientId,
			@RequestParam(value = "updatedDate", required = false) String updatedDate,
			@RequestParam(value = "createdBy", required = false) String createdBy,
			@RequestParam(value = "updatedBy", required = false) String updatedBy,
			@RequestParam(value = "nhsNumber", required = false) String nhsNumber,
			@RequestParam(value = "hnum", required = false) String hnum) {
		System.out.println("Fname" + fname);
		RequestBean req = new RequestBean();
		req.setFirstName(fname);
		req.setLastName(lname);
		req.getDateofBirth();
		req.setGender(gender);
		req.setCreatedDate(createdDate);
		req.setPostalCode(postalCode);
		req.setNationalIdentifierType(nationalIdentifierType);
		req.setNationalPatientId(nationalPatientId);
		req.setNationalPatientId(nationalPatientId);
		req.setNationalPatientId(nationalPatientId);
		req.setUpdatedDate(updatedDate);
		req.setCreatedBy(createdBy);
		req.setUpdatedBy(updatedBy);
		req.setNhsNumber(nhsNumber);
		PatientDetailsResourceClient client = new PatientDetailsResourceClient();
		ReqBuilder reqBuild = new ReqBuilder();
		PatientDetailsReq reqType = reqBuild.buildPatientDetailsReq(req);
		client.updatePatient(reqType);
		System.out.println("craeted Patient Sucessfylly");
		return "UpdatePatient";
	}
	@RequestMapping(value = "/result", method = RequestMethod.GET)
	public String SearchResult() {
		return "SearchResult";
	}

	@RequestMapping(value="/patient", method=RequestMethod.GET)
	public String patient()
	{
		return "Patient";
	}
}
