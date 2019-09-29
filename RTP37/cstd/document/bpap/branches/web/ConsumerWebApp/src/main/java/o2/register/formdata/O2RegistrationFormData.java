package o2.register.formdata;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.context.annotation.Scope;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;

@Scope("session")
public class O2RegistrationFormData {

	@NotNull(message="MobileNo should not blank")
	@NotEmpty(message="MobileNo should not blank")
	@NumberFormat(pattern="mobile should be number")
	@Size(min=10,max=10, message="mobNo should be 10 digit")
	private long  mobNo;
	
	@NotNull(message="cardNumber should not blank")
	@NotEmpty(message="CardNumb should not blank")
	@CreditCardNumber(message="cardNumb should be 16 digit")
	@Size(min=16,max=16, message="cardNumb num should be 16 digit")
	private String  cardNumb;
	
	@NotEmpty(message="cvv should not blank")
	@NotNull(message="cvv should not blank")
	@NumberFormat(pattern="cvv should be number")
	@Size(min=3,max=3, message="cvv size should be 3 digit")
	private String  cvv;
	
	@DateTimeFormat(iso=ISO.NONE)
	@NotEmpty(message=" expDate should not blank")
	@NotNull(message="expDate shold not balank")
	private String  expDate;
	
	@NotEmpty(message="name on card should not empty")
	@NotNull(message="name on card should not empty")
	private String  nameOnCard;
	
	
	public long getMobNo() {
		return mobNo;
	}
	public void setMobNo(long mobNo) {
		this.mobNo = mobNo;
	}
	public String getCardNumb() {
		return cardNumb;
	}
	public void setCardNumb(String cardNumb) {
		this.cardNumb = cardNumb;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public String getNameOnCard() {
		return nameOnCard;
	}
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("O2RegistrationFormData [mobNo=");
		builder.append(mobNo);
		builder.append(", cardNumb=");
		builder.append(cardNumb);
		builder.append(", cvv=");
		builder.append(cvv);
		builder.append(", expDate=");
		builder.append(expDate);
		builder.append(", nameOnCard=");
		builder.append(nameOnCard);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
	
	

	
	
}


