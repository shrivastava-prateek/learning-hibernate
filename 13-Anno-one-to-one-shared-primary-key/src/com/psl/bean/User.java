package com.psl.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int userId;
	private String userName;
	@OneToMany(cascade=CascadeType.ALL)
	private Set<Contact> contacts= new HashSet<Contact>();

	public User() {
		super();
	}

	public User(String userName) {
		super();
		this.userName = userName;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Set<Contact> getContacts() {
		return contacts;
	}
	public void setContacts(Set<Contact> contacts) {
		this.contacts = contacts;
	}

	public void addContact(Contact contact){
		getContacts().add(contact);
		contact.setUser(this);
	}

}
