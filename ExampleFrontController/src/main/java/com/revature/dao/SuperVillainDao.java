package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.SuperVillain;

public class SuperVillainDao {

	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private String url = "jdbc:postgresql://revature-osberg.cmbmxlvbcdgh.us-east-2.rds.amazonaws.com:5432/supervillaindb";
	private String username = "vill";
	private String password = "p4ssw0rd";

	public SuperVillainDao() {

	}

	public List<SuperVillain> getAllVillains() {
		List<SuperVillain> villList = new ArrayList<SuperVillain>();
		try {
			Connection connection = DriverManager.getConnection(this.url, this.username, this.password);
			String sql = "select * from Supervillain";
			PreparedStatement prepStat = connection.prepareStatement(sql);
			ResultSet resSet = prepStat.executeQuery();
			while (resSet.next()) {
				villList.add(new SuperVillain(resSet.getString(1), resSet.getString(2), resSet.getInt(3)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return villList;
	}

	public void insertSuperVillain(SuperVillain vill) {
		try {
			Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
			String sql = "insert into Supervillain values (?, ? ,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, vill.getName());
			ps.setString(2, vill.getSuperPower());
			ps.setInt(3, vill.getBounty());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public SuperVillain getVillainByName(String name) {
		SuperVillain vill = new SuperVillain();
		try {
			Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
			String sql = "select * from Supervillain where name = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				vill.setName(rs.getString(1));
				vill.setSuperPower(rs.getString(2));
				vill.setBounty(rs.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vill;
	}
}
