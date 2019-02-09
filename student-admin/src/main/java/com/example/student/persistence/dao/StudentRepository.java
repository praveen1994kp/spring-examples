package com.example.student.persistence.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.student.persistence.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
