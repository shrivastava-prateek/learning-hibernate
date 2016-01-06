package com.psl.bean;

import java.util.HashSet;
import java.util.Set;

public class Degree {
	private int degreeId;
	private String name;
	private Set<Profile> profiles= new HashSet<Profile>();
	
	public Degree() {
		super();
	}

	public Degree(String name) {
		super();
		this.name = name;
	}

	public int getDegreeId() {
		return degreeId;
	}

	public void setDegreeId(int degreeId) {
		this.degreeId = degreeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(Set<Profile> profiles) {
		this.profiles = profiles;
	}
	

}
