package com.revature.users;

public class DirectSupervisor extends User{
	private int superId;
	private String firstName;
	private String lastName;
	private boolean isADepartmentHead;

	public DirectSupervisor() {
		super();
	}
	
	//use for login?
	public DirectSupervisor(String username, String password) {
		super(null, username, password);
	}

	public DirectSupervisor(int superId, String firstName, String lastName, boolean isADepartmentHead) {
		super();
		this.superId = superId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.isADepartmentHead = isADepartmentHead;
	}

	public int getSuperId() {
		return superId;
	}
	
	public void setSuperId(int superId) {
		this.superId = superId;
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
	
	public boolean isADepartmentHead() {
		return isADepartmentHead;
	}
	
	public void setADepartmentHead(boolean isADepartmentHead) {
		this.isADepartmentHead = isADepartmentHead;
	}
	
	@Override
	public String toString() {
		return "Supervisor [superId=" + superId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", isADepartmentHead=" + isADepartmentHead + "]";
	}
	
	
	
	
}
