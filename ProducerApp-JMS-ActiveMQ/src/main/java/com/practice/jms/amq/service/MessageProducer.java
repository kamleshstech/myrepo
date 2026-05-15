package com.practice.jms.amq.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.Session;
import jakarta.jms.TextMessage;

@Service
public class MessageProducer implements CommandLineRunner{
	
	@Autowired
	JmsTemplate jmsTemplate;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Data sending from Producer App -> ");
	}

	public void send(String queue, String msg) {
		/*
		 * jmsTemplate.send(queue, new MessageCreator() {
		 * 
		 * @Override public Message createMessage(Session session) throws JMSException {
		 * TextMessage createdMsg = session.createTextMessage(msg); return createdMsg; }
		 * });
		 */
		
		jmsTemplate.send(queue,(sessionObj) -> sessionObj.createTextMessage(msg));
	}
}
