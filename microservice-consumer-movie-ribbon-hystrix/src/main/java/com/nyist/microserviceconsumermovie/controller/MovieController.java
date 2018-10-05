package com.nyist.microserviceconsumermovie.controller;


import javax.annotation.Resource;

import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.nyist.microserviceconsumermovie.entity.User;

@RestController
public class MovieController {

	@Resource
	private RestTemplate restTemplate;
	
	@GetMapping("/movie/{id}")
	@HystrixCommand(fallbackMethod="findByIdFallBack")
	public Object findById(@PathVariable String id){
		return this.restTemplate.getForObject("http://microservice-provider-user/simple/"+id, User.class);
	}
	public Object findByIdFallBack(String id){
		User user=new User(1L, "zhangzan");
		return user;
	}
	
	
	
}
