package com.example.student.persistence.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "INSTITUTES")
@SequenceGenerator(name = "instituteSequence", sequenceName = "inst_seq", initialValue = 1)
public class Institute implements Serializable {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = -6789545289741392864L;

	@Id
	@GeneratedValue(generator = "instituteSequence", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column
	private String name;

	@Column
	private String city;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
