package com.st.spring.core.beans;

import com.st.spring.core.beans.interfaces.Ink;
import com.st.spring.core.beans.interfaces.Pen;

public class FountainPen implements Pen {
	
	private Ink ink;
	
	public void write() {
		System.out.println("Writing with " + ink.getColor() + 
				" ink of " + ink.getBrandName() + " brand");
	}

	public Ink getInk() {
		return ink;
	}

	public void setInk(Ink ink) {
		this.ink = ink;
	}

}
