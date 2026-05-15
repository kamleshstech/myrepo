package com.practice.email.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

@Component
public class NITJavaMailService {

	@Autowired
	JavaMailSender mailSender;

	public boolean sendMail(
			String to,
			String []cc,
			String []bcc,
			String subject,
			String text,
			FileSystemResource attachment
			) 
	{
		boolean flag=false;
		try {
			//1. Create MimeMessage
			MimeMessage message = mailSender.createMimeMessage(); 
			//2. Create MimeMessageHelper Object 
			MimeMessageHelper helper = new MimeMessageHelper(message, attachment!=null?true:false);
			//3. Set Message details
			helper.setTo(to); 
			if(cc!=null)
				helper.setCc(cc);
			if(bcc!=null)
				helper.setBcc(bcc);
			helper.setSubject(subject);
			helper.setText(text);
			if(attachment!=null)
				helper.addAttachment(attachment.getFilename(), attachment);
			//4. send Mail
			mailSender.send(message);
			
			flag=true;
		} catch (Exception e) {
			flag=false;
			e.printStackTrace();
		}
		return flag;
	}
}
