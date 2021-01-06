package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.users.User;

public interface UsersDao {

	public List<User> getAllUsers() throws SQLException;

	public User getUserByUsername(String username) throws SQLException;

	public void insertUser(User user) throws SQLException;

}
