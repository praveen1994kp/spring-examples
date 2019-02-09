package com.example.student.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.student.persistence.dao.DepartmentRepository;
import com.example.student.persistence.dao.InstituteRepository;
import com.example.student.persistence.dao.StudentRepository;
import com.example.student.persistence.entity.Department;
import com.example.student.persistence.entity.Institute;
import com.example.student.persistence.entity.Student;
import com.example.student.rest.DTO.StudentDTO;

@Service
public class StudentService {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private InstituteRepository instituteRepo;

	@Autowired
	private DepartmentRepository deptRepo;

	@Autowired
	private StudentRepository studentRepo;

	private static final String EMPTY = "";

	public List<Student> getStudents() {
		return (List<Student>) studentRepo.findAll();
	}

	public List<Department> getDepartments() {
		return (List<Department>) deptRepo.findAll();
	}

	public List<Institute> getInstitutes() {
		return (List<Institute>) instituteRepo.findAll();
	}

	@Transactional
	public void addStudent(StudentDTO student) {
		Student studentRec = new Student();
		studentRec.setFirstName(student.getFirstName());
		studentRec.setLastName(student.getLastName());
		studentRec.setCity(student.getCity());
		studentRec.setDept(deptRepo.findById(Long.valueOf(student.getDeptId())).get());

		Long id = studentRepo.save(studentRec).getId();

		logger.debug("Created student record with ID: " + id);
	}

	@Cacheable(cacheNames = "student-cache")
	public Student getStudentById(Long id) {
		return getStudent(id);
	}

	private Student getStudent(Long id) {
		logger.debug("Fetching student from Database for ID: " + id);
		return studentRepo.findById(id).get();
	}

	@CacheEvict(key = "#id", cacheNames = "student-cache")
	@Transactional
	public Student updateStudent(Long id, StudentDTO student) {
		Student studentRecord = studentRepo.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("Student not found!");
		});
		if (!EMPTY.equals(student.getFirstName()))
			studentRecord.setFirstName(student.getFirstName());
		if (!EMPTY.equals(student.getCity()))
			studentRecord.setCity(student.getCity());
		if (!EMPTY.equals(student.getDeptId()))
			studentRecord.setDept(deptRepo.findById(Long.valueOf(student.getDeptId())).get());
		if (!EMPTY.equals(student.getLastName()))
			studentRecord.setLastName(student.getLastName());

		return studentRepo.save(studentRecord);
	}
}
