package com.nyist.microserviceconsumermovie.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {

	@Value("${profile}")
	private String profile;

	@GetMapping("/getProfile")
	public Object getProfile(){
		return this.profile;
	}
}
