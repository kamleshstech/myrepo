package com.practice.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.kafka.producer.OrderProducer;
import com.practice.kafka.store.MsgStore;

@RestController
@RequestMapping("/kafka")
public class KafkaRestController {

	@Autowired
	OrderProducer orderProducer;
	
	@Autowired
	MsgStore store;
	
	@GetMapping("/place")// place?message=HELLO
	public String placeOrder(@RequestParam("message") String msg) {
		orderProducer.produceOrder(msg);
		return "Order Sent To Kafka->"+msg;
	}
	
	@GetMapping("/all")
	public String allOrders() {
		String allMsg = store.readAll();
		return allMsg;
	}
}
//http://localhost:8081/kafka/place?message=HELLO