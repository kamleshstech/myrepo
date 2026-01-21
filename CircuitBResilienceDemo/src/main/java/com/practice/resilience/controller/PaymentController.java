package com.practice.resilience.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.practice.resilience.service.PaymentService;

@RestController
public class PaymentController {
	
	@Autowired
	PaymentService service;

    @GetMapping("/pay")
    public CompletableFuture<String> testCircuitBreaker() {
    	System.out.println("service class : "+service.getClass());
        return service.doPayment(); 
    }
    
    @GetMapping("/bill")
    public String testBulkHeadSemaphore() {
    	
    	try {
			return service.billGenrator();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
    }
    
}
