package com.st.spring.core.beans;

import com.st.spring.core.beans.interfaces.Ink;

public class BlackInk implements Ink {

	public String getBrandName() {
		return "Parker";
	}

	public String getColor() {
		return "Black";
	}

}
