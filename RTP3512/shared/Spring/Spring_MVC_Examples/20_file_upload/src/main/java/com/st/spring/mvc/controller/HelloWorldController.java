package com.st.spring.mvc.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class HelloWorldController {
	
	@RequestMapping(value = "/helloWorldDynamic", method = RequestMethod.GET)
	public String helloWorld() {
		return "helloWorldDynamic";
	}
	
	@RequestMapping(value = "/fileupload", method = RequestMethod.POST)
	public String fileUpload(
			@RequestParam("profilepic") MultipartFile file, 
			Model model) throws IOException {
		FileCopyUtils.copy(file.getBytes(), new File(<location where you want to store the file>));
		model.addAttribute("uploadSuccess", "File Uploaded Successfully");
		return "helloWorldDynamic";
	}
	
	
	
	
	
	
}
