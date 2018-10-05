package com.nyist.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class TestConfiguration {

	@Bean
	  public IRule ribbonRule() {
	    return new RandomRule();
	  }
}
