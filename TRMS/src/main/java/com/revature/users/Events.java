package com.revature.users;

public interface Events {
	public enum EventType{
		UNIVERSITYCOURSE, 
		SEMINAR,
		CERTIFICATIONPREPARATIONCLASS,
		CERTIFICAITON, 
		TECHNICALTRAINING,
		OTHER
	}
	
	public enum GradeFormat{
		GRADE,
		PRESENTATION
	}
}
