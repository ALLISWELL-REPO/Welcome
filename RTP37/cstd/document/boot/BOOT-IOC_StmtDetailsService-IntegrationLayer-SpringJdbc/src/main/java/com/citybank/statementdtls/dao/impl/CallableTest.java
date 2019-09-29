package com.citybank.statementdtls.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class CallableTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/RTP3735", "root", "root");
		String sql = "{call GET_TRANSACTIONS(?,?,?,?,?,?,?,?)}";
		CallableStatement cs = connection.prepareCall(sql);

		cs.registerOutParameter(7, Types.VARCHAR);
		cs.registerOutParameter(8, Types.VARCHAR);

		cs.setString(1, "web");
		cs.setString(2, "online");
		cs.setString(3, "4590050000326752");
		cs.setLong(4, 514);
		cs.setString(5, "2018-04-03");
		cs.setString(6, "sunny");
		
		cs.execute();
		ResultSet rs = cs.executeQuery();
		if (rs.wasNull()) {
			
			while (rs.next()) {
				System.out.println(rs.getString(1) + "--" + rs.getString(2) + "--" + rs.getString(3));
			}
		}

		System.out.println(cs.getString(7));
		System.out.println(cs.getString(8));
	}

}
