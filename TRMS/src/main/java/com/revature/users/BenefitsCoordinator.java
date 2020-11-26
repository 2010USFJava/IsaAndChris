package com.revature.users;

public class BenefitsCoordinator extends Users{
	private int benCoId;
	private String firstName;
	private String lastName;
	
	
	public BenefitsCoordinator() {
		super();
	}
	
	//use for login
	public BenefitsCoordinator(String username, String password) {
		super(username, password);
	}
	
	public BenefitsCoordinator(int benCoId, String firstName, String lastName) {
		super();
		this.benCoId = benCoId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public int getBenCoId() {
		return benCoId;
	}
	
	public void setBenCoId(int benCoId) {
		this.benCoId = benCoId;
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
		return "BenefitsCoordinator [benCoId=" + benCoId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
}
