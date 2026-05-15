package com.practice.ncs.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
	
	@Value("${my.app.code}")
	private String key;
	
	@GetMapping("/getKey")
	public String getKey() {
		return "From Native Server "+key;
	}
}
