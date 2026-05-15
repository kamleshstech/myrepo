package com.practice.email.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import com.practice.email.service.NITJavaMailService;


@Component
public class JavaMailSenderTestRunner implements CommandLineRunner{

	@Autowired
	private NITJavaMailService nitMailService; 
	
	@Override
	public void run(String... args) throws Exception {
		FileSystemResource file = new FileSystemResource("D:\\SITARAM\\M3 PHOTOS");
		nitMailService.sendMail("seetarammakode@gmail.com",
								null,
								null,
								"Welcome",
								"Hello There....",
								file);
		System.out.println("mail sent...."); 
	}

}