package com.psl.bean;

import java.sql.Date;

import javax.persistence.Entity;
@Entity

public class Relative extends Contact {
    private String relation,petName;

	public Relative() {
		super();
	}

	public Relative(String firstName, String lastName, Date dateofBirth,
			Address address, String relation, String petName) {
		super(firstName, lastName, dateofBirth, address);
		this.relation = relation;
		this.petName = petName;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}
    
    
	
}
