package com.psl.bean;

import java.util.HashSet;
import java.util.Set;

public class User {
	private int userId; 
	private String fullName;
	private Set<Account> accounts= new HashSet<Account>();
	
	public User() {
		super();
	}

	public User(String fullName) {
		super();
		this.fullName = fullName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}
	
	public void addAccount(Account account){
		getAccounts().add(account);
		account.setUser(this);
		
	}
	
}
