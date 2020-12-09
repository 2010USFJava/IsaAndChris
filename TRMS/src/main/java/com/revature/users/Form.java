package com.revature.users;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Form implements Events, Serializable {
	private static final long serialVersionUID = 2697241077966009312L;
	private long eventId;
	private long employeeId;
//	//(yyyy,MMM,dd) y= year(exDisplay: 2020); M= month in year(exDisplay: Jul); d= day in month(exDisplay: 04)
//	private SimpleDateFormat dateOfEvent;//figure out how to use
//	//(hh,mm,a) hh= hour in am/pm (1-12) (exDisplay: 11:); mm= minutes in hour (exDisplay: :22); a= am/pm marker
//	private SimpleDateFormat timeOfEvent;
	//Employee employee; //do we need this for basic information?
	Employee employee;
	private EventType eventType;
	@JsonProperty("dateAndTime")
	private Timestamp dateAndTime;
	private String eventLocation;
	private double eventCost;
	private GradeFormat gradeFormat;

	private String description;
	private String justification;
	private boolean hasApprovalEmail;
	private boolean isApproved = false;
	
	public Form() {
		super();
	}

	@JsonCreator
	public Form(long eventId, long employeeId, @JsonProperty("eventType") EventType eventType, Timestamp dateAndTime,
			String eventLocation,  double eventCost, @JsonProperty("gradeFromat") GradeFormat gradeFormat, String description,
			String justification, boolean hasApprovalEmail, boolean isApproved) {
		super();
		this.eventId = eventId;
		this.employeeId = employeeId;
		this.eventType = eventType;
		this.dateAndTime = dateAndTime;
		this.eventLocation = eventLocation;
		this.eventCost = eventCost;
		this.gradeFormat = gradeFormat;
		this.description = description;
		this.justification = justification;
		this.hasApprovalEmail = hasApprovalEmail;
		this.isApproved = isApproved;
	}
	
	

	public long getEventId() {
		return eventId;
	}


	public void setEventId(long eventId) {
		this.eventId = eventId;
	}


	public long getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}


	public Timestamp getDateAndTime() {
		return dateAndTime;	
	}

	public void setDateAndTime(Timestamp dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public String getEventLocation() {
		return eventLocation;
	}


	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

//	@JsonValue
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
//
//	@JsonValue
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
		return "Form [eventId=" + eventId + ", employeeId=" + employeeId +  ", eventType="
				+ eventType + ", dateAndTime=" + dateAndTime + ", eventLocation=" + eventLocation + ", eventCost="
				+ eventCost + ", gradeFormat=" + gradeFormat + ", description=" + description + ", justification="
				+ justification + ", hasApprovalEmail=" + hasApprovalEmail + ", isApproved=" + isApproved + "]";
	}


	
	
	
	
	


}
