package com.nyist.microserviceconsumermovie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nyist.microserviceconsumermovie.entity.User;
import com.nyist.microserviceconsumermovie.feign.FeignClient2;
import com.nyist.microserviceconsumermovie.feign.UserFeignClient;

@RestController
public class MovieController {

  @Autowired
  private UserFeignClient userFeignClient;

  @Autowired
  private FeignClient2 feignClient2;

  @GetMapping("/movie/{id}")
  public User findById(@PathVariable String id) {
    return this.userFeignClient.findById(id);
  }

  @GetMapping("/{serviceName}")
  public String findServiceInfoFromEurekaByServiceName(@PathVariable String serviceName) {
    return this.feignClient2.findServiceInfoFromEurekaByServiceName(serviceName);
  }
}
