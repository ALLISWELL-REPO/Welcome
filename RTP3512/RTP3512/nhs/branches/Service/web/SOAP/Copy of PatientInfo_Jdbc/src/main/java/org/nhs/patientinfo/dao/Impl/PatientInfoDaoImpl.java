package org.nhs.patientinfo.dao.Impl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class PatientInfoDaoImpl {
	public static void main(String args[]) throws FileNotFoundException, SQLException

	{
		// 1.create Properties Object
		Properties prop = new Properties();
		String sql = "select*from patientinfo";
		String sql1="select*from patientinfo where patient_id>=3;";
		String sql2="insert into patientinfo(nhs_number,patient_id,first_name,last_name,postal_code)"+"values(12345,12356,'kalpana','roo','124wwere')";
		String sql4="update patientinfo set created_by=?,created_date=?,update_by=? where patient_id=?";
		try {
			prop.load(new FileReader(
					"D:\\RTP3512\\SOAP\\Copy of PatientInfo_Jdbc\\src\\main\\resources\\DB\\PatientInfo_dev_db.properties"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// 2.Get the Properties From Properties
		String url = prop.getProperty("DB_URL");
		String userName = prop.getProperty("DB_USRNM");
		String pswd = prop.getProperty("DB_PASSWD");
		System.out.println(url);
		System.out.println(userName);
		System.out.println(pswd);
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection(url, userName, pswd);
			PreparedStatement pstm = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
		
			PreparedStatement	pstm = con.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		PreparedStatement pstm = null;
		ResultSet res = pstm.executeQuery();
		PatientInfo ptn = new PatientInfo();
		res.next();
		{
			System.out.println(" enter into resultset");
			ptn.setNhs_number(res.getInt(1));
			ptn.setPatientId(res.getInt(2));
			// ptn.setDateOfBirth(res.getDate(5));
			ptn.setFirstName(res.getString(3));
			ptn.setGender(res.getString(6));
			System.out.println("this part is working");
			ptn.setLastName(res.getString(4));
			ptn.setNhs_number(res.getInt(1));
			ptn.setPostalNumber(res.getString(7));
			ptn.setCreatedBy(res.getString(8));
			// ptn.setCreatedDate(res.getDate(9));
			ptn.setUpdateBy(res.getString(10));
			// ptn.setUpdateDate(res.getDate(11));
			System.out.println("***"+ptn.getPatientId());
			System.out.println("****"+ptn.getDateOfBirth());
			System.out.println("***"+ptn.getFirstName());
			System.out.println("***"+ptn.getGender());
			System.out.println("***"+ptn.getLastName());
			System.out.println("***"+ptn.getNhs_number());
			System.out.println("***"+ptn.getPostalNumber());
			System.out.println("***"+ptn.getCreatedBy());
			System.out.println("***"+ptn.getCreatedDate());
			System.out.println("***"+ptn.getUpdateDate());
			System.out.println("ptn" + ptn.getNhs_number());

		}
		// second sql queary?
		System.out.println("*******************************************");
	System.out.println("this is second sql queary");
		pstm = con.prepareStatement(sql1);
		ptn.setPatientId(res.getInt(2));
		System.out.println(ptn.getPatientId());
		
	}
	

}
