package com.practice.order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderRestController {
	
	@Value("${server.port}")
	private int port;
	
	@PostMapping("/place")
	public String createOrder() {
		return "Order placed sucessfully !! "+port;
	}
	
	@GetMapping("/fetch")
	public String fetchOrder() {
		return "fetching order...."+port;
	}
}
