package com.revature.dao;

import java.sql.SQLException;

import com.revature.users.Attachment;

public interface AttachmentDao {
	public Attachment getAttachmentById(long id) throws SQLException;
	public long insertNewAttachment(Attachment attach) throws SQLException;
	public long insertMultipleAttachments(Attachment a, Attachment b) throws SQLException;
	public long deleteAttachment(Attachment attach, long id) throws SQLException;
	public void updateAttachment(Attachment attach, long id) throws SQLException;
}
