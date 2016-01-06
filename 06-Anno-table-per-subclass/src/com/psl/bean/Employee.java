package com.psl.bean;

import java.sql.Date;

import javax.persistence.Entity;
@Entity
public class Employee extends Contact {
	private String employeeCode,department,designation;

	
	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName, Date dateofBirth,
			Address address, String employeeCode, String department,
			String designation) {
		super(firstName, lastName, dateofBirth, address);
		this.employeeCode = employeeCode;
		this.department = department;
		this.designation = designation;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	

}
