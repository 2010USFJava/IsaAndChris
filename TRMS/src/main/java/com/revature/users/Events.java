package com.revature.users;

import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

public interface Events {
	@JsonFormat(shape = JsonFormat.Shape.OBJECT)
	public enum EventType{
		@JsonProperty("universitycourse")
		UNIVERSITYCOURSE("universitycourse"), 
		@JsonProperty("seminar")
		SEMINAR("seminar"),
		@JsonProperty("certificationpreparationclass")
		CERTIFICATIONPREPARATIONCLASS("certificationpreparationclass"),
		@JsonProperty("certification")
		CERTIFICAITON("certification"), 
		@JsonProperty("technicaltraining")
		TECHNICALTRAINING("technicaltraining"),
		@JsonProperty("other")
		OTHER("other");
		private String eventType;
		private EventType(String string) {
			this.eventType = string;
		}
		@Override 
		public String toString() {
			return eventType;
		}
		
		@JsonValue
		public String getCode() {
			return eventType;
		}
	}

	@JsonFormat(shape = JsonFormat.Shape.OBJECT)
	public enum GradeFormat{
		@JsonProperty("grade")
		GRADE("grade"),
		@JsonProperty("presentation")
		PRESENTATION("presentation");
		private String gradeFormat;
		private GradeFormat(String string) {
			this.gradeFormat = string;
		}
		@Override
		public String toString() {
			return gradeFormat;
		}
		
		@JsonValue
		public String getCode() {
			return gradeFormat;
		}
	}
	
	public enum PassingGrade{
		@JsonProperty("a")
		A("a"),
		@JsonProperty("b")
		B("b"),
		@JsonProperty("c")
		C("c");
		private String passingGrade;
		private PassingGrade(String string) {
			this.passingGrade = string;
		}
		@Override
		public String toString() {
			return passingGrade;
		}
		
		@JsonValue
		public String getCode() {
			return passingGrade;
		}
	}
	
	public enum Approval{
		@JsonProperty("pending")
		PENDING("pending"),
		@JsonProperty("approved")
		APPROVED("approved"),
		@JsonProperty("denied")
		DENIED("denied"),
		@JsonProperty("requestingmoreinformation")
		REQUESTINGMOREINFORMATION("requestingmoreinformation");
		private String approval;
		private Approval(String string) {
			this.approval = string;
		}
		@Override
		public String toString() {
			return approval;
		}
		
		@JsonValue
		public String getCode() {
			return approval;
		}
	}
}
