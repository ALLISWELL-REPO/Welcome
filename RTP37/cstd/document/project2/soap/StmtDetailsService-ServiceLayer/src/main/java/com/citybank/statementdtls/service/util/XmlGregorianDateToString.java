package com.citybank.statementdtls.service.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class XmlGregorianDateToString {

	public static String convertXmlGregorianToString(XMLGregorianCalendar xc) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

		GregorianCalendar gCalendar = xc.toGregorianCalendar();
		Date date = gCalendar.getTime();
		String dateString = simpleDateFormat.format(date);
		return dateString;

	}

	public static void main(String[] args) throws DatatypeConfigurationException {
		GregorianCalendar gcal=new  GregorianCalendar();
		gcal.setTime(new Date());
		XMLGregorianCalendar xgcal=DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
		System.out.println(convertXmlGregorianToString(xgcal));
	}

}
