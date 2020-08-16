package com.example.fitnesspartneruser.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.fitnesspartneruser.persistence.entity.User;

public interface UserRepository extends CrudRepository<User, String> {

}
