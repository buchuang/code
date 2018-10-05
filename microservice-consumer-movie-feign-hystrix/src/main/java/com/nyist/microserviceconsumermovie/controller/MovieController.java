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
import com.nyist.microserviceconsumermovie.feign.UserFeignClient;

@RestController
public class MovieController {	
	
	@Resource
	private UserFeignClient userFeignClient;
	
	@GetMapping("/movie/{id}")
	public Object findById(@PathVariable String id){
		return this.userFeignClient.findById(id);
	}
	
}
