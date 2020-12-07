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
		
		
//		@JsonCreator
//		public static EventType decodeEvent(final String aType) {
//			return Stream.of(EventType.values()).filter(targetEnum -> targetEnum.eventType.equals(aType)).findFirst().orElse(null);
//		}
		
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
		
//		@JsonCreator
//		public static GradeFormat decodeEvent(final String bType) {
//			return Stream.of(GradeFormat.values()).filter(targetEnum -> targetEnum.bType.equals(bType)).findFirst().orElse(null);
//		}
		
		@JsonValue
		public String getCode() {
			return gradeFormat;
		}
	}
}
