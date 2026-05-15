package com.practice.payment.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name =  "ORDER-APP")
public interface OrderConsumer {
	
	@PostMapping("/order/place")
	public String createOrder() ;
	
	@GetMapping("/order/fetch")
	public String fetchOrder() ;
}
