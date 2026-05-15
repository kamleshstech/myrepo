package com.practice.scheduler.service;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedulerService {

	/*
	@Scheduled(fixedDelay=5000)
	public void doTask() {
		System.out.println("Hello There...."+new Date());
	}
	*/
	/***********
	 * there no extra dependency need to add in the pom for scheduling 
	 * we get all required things using default added
	 * starter 'spring-boot-starter' 
	 */
	//cron-demo
	@Scheduled(cron="5 * * * * *")
	public void doTask() {
		System.out.println("Hello There...."+new Date());
	}

}
