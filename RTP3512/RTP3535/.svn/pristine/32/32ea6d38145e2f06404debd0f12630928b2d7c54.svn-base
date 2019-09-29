package org.nhs.patientinfo.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.nhs.patientinfo.dao.beans.PatientInfoDAOReq;

public class RetriveConnection {

	public Connection getConnection() 
	{
		Connection con = null;
		
			Properties props = new Properties();
			try {
				props.load(RetriveConnection.class.getClassLoader().getResourceAsStream("properties/patient_dev_db.properties"));
			
			String driver = props.getProperty("DB_DRIVER");
			String url = props.getProperty("DB_URL");
			String username = props.getProperty("DB_USERNAME");
			String pwd = props.getProperty("DB_PASSWORD");
			
				con = DriverManager.getConnection(url, username, pwd);
				return con;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				return null;
			}
		
	}
		
		
	}

