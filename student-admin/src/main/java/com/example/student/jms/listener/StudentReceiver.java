package com.example.student.jms.listener;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private StudentService studentService;

	@JmsListener(destination = "students-queue")
	public void receiveStudent(final String message) throws JsonParseException, JsonMappingException, IOException {
		logger.debug("Received JMS Message from students-queue: " + message);
		ObjectMapper jsonMapper = new ObjectMapper();
		StudentDTO student = jsonMapper.readValue(message, StudentDTO.class);
		studentService.addStudent(student);

	}
}
