package org.o2.registersvc.intg.util;

public class BussinessException extends Exception {

	private String  dbRespCode;
	private String dbRespMsg;
	
	public BussinessException(String dbRespCode, String dbRespMsg) {
		
		this.dbRespCode = dbRespCode;
		this.dbRespMsg = dbRespMsg;
	}

	public String getDbRespCode() {
		return dbRespCode;
	}

	public String getDbRespMsg() {
		return dbRespMsg;
	}
	

	
	
}
