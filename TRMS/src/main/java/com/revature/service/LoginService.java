package com.revature.service;

import java.sql.SQLException;
import java.util.List;

import com.revature.daoimpl.UsersDaoImpl;
import com.revature.users.Employee;
import com.revature.users.User;

public class LoginService {
	UsersDaoImpl udi = new UsersDaoImpl();

	public User loginGetUser(String username, String password) {
		System.out.println("LoginService.loginGetEmployee username: " + username + ", password: " + password);
		if (loginVerify(username, password)) {
			try {
				User user = udi.getUserByUsername(username);
				System.out.println("LoginService.loginGetEmployee user = " + user);
				return user;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("LoginService.loginGetEmployee user not found.");
		return null;
	}
	
	public Employee callGetEmployeeByUserId(Integer id) {
		return udi.getEmployeeByUserId(id);
	}

	public boolean loginVerify(String username, String password) {
		List<User> usersList = null;
		System.out.println("LoginService.loginVerify username: " + username + ", password: " + password);
		try {
			usersList = udi.getAllUsers();
			System.out.println("All users: " + usersList.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		boolean verify = false;
		for (User user : usersList) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				verify = true;
			}
		}
		System.out.println("loginVerify user found = " + verify);
		return verify;
	}

	public void insertNewUser(User user) {
		try {
			udi.insertUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
