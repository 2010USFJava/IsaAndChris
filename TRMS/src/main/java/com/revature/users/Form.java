package com.revature.users;

import java.text.SimpleDateFormat;

public class Form implements Events {
	private int eventId;
	private int employeeId;
	//(yyyy,MMM,dd) y= year(exDisplay: 2020); M= month in year(exDisplay: Jul); d= day in month(exDisplay: 04)
	private SimpleDateFormat dateOfEvent;//figure out how to use
	//(hh,mm,a) hh= hour in am/pm (1-12) (exDisplay: 11:); mm= minutes in hour (exDisplay: :22); a= am/pm marker
	private SimpleDateFormat timeOfEvent;
	private String eventLocation;
	private EventType eventType;
	private double eventCost;
	private GradeFormat gradeFormat;
	private String description;
	private String justification;
	private boolean hasApprovalEmail;
	private boolean isApproved = false;
	
	public Form() {
		super();
	}


	public Form(int eventId, int employeeId, SimpleDateFormat dateOfEvent, SimpleDateFormat timeOfEvent,
			String eventLocation, EventType eventType, double eventCost, GradeFormat gradeFormat, String description,
			String justification, boolean hasApprovalEmail, boolean isApproved) {
		super();
		this.eventId = eventId;
		this.employeeId = employeeId;
		this.dateOfEvent = dateOfEvent;
		this.timeOfEvent = timeOfEvent;
		this.eventLocation = eventLocation;
		this.eventType = eventType;
		this.eventCost = eventCost;
		this.gradeFormat = gradeFormat;
		this.description = description;
		this.justification = justification;
		this.hasApprovalEmail = hasApprovalEmail;
		this.isApproved = isApproved;
	}


	public int getEventId() {
		return eventId;
	}


	public void setEventId(int eventId) {
		this.eventId = eventId;
	}


	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	public SimpleDateFormat getDateOfEvent() {
		return dateOfEvent;
	}


	public void setDateOfEvent(SimpleDateFormat dateOfEvent) {
		this.dateOfEvent = dateOfEvent;
	}


	public SimpleDateFormat getTimeOfEvent() {
		return timeOfEvent;
	}


	public void setTimeOfEvent(SimpleDateFormat timeOfEvent) {
		this.timeOfEvent = timeOfEvent;
	}


	public String getEventLocation() {
		return eventLocation;
	}


	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}


	public EventType getEventType() {
		return eventType;
	}


	public void setEventType(EventType eventType) {
		this.eventType = eventType;
	}


	public double getEventCost() {
		return eventCost;
	}


	public void setEventCost(double eventCost) {
		this.eventCost = eventCost;
	}


	public GradeFormat getGradeFormat() {
		return gradeFormat;
	}


	public void setGradeFormat(GradeFormat gradeFormat) {
		this.gradeFormat = gradeFormat;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getJustification() {
		return justification;
	}


	public void setJustification(String justification) {
		this.justification = justification;
	}


	public boolean isHasApprovalEmail() {
		return hasApprovalEmail;
	}


	public void setHasApprovalEmail(boolean hasApprovalEmail) {
		this.hasApprovalEmail = hasApprovalEmail;
	}


	public boolean isApproved() {
		return isApproved;
	}


	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}


	@Override
	public String toString() {
		return "Form [eventId=" + eventId + ", employeeId=" + employeeId + ", dateOfEvent=" + dateOfEvent
				+ ", timeOfEvent=" + timeOfEvent + ", eventLocation=" + eventLocation + ", eventType=" + eventType
				+ ", eventCost=" + eventCost + ", gradeFormat=" + gradeFormat + ", description=" + description
				+ ", justification=" + justification + ", hasApprovalEmail=" + hasApprovalEmail + ", isApproved="
				+ isApproved + "]";
	}
	
	
	
	
	
	


}
