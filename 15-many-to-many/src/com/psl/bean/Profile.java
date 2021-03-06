package com.psl.bean;

import java.util.HashSet;
import java.util.Set;

public class Profile {
	
  private int profileId;
  private String school,college;
  private Contact contact;
  private Set<Degree> degrees= new HashSet<Degree>();
  
public Profile() {
	super();
}

public Profile(String school, String college) {
	super();
	this.school = school;
	this.college = college;
}

public int getProfileId() {
	return profileId;
}
public void setProfileId(int profileId) {
	this.profileId = profileId;
}
public String getSchool() {
	return school;
}
public void setSchool(String school) {
	this.school = school;
}
public String getCollege() {
	return college;
}
public void setCollege(String college) {
	this.college = college;
}

public Contact getContact() {
	return contact;
}

public void setContact(Contact contact) {
	this.contact = contact;
}

public Set<Degree> getDegrees() {
	return degrees;
}

public void setDegrees(Set<Degree> degrees) {
	this.degrees = degrees;
}
  public void addDegree(Degree degree){
	  getDegrees().add(degree);
	  degree.getProfiles().add(this);
  }
}
