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
		return new Writer(pen);
	}
	
	@Bean
	public Pen fountainPen(Ink ink) {
		return new FountainPen(ink);
	}
	
	@Bean
	public Ink blackInk() {
		return new BlackInk();
	}

}
