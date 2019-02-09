package com.example.student.persistence.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.student.persistence.entity.Institute;

public interface InstituteRepository extends CrudRepository<Institute, Long> {

}
