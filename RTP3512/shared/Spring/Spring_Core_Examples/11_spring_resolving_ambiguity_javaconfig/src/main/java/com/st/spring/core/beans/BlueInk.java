package com.st.spring.core.beans;

import com.st.spring.core.beans.interfaces.Ink;

public class BlueInk implements Ink {

	public String getBrandName() {
		return "Camlin";
	}

	public String getColor() {
		return "Blue";
	}

}
