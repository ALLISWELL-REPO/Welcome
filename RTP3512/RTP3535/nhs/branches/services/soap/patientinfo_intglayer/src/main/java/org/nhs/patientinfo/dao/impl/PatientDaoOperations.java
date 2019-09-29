package org.nhs.patientinfo.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;
import org.nhs.patientinfo.dao.beans.PatientInfoReqIntg;

public class PatientDaoOperations {

	private static Logger logger = Logger.getLogger(PatientDaoOperations.class);

	RetriveConnection rc = new RetriveConnection();
	Connection con = rc.getConnection();
	ResultSet rs = null;
	Statement st = null;
	String sql = "";

	public void createPatient(PatientInfoReqIntg req) throws SQLException {
		st=con.createStatement();
		sql = "insert into patient_details values('" + req.getFname() + "','" + req.getLname() + "','" + req.getSex()
				+ "'," + req.gethCode() + ",'" + req.getDob() + "'," + req.gethNum() + ","
				+ req.getPostalCode()+")";
		System.out.println(sql);
		st.executeUpdate(sql);
		System.out.println("inserted sucessfully");
	}

}
