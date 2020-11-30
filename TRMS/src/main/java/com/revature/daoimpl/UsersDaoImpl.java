package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.UsersDao;
import com.revature.users.Users;
import com.revature.util.ConnFactory;

public class UsersDaoImpl implements UsersDao {

	public static ConnFactory cf = ConnFactory.getInstance();

	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void insertUser(Users user) throws SQLException {
		try {
			Connection conn = cf.getConnection();
			String sql = "insert into users values (?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(2, user.getUsername()); // The first variable is the emp_id
			ps.setString(3, user.getPassword());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Users getUserByUsername(String username) throws SQLException {
		Users user = new Users();
		try {
			Connection conn = cf.getConnection();
			String sql = "select * from users where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user.setUsername(rs.getString(2)); // The first variable is the emp_id
				user.setPassword(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("UsersDaoImpl.getUserByUsername user = " + user.toString());
		return user;
	}

	public List<Users> getAllUsers() throws SQLException {
		List<Users> usersList = new ArrayList<Users>();
		try {
			Connection conn = cf.getConnection();
			String sql = "select * from users";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				usersList.add(new Users(rs.getString(2), rs.getString(3))); // The first variable is the emp_id
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usersList;
	}

}
