package com.automation.capacitacion.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

	private String url = "jdbc:mysql://localhost:3306/datos?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String username = "root";
	private String password = "admin123";
	private Connection con;

	public Connection getConnection() {
		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
		}
		return con;
	}

	public void closeConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
