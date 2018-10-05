package com.nyist.microserviceprovideruser.controller;

import javax.annotation.Resource;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.nyist.microserviceprovideruser.dao.UserRepository;

@RestController
public class UserController {

	@Resource
	private UserRepository userRepository;
	@Resource
	private EurekaClient eurekaClient;
	@Resource
	private DiscoveryClient discoveryClient;
	
	@GetMapping("/simple/{id}")
	public Object findById(@PathVariable String id){
		return userRepository.findById(id);
	}
	  @GetMapping("/eureka-instance")
	  public String serviceUrl() {
	    InstanceInfo instance = this.eurekaClient.getNextServerFromEureka("MICROSERVICE-PROVIDER-USER", false);
	    return instance.getHomePageUrl();
	  }
	  @GetMapping("/instance-info")
	  public Object showInfo() {
	    ServiceInstance localServiceInstance = this.discoveryClient.getLocalServiceInstance();
	    return localServiceInstance;
	  }
}
