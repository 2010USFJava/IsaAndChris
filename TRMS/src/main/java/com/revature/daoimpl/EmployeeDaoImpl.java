package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.util.ConnFactory;

public class EmployeeDaoImpl {
	public static ConnFactory cf = ConnFactory.getInstance();

	public boolean updateEmployeeReimbursement(int employeeId, double deduction) throws SQLException {
		Connection conn = cf.getConnection();
		String sql2 = "select reimbursement from employee where employeeid = ?";
		PreparedStatement ps2 = conn.prepareStatement(sql2);
		ps2.setInt(1, employeeId);
		ResultSet rs = ps2.executeQuery();
		double balance = 0.0;
		while (rs.next()) {
			balance = rs.getDouble(1);
		}
		if (balance - deduction >= 0) {
			System.out.println("EmployeeDaoImpl.updateEmployeeReimbursement employeeId = " + employeeId
					+ ", deduction = " + deduction);
			String sql = "update employee set reimbursement = reimbursement - ? where employeeId = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, deduction);
			ps.setInt(2, employeeId);
			ps.execute();
			return true;
		} else {
			return false;
		}
	}
}
