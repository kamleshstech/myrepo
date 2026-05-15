package com.practice.vendor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/vendor")
public class VendorRestController {
	
	@Value("${server.port}") 
	private int port;
	
	@Autowired
	RestTemplate rTemp;
	
	String url = "http://localhost:9092/pay";
	
	public ResponseEntity<String> getVendorDetails(@RequestParam String vendorId){
		
		ResponseEntity<String> entity = new ResponseEntity<String>(null);
		return null;
	}
	
	@GetMapping("/testCBnR")
	public String testCircuitBreakerNRetry() {
		System.out.println("inside vendor"); 
		String resp = null;
		resp = rTemp.getForObject(url, String.class);
		return resp;
	}
}
