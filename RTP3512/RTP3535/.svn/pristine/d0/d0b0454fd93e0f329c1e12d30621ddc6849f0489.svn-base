
package org.nhs.patient.resource.client;

import java.util.ArrayList;
import java.util.List;

import org.nhs.patient.resource.beans.PatientDetailsMainRes;
import org.nhs.patient.resource.beans.PatientDetailsReq;
import org.nhs.patient.resource.beans.PatientDetailsRes;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class PatientDetailsResourceClient {
	List<HttpMessageConverter<?>> msgConverters = new ArrayList<HttpMessageConverter<?>>();
	RestTemplate template = new RestTemplate();

	public PatientDetailsMainRes searchPatient(PatientDetailsReq req) {
		/*
		 * String rsrcURI =
		 * "http://localhost:8888/patientresourceweb-0.0.1-SNAPSHOT/rest/patientinfo/search?"
		 * + "nhsNumber=" + req.getNhsNumber() + "&" + "fname=" + req.getFname()
		 * + "&" + "lname=" + req.getLname() + "&" + "dob=" + req.getDOB() + "&"
		 * + "hnumber=" + req.getHnum() + "&" + "gender=" + req.getGender() +
		 * "&" + "postalCode=" + req.getPostalCode();
		 */
				
		String rsrcURI = "http://localhost:8565/patientInfoResource-SpringRest/patientInfo/search?firstName=vineet";
		System.out.println("service URI :" + rsrcURI);

		// Add the Jackson Message converter
		msgConverters.add(new MappingJackson2HttpMessageConverter());
		template.setMessageConverters(msgConverters);

		/*
		 * List<PatientDetailsRes> resp = (List<PatientDetailsRes>)
		 * template.getForObject(rsrcURI, PatientDetailsRes.class);
		 */
		PatientDetailsMainRes resp = (PatientDetailsMainRes) template.getForObject(rsrcURI,
				PatientDetailsMainRes.class);

		System.out.println("response is :" + resp);
		List<PatientDetailsRes> list = resp.getPatientDetailsRes1();
		System.out.println("list=" + list);
		for (PatientDetailsRes res1 : list) {
			System.out.println(res1.getCreatedBy());
			System.out.println(res1.getCreatedDate());
			System.out.println(res1.getDOB());
			System.out.println("name=" + res1.getFname());
			System.out.println(res1.getGender());
			System.out.println(res1.getHnum());
			System.out.println(res1.getId());
		}

		return resp;

	}

	public Integer createPatient(PatientDetailsReq req) {
		String rsrcURI = "http://localhost:8565/patientInfoResource-SpringRest/patientInfo/createPatient";
		System.out.println("Service URI" + rsrcURI);
		msgConverters.add(new MappingJackson2HttpMessageConverter());
		template.setMessageConverters(msgConverters);
		Integer id = template.postForObject(rsrcURI, req, Integer.class);
		return id;
	}

	public PatientDetailsRes getDetails(Integer patientId) {
		String rsrcURI = "http://localhost:8565/patientInfoResource-SpringRest/patientInfo/getpatient/{patientid}"
				+ patientId;
		System.out.println("Service URI" + rsrcURI);
		msgConverters.add(new MappingJackson2HttpMessageConverter());
		template.setMessageConverters(msgConverters);
		PatientDetailsRes resp = template.getForObject(rsrcURI, PatientDetailsRes.class);
		return resp;

	}

	public void updatePatient(PatientDetailsReq req) {
		String rsrcURI = "http://localhost:8565/patientInfoResource-SpringRest/patientInfo/updatePatient";
		System.out.println("Service URI" + rsrcURI);
		msgConverters.add(new MappingJackson2HttpMessageConverter());
		template.setMessageConverters(msgConverters);
		template.put(rsrcURI, req);
	}

	public static void main(String[] args) {
		PatientDetailsResourceClient rsrcClient = new PatientDetailsResourceClient();
		PatientDetailsReq req = new PatientDetailsReq();
		req.setDOB("24-03-1988");
		req.setFname("sreenu");
		req.setGender("M");
		req.setLname("Tech");
		req.setNationalIdentifierType("232323232");
		req.setNhsNumber("abc121212xyz");
		req.setId("121212");
		req.setCreatedBy("s41");
		req.setCreatedDate("12-05-2010");
		req.setPostalCode("postal43");
		req.setUpdatedBy("ytoruji");
		req.setUpdatedDate("12-05-2010");
		// invoke the searchPatient

		PatientDetailsMainRes resp = rsrcClient.searchPatient(req);
		System.out.println(resp);
		// System.out.println("Response is :" + resp); // invoke the
		// createPatient
		int createResp = rsrcClient.createPatient(req);
		System.out.println("createPatient resp :" + createResp); // invokethe
																	// getPatinet
		/*
		 * PatientDetailsRes getPatientResp =
		 * rsrcClient.getDetails(Integer.parseInt(req.getId()));
		 * System.out.println("getPatientResp resp :" + getPatientResp);
		 */

	}

}