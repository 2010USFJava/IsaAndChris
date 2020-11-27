package com.revature.users;

public class Users {
//or make an interface?
	// we need instances to easily obtain info from the DB -Chris
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

	@Override
	public String toString() {
		return "Users [username=" + username + ", password=" + password + "]";
	}
}
