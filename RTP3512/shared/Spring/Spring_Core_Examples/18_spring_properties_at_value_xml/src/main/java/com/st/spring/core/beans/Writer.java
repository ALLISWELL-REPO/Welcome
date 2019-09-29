package com.st.spring.core.beans;

import com.st.spring.core.beans.interfaces.Pen;

public class Writer {
	
	private Pen pen;
	
	public Writer(final Pen pen) {
		this.pen = pen;
	}
	
	public void write() {
		pen.write();
	}

}
