package org.o2.registersvc.intg.beans;

public class RegisterSvcDAORes {

	@Override
	public String toString() {
		return "RegisterSvcDAORes [daoRespCode=" + daoRespCode + ", daoRespMsg=" + daoRespMsg + "]";
	}
	
	private String daoRespCode;
	private String daoRespMsg;
	
	
	public String getDaoRespCode() {
		return daoRespCode;
	}
	public void setDaoRespCode(String daoRespCode) {
		this.daoRespCode = daoRespCode;
	}
	public String getDaoRespMsg() {
		return daoRespMsg;
	}
	public void setDaoRespMsg(String daoRespMsg) {
		this.daoRespMsg = daoRespMsg;
	}
	
	
	
	
}
