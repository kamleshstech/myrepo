package com.practice.kafka.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderProducer {
	
	@Value("${my.kafka.tpcname}") 
	private String tpc;
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public void produceOrder(String orderData) {
		System.out.println("Order/data produce/sent from producer to kafka::"+orderData);
		kafkaTemplate.send(tpc, orderData);
	}
}
