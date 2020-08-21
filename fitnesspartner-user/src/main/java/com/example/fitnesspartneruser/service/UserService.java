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
	
	public User saveUser(User userDetails) {
		
		return repository.save(userDetails);
	}
	
	public User updateUser(User userDetails, String email) {
		User userInfo = repository.findById(email).get();
		userInfo.setBmi(userDetails.getBmi());
		userInfo.setAge(userDetails.getAge());
		userInfo.setGender(userDetails.getGender());
		userInfo.setWeightInKg(userDetails.getWeightInKg());
		userInfo.setHeightInCm(userDetails.getHeightInCm());
		
		return this.saveUser(userInfo);
	}
	
	public Optional<User> validateCredentials(User userDetails) {
		
		User userInfo = repository.findById(userDetails.getEmail()).get();
		
		if (userInfo.getPassword().equals(userDetails.getPassword())) {
			return Optional.of(userInfo);
		}
		
		return Optional.empty();
	}

}
