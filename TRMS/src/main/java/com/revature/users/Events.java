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
		universitycourse("universitycourse"), 
		@JsonProperty("seminar")
		seminar("seminar"),
		@JsonProperty("certificationpreparationclass")
		certificationpreparationclass("certificationpreparationclass"),
		@JsonProperty("certification")
		certification("certification"), 
		@JsonProperty("technicaltraining")
		technicaltraining("technicaltraining"),
		@JsonProperty("other")
		other("other");
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
		grade("grade"),
		@JsonProperty("presentation")
		presentation("presentation");
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
		a("a"),
		@JsonProperty("b")
		b("b"),
		@JsonProperty("c")
		c("c");
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
		pending("pending"),
		@JsonProperty("approved")
		approved("approved"),
		@JsonProperty("denied")
		denied("denied"),
		@JsonProperty("requestingmoreinformation")
		requestingmoreinformation("requestingmoreinformation");
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
	
	public enum FileName{
		@JsonProperty("eventrelateddocument")
		eventrelateddocument("eventrelateddocument"),
		@JsonProperty("approvaldocument")
		approvaldocument("approvaldocument");
		private String fileName;
		private FileName(String string) {
			this.fileName = string;
		}
		@Override
		public String toString() {
			return fileName;
		}
		
		@JsonValue
		public String getCode() {
			return fileName;
		}
	}
}
