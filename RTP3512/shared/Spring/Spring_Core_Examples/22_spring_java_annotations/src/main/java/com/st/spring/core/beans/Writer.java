package com.st.spring.core.beans;

import javax.inject.Inject;
import javax.inject.Named;

import com.st.spring.core.beans.interfaces.Pen;

@Named
public class Writer {
	
	private Pen pen;
	
	@Inject
	public Writer(final Pen pen) {
		this.pen = pen;
	}
	
	public void write() {
		pen.write();
	}

}
