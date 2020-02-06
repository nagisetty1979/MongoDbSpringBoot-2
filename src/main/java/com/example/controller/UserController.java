package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.repository.UserRepository;


@RestController
public class UserController {

	private final Logger LOG = LoggerFactory.getLogger(getClass());
    @Autowired
	private final UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

@RequestMapping(value = "getAllUsers", method = RequestMethod.GET)
public List<User> getAllUsers() {
	LOG.info("Getting all users.");
	return userRepository.findAll();
}


@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
public Optional<User> getUser(@PathVariable int userId) {
	LOG.info("Getting user with ID: {}.", userId);
	return userRepository.findById(userId);
}

@RequestMapping(value = "/create", method = RequestMethod.POST)
public User addNewUsers(@RequestBody User user) {
	LOG.info("Saving user.");
	return userRepository.save(user);
}

@RequestMapping(value = "/test", method = RequestMethod.GET)
public String addNewUsers1() {
	System.out.println("Saving user.");
	return "success";
}

}

