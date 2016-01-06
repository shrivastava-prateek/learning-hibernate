package com.psl.bean;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Contact {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int contactId;
	private String firstName,lastName;
	private Date dateofBirth;
	@Embedded
	@ElementCollection
	private Set<Address> addresses = new HashSet<Address>();
    @ElementCollection
	private Set<String> mobileNumbers = new HashSet<String>();
    @ManyToOne
    private User user;

	public Contact() {
		super();
	}

	
	public Contact(String firstName, String lastName, Date dateofBirth) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateofBirth = dateofBirth;
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

	
	

	public Set<String> getMobileNumbers() {
		return mobileNumbers;
	}

	public void setMobileNumbers(Set<String> mobileNumbers) {
		this.mobileNumbers = mobileNumbers;
	}


	public Set<Address> getAddresses() {
		return addresses;
	}


	public void setAddresses(Set<Address> address) {
		this.addresses = address;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


}
