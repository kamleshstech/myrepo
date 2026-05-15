package com.practice.profiles.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.practice.profiles.service.AlertService;
import com.practice.profiles.service.impl.EmailAlertServiceImpl;

@Component
public class RunnerDemo implements CommandLineRunner{
	
//	@Value("${app.val.key}")
//	private String valFromProp;
	
	@Autowired
	private AlertService alertService;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	//System.out.println("valFromProp : "+valFromProp);
		alertService.showMsg();
	}

}
