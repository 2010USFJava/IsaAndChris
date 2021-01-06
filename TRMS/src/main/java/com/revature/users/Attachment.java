package com.revature.users;

import java.util.Arrays;

public class Attachment implements Events{
	private long attachId;
	private FileName fileName;
	private byte[] fileData;
	private boolean isUrgent = false;
	private long eventId;
	
	public Attachment(long attachId, FileName fileName, byte[] fileData, boolean isUrgent, long eventId) {
		super();
		this.attachId = attachId;
		this.fileName = fileName;
		this.fileData = fileData;
		this.isUrgent = isUrgent;
		this.eventId = eventId;
	}
	public long getAttachId() {
		return attachId;
	}
	public void setAttachId(long attachId) {
		this.attachId = attachId;
	}
	public FileName getFileName() {
		return fileName;
	}
	public void setFileName(FileName fileName) {
		this.fileName = fileName;
	}
	public byte[] getFileData() {
		return fileData;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	
	public boolean isUrgent() {
		return isUrgent;
	}
	public void setUrgent(boolean isUrgent) {
		this.isUrgent = isUrgent;
	}
	public long getEventId() {
		return eventId;
	}
	public void setEventId(long eventId) {
		this.eventId = eventId;
	}
	@Override
	public String toString() {
		return "Attachment [attachId=" + attachId + ", fileName=" + fileName + ", fileData=" + Arrays.toString(fileData)
				+ ", isUrgent=" + isUrgent + ", eventId=" + eventId + "]";
	}
	

	
	
}
