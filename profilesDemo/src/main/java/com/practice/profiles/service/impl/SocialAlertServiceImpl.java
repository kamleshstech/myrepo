package com.practice.profiles.service.impl;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.practice.profiles.service.AlertService;

@Component
@Profile("htc")
public class SocialAlertServiceImpl implements AlertService{

	@Override
	public void showMsg() {
		System.out.println("HTC-SOCIAL-ALERT-SERVICE");
	}

}
