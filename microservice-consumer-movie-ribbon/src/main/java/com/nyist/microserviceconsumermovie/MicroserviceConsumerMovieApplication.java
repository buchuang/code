package com.nyist.microserviceconsumermovie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.nyist.config.TestConfiguration;


@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name="microservice-provider-user",configuration=TestConfiguration.class)
public class MicroserviceConsumerMovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceConsumerMovieApplication.class, args);
	}
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
