package org.o2.registersvc.intg.impl;

import java.io.FileReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Properties;

public class Main {

	public static void main(String[] args) {
		Connection con;
		CallableStatement cs = null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			Properties properties = new Properties();
			FileReader fileReader = new FileReader("src/main/resources/db.properties");
			properties.load(fileReader);

			con = DriverManager.getConnection(properties.getProperty("db.url"), properties.getProperty("db.userName"), properties.getProperty("db.password"));
			// ps=con. ("select * from customerdetails ");
			String sql = "{call GET_ENROLLMENT(?,?,?,?,?,?,?,?,?,?)}";
			cs = (CallableStatement) con.prepareCall(sql);
			// register output parameters with JDBC types
			cs.registerOutParameter(9, Types.VARCHAR);
			cs.registerOutParameter(10, Types.VARCHAR);
			// Set values to input parameters
			cs.setString(1, "101");
			cs.setString(2, "web");
			cs.setString(3, "123");
			cs.setLong(4, 321);
			cs.setString(5, "784455");
			cs.setString(6, "123");
			cs.setString(7, "02/25");
			cs.setString(8, "sonu");
			cs.execute();
			System.out.println("statuscode is::" + cs.getString(9));
			System.out.println("status message is::" + cs.getString(10));

		}

		catch (SQLException se) {
			se.printStackTrace();
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
