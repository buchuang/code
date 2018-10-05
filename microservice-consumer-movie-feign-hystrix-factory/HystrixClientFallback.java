package com.nyist.microserviceconsumermovie.feign;

import org.springframework.stereotype.Component;

import com.nyist.microserviceconsumermovie.entity.User;
@Component
public class HystrixClientFallback implements UserFeignClient {

	@Override
	public User findById(String id) {
		User user=new User(1L, "zhangzan");
		return user;
	}
   
}
