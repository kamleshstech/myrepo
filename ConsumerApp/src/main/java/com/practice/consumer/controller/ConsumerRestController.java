package com.practice.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.consumer.client.ClientDemo;

@RestController
public class ConsumerRestController {
	
	@Value("${server.port}")
	private String portn;

	@Autowired
	private ClientDemo clientDemo;
	
	@GetMapping("/consumer")
	public String getProviderDetails() {
		System.out.println("ConsumerRestController::getProviderDetails::port"+portn);
		String resp = "";	
		resp = clientDemo.callingProvider(); 
		System.out.println("ConsumerRestController::getProviderDetails::port::after callingProvider()"+portn);
		return "calling from consumer"+resp;
	}

}
