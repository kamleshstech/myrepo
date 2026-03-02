package com.practice.aws.s3.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.practice.aws.s3.service.S3Service;

@RestController
@RequestMapping("/api/s3")
public class S3Controller {
	
	@Autowired
	private S3Service s3Service;
	
	@PostMapping("/upload")
	public String upload(
			@RequestParam("bucketName") String bucketName, 
			@RequestParam("file") MultipartFile file) throws IOException {
		String url = s3Service.uploadFile(bucketName, file.getOriginalFilename(), file.getInputStream()
				); 
		return url;
	}
}
