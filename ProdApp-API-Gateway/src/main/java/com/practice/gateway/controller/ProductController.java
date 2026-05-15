package com.practice.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
//@RequestMapping("/product")
public class ProductController {

	@Autowired
	HttpServletRequest request;
	
	@Value("${server.port}")
	int port;
	
	@GetMapping("/getProduct")
	public String getProduct() {
		StringBuffer requestURL = request.getRequestURL();
		String url = requestURL.toString();
		
		return "Get Product..."+port+":: URL : "+url;
	}
}
