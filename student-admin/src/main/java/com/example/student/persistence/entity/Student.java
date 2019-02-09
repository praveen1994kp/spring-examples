package com.example.student.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENTS")
@SequenceGenerator(name = "studentsSeq", sequenceName = "STUDENT_SEQ", initialValue = 1, allocationSize = 100)
public class Student implements Serializable {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 885415661077615609L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(generator = "studentsSeq", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "CITY")
	private String city;

	@ManyToOne(targetEntity = Department.class)
	@JoinColumn(name = "DEPT_ID", referencedColumnName = "ID")
	private Department dept;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

}
