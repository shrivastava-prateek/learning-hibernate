package com.psl.bean;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Profile {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int profileId;
	private String school,college;
	@OneToOne(cascade=CascadeType.ALL)
	private Contact contact;

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

}
