package com.practice.multiple.db.h2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.multiple.db.h2.entity.Order;
import com.practice.multiple.db.h2.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@PostMapping("/place")
	public ResponseEntity<String> placeOrder(@RequestBody Order order){
		return new ResponseEntity<String>(orderService.placeOrder(order),  HttpStatus.CREATED);
	}
}
//http://localhost:8080/order/place