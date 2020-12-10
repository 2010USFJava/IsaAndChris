package com.revature.daoimpl;


import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.dao.AttachmentDao;
import com.revature.users.Attachment;
import com.revature.util.ConnFactory;

public class AttachmentDaoImpl implements AttachmentDao {
	
	public static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public Attachment getAttachmentById(long id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "select * from attachment where attachId=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, id);
		ResultSet rs = pstmt.executeQuery();
		Attachment a = null;
		while(rs.next()) {
//			Blob data = rs.getBlob(3);
//			byte[] bytes = data.getBytes(1l, (int)data.length());
			a = new Attachment(rs.getLong(1), rs.getString(2), rs.getBytes(3));
		}
		return a;
	}

	@Override
	public long insertNewAttachment(Attachment attach) throws SQLException {
		String sql = "insert into attachment values (DEFAULT,?,?)";
		Connection conn = cf.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		stmt.setString(1, attach.getFileName());
		stmt.setBytes(2, attach.getFileData());
		long attachId = 0;
		int affectedRows = stmt.executeUpdate();
		if(affectedRows > 0) {
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()) {
				attachId = rs.getLong(1);
			}
		}
		
		return attachId;
	}

	@Override
	public long deleteAttachment(Attachment attach, long id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateAttachment(Attachment attach, long id) throws SQLException {
		// TODO Auto-generated method stub
		
	}

}
