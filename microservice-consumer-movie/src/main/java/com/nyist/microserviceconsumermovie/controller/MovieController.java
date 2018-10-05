package com.nyist.microserviceconsumermovie.controller;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nyist.microserviceconsumermovie.entity.User;

@RestController
public class MovieController {

	@Resource
	private RestTemplate restTemplate;
	@Resource
	private LoadBalancerClient loadBalanceClient;
	
	
	@GetMapping("/movie/{id}")
	public Object findById(@PathVariable String id){
		return this.restTemplate.getForObject("http://microservice-provider-user/simple/"+id, User.class);
	}
	@GetMapping("/test")
	public Object test(){
		ServiceInstance serviceInstance=loadBalanceClient.choose("microservice-provider-user");
		System.out.println("111"+serviceInstance.getServiceId()+"-"+serviceInstance.getHost()+"-"+serviceInstance.getPort());
		
		ServiceInstance serviceInstance2=loadBalanceClient.choose("microservice-provider-user2");
		System.out.println("222"+serviceInstance2.getServiceId()+"-"+serviceInstance2.getHost()+"-"+serviceInstance2.getPort());
		return "1";
	}
	
}
