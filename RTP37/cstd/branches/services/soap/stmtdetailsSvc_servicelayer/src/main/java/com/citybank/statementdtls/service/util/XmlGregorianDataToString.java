package com.citybank.statementdtls.service.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class XmlGregorianDataToString {

	public static void main(String[] args) throws DatatypeConfigurationException {
		GregorianCalendar greCal=new GregorianCalendar();
		greCal.setTime(new Date());
		XMLGregorianCalendar xmlCal=DatatypeFactory.newInstance().newXMLGregorianCalendar(greCal);
		System.out.println(convertXmlGregorianToString(xmlCal));

	}

	public static String convertXmlGregorianToString(XMLGregorianCalendar xgc) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		GregorianCalendar gcalend = xgc.toGregorianCalendar();
		Date date = gcalend.getTime();
		String dateString = sdf.format(date);
		return dateString;

	}

}
