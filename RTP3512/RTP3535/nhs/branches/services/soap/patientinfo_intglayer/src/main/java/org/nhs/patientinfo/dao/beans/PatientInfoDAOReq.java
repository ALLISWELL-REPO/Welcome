/**
 * NHS Technologies.All Rights are reserved @Copy Rights are reserved.
You should not disclose the information outside otherwise
 terms and conditions will apply
 */
package org.nhs.patientinfo.dao.beans;

/**
 * @author: Stech
 * @Date     :  Feb 23, 2018
 * Description:  
 */
/**
 * @author stech6
 *
 */
public class PatientInfoDAOReq {
	 private String fname;
	    private String lname;
	    private int dob;
	    private String gender;
	    /**
	     * 
	     */
	    private int patientId;
	    private int age;
	    private int mobnum;
	    private String address;
		/**
		 * @return the fname
		 */
		public String getFname() {
			return fname;
		}
		/**
		 * @param fname the fname to set
		 */
		public void setFname(String fname) {
			this.fname = fname;
		}
		/**
		 * @return the lname
		 */
		public String getLname() {
			return lname;
		}
		/**
		 * @param lname the lname to set
		 */
		public void setLname(String lname) {
			this.lname = lname;
		}
		/**
		 * @return the dob
		 */
		public int getDob() {
			return dob;
		}
		/**
		 * @param dob the dob to set
		 */
		public void setDob(int dob) {
			this.dob = dob;
		}
		/**
		 * @return the gender
		 */
		public String getGender() {
			return gender;
		}
		/**
		 * @param string the gender to set
		 */
		public void setGender(String string) {
			this.gender = string;
		}
		/**
		 * @return the patientId
		 */
		public int getPatientId() {
			return patientId;
		}
		/**
		 * @param patientId the patientId to set
		 */
		public void setPatientId(int patientId) {
			this.patientId = patientId;
		}
		/**
		 * @return the age
		 */
		public int getAge() {
			return age;
		}
		/**
		 * @param age the age to set
		 */
		public void setAge(int age) {
			this.age = age;
		}
		/**
		 * @return the mobnum
		 */
		public int getMobnum() {
			return mobnum;
		}
		/**
		 * @param mobnum the mobnum to set
		 */
		public void setMobnum(int mobnum) {
			this.mobnum = mobnum;
		}
		/**
		 * @return the address
		 */
		public String getAddress() {
			return address;
		}
		/**
		 * @param address the address to set
		 */
		public void setAddress(String address) {
			this.address = address;
		}
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("PatientInfoProcessVbReq [fname=");
			builder.append(fname);
			builder.append(", lname=");
			builder.append(lname);
			builder.append(", dob=");
			builder.append(dob);
			builder.append(", gender=");
			builder.append(gender);
			builder.append(", patientId=");
			builder.append(patientId);
			builder.append(", age=");
			builder.append(age);
			builder.append(", mobnum=");
			builder.append(mobnum);
			builder.append(", address=");
			builder.append(address);
			builder.append("]");
			return builder.toString();
		}
	    
}
