package com.nyist.microserviceconsumermovie.feign;

import org.apache.log4j.spi.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import com.nyist.microserviceconsumermovie.entity.User;

import feign.hystrix.FallbackFactory;

@Component
public class HystrixClientFallbackFactory implements FallbackFactory<UserFeignClient>{

	private static final Logger LOGGER=org.slf4j.LoggerFactory.getLogger(HystrixClientFallbackFactory.class);
	@Override
	public UserFeignClient create(Throwable cause) {
		
		HystrixClientFallbackFactory.LOGGER.info("fallback reason is {}", cause.getMessage());	
		return new HystrixClientWithFallBackFactory(){
			@Override
			public User findById(String id) {
				User user=new User(1L,"hehe");
				return user;
			}
			
		};
	}

}
