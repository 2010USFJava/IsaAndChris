package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.dao.UsersDao;
import com.revature.users.Employee;
import com.revature.users.User;
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

	public void insertUser(User user) throws SQLException {
		try {
			Connection conn = cf.getConnection();
			String sql = "insert into login values (?, ?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(2, user.getUsername()); // The first column is generated automatically
			ps.setString(3, user.getPassword());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public User getUserByUsername(String username) throws SQLException {
		User user = new User();
		try {
			Connection conn = cf.getConnection();
			String sql = "select * from login where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user.setEmployeeId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("UsersDaoImpl.getUserByUsername user = " + user.toString());
		return user;
	}

	public List<User> getAllUsers() throws SQLException {
		List<User> usersList = new ArrayList<User>();
		try {
			Connection conn = cf.getConnection();
			String sql = "select * from login";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				usersList.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usersList;
	}
	
	public Employee getEmployeeByUserId(Integer id) {
		Employee employee = new Employee();
		try {
			Connection conn = cf.getConnection();
			String sql = "select * from employee where employeeid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				employee.setEmployeeId(rs.getInt(1));
				employee.setFirstName(rs.getString(2));
				employee.setLastName(rs.getString(3));
				employee.setReimburseAmount(rs.getDouble(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("UsersDaoImpl.getEmployeeByUserId employee = " + employee.toString());
		return employee;
	}
}
