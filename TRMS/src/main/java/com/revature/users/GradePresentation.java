package com.revature.users;

import java.util.Arrays;

public class GradePresentation {
	private int employeeId;
	private long eventId;
	private byte[] fileData;
	private char grade;
	public GradePresentation() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GradePresentation(int employeeId, long eventId, byte[] fileData, char grade) {
		super();
		this.employeeId = employeeId;
		this.eventId = eventId;
		this.fileData = fileData;
		this.grade = grade;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public long getEventId() {
		return eventId;
	}
	public void setEventId(long eventId) {
		this.eventId = eventId;
	}
	public byte[] getFileData() {
		return fileData;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	public char getGrade() {
		return grade;
	}
	public void setGrade(char grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "GradePresentation [employeeId=" + employeeId + ", eventId=" + eventId + ", fileData="
				+ Arrays.toString(fileData) + ", grade=" + grade + "]";
	}
	
	
}
