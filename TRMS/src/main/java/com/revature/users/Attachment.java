package com.revature.users;



public class Attachment {
	private long attachId;
	private String fileName;
	private byte[] fileData;
	
	public Attachment(long attachId, String fileName, byte[] fileData) {
		super();
		this.attachId = attachId;
		this.fileName = fileName;
		this.fileData = fileData;
	}
	public long getAttachId() {
		return attachId;
	}
	public void setAttachId(long attachId) {
		this.attachId = attachId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public byte[] getFileData() {
		return fileData;
	}
	public void setFileData(byte[] fileData) {
		this.fileData = fileData;
	}
	@Override
	public String toString() {
		return "Attachment [attachId=" + attachId + ", fileName=" + fileName + ", fileData=" + fileData + "]";
	}
	
	
}
