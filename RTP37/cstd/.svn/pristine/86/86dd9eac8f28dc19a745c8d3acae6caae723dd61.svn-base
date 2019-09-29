package com.app;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class ProcedureTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost/RTP_3710","root","root");
		String sql="{call getTransactions(?,?,?,?,?,?,?,?)}";
		CallableStatement csmt=(CallableStatement)con.prepareCall(sql);
	
		//register output parameter with jdbc types
		csmt.registerOutParameter(7, Types.VARCHAR);
		csmt.registerOutParameter(8, Types.VARCHAR);
		//set value to import parameter
		csmt.setString(1, "web");
		csmt.setString(2, "online");
		csmt.setString(3, "57611100088878");
		csmt.setString(4, "123");                                                                                                                                                                                                 
		csmt.setString(5, "noor");
		csmt.setString(6, "alam");
		boolean b=csmt.execute();
		String respCode=csmt.getString(7);
		String respMsg=csmt.getString(8);
		
		System.out.println(respCode);
		System.out.println(respMsg);

		
		
		
	

	}

}
