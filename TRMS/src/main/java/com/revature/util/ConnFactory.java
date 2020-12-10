package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnFactory {
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static ConnFactory cf;
	
	private ConnFactory() {
		super();
	}
	
	public static synchronized ConnFactory getInstance() {
		if(cf == null) {
			cf = new ConnFactory();
		}
		return cf;
	}
	
	public Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties();
		
		String url = "jdbc:postgresql://isaandchrisdb.c8xt2vsyvgm5.us-east-2.rds.amazonaws.com:5432/TRMS_Database?currentSchema=reimbursement";
		String username = "project1";
		String	password = "database";
		
		try {
//			prop.load(new FileReader("database.properties"));
//			conn = DriverManager.getConnection(prop.getProperty("url"),
//					prop.getProperty("username"),
//					prop.getProperty("password"));
					
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return conn;
		
	}

}
