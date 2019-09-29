package org.nhs.patientinfo.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.nhs.patientinfo.dao.beans.PatientInfoDAOReq;

public class PatientDaoMain {
	private static Logger logger = Logger.getLogger(PatientDaoMain.class);

	/**
	 * @param args
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws SQLException
	 */
	public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {

		String query = "create table patient(patient_id varchar(255),date_of_birth DATE,first_Name varchar(255),gender varchar(255),nhs_number varchar(255),created_by varchar(255),created_date TIMESTAMP,updated_by varchar(255),updated_by TIMESTAMP";
		Properties props = new Properties();
		Connection con = null;
		ResultSet rs = null;
		Statement st = null;
		PatientInfoDAOReq req = new PatientInfoDAOReq();
		// System.setProperty("env", "dev");
		// String sql="{call get_Details(3,'3xyz','3abc')}";
		props.load(PatientDaoMain.class.getClassLoader().getResourceAsStream("properties/patient_dev_db.properties"));
		String driver = props.getProperty("DB_DRIVER");
		String url = props.getProperty("DB_URL");
		String username = props.getProperty("DB_USERNAME");
		String pwd = props.getProperty("DB_PASSWORD");
		con = DriverManager.getConnection(url, username, pwd);
		logger.info(driver);
		st = con.createStatement();
		req.setFname("sreenu");
		req.setLname("tech");
		req.setGender("M");
		req.setPatientId(1232);
		req.setAge(20);
		req.setMobnum(12335);
		req.setAddress("hyd");
		System.out.println("Enter your option:");
		System.out.println("1:CREATE");
		System.out.println("2:GET");
		System.out.println("3:SEARCH");
		System.out.println("4:UPDATE");
		Scanner sc = new Scanner(System.in);
		int option =sc.nextInt();
		
		switch (option) {
		case 1:
			// rs = st.executeQuery("insert into patient_details
			// values('"+req.getFname()+"','"+req.getLname()+"','"+req.getGender()+"','"+req.getPatientId()+"','"+req.getAge()+"','"+req.getMobnum()+"','"+req.getAddress()+"')");
			System.out.println("CREATE PATIENT DETAILS");
			String sql = "insert into patient_details values('" + req.getFname() + "','" + req.getLname() + "','"
					+ req.getGender() + "'," + req.getPatientId() + "," + req.getAge() + "," + req.getMobnum() + ",'"
					+ req.getAddress() + "')";
			System.out.println(sql);
			st.executeUpdate(sql);
			System.out.println("inserted sucessfully");
          break;
		case 2:
			System.out.println("GET PATIENT DETAILS");
			String sql1 = "select * from patient_details where patientId=" + req.getPatientId();
			rs = st.executeQuery(sql1);
			while (rs.next()) {
				System.out.print(rs.getString(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getString(3) + "\t");
				System.out.print(rs.getInt(4) + "\t");
				System.out.print(rs.getInt(5) + "\t");
				System.out.print(rs.getInt(6) + "\t");
				System.out.println(rs.getString(7) + "\t");
			}
			System.out.println("Get the patient details successfully");
			break;
		case 3:
			
			
			System.out.println("Search Patient Details");

			Integer pid = req.getPatientId();
			String fname = req.getFname();
			String lname = req.getLname();
			Integer age = req.getAge();
			Integer mobile = req.getMobnum();
			String address = req.getAddress();
			String gender = req.getGender();

			String sql2 = "select * from patient_details";
			if (pid != null) {
				sql2 = "select * from patient_details where patientId=" + pid;
			}
			if (pid != null && fname != null) {
				sql2 = "select * from patient_details where patientId=" + pid + " and fname='" + fname + "'";
			}
			if (pid != null && fname != null && lname != null) {
				sql2 = "select * from patient_details where patientId=" + pid + " and fname='" + fname + "'"
						+ " and lname='" + lname + "'";
			}
			if (pid != null && fname != null && lname != null && age != null) {
				sql2 = "select * from patient_details where patientId=" + pid + " and fname='" + fname + "'"
						+ " and lname='" + lname + "'" + " and age=" + age;
			}
			if (pid != null && fname != null && lname != null && age != null && mobile != null) {
				sql2 = "select * from patient_details where patientId=" + pid + " and fname='" + fname + "'"
						+ " and lname='" + lname + "'" + " and age=" + age + " and mobnum=" + mobile;
			}
			if (pid != null && fname != null && lname != null && age != null && mobile != null && address != null) {
				sql2 = "select * from patient_details where patientId=" + pid + " and fname='" + fname + "'"
						+ " and lname='" + lname + "'" + " and age=" + age + " and mobnum=" + mobile + " and address='"
						+ address + "'";
			}
			if (pid != null && fname != null && lname != null && age != null && mobile != null && address != null
					&& gender != null) {
				sql2 = "select * from patient_details where patientId=" + pid + " and fname='" + fname + "'"
						+ " and lname='" + lname + "'" + " and age=" + age + " and mobnum=" + mobile + " and address='"
						+ address + "'" + " and gender='" + gender + "'";
			}
			System.out.println(sql2);
			rs = st.executeQuery(sql2);
			while (rs.next()) {
				System.out.print(rs.getString(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getString(3) + "\t");
				System.out.print(rs.getInt(4) + "\t");
				System.out.print(rs.getInt(5) + "\t");
				System.out.print(rs.getInt(6) + "\t");
				System.out.println(rs.getString(7) + "\t");
			}
			System.out.println("Get the patient details successfully");
			break;
		case 4:
			System.out.println("UPDATE PATIENT DETAILS");
			String sql3 = "select * from patient_details";
			req.setFname("sreenu");
			req.setLname("technology");
			Integer pid12 = req.getPatientId();
			String fname12= req.getFname();
			String lname12 = req.getLname();
			Integer age12 = req.getAge();
			Integer mobile12 = req.getMobnum();
			String address12 = req.getAddress();
			String gender12 = req.getGender();

			String fname1 = null;
			String lname1 = null;
			String gender1 = null;
			Integer patientId1 = null;
			Integer age1 = null;
			Integer mobnum1 = null;
			String address1 = null;
			rs = st.executeQuery(sql3);
			while (rs.next()) {
				fname1 = rs.getString(1);
				lname1 = rs.getString(2);
				gender1 = rs.getString(3);
				age1 = rs.getInt(5);
				mobnum1 = rs.getInt(6);
				address1 = rs.getString(7);
			}
			
			
			/*if (!(pid.equals(patientId1)) || !(fname.equals(fname1)) || !(lname.equals(lname1)) || !(age.equals(age1))
					|| !(mobile.equals(mobnum1)) || !(address.equals(address1)) || !(gender.equals(gender1))) {
                     
				String sql4="update table patient_details set patient";
				
			}*/
		String sql4="";
			if (!(fname12.equals(fname1))) {
                     
			 sql4="update patient_details set fname='"+fname12+"' where patientId="+pid12;
				System.out.println(sql4);
				
				
			}
			
			if (!(fname12.equals(fname1)) && !(lname12.equals(lname1))) {
			      
							 sql4="update patient_details set fname='"+fname12+"' and lname='"+lname12+"' where patientId="+pid12;
							System.out.println(sql4);
						
			}
			if (!(fname12.equals(patientId1)) && !(lname12.equals(lname1)) && !(age12.equals(age1))) {
				 sql4="update patient_details set fname='"+fname12+"' and lname='"+lname12+"' and age='"+age12+"' where patientId="+pid12;
				System.out.println(sql4);
			
			}
			if (!(fname12.equals(patientId1)) && !(lname12.equals(lname1)) && !(age12.equals(age1)) && !(mobile12.equals(mobnum1))) {
				 sql4="update patient_details set fname='"+fname12+"' and lname='"+lname12+"' and age='"+age12+"' and mobnum='"+mobile12+"' where patientId="+pid12;
				System.out.println(sql4);
				
			}
			if (!(fname12.equals(patientId1)) && !(lname12.equals(lname1)) && !(age12.equals(age1)) && !(mobile12.equals(mobnum1))&& !(address12.equals(address1))) {
				 sql4="update patient_details set fname='"+fname12+"' and lname='"+lname12+"' and age='"+age12+"' and mobnum='"+mobile12+"' and address='"+address12+"' where patientId="+pid12;
				System.out.println(sql4);
			
			}
			if (!(fname12.equals(patientId1)) && !(lname12.equals(lname1)) && !(age12.equals(age1)) && !(mobile12.equals(mobnum1))&& !(address12.equals(address1)) && !(gender12.equals(gender1))){
				 sql4="update patient_details set fname='"+fname12+"' and lname='"+lname12+"' and age='"+age12+"' and mobnum='"+mobile12+"' and address='"+address12+"' and gender='"+gender12+"' where patientId="+pid12;
				System.out.println(sql4);
				
			}
			int count=st.executeUpdate(sql4);
			System.out.println("Updated Successfully");
		}
	}

}
