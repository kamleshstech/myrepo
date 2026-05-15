package com.practice.scheduler.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.practice.scheduler.service.SchedulerService;

@Component
public class SchedulerRunner implements CommandLineRunner{

	@Autowired
	private SchedulerService schedulerService;
	
	@Override
	public void run(String... args) throws Exception {
		schedulerService.doTask();
	}
	
	
}
