package com.st.spring.boot.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.st.spring.boot.controller")
public class ChildContextConfig {

}
