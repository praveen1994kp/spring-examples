package com.example.student.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.persistence.entity.Department;
import com.example.student.persistence.entity.Institute;
import com.example.student.persistence.entity.Student;
import com.example.student.rest.DTO.StudentDTO;
import com.example.student.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping(path = "/institutes")
	@ResponseBody
	public List<Institute> getInstitutes() {
		return studentService.getInstitutes();
	}

	@GetMapping(path = "/departments")
	@ResponseBody
	public List<Department> getDepartments() {
		return studentService.getDepartments();
	}

	@GetMapping(path = "/students")
	@ResponseBody
	public List<Student> getStudents() {
		return studentService.getStudents();
	}

	@PostMapping(path = "/students")
	@ResponseBody
	public void addStudent(@RequestBody StudentDTO student) {
		studentService.addStudent(student);
	}

	@GetMapping(path = "/students/{studentId}")
	public Student getStudentById(@PathVariable(name = "studentId") Long id) {
		return studentService.getStudentById(id);
	}

	@PutMapping(path = "/students/{studentId}")
	public Student updateStudent(@PathVariable(name = "studentId") Long id, @RequestBody StudentDTO student) {
		return studentService.updateStudent(id, student);
	}

}
