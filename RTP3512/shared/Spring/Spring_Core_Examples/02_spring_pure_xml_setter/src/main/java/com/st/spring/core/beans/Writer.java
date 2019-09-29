package com.st.spring.core.beans;

import com.st.spring.core.beans.interfaces.Pen;

public class Writer {
	
	private Pen pen;
	
	public void write() {
		pen.write();
	}

	public Pen getPen() {
		return pen;
	}

	public void setPen(Pen pen) {
		this.pen = pen;
	}

}
