package com.revature.users;

import java.io.Serializable;

public class Employee implements Serializable {
	private static final long serialVersionUID = -844753909439401218L;
	private int employeeId;
	private String firstName;
	private String lastName;
	private double reimburseAmount;
	private int jobTitleCode;
	
	public Employee() {
		super();
	}
	
	public Employee(int employeeId, String firstName, String lastName, double reimburseAmount, int jobTitleCode) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.reimburseAmount = reimburseAmount;
		this.jobTitleCode = jobTitleCode;
	}

	public Integer getEmployeeId() {
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

	public int getJobTitleCode() {
		return jobTitleCode;
	}

	public void setJobTitleCode(int jobTitleCode) {
		this.jobTitleCode = jobTitleCode;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", reimburseAmount=" + reimburseAmount + ", jobTitleCode=" + jobTitleCode + "]";
	}
	
}
