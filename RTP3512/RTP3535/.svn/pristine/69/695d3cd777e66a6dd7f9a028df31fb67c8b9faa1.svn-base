package org.patientdetails.controller.builder;

import java.util.ArrayList;
import java.util.List;

import org.nhs.patient.resource.beans.PatientDetailsRes;
import org.patientdetails.controller.bean.ResponseBean;

public class ResBuilder {

	public List<ResponseBean> getResp(List<PatientDetailsRes> res) {
		List<ResponseBean> resList=new ArrayList<ResponseBean>();
		for(PatientDetailsRes cliRes:res){
			ResponseBean resBean=new ResponseBean();
			resBean.setFname(cliRes.getFname());
			resBean.setLname(cliRes.getLname());
			resBean.setDOB(cliRes.getDOB());
			resBean.setGender(cliRes.getGender());
			resBean.setPostalCode(cliRes.getPostalCode());
			resList.add(resBean);
		}
		
		return resList;
		// TODO Auto-generated method stub
		
	}

}
