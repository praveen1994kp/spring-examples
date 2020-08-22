package com.example.fitnesspartneruser.rest;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.fitnesspartneruser.persistence.entity.User;
import com.example.fitnesspartneruser.service.UserService;

@RestController
@RequestMapping(path = "/user")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping
	public User createUser(@RequestBody User userDetails) {
		return service.saveUser(userDetails);
	}
	
	@PutMapping
	public User update(@RequestBody User userDetails
			, @RequestParam(required = true) String email) {
		return service.updateUser(userDetails, email);
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
	
	@ExceptionHandler(UnsupportedOperationException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public String handleNoUnsupportedOperationException(UnsupportedOperationException ex) {
		return ex.getMessage();
	}
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public String handleSqlIntegrityViolationException(SQLIntegrityConstraintViolationException ex) {
		return ex.getMessage();
	}

}
