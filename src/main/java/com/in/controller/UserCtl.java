package com.in.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

	@GetMapping("/getuser/{id}")
	public Optional<User> getByID(@PathVariable(value = "id") Integer id) {
		return service.findById(id);
	}

	@PostMapping("/create")
	public User createUser(@RequestBody User user) {
		return service.createUser(user);
	}

}