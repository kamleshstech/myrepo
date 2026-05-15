package com.practice.kafka.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.practice.kafka.store.MsgStore;

@Component
public class OrderConsumer {

	@Autowired
	private MsgStore store;
	
	@KafkaListener(topics = "${my.kafka.tpcname}",groupId = "order-group")
	public void consume(String message) {
		System.out.println("msg received/consumed from kafka-eco-system::"+message);
		store.add(message);
	}
}
