package com.example.student.jms.listener;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.example.student.rest.DTO.StudentDTO;
import com.example.student.service.StudentService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class StudentReceiver {

	@Autowired
	private StudentService studentService;

	@JmsListener(destination = "students-queue")
	public void receiveStudent(final String message) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper jsonMapper = new ObjectMapper();
		StudentDTO student = jsonMapper.readValue(message, StudentDTO.class);
		studentService.addStudent(student);

	}
}
