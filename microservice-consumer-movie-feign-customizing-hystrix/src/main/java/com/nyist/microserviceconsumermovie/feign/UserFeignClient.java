package com.nyist.microserviceconsumermovie.feign;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.nyist.config.Configuration1;
import com.nyist.microserviceconsumermovie.entity.User;

import feign.Param;
import feign.RequestLine;

@FeignClient(name = "microservice-provider-user", configuration = Configuration1.class, fallback=UserFeignClientfallback.class)
public interface UserFeignClient {
  @RequestLine("GET /simple/{id}")
  public User findById(@Param("id") String id);
}
