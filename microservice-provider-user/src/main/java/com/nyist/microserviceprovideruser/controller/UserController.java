package com.nyist.microserviceprovideruser.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.nyist.microserviceprovideruser.dao.UserRepository;
import com.nyist.microserviceprovideruser.entity.User;

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
	  @GetMapping("/get-all")
	  public Object get_all(){
		  List<User> list=new ArrayList<User>();
		  User user=new User(1L,"zhangsan");
		  User user2=new User(2L,"zhangsan2");
		  User user3=new User(3L,"zhangsan3");
		  list.add(user);
		  list.add(user2);
		  list.add(user3);
		  return list;
	  }
}
