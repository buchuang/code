package com.nyist.microserviceconsumermovie.feign;

import org.springframework.stereotype.Component;

@Component
public class FeignClient2fallback implements FeignClient2{

	@Override
	public String findServiceInfoFromEurekaByServiceName(String serviceName) {
		return "haha";
	}

}
