package com.practice.consumer.client;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ClientDemo {

	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	public String response = null;
	
	public String callingProvider() {
		System.out.println("ClientDemo :: callingProvider()"); 
		String url = "";
		//1. get service instance
		ServiceInstance instance = loadBalancerClient.choose("provider-app");
		//2. get uri from service instance
		URI uri =instance.getUri();
		url=uri+"/provider";
		//3. calling provider via rest controller
		RestTemplate rt = new RestTemplate();
		response = rt.getForObject(url, String.class);
		
		return response;
	}
	
}
