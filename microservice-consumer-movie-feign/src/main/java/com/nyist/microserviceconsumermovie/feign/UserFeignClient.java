package com.nyist.microserviceconsumermovie.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nyist.config.configruation1;
import com.nyist.microserviceconsumermovie.entity.User;

@FeignClient(name="microservice-provider-user",configuration=configruation1.class)
public interface UserFeignClient {

	@RequestMapping(value="/simple/{id}",method=RequestMethod.GET)
	public User findById(@PathVariable("id") String id);
}
