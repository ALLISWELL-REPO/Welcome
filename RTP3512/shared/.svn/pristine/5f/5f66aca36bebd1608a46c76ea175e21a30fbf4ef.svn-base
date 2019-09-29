package com.st.spring.boot.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@ConfigurationProperties(prefix = "st")
public class HelloWorldController {
	
	private String name;
	private String areaName;
	private String pincode;
	
	@GetMapping("/helloWorld")
	public String helloWorld(Model model) {
		model.addAttribute("name", name);
		model.addAttribute("areaName", areaName);
		model.addAttribute("pincode", pincode);
		return "helloWorldDynamic";
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	
	
	

}
