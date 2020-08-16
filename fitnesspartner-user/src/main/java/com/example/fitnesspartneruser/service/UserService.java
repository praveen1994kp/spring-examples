package com.example.fitnesspartneruser.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.fitnesspartneruser.dao.UserRepository;
import com.example.fitnesspartneruser.persistence.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public User createUser(User userDetails) {
		
		return repository.save(userDetails);
	}
	
	public Optional<User> validateCredentials(User userDetails) {
		
		User userInfo = repository.findById(userDetails.getEmail()).get();
		
		if (userInfo.getPassword().equals(userDetails.getPassword())) {
			return Optional.of(userInfo);
		}
		
		return Optional.empty();
	}

}
