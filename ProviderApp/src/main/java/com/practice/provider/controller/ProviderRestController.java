package com.practice.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderRestController {
	
	@Value("${server.port}")
	private String portnum;
	
	@GetMapping("/provider")
	public String helloProvider() {
		System.out.println("protnum : "+portnum);
		return "From Provider ::: Port ::: "+portnum;
	}

}
