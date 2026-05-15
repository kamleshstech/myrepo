package com.practice.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.payment.consumer.OrderConsumer;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	private OrderConsumer orderConsumer;
	
	@PostMapping("/PaymentDone")
	public String postPaymentDetailsForOrder() {
		
		String createOrder = orderConsumer.createOrder();
		
		return "connecting to OrderSvc from PaymentSvc.."+" " +createOrder;
	}

	@GetMapping("/payOrder")
	public String fetchOrderDetailsForPayment() {
		
		String fetchOrder = orderConsumer.fetchOrder(); 
		
		return "connecting to OrderSvc from PaymentSvc.."+" " +" "+fetchOrder;
	}
}
