package com.st.spring.mvc.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.security.Principal;
import java.util.Locale;
import java.util.TimeZone;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping(value = "/helloWorldDynamic/")
public class HelloWorldController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String helloWorld(HttpServletRequest httpServletRequest,
							 HttpSession httpSession,
							 WebRequest webRequest,
							 Locale locale,
							 TimeZone timeZone,
							 InputStream inputStream,
							 OutputStream outputStream,
							 HttpMethod httpMethod,
							 Principal principal,
							 @PathVariable("name") String name,
							 @MatrixVariable String matrixVar,
							 @RequestParam String reqParam,
							 @RequestHeader String reqHeader,
							 @RequestBody String reqBody,
							 @RequestPart String reqPart,
							 HttpEntity<?> httpEntity,
							 Model model,
							 RedirectAttributes redirectAttributes,
							 @ModelAttribute String modelAttribute,
							 BindingResult bindingResult,
							 SessionStatus sessionStatus,
							 UriComponentsBuilder uriComponentsBuilder,
							 @CookieValue("JSESSIONID") String cookieValue) {
		return "helloWorldDynamic";
	}

}











