package com.practice.profiles.service.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.practice.profiles.service.AlertService;

@Component
@Profile("default")
public class EmailAlertServiceImpl implements AlertService{

	@Override
	public void showMsg() {
		System.out.println("DEFAULT-EMAIL-ALERT-SERVICE");
	}
	
	
}
