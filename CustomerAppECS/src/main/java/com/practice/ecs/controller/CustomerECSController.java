package com.practice.ecs.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class CustomerECSController {
	
	@Value("${my.app.name}")
	public String data;
	
	@GetMapping("/customer")
	public String getData() {
		
		return "From CustomerECS :: "+data;
	}
}
