package com.capgemini.crudexample.Example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ExampleDomain {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String rollNum;
	public ExampleDomain() {
		
	}
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
	public String getRollNum() {
		return rollNum;
	}
	public void setRollNum(String rollNum) {
		this.rollNum = rollNum;
	}
}
