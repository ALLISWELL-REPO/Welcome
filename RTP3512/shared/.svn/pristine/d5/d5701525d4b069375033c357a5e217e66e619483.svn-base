package com.st.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.st.spring.core.beans.BlackInk;
import com.st.spring.core.beans.FountainPen;
import com.st.spring.core.beans.Writer;
import com.st.spring.core.beans.interfaces.Ink;
import com.st.spring.core.beans.interfaces.Pen;

@Configuration
public class SpringConfig {
	
	@Bean
	public Writer writer(Pen pen) {
		Writer writer = new Writer();
		writer.setPen(pen);
		return writer;
	}
	
	@Bean
	public Pen fountainPen(Ink ink) {
		FountainPen fountainPen = new FountainPen();
		fountainPen.setInk(ink);
		return fountainPen;
	}
	
	@Bean
	public Ink blackInk() {
		return new BlackInk();
	}

}
