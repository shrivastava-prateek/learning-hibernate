package com.psl.bean;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

public class Contact {
	private int contactId;
	private String firstName,lastName;
	private Date dateofBirth;
	private Address address;
    private Map<String,String> mobileNumbers = new HashMap<String,String>();

	public Contact() {
		super();
	}

	public Contact(String firstName, String lastName,
			Date dateofBirth, Address address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateofBirth = dateofBirth;
		this.address = address;
	}

	public int getContactId() {
		return contactId;
	}
	public void setContactId(int contactId) {
		this.contactId = contactId;
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
	public Date getDateofBirth() {
		return dateofBirth;
	}
	public void setDateofBirth(Date dateofBirth) {
		this.dateofBirth = dateofBirth;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Map<String, String> getMobileNumbers() {
		return mobileNumbers;
	}

	public void setMobileNumbers(Map<String, String> mobileNumbers) {
		this.mobileNumbers = mobileNumbers;
	}

	

}
