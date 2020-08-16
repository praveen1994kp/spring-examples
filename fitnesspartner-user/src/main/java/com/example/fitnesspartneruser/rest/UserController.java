package com.example.fitnesspartneruser.rest;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.fitnesspartneruser.persistence.entity.User;
import com.example.fitnesspartneruser.service.UserService;

@RestController
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping(path = "/")
	public User createUser(@RequestBody User userDetails) {
		return service.createUser(userDetails);
	}

	@PostMapping(path = "/login")
	public User validateCredentials(@RequestBody User userDetails) {
		return service.validateCredentials(userDetails).get();
	}

	@ExceptionHandler(NoSuchElementException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public String handleNoSuchElementException(NoSuchElementException ex) {
		return "Invalid User Details";
	}

}
