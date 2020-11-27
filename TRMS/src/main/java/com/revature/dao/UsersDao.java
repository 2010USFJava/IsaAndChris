package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.users.Users;

public interface UsersDao {

	public List<Users> getAllUsers() throws SQLException;

	public Users getUserByUsername(String username) throws SQLException;

	public void insertUser(Users user) throws SQLException;

}
