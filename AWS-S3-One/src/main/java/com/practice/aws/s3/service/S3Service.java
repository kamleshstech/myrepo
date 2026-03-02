package com.practice.aws.s3.service;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.awspring.cloud.s3.S3Resource;
import io.awspring.cloud.s3.S3Template;

@Service 
public class S3Service {
	
	@Autowired
	private S3Template s3Template;
	
	//upload file
	public String uploadFile(String bucketName, String key, InputStream content) throws IOException {
		S3Resource resource = s3Template.upload(bucketName, key, content);
		return resource.getURL().toString();
	}
	
	//download file  
	public InputStream download(String bucketName, String key) throws IOException {
		S3Resource resource = s3Template.download(bucketName, key);
		InputStream is = resource.getInputStream();
		return is;
	}
}
