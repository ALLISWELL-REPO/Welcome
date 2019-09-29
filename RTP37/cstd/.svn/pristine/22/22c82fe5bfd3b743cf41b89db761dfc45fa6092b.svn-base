package o2.register.service;

import org.register.beans.O2LoginResp;
import org.register.dao.O2LoginDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import o2.register.formdata.O2LoginFormData;

@Service
public class O2LoginService {

	@Autowired(required=true)
	private O2LoginDAO loginDao;
	
	public O2LoginResp process(O2LoginFormData loginFormData) {
		
		return loginDao.process(loginFormData);
	}

}
