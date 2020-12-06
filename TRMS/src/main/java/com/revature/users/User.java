package com.revature.users;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 5686159814995235088L;

	private Integer employeeId;
	private String username;
	private String password;
	
	public User() {
		super();
	}
	
	public User(Integer employeeId, String username, String password) {
		this.employeeId = employeeId;
		this.username = username;
		this.password = password;
	}
	
	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getUsername() {
		return this.username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Users [employeeId=" + employeeId + ", username=" + username + ", password=" + password + "]";
	}
}
