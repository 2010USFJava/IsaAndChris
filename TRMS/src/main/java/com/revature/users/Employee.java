package com.revature.users;

public class Employee {
	private int employeeId;
	private String firstName;
	private String lastName;
	private double reimburseAmount;
	//implements username and password
	//hopefully employeeId will also be connected to username and password for easy use of the database
	
	public Employee() {
		super();
	}
	
	//use for login
//	public Employee(String username, String password) {
//		super(username, password);
//	}

	public Employee(int employeeId, String firstName, String lastName) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		//log for when a new employee is made (for our purposes not demonstration)
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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
	
	public double getReimburseAmount() {
		return reimburseAmount;
	}
	
	public void setReimburseAmount(double reimburseAmount) {
		this.reimburseAmount = reimburseAmount;
	}
	
	//doesn't display username and password
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", reimburseAmount=" + reimburseAmount + "]";
	}

	
	
}
