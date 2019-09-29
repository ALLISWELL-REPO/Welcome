package org.o2.registersvc.intg.util;

public class SystemException extends Exception {

	private String  dbRespCode;
	private String dbRespMsg;
	
		
	public SystemException(String dbRespCode, String dbRespMsg) {
		super();
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
