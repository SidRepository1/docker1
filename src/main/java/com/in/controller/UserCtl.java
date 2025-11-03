package com.in.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.in.model.User;
import com.in.service.UserService;

@RestController
@EnableCaching
public class UserCtl {

	@Autowired
	private UserService service;

	// #id => parameter passed, for multiple parameter we can use ({#parameter1,
	// #parameter2}
	// value => any name you want to specify
	// condition => any condition you want to execute with parameter
	// #result => this is result object which we are returning from method
	// @Cacheput => used with post methods
	// @Cacheevict => used when, we want to store data into DB, but not into cache
	@Cacheable(key = "#id", value = "User", condition = "#id<5", unless = "#result.fname=='sid3'")
	@GetMapping("/getuser/{id}")
	public Optional<User> getByID(@PathVariable(value = "id") Integer id) {
		return service.findById(id);
	}

	@PostMapping("/create")
	public User createUser(@RequestBody User user) {
//		logger.debug("inside /create");
		return service.createUser(user);
	}

}