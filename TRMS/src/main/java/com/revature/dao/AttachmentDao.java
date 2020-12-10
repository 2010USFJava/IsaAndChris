package com.revature.dao;

import java.sql.SQLException;

import com.revature.users.Attachment;

public interface AttachmentDao {
	public Attachment getAttachmentById(long id) throws SQLException;
	public long insertNewAttachment(Attachment form) throws SQLException;
	public long deleteAttachment(Attachment form, long id) throws SQLException;
	public void updateAttachment(Attachment form, long id) throws SQLException;
}
