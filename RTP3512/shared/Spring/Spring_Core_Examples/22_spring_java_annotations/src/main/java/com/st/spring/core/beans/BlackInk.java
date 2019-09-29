package com.st.spring.core.beans;

import javax.inject.Named;

import com.st.spring.core.beans.interfaces.Ink;

@Named
public class BlackInk implements Ink {

	public String getBrandName() {
		return "Parker";
	}

	public String getColor() {
		return "Black";
	}

}
