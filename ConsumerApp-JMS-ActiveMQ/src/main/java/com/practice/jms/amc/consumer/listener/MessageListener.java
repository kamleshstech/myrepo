package com.practice.jms.amc.consumer.listener;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {
								
	@JmsListener(destination = "SEETARAM-QUEUE")
	public void receive(String msg) {
		System.out.println("✔ Consumer Received: "+msg);
	}
}
