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
@Table(name = "DEPARTMENTS")
@SequenceGenerator(name = "deptSeq", sequenceName = "DEPT_SEQ", initialValue = 1, allocationSize=100)
public class Department implements Serializable {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 8946843431002297639L;

	@Id
	@GeneratedValue(generator = "deptSeq", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = "NAME")
	private String name;

	@ManyToOne(targetEntity = Institute.class)
	@JoinColumn(referencedColumnName = "ID", name = "INST_ID")
	private Institute institute;

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

	public Institute getInstitute() {
		return institute;
	}

	public void setInstitute(Institute institute) {
		this.institute = institute;
	}

}
