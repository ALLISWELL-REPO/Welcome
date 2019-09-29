package org.register.dao;

import org.register.beans.O2LoginReq;
import org.register.beans.O2LoginResp;
import org.springframework.stereotype.Repository;

import o2.register.formdata.O2LoginFormData;

@Repository
public class O2LoginDAO {

	public O2LoginResp process(O2LoginFormData loginFormData) {
      System.out.println(loginFormData);
		O2LoginResp resp = null;
		
		if (loginFormData.getAccNo().equals("123") && loginFormData.getMobNo().equals("321")

				&& loginFormData.getPass().equals("pass")) {
			resp = new O2LoginResp();
			resp.setRespCode("0000");
			resp.setRespMsg("valide User");
		}
		else{
			resp=new O2LoginResp();
			resp.setRespCode("1111");
			resp.setRespMsg("invalide valide User");
		}
		return resp;

	}

}
