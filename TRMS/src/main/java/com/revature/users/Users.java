package com.revature.users;

public abstract class Users {
//or make an interface?
	private String username;
	private String password;
	
	public Users() {
		super();
	}
	
	public Users(String username, String password) {
		this.username = username;
		this.password = password;
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
	
}
