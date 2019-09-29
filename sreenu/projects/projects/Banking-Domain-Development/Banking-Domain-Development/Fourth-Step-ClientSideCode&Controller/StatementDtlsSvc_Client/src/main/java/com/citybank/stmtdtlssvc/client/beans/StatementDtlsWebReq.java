package com.citybank.stmtdtlssvc.client.beans;
public class StatementDtlsWebReq {
	private String cardnum;
	private String cvvnum;
	private String expdate;
	private String nameoncard;
	private String startdate;
	private String enddate;
	private String typeOfCategory;

	public String getCardnum() {
		return cardnum;
	}

	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}

	public String getCvvnum() {
		return cvvnum;
	}

	public void setCvvnum(String cvvnum) {
		this.cvvnum = cvvnum;
	}

	public String getExpdate() {
		return expdate;
	}

	public void setExpdate(String expdate) {
		this.expdate = expdate;
	}

	public String getNameoncard() {
		return nameoncard;
	}

	public void setNameoncard(String nameoncard) {
		this.nameoncard = nameoncard;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	public String getTypeOfCategory() {
		return typeOfCategory;
	}

	public void setTypeOfCategory(String typeOfCategory) {
		this.typeOfCategory = typeOfCategory;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("StatementDtlsWebReq [cardnum=");
		builder.append(cardnum);
		builder.append(", cvvnum=");
		builder.append(cvvnum);
		builder.append(", expdate=");
		builder.append(expdate);
		builder.append(", nameoncard=");
		builder.append(nameoncard);
		builder.append(", startdate=");
		builder.append(startdate);
		builder.append(", enddate=");
		builder.append(enddate);
		builder.append(", typeOfCategory=");
		builder.append(typeOfCategory);
		builder.append("]");
		return builder.toString();
	}

}
