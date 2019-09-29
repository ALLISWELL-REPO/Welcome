package org.o2.registersvc.intg.impl;

import java.sql.SQLException;

import org.o2.registersvc.intg.beans.RegisterSvcDAOReq;
import org.o2.registersvc.intg.util.BussinessException;
import org.o2.registersvc.intg.util.SystemException;
import org.o2.registersvc.intg.util.UnknownException;

public class Main {

	public static void main(String[] args) {
		
		RegisterSvcDAOImpl dao=new RegisterSvcDAOImpl();
		RegisterSvcDAOReq daoReq=new RegisterSvcDAOReq();
		daoReq.setAccountNum("wewd");
		daoReq.setCardNum("121");
		daoReq.setChannelId("ssd");
		daoReq.setClientId("dfd");
		daoReq.setCvv("222");
		daoReq.setExpDate("dd");
		daoReq.setMobileNum(23434);
		daoReq.setNameOnCard("sonu");
		try {
			dao.enrollment(daoReq);
		} catch (Exception  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*Connection con;
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
*/
	}

}
