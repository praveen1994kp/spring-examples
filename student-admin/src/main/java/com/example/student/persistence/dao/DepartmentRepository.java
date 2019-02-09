package com.example.student.persistence.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.student.persistence.entity.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long> {

}
