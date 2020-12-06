package com.revature.users;

public class DepartmentHead extends User{
	private int departmentId;
	private String firstName;
	private String lastName;
	
	
	public DepartmentHead() {
		super();
	}
	
	//use for login
	public DepartmentHead(String username, String password) {
		super(null, username, password);
	}
	
	public DepartmentHead(int departmentId, String firstName, String lastName) {
		super();
		this.departmentId = departmentId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public int getDepartmentId() {
		return departmentId;
	}
	
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
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
	
	@Override
	public String toString() {
		return "DepartmentHead [departmentId=" + departmentId + ", firstName=" + firstName + ", lastName=" + lastName
				+ "]";
	}
	
}
