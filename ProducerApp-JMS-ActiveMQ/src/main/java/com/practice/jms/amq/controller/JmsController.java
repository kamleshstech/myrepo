package com.practice.jms.amq.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.jms.amq.service.MessageProducer;

@RestController
@RequestMapping("/jms")
public class JmsController {
	
	@Autowired
	private MessageProducer producer;

    @GetMapping("/send/{msg}")
    public String send(@PathVariable String msg) {
    	String newMsg = msg+" :: "+new Date();
        producer.send("SEETARAM-QUEUE", newMsg); 
        return "Message sent → " + newMsg;
    }
}
