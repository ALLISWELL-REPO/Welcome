package o2.register.formdata;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class O2LoginFormData {

	@NotNull(message="accNo should not blank")
	@NotEmpty(message="accNo should not blank")
	private String accNo;
	
	@NotNull(message="MobileNo should not blank")
	@NotEmpty(message="MobileNo should not blank")
	private String mobNo;
	
	@NotNull(message="Password should not blank")
	@NotEmpty(message="pasword should not blank")
	private String pass;
	
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getMobNo() {
		return mobNo;
	}
	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("O2LoginFormData [accNo=");
		builder.append(accNo);
		builder.append(", mobNo=");
		builder.append(mobNo);
		builder.append(", pass=");
		builder.append(pass);
		builder.append("]");
		return builder.toString();
	}
	
	
}
