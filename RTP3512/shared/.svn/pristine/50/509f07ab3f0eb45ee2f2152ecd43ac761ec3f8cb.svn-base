package com.st.spring.core.beans;

import javax.inject.Inject;
import javax.inject.Named;

import com.st.spring.core.beans.interfaces.Ink;
import com.st.spring.core.beans.interfaces.Pen;

@Named
public class FountainPen implements Pen {
	
	private Ink ink;
	
	@Inject
	public FountainPen(final Ink ink) {
		this.ink = ink;
	}
	
	public void write() {
		System.out.println("Writing with " + ink.getColor() + 
				" ink of " + ink.getBrandName() + " brand");
	}

}
