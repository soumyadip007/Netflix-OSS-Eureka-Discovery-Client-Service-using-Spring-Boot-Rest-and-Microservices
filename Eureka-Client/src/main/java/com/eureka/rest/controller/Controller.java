package com.eureka.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.eureka.enitity.UserRating;
import com.netflix.discovery.DiscoveryClient;

@RestController
@RequestMapping("client")
public class Controller {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private WebClient.Builder WebClient;
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	 @RequestMapping("/test")
	    public String Test() {
		 	return "Hello";
	    }

    @RequestMapping("/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId) {

        UserRating userRating = restTemplate.getForObject("http://ratings-data-service/ratingsdata/user/" + userId, UserRating.class);

        return userRating;

    }
	
}
