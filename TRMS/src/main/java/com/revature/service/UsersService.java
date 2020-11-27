package com.revature.service;

import java.sql.SQLException;
import java.util.List;

import com.revature.daoimpl.UsersDaoImpl;
import com.revature.users.Users;

public class UsersService {
	UsersDaoImpl udi = new UsersDaoImpl();

	public Users loginGetEmployee(String username, String password) {
		if (loginVerify(username, password)) {
			try {
				return udi.getUserByUsername(username);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public boolean loginVerify(String username, String password) {
		List<Users> usersList = null;
		try {
			usersList = udi.getAllUsers();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		boolean verify = false;
		for (Users user : usersList) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
				verify = true;
			}
		}
		return verify;
	}

	public void insertNewUser(Users user) {
		try {
			udi.insertUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
