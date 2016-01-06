package com.psl.bean;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="tbl_contacts")
public class Contact {
	@Id
	@Column(name="CONTACTID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int contactId;
	@Column(name="FIRSTNAME")
	private String firstName;
	@Column(name="LASTNAME")
	private String lastName;
	@Column(name="DATEOFBIRTH")
	private Date dateofBirth;
	
	
	
	public Contact() {
		super();
	}
	public Contact(String firstName, String lastName,
			Date dateofBirth) {
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
	

}
